package com.matt.spring.validation.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * API 공통 응답 데이터
 */
@Getter @Setter
public class CommonResponseData {
    private boolean success;        // 성공 여부
    private String errorMessage;    // 에러 메세지

    public CommonResponseData() {
        this.success = true;
    }
    public CommonResponseData(boolean success) {
        this.success = success;
    }
}
