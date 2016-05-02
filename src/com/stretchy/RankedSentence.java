package com.stretchy;

/**
 * Created by ian on 5/2/16.
 */
public class RankedSentence {
    private String sentence;
    private int rank;
    public RankedSentence(String s)
    {
        sentence = s;
        rank = 1;
    }

    public RankedSentence(String s, int r)
    {
        sentence = s;
        rank = r;
    }

    public String getSentence() {
        return sentence;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return sentence;
    }
}
