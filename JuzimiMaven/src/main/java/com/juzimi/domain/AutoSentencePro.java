package com.juzimi.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class AutoSentencePro {
    private List<SentencePro> sentenceProList = new ArrayList<>();
    private Boolean next;

    public List<SentencePro> getSentenceProList() {
        return sentenceProList;
    }

    public void setSentenceProList(List<SentencePro> sentenceProList) {
        this.sentenceProList = sentenceProList;
    }

    public Boolean getNext() {
        return next;
    }

    public void setNext(Boolean next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "AutoSentencePro{" +
                "sentenceProList=" + sentenceProList +
                ", next=" + next +
                '}';
    }
}
