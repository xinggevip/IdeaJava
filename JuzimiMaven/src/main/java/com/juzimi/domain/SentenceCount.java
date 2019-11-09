package com.juzimi.domain;

import org.springframework.stereotype.Service;

@Service
public class SentenceCount {
    private Integer sentenceCount;

    public Integer getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(Integer sentenceCount) {
        this.sentenceCount = sentenceCount;
    }

    @Override
    public String toString() {
        return "SentenceCount{" +
                "sentenceCount=" + sentenceCount +
                '}';
    }
}
