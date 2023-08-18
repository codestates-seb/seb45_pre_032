package com.Exception;

import lombok.Getter;

public enum ExceptionCode {

    VOTE_NOT_FOUND(404, "Vote Not Found"),
    COMMENT_NOT_FOUND(404, "Comment Not Found"),
    MEMBER_FORBIDDEN(403, "Forbidden User"),
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member exists"),
    INVALID_MEMBER_STATUS(400, "Invalid member status");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
