package com.tsa;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TweetsFetcher {

    public static void main (String[] args)
    {
        Twitter twitter = new TwitterFactory().getInstance();
        String topic="Modi";
        int i=0;
        try {
            Query query = new Query(topic);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {

                    System.out.println(tweet.getText()+" ");
                    i++;
                    if(i==100)
                    {
                        break;
                    }
                    //tweetList.add(tweet.getText());
                }
                if(i==100)
                {
                    break;
                }
            } while ((query = result.nextQuery()) != null);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
        //return tweetList;
    }
}