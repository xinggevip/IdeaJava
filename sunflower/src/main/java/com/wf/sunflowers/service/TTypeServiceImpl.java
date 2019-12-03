package com.wf.sunflowers.service;

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
}
