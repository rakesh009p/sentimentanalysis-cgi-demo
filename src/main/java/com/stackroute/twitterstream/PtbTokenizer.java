package com.stackroute.twitterstream;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.AnnotatorPool;
//import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;


import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class PtbTokenizer {
    static StanfordCoreNLP pipeline;
    private static Properties tweet;

    public static void main(String[] args) throws NullPointerException, IOException {
        File myFile = new File("src/main/resources/survey");
        PTBTokenizer ptbTokenizer = new PTBTokenizer<>(new FileReader(myFile), new CoreLabelTokenFactory(), "");
        while (ptbTokenizer.hasNext()) {
            CoreLabel coreLabel = (CoreLabel) ptbTokenizer.next();
            System.out.println(coreLabel);
        }
        PtbTokenizer ptbTokenizer1 = new PtbTokenizer();
        System.out.println(ptbTokenizer1.findSentiment(myFile));
    }

    public static double findSentiment(File line) throws NullPointerException {

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit,pos, parse, sentiment, lemma");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        double mainSentiment = 0;
        if (line != null && line.length() > 0) {
            double longest = 0;
            Annotation annotation = pipeline.process(String.valueOf(line));
            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
                String partText = sentence.toString();
                if (partText.length() > longest) {
                    mainSentiment = sentiment;
                    longest = partText.length();
                }

            }
        }


        return Math.ceil(mainSentiment);
    }


}





