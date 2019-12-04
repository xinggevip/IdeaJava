package com.wf.sunflowers.service;

import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TType;
import com.wf.sunflowers.mapper.TTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TTypeServiceImpl implements TTypeService {
    @Autowired
    private TTypeMapper tTypeMapper;

    // 获取所有时间类型
    @Override
    public List<TType> getAllTtypes() {
        try {
            List<TType> tTypes = tTypeMapper.selectAll();
            return tTypes;
        }catch (Exception e){
            return null;
        }
    }

    // 更新和添加任务
    @Override
    public ResultInfo setAndAdd(List<TType> list) {
        try {
            for (TType tType : list) {
                // 根据id查询是否已存在该对象
                if (tType.getTid() != null){
                    // 如果不为空则更新
                    tTypeMapper.updateByPrimaryKey(tType);
                }else {
                    // 如果为空则增加
                    tTypeMapper.insert(tType);
                }
            }
            return new ResultInfo(true,"操作成功");
        }catch (Exception e){
            return new ResultInfo(false,"操作失败");
        }
    }
}
