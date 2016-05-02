# ArticleDe-lengthener
A utility that will parse an internet article and extract the most important information from it.

##How it works
The Article De-lengthener will scan an article at the given URL and tally up the number of times each word is used.  At the end of this stage, the tool has a list of words and their frequency of appearance in the article.  The tool loads a file of ignored words (primarily prepositions, articles, and pronouns) and removes collisions from the ranked list.  The tool will then separate the news article into individual sentences and rank them based on the sentence's use of the top 15 words in the ranked word list.  Highly ranked sentences are displayed at the end.  

##Installation and Usage
Eventually there will be a .jar of the complete project somewhere in the out/artifacts/ directory.  Simply download this archive, navigate to the download directory and do: 
//java -jar ./ArticleScannerBot [Put URL Here]

##TODO
<ul>
<li>Make a GUI</li>
