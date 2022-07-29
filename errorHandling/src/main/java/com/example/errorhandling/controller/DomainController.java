package com.example.errorhandling.controller;

import com.example.errorhandling.domain.Domain;
import com.example.errorhandling.dto.*;
import com.example.errorhandling.exception.InvalidatePwException;
import com.example.errorhandling.exception.InvalidateUserException;
import com.example.errorhandling.repository.DomainRepository;
import com.example.errorhandling.service.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class DomainController {

    private final DomainRepository domainRepository;
    private final DomainService domainService;

    // 전체 게시글 목록 조회
    @GetMapping("/api/post")
    public ListResponse<Data> getPosts() {
        List<Domain> data = domainRepository.findAllByOrderByModifiedAtDesc();
        ArrayList<Data> dataArrayList = new ArrayList<>();

        for (Domain datum : data) {
            Data dto = new Data(datum);
            dataArrayList.add(dto);
        }
//        return dataArrayList;
        return domainService.getListResponse(dataArrayList);
    }

    // 게시글 조회 API
    @GetMapping("/api/post/{id}")
    public SingleResponse<Data> getPostByUser(@PathVariable Long id) {
        Domain domain = domainRepository.findById(id).orElseThrow(InvalidateUserException::new);
        Data data = new Data(domain);
        return domainService.getSingleResponse(data);
    }

    //게시글 작성
    @PostMapping("/api/post")
    public SingleResponse<Data> createPost(@RequestBody DomainRequestDto requestDto) {
        Domain domain = new Domain(requestDto);
        domainRepository.save(domain);

        Data data = new Data(domain);
        return domainService.getSingleResponse(data);
    }

    // 비밀번호 일치 여부 확인하기
    @PostMapping("/api/post/{id}")
    public CommonResponse checkPw(@PathVariable Long id, @RequestBody DomainRequestDto requestDto) {
        Domain domain = domainRepository.findById(id).orElseThrow(InvalidateUserException::new);
        if (!domain.checkPw(requestDto)) {
            throw new InvalidatePwException();
        }
        return domainService.getSuccessResponse();
    }

    // 게시글 비밀번호 확인 API

    // 게시글 수정 API
    @PutMapping("/api/post/{id}")
    public SingleResponse updatePost(@PathVariable Long id, @RequestBody DomainRequestDto requestDto) {
        domainRepository.findById(id).orElseThrow(InvalidateUserException::new);
        return domainService.update(id, requestDto);
    }

    // 게시글 삭제 API
    @DeleteMapping("/api/post/{id}")
    public CommonResponse deletePost(@PathVariable Long id) {
        domainRepository.findById(id).orElseThrow(InvalidateUserException::new);
        domainRepository.deleteById(id);
        return domainService.getSuccessResponse();
    }
}
