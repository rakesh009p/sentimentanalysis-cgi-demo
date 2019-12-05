package com.stackroute.twitterstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterStreamApplication.class, args);

        Streaming stream = new Streaming();
        Sentimental sentimental = new Sentimental();
        sentimental.findSentiment();
        stream.getTweets();


    }
}
