package com.matt.spring.validation.controller;

import com.matt.spring.validation.dto.CommonResponseData;
import com.matt.spring.validation.dto.UserDto;
import com.matt.spring.validation.entity.User;
import com.matt.spring.validation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 사용자 관련 Controller
 */
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    /**
     * 사용자 정보 조회
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> findUser(@RequestParam String userId) throws Exception {
        User user = userService.findUser(userId);
        return ResponseEntity.ok().body(user);
    }

    /**
     * 사용자 정보 추가
     * @param userDto
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/user2", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser2(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorList = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
            CommonResponseData response = new CommonResponseData(false);
            response.setErrorMessage(String.join(", ", errorList));
            return ResponseEntity.badRequest().body(response);
        }
        userService.saveUser(userDto);
        return ResponseEntity.ok().build();
    }
}
