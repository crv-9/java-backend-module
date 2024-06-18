package io.everyonecodes.w1springbeans.jsonplaceholder.client;

import io.everyonecodes.w1springbeans.jsonplaceholder.logic.PostTranslator;
import io.everyonecodes.w1springbeans.jsonplaceholder.model.Post;
import io.everyonecodes.w1springbeans.jsonplaceholder.model.PostDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* JsonPlaceholderClient. Injects the RestTemplate  and the PostTranslator beans.
* Is responsible for the external communication with the jsonplaceholder API.
* Its methods always receive or return Posts, but the communication with the external API is done with PostDTOs.
* Has a method that gets all the Posts.
* Has a method that gets one Post.
* Has a method that posts one Post.
* Has a method that modifies one Post.
* Has a method that deletes one Post.

 * */
@Controller
public class JsonPlaceholderClient {
    private final RestTemplate restTemplate;
    private final PostTranslator postTranslator;
    private final String url = "https://jsonplaceholder.typicode.com/posts/";

    public JsonPlaceholderClient(RestTemplate restTemplate, PostTranslator postTranslator) {
        this.restTemplate = restTemplate;
        this.postTranslator = postTranslator;
    }

    public List<Post> getAllPosts(){
        PostDTO[] incomingPosts = restTemplate.getForObject(url, PostDTO[].class);
        assert incomingPosts != null;
        ArrayList<PostDTO> posts = new ArrayList<>(Arrays.asList(incomingPosts));
        return posts.stream()
                .map(postTranslator::translateDTOToNormal)
                .toList();
    }

    public Post getOnePost(int id){
        PostDTO incomingPostDTO = restTemplate.getForObject(url + id, PostDTO.class);
        assert incomingPostDTO != null;
        return postTranslator.translateDTOToNormal(incomingPostDTO);
    }


    // I am creating a post, but i need to send it as DTO
    // what I get in return is also a DTO, so I need to change it into a post again.
    public Post createPost(Post post){
        PostDTO newDTO = postTranslator.translateNormalToDTO(post);
        return postTranslator.translateDTOToNormal(restTemplate.postForObject(url, newDTO, PostDTO.class));
    }

    // I am indicating which url+id I want to put, then I call it to review that I have updated it
    public Post updatePost(String id, Post post){
        restTemplate.delete(url + id);
        PostDTO newDTO = postTranslator.translateNormalToDTO(post);
        return postTranslator.translateDTOToNormal(restTemplate.postForObject(url, newDTO, PostDTO.class));
    }

    // delete post
    public void deletePost(String id){
        restTemplate.delete(url + id);
    }



}
