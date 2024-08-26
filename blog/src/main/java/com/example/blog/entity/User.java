package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="usersInfo")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="about")
    private String about;
}
