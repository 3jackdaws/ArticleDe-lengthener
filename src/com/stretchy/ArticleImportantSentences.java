package com.stretchy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Created by ian on 5/2/16.
 */
public class ArticleImportantSentences {
    private String articleText;
    private float threshhold;
    private LinkedList<RankedWord> topWords;
    private LinkedList<RankedSentence> topSentences;
    public ArticleImportantSentences(String article, LinkedList<RankedWord> top, float t)
    {
        articleText = article;
        topWords = top;
        threshhold = t;
        topSentences = new LinkedList<>();
        findImportantSentences();
    }

    private void findImportantSentences()
    {
        LinkedList<String> sentences = new LinkedList<>();
        LinkedList<RankedSentence> rankedSentences = new LinkedList<>();
        sentences.addAll(Arrays.asList(articleText.split("\\. ")));
        sentences.removeIf(s -> s.equals(""));
        sentences.removeIf(s -> s.matches("[^a-zA-Z]*"));

        for(String s : sentences)
        {
            int rank = 0;
            for(int i = 0; i<15; i++)
            {
                if(s.contains(topWords.get(i).getWord()))
                {
                    rank += topWords.get(i).getOccurences();
                }
            }
            rankedSentences.add(new RankedSentence(s, rank));
        }
        int top = 0;
        int average = 0;
        int current = 0;
        for(RankedSentence s : rankedSentences)
        {
            current = s.getRank();
            if(current > top)
                top = current;
            average += current;
        }
        average /= rankedSentences.size();
        int lowerbounds = (int)((top - average/2) * threshhold);
        topSentences.add(rankedSentences.get(0));
        System.out.println(rankedSentences.get(0) + ".");
        for (RankedSentence s : rankedSentences)
        {
            if(s.getRank() > lowerbounds && !topSentences.contains(s)) {
                topSentences.add(s);
                System.out.println(s + ".");
            }
        }



//        topSentences.sort((s1,s2)->{
//            if(s1.getRank() == s2.getRank()) return 0;
//            if(s1.getRank() > s2.getRank()) return -1;
//            else return 1;
//        });

    }
}
