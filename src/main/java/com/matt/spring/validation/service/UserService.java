package com.matt.spring.validation.service;

import com.matt.spring.validation.dto.UserDto;
import com.matt.spring.validation.entity.User;
import com.matt.spring.validation.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 사용자 관련 Service
 */
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJpaRepository userJpaRepository;

    /**
     * 사용자 정보 조회
     * @param userId
     * @return
     * @throws Exception
     */
    public User findUser(String userId) throws Exception {
        return userJpaRepository.findById(userId).orElseThrow(() -> new Exception());
    }

    /**
     * 사용자 정보 저장
     * @param userDto
     */
    public void saveUser(UserDto userDto) {
        userJpaRepository.save(new User(userDto));
    }
}
