package com.stretchy;

public class Main {

    public static void main(String[] args) {
        if(args.length == 2)
        {
            WebpageParser parser = new WebpageParser(args[1]);
            ArticleMostFrequentWord mostFrequentWord = new ArticleMostFrequentWord(parser.getArticleText());
            ArticleImportantSentences important = new ArticleImportantSentences(parser.getArticleText(), mostFrequentWord.getTopWords());
        }
        else
        {
            System.out.println("Please enter a website URL.");
        }
    }
}
