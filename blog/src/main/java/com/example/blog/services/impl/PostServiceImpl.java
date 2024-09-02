package com.example.blog.services.impl;

import com.example.blog.entity.Category;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import com.example.blog.exceptions.ResourceNotFoundException;
import com.example.blog.payloads.PostDTO;
import com.example.blog.repositries.CategoryRepo;
import com.example.blog.repositries.PostRepo;
import com.example.blog.repositries.UserRepo;
import com.example.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;



    @Override
    public PostDTO createPost(PostDTO postDTO,String userId,String categoryId) {

        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException());
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException());
        String randomUserId = UUID.randomUUID().toString();
        Post post=this.modelMapper.map(postDTO,Post.class);
        post.setPostId(randomUserId);
        post.setImgName("default.png");
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost,PostDTO.class);
    }

    @Override
    public Post updatePost(PostDTO postDTO, String postId) {
        return null;
    }

    @Override
    public void deletePost(String postId) {

    }

    @Override
    public List<PostDTO> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(String postId) {
        return null;
    }

    @Override
    public List<PostDTO> getPostByCategory(String categoryId) {
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException());
        List<Post> posts = this.postRepo.findByCategory(category);
        List<PostDTO> collect = posts.stream().map(post -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<PostDTO> getPostByUser(String userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException());
        List<Post> postByUser = this.postRepo.findByUser(user);
        List<PostDTO> collect = postByUser.stream().map((posts) -> this.modelMapper.map(posts, PostDTO.class)).collect(Collectors.toList());
       return collect;
    }

    @Override
    public List<PostDTO> searchPost(String keyword) {
        return null;
    }
}
