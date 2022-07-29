package com.example.errorhandling.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Exception {
    INVALIDATE_USER("NULL_POST_ID", "post id isn't exist"),
    INVALIDATE_PW("NOT_MATCHED_PW", "pw is not matched");

    private final String code;
    private final String message;

}
