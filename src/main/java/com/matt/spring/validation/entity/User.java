package com.matt.spring.validation.entity;

import com.matt.spring.validation.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 사용자 정보 Entity
 */
@Entity
@NoArgsConstructor
@Getter @Setter
public class User {
    @Id
    private String userId;
    private String userName;
    private String email;
    private String address;

    public User(UserDto userDto) {
        this.userId = userDto.getUserId();
        this.userName = userDto.getUserName();
        this.email = userDto.getEmail();
        this.address = userDto.getAddress();
    }
}
