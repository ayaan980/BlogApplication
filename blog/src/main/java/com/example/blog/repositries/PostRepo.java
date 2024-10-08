package com.example.blog.repositries;

import com.example.blog.entity.Category;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,String> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
