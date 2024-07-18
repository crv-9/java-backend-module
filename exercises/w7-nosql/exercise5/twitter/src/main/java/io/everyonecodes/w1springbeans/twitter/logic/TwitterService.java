package io.everyonecodes.w1springbeans.twitter.logic;

import io.everyonecodes.w1springbeans.twitter.model.Tweet;
import io.everyonecodes.w1springbeans.twitter.repositories.TweetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TwitterService {

    TweetRepository tweetRepository;

    public TwitterService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    // get a list of all tweets
    public List<Tweet> getAllTweets() {
        return tweetRepository.findByOrderByTimestampDesc();
    }

    // get a list of all tweets from user
    public List<Tweet> getAllTweetsByUser(String user) {
        return tweetRepository.findByUserOrderByTimestampDesc(user);
    }

    // add a tweet
    public Tweet postTweet(Tweet tweet) {
        addTimestampToTweet(tweet);
        return tweetRepository.save(tweet);
    }

    // add like to specific tweet
    public Optional<Tweet> addLikeToTweet(String id) {
        Optional<Tweet> oTweet = tweetRepository.findById(id);
        oTweet.ifPresent(tweet -> tweet.setLikes(tweet.getLikes() + 1));
        oTweet.ifPresent(tweet -> tweetRepository.save(tweet));
        System.out.println("like added to tweet");
        return oTweet;
    }

    // add comment to specific tweet
    public void addCommentToTweet(String id, String comment) {
        Optional<Tweet> oTweet = tweetRepository.findById(id);
        if (oTweet.isPresent()){
            List<String> commentsList = oTweet.get().getComments();
            commentsList.add(comment);
            tweetRepository.save(oTweet.get());
        }
    }

    private void addTimestampToTweet(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
    }

}
