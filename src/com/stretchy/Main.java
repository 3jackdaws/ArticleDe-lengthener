package com.stretchy;

public class Main {

    public static void main(String[] args) {
        if(args.length > 1)
        {
            float threshhold = 1;
            if(args.length ==2) threshhold = Float.parseFloat(args[1]);
            WebpageParser parser = new WebpageParser(args[0]);
            ArticleMostFrequentWord mostFrequentWord = new ArticleMostFrequentWord(parser.getArticleText());
            ArticleImportantSentences important = new ArticleImportantSentences(parser.getArticleText(), mostFrequentWord.getTopWords(), threshhold);
        }
        else
        {
            System.out.println("Please enter a website URL.");
        }
    }
}
