package com.juzimi.domain;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class AutoSentence {
    private List<Sentence> sentenceList = new ArrayList<>();
    private Boolean next;

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }

    public Boolean getNext() {
        return next;
    }

    public void setNext(Boolean next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "AutoSentence{" +
                "sentenceList=" + sentenceList +
                ", next=" + next +
                '}';
    }
}
