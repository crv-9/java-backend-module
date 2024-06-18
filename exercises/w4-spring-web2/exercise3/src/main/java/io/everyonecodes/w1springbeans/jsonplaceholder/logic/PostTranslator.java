package io.everyonecodes.w1springbeans.jsonplaceholder.logic;

import io.everyonecodes.w1springbeans.jsonplaceholder.model.Post;
import io.everyonecodes.w1springbeans.jsonplaceholder.model.PostDTO;
import org.springframework.stereotype.Service;

@Service
public class PostTranslator {

    // translate from Post to PostDTO
    public PostDTO translateNormalToDTO(Post post) {
        return new PostDTO(post.getTitle(), post.getContent(), post.getUser(), post.getIdentifier());
    }

    // translate from PostDTO to Post
    public Post translateDTOToNormal(PostDTO postDTO) {
        return new Post(postDTO.getTitle(), postDTO.getBody(), postDTO.getUserId(), postDTO.getId());
    }

}
