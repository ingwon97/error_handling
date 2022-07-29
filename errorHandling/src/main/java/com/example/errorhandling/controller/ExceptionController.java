package com.example.errorhandling.controller;

import com.example.errorhandling.dto.CommonResponse;
import com.example.errorhandling.exception.Exception;
import com.example.errorhandling.exception.InvalidatePwException;
import com.example.errorhandling.exception.InvalidateUserException;
import com.example.errorhandling.service.DomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {

    private final DomainService domainService;

    @ExceptionHandler(InvalidateUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private CommonResponse invalidateUserException(InvalidateUserException e) {
        log.info(e.getMessage());
        return domainService.getErrorResponse(Exception.INVALIDATE_USER.getCode(), Exception.INVALIDATE_USER.getMessage());
    }

    @ExceptionHandler(InvalidatePwException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private CommonResponse invalidatePwException(InvalidatePwException e) {
        log.info(e.getMessage());
        return domainService.getErrorResponse(Exception.INVALIDATE_PW.getCode(), Exception.INVALIDATE_PW.getMessage());
    }
}
