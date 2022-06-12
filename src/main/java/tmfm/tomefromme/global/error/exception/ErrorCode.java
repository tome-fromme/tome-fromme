package tmfm.tomefromme.global.error.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // 회원
    MEMBER_NOT_EXIST(400, "해당 회원은 존재하지 않습니다.");

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;

}