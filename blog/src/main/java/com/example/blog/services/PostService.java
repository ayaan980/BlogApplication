package com.example.blog.services;

import com.example.blog.entity.Post;
import com.example.blog.payloads.PostDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO,String userId,String categoryId );
    Post updatePost(PostDTO postDTO,String postId );
    void deletePost(Integer postId);
    List<Post> getAllPost();
    Post getPostById(Integer postId);
    List<Post> getPostByCategory(Integer categoryId);
    List<Post> getPostByUser(Integer userId);
    List<Post> searchPost(String keyword);
}
