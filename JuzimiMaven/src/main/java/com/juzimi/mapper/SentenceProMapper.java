package com.juzimi.mapper;

import com.juzimi.domain.SentencePro;

import java.util.List;

public interface SentenceProMapper {
    /* 查询所有记录  带专辑名称字段 */
    List<SentencePro> selectAllPro();
}
