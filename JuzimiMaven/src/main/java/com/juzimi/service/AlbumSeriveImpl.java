package com.juzimi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juzimi.domain.*;
import com.juzimi.mapper.AdminMapper;
import com.juzimi.mapper.AlbumMapper;
import com.juzimi.mapper.SentenceMapper;
import com.juzimi.mapper.UserlikesenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AlbumSeriveImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Autowired AutoAlbums autoAlbums;

    @Autowired
    private SentenceMapper sentenceMapper;

    @Autowired
    private UserlikesenMapper userlikesenMapper;

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public List<Album> getAlbumsByClassifyId(Integer classifyId) {
        System.out.println("来到了serive");
        List<Album> albums = albumMapper.selectAlbumByClassifyId(classifyId);
        System.out.println("serive----------albums--------------" + albums);
        return albums;
    }

    @Override
    public Integer save(Album album) {
        try {
            //时间转换
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //上传时间
            album.setCreateDate(Timestamp.valueOf(nowTime));
            // 这个返回的是插入了几条记录
            int insert = albumMapper.insert(album);
            System.out.println("插入了------------" + insert + "条记录");
            System.out.println("获取最后插入的id为：----------" + album.getAlbumId());
            if (album.getAlbumId() > 0){
                return album.getAlbumId();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        return -1;
    }

    @Override
    public AutoAlbums getAutoAlbums(Integer classifyId, Integer pageNum, Integer pageSize) {

        /* 配置分页查询 从第几页开始查，一页查多少条记录 */
        String orderBy = "album_id  desc";//按照排序字段 倒序 排序
        Page<Album> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

        List<Album> albumList = getAlbumsByClassifyId(classifyId);
        // 集合反转
//        Collections.reverse(albumList);

        /* 信息更加详细 配置导航显示几条页码 */
        PageInfo<Album> pageInfo = new PageInfo<>(albumList, 3);

        for (Album album : albumList) {
            System.out.println(album);
        }

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示记录数:"+pageInfo.getPageSize());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("导航页码:"+ Arrays.toString(pageInfo.getNavigatepageNums()));


        autoAlbums.setAlbumList(albumList);
        autoAlbums.setNext(pageInfo.isHasNextPage());


        return autoAlbums;
    }

    @Override
    public Album selectById(Integer albumId) {
        Album album = albumMapper.selectByPrimaryKey(albumId);
        return album;
    }

    // 获取所有专辑
    @Override
    public PageInfo<Album> getAllAlbum(Integer pageNum, Integer pageSize) {
        try {
            /* 配置分页查询 从第几页开始查，一页查多少条记录 */
            String orderBy = "create_date  desc";//按照排序字段 倒序 排序
            Page<Album> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

            List<Album> albums = albumMapper.selectAll();

            /* 信息更加详细 配置导航显示几条页码 */
            PageInfo<Album> pageInfo = new PageInfo<>(albums, 4);
            return pageInfo;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    // 更新专辑
    @Override
    public Result updataAlbum(Album album) {
        try {
            //时间转换
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //设置时间为现在的时间
            album.setCreateDate(Timestamp.valueOf(nowTime));
            int i = albumMapper.updateByPrimaryKey(album);
            if (i > 0){
                return new Result(true,"更新成功");
            }else {
                return new Result(false,"更新失败");
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new Result(false,"更新失败");
        }
    }

    // 删除专辑
    @Override
    public Result delAlbum(Album album) {
        try {
            // 获取专辑下的句子
            List<Sentence> sentenceList = sentenceMapper.selectByAlbumId(album.getAlbumId());
            for (Sentence sentence : sentenceList) {
                // 删除关系
                userlikesenMapper.deleteBySenId(sentence.getSentenceId());
                // 删除句子
                sentenceMapper.deleteByPrimaryKey(sentence.getSentenceId());
            }
            // 删除专辑
            int i = albumMapper.deleteByPrimaryKey(album.getAlbumId());

            if (i > 0){
                return new Result(true,"删除成功");
            }else {
                return new Result(false,"删除失败");
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new Result(false,"删除失败");
        }
    }

    // 批量删除专辑
    @Override
    public Result delSomeAlbum(List<Album> albumList) {
        try {
            for (Album album : albumList) {
                // 获取专辑下的句子
                List<Sentence> sentenceList = sentenceMapper.selectByAlbumId(album.getAlbumId());
                for (Sentence sentence : sentenceList) {
                    // 删除关系
                    userlikesenMapper.deleteBySenId(sentence.getSentenceId());
                    // 删除句子
                    sentenceMapper.deleteByPrimaryKey(sentence.getSentenceId());
                }
                int i = albumMapper.deleteByPrimaryKey(album.getAlbumId());
            }
            return new Result(true,"批量删除成功");
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new Result(false,"批量删除失败");
        }
    }

    // 获取推荐专辑
    @Override
    public List<Album> getPushAlbum() {
        try {
            // 获取admin
            Admin admin = adminMapper.selectByPrimaryKey("admin");
            Integer i = Integer.valueOf(admin.getAdminOtherTwo());

            if (admin.getAdminOtherOne().equals("1")){
                // 获取最新专辑
                /* 配置分页查询 从第几页开始查，一页查多少条记录 */
                String orderBy = "create_date  desc";//按照排序字段 倒序 排序
                Page<Album> pageIn = PageHelper.startPage(1,i,orderBy);

                List<Album> albums = albumMapper.selectAll();

                /* 信息更加详细 配置导航显示几条页码 */
                PageInfo<Album> pageInfo = new PageInfo<>(albums, 4);
                return pageInfo.getList();

            }else if (admin.getAdminOtherOne().equals("0")){
                // 获取最热专辑

                Page<Album> pageIn = PageHelper.startPage(1,i);

                List<Album> albums = albumMapper.selectHotAlbum();

                /* 信息更加详细 配置导航显示几条页码 */
                PageInfo<Album> pageInfo = new PageInfo<>(albums, 4);
                return pageInfo.getList();

            }

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }




}
