package com.tsa;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    String topic = "Narendra Modi";
    ArrayList<String> tweets = TweetsFetcher.fetchtweets(topic);
    NLP.init();
    for(String tweet : tweets) {
      System.out.println(tweet + " : " + NLP.findSentiment(tweet));
    }
  }

}
