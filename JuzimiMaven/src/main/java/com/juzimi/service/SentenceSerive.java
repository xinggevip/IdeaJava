package com.juzimi.service;

import com.juzimi.domain.AutoSentence;
import com.juzimi.domain.Result;
import com.juzimi.domain.Sentence;

public interface SentenceSerive {
    /* 添加句子 */
    public Result addSentence(Sentence sentence);
    /* 根据专辑id查所有句子 */
    public AutoSentence selectSentenceByAlbumId(Integer albumId, Integer pageNum, Integer pageSize);
}
