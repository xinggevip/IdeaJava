package com.juzimi.service;

import com.juzimi.domain.*;

import java.util.List;

public interface SentenceSerive {
    /* 添加句子 */
    public Result addSentence(Sentence sentence);
    /* 根据专辑id查所有句子 */
    public AutoSentence selectSentenceByAlbumId(Integer albumId, Integer pageNum, Integer pageSize);
    /* 根据专辑id统计记录数 */
    public SentenceCount selectSentenceCount(Integer albumId);
    /* 查出所有句子展示在首页 */
    public AutoSentencePro selectAllSentence(Integer pageNum, Integer pageSize);
    // 删除句子
    public Result delSentenceById(Integer sentenceId);
    // 批量删除句子
    public Result delSomeSen(List<Sentence> sentenceList);
    // 更新句子
    public Result updataSen(Sentence sentence);
}
