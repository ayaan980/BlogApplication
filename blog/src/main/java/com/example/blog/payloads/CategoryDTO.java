package com.example.blog.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTO {

    private String categoryId;
    private String categoryTitle;
    private String categoryDesc;
}
