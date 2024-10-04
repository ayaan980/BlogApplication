package com.example.blog.services;

import com.example.blog.entity.Post;
import com.example.blog.payloads.PostDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO,String userId,String categoryId );
    Post updatePost(PostDTO postDTO,String postId );
    void deletePost(String postId);
    List<PostDTO> getAllPost();
    Post getPostById(String postId);
    List<PostDTO> getPostByCategory(String categoryId);
    List<PostDTO> getPostByUser(String userId);
    List<PostDTO> searchPost(String keyword);
}
