package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "post")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    private String postId;
    private String postTitle;
    private String content;
    private String imgName;
    private Date addDate;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;




}
