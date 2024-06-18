package io.everyonecodes.w1springbeans.jsonplaceholder.endpoints;

import io.everyonecodes.w1springbeans.jsonplaceholder.client.JsonPlaceholderClient;
import io.everyonecodes.w1springbeans.jsonplaceholder.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostEndpoint {

    private final JsonPlaceholderClient jsonPlaceholderClient;
    public PostEndpoint(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    // getting all posts
    @GetMapping
    public List<Post> showAllPosts() {
       return jsonPlaceholderClient.getAllPosts();
    }

    // getting one specific post
    @GetMapping("/{id}")
    public Post showPost(@PathVariable int id) {
        return jsonPlaceholderClient.getOnePost(id);
    }

    // creating one post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return jsonPlaceholderClient.createPost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post post) {
        return jsonPlaceholderClient.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String id) {
        jsonPlaceholderClient.deletePost(id);
    }


}
