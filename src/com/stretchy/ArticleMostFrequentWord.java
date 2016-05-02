package com.stretchy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by ian on 5/2/16.
 */
public class ArticleMostFrequentWord {
    LinkedList<RankedWord> topWords;
    LinkedList<String> ignoredWords;
    String articleText;
    public ArticleMostFrequentWord(String text)
    {
        articleText = text;
        topWords = new LinkedList<>();
        ignoredWords = new LinkedList<>();
        populateIgnoreList("/Users/ian/Words/ignored_words.txt");
        findMostFrequent();
    }

    private void findMostFrequent()
    {
        Scanner scanner = new Scanner(articleText);
        while(scanner.hasNext())
        {
            RankedWord word = new RankedWord(scanner.next().toLowerCase());
            if(ignoredWords.contains(word.getWord()))
            {

            }
            else if(!topWords.contains(word))
            {
                topWords.add(word);
            }
            else
            {
                topWords.get(topWords.indexOf(word)).increment();
            }
        }
        topWords.sort(new Comparator<RankedWord>() {
            @Override
            public int compare(RankedWord o1, RankedWord o2) {
                if(o1.getOccurences() == o2.getOccurences()) return 0;
                if(o1.getOccurences() > o2.getOccurences()) return -1;
                else return 1;
            }
        });
    }

    private void populateIgnoreList(String filename)
    {
        try {
            BufferedReader filereader = new BufferedReader(new FileReader(filename));
            String word;
            while((word = filereader.readLine())!= null)
            {
                ignoredWords.add(word.toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public LinkedList<RankedWord> getTopWords()
    {
        return topWords;
    }
}
