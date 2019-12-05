package com.stackroute.twitterstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication
public class TwitterStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterStreamApplication.class, args);

	Stream stream= new Stream();
	Sentimental sentimental= new Sentimental();
	sentimental.findSentiment();
	stream.getTweets();


}}
