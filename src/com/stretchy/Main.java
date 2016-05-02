package com.stretchy;

public class Main {

    public static void main(String[] args) {
        WebpageParser parser = new WebpageParser("http://arstechnica.com/business/2016/05/craig-wright-says-loud-and-proud-i-am-satoshi-nakamoto/");
        ArticleMostFrequentWord mostFrequentWord = new ArticleMostFrequentWord(parser.getArticleText());
        ArticleImportantSentences important = new ArticleImportantSentences(parser.getArticleText(), mostFrequentWord.getTopWords());

    }
}
