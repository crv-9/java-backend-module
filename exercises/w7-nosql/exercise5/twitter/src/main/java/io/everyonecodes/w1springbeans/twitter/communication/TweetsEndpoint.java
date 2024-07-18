package io.everyonecodes.w1springbeans.twitter.communication;

import io.everyonecodes.w1springbeans.twitter.logic.TwitterService;
import io.everyonecodes.w1springbeans.twitter.model.Tweet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tweets")
public class TweetsEndpoint {
    private final TwitterService twitterService;

    public TweetsEndpoint(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    // get all saved tweets
    @GetMapping
    public List<Tweet> getAllTweets(){
        return twitterService.getAllTweets();
    }

    @GetMapping("/user/{user}")
    public List<Tweet> getUserTweets(@PathVariable String user){
        return twitterService.getAllTweetsByUser(user);
    }

    @PostMapping
    public Tweet addTweet(@RequestBody Tweet tweet){
        return twitterService.postTweet(tweet);
    }

    @PutMapping("/tweets/{id}/likes")
    public void addLike(@PathVariable String id){
        twitterService.addLikeToTweet(id);
    }

    @PutMapping("/tweets/{id}/comments")
    public void addComment(@PathVariable String id, @RequestBody String comment){
        twitterService.addCommentToTweet(id, comment);
    }

}
