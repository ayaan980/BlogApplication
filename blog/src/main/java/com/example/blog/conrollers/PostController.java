package com.example.blog.conrollers;


import com.example.blog.entity.Post;
import com.example.blog.payloads.PostDTO;
import com.example.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO,
                                              @PathVariable String userId,
                                              @PathVariable String categoryId){
        PostDTO createPost = this.postService.createPost(postDTO, userId, categoryId);
        return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);

    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getByUser(@PathVariable String userId){
        List<PostDTO> postByUser = this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDTO>>(postByUser,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getByCategory(@PathVariable String categoryId){
        List<PostDTO> postByCategory = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDTO>>(postByCategory,HttpStatus.OK);
    }

}

