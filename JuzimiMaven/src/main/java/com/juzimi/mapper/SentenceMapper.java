package com.juzimi.mapper;

import com.juzimi.domain.Sentence;
import java.util.List;

public interface SentenceMapper {
    int deleteByPrimaryKey(Integer sentenceId);

    int insert(Sentence record);

    Sentence selectByPrimaryKey(Integer sentenceId);

    List<Sentence> selectAll();

    int updateByPrimaryKey(Sentence record);

    /* 根据专辑id查句子 */
    List<Sentence> selectByAlbumId(Integer albumId);

    /* 根据专辑id查询记录个数 */
    int selectSentenceCount(Integer albumId);
}