package com.example.blog.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String id;

    @NotEmpty
    @Size(min = 4,message = "Name Should Be More Than 4 Characters")
    private String name;

    @Email(message = "Email is not valid")
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 6,message = "Password should be minimun 6 Char")
    private String password;

    @NotEmpty(message = "About cannot be blank")
    @Size(max = 200,message = "About cannot be more than 200 Characters")
    private String about;
}
