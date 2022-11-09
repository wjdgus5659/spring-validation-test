package com.matt.spring.validation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 사용자 정보 Dto
 */
@Getter @Setter
public class UserDto {
    @NotBlank
    private String userId;
    @NotBlank
    private String userName;
    @Email
    private String email;
    private String address;
}
