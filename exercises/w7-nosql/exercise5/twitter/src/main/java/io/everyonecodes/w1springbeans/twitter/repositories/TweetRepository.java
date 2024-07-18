package io.everyonecodes.w1springbeans.twitter.repositories;

import io.everyonecodes.w1springbeans.twitter.model.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/*Has a method that returns a list of Tweet elements already sorted by timestamp in descending order.
Has a method that returns a list of Tweet elements that belong to a particular user, already sorted by timestamp in descending order.
 */

public interface TweetRepository extends MongoRepository<Tweet, String> {

    // returns list of all tweets ordered by timestamp
    List<Tweet> findByOrderByTimestampDesc();

    // returns list of tweets from a specific user ordered by timestamp
    List<Tweet> findByUserOrderByTimestampDesc(String user);
}
