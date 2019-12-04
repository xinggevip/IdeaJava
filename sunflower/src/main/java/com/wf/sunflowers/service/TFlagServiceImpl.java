package com.wf.sunflowers.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TFlag;
import com.wf.sunflowers.entity.TFlagPro;
import com.wf.sunflowers.mapper.TFlagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TFlagServiceImpl implements TFlagService {
    @Autowired
    private TFlagMapper tFlagMapper;

    // 获取所有flag
    @Override
    public PageInfo<TFlagPro> getAllFlagByUidAndKey(Integer userid, String key, Integer pageNum, Integer pageSize) {
        try {
            /* 配置分页查询 从第几页开始查，一页查多少条记录 */
            String orderBy = "fid  desc";//按照排序字段 倒序 排序
            Page<TFlagPro> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

            List<TFlagPro> tFlagPros = tFlagMapper.selectAllByUidAndKey(userid, key);

            /* 信息更加详细 配置导航显示几条页码 */
            PageInfo<TFlagPro> PageInfo = new PageInfo<>(tFlagPros, 3);

            return PageInfo;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    // 发布flag
    @Override
    public ResultInfo insertFlag(TFlag tFlag) {
        try {
            tFlag.setClick(0);
            int i = tFlagMapper.insert(tFlag);
            if (i > 0){
                System.out.println(tFlag);
                return new ResultInfo(true,"发布成功");
            }else {
                System.out.println(tFlag);
                return new ResultInfo(false,"发布失败");
            }
        }catch (Exception e){
            System.out.println(tFlag);
            return new ResultInfo(false,"发布失败");
        }
    }

    // 更新flag
    @Override
    public ResultInfo updataFlag(TFlag tFlag) {
        try {
            int i = tFlagMapper.updateByPrimaryKey(tFlag);
            if (i > 0){
                return new ResultInfo(true,"更新成功");
            }else {
                return new ResultInfo(false,"更新失败");
            }
        }catch (Exception e){
            return new ResultInfo(false,"更新失败");
        }
    }

    // 删除flag
    @Override
    public ResultInfo delFalg(TFlag tFlag) {
        try {
            int i = tFlagMapper.deleteByPrimaryKey(tFlag.getFid());
            if (i > 0){
                return new ResultInfo(true,"删除成功");
            }else {
                return new ResultInfo(false,"删除失败");
            }
        }catch (Exception e){
            return new ResultInfo(false,"删除失败");
        }
    }

    // 批量删除flag
    @Override
    public ResultInfo delFlags(List<TFlag> tFlags) {
        try {
            for (TFlag tFlag : tFlags) {
                tFlagMapper.deleteByPrimaryKey(tFlag.getFid());
            }
            return new ResultInfo(true,"批量删除成功");
        }catch (Exception e){
            return new ResultInfo(false,"批量删除失败");
        }
    }

    // 批量设置flag完成状态
    @Override
    public ResultInfo setFlagsState(List<TFlag> tFlags) {
        try {
            for (TFlag tFlag : tFlags) {
                tFlagMapper.updateByPrimaryKey(tFlag);
            }
            return new ResultInfo(true,"操作成功");
        }catch (Exception e){
            return new ResultInfo(false,"操作失败");
        }
    }
}
