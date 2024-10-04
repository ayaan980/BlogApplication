package com.example.blog.payloads;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTO {



    private String categoryId;

    @NotEmpty(message = "Title cannot be empty")
    private String categoryTitle;

    @NotEmpty(message = "Description cannot be blank")
    @Size(max = 200,message = "Description cannot be more than 200 Characters")
    private String categoryDesc;
}
