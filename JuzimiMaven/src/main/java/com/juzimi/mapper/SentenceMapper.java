package com.juzimi.mapper;

import com.juzimi.domain.Sentence;
import java.util.List;

public interface SentenceMapper {
    int deleteByPrimaryKey(Integer sentenceId);

    int insert(Sentence record);

    Sentence selectByPrimaryKey(Integer sentenceId);

    List<Sentence> selectAll();

    int updateByPrimaryKey(Sentence record);
}