package com.stretchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ian on 5/2/16.
 */
public class WebpageParser {
    private String webURL;
    private String articleText;
    public WebpageParser(String url)
    {
        webURL = url;
        ParsePage();
    }

    private void ParsePage()
    {
        URL url;
        InputStream is = null;
        BufferedReader br;
        StringBuilder at = new StringBuilder();
        String line;
        boolean articleFound = false;
        try {
            url = new URL(webURL);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {

                if(line.contains("<article"))
                {
                    articleFound = true;
                }
                if(articleFound)
                {
                    at.append(line);
                }
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        String token = at.toString().replaceAll("<p>", " ");
        token = token.replaceAll("</p>", ".");
        token = token.replaceAll("</h1>", ".");
        token = token.replaceAll("\\</article>.*","");
        token = token.replaceAll("\\<aside*\\</aside","");
        //token = token.replaceAll("\\<div*\\</div","");
        token = token.replaceAll("\\<table*\\</table","");
        token = token.replaceAll("id=\"[a-z]*ad[a-z]*\"*","");

        token = token.replaceAll("\\<[^>]*>"," ");
        token = token.replaceAll("  +"," ");
        token = token.replaceAll("[\t]+"," ");
        token = token.replaceAll(" +"," ");


        articleText = token;



    }

    public String getArticleText()
    {
        return articleText;
    }
}
