package com.stretchy;

import com.sun.org.apache.xpath.internal.operations.Equals;

/**
 * Created by ian on 5/2/16.
 */
public class RankedWord {
    private String word;
    private int occurences;

    public RankedWord(String w) {
        word = w;
        occurences = 1;
    }

    public RankedWord(String w, int o) {
        word = w;
        occurences = o;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RankedWord that = (RankedWord) o;

        if(word.equals(that.word)) return true;

        return false;

    }

    public void increment()
    {
        occurences++;
    }

    public int getOccurences()
    {
        return occurences;
    }

    public String getWord()
    {
        return word;
    }
}
