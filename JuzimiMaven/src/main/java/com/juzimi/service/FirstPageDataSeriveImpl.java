package com.juzimi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juzimi.domain.FirstPageData;
import com.juzimi.domain.ResultFirstPageData;
import com.juzimi.mapper.FirstPageDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FirstPageDataSeriveImpl implements FirstPageDataSerive {
    @Autowired
    private FirstPageDataMapper firstPageDataMapper;
    @Autowired
    private ResultFirstPageData resultFirstPageData;

    @Override
    public ResultFirstPageData getFirstPageData(String userId,Integer pageNum,Integer pageSize) {



        /* 配置分页查询 从第几页开始查，一页查多少条记录 */
        String orderBy = "sentence_id  desc";//按照排序字段 倒序 排序
        Page<FirstPageData> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

        List<FirstPageData> firstPageDatas = firstPageDataMapper.selectFirstPageData(userId);
        // 集合反转
//        Collections.reverse(albumList);

        /* 信息更加详细 配置导航显示几条页码 */
        PageInfo<FirstPageData> firstPageDataPageInfo = new PageInfo<>(firstPageDatas, 3);

        resultFirstPageData.setFirstPageDataList(firstPageDatas);
        resultFirstPageData.setNext(firstPageDataPageInfo.isHasNextPage());


        return resultFirstPageData;
    }

    @Override
    public ResultFirstPageData getAlbumPagedata(String userId, Integer albumId, Integer pageNum, Integer pageSize) {

        /* 配置分页查询 从第几页开始查，一页查多少条记录 */
        String orderBy = "sentence_id  desc";//按照排序字段 倒序 排序
        Page<FirstPageData> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

        List<FirstPageData> albumDataList = firstPageDataMapper.selectAlbumPageData(userId, albumId);

        /* 信息更加详细 配置导航显示几条页码 */
        PageInfo<FirstPageData> firstPageDataPageInfo = new PageInfo<>(albumDataList, 3);

        resultFirstPageData.setFirstPageDataList(albumDataList);
        resultFirstPageData.setNext(firstPageDataPageInfo.isHasNextPage());


        return resultFirstPageData;
    }

    @Override
    public ResultFirstPageData getSenByUserId(String userId, Integer pageNum, Integer pageSize) {
        /* 配置分页查询 从第几页开始查，一页查多少条记录 */
        String orderBy = "sentence_id  desc";//按照排序字段 倒序 排序
        Page<FirstPageData> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

        List<FirstPageData> senByUserIdList = firstPageDataMapper.selectSenByUserId(userId);

        /* 信息更加详细 配置导航显示几条页码 */
        PageInfo<FirstPageData> firstPageDataPageInfo = new PageInfo<>(senByUserIdList, 3);

        resultFirstPageData.setFirstPageDataList(senByUserIdList);
        resultFirstPageData.setNext(firstPageDataPageInfo.isHasNextPage());

        return resultFirstPageData;
    }

    @Override
    public ResultFirstPageData getLikeSenByUserId(String userId, Integer pageNum, Integer pageSize) {
        /* 配置分页查询 从第几页开始查，一页查多少条记录 */
        String orderBy = "user_likesen_id  desc";//按照排序字段 倒序 排序
        Page<FirstPageData> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

        List<FirstPageData> userLikeSenList = firstPageDataMapper.selectLikeSenByUserId(userId);

        /* 信息更加详细 配置导航显示几条页码 */
        PageInfo<FirstPageData> firstPageDataPageInfo = new PageInfo<>(userLikeSenList, 3);

        resultFirstPageData.setFirstPageDataList(userLikeSenList);
        resultFirstPageData.setNext(firstPageDataPageInfo.isHasNextPage());

        return resultFirstPageData;
    }

    @Override
    public ResultFirstPageData searchSen(String userId,String key, Integer pageNum, Integer pageSize) {
        try {
            /* 配置分页查询 从第几页开始查，一页查多少条记录 */
            String orderBy = "sentence_id  desc";//按照排序字段 倒序 排序
            Page<FirstPageData> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

            List<FirstPageData> firstPageDatas = firstPageDataMapper.selectSearchSen(userId,key);
            // 集合反转
//        Collections.reverse(albumList);

            /* 信息更加详细 配置导航显示几条页码 */
            PageInfo<FirstPageData> firstPageDataPageInfo = new PageInfo<>(firstPageDatas, 3);

            resultFirstPageData.setFirstPageDataList(firstPageDatas);
            resultFirstPageData.setNext(firstPageDataPageInfo.isHasNextPage());

            return resultFirstPageData;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }


}
