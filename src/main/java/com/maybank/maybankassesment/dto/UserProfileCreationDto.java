package com.maybank.maybankassesment.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserProfileCreationDto {

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    private String dob;

}
