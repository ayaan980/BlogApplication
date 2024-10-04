package com.example.blog.payloads;

import com.example.blog.entity.Category;
import com.example.blog.entity.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private String postTitle;
    private String content;
    private String imgName;
    private Date addDate;
    private CategoryDTO category;
    private UserDTO user;

}
