package com.example.errorhandling.service;

import com.example.errorhandling.domain.Domain;
import com.example.errorhandling.dto.*;
import com.example.errorhandling.repository.DomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class DomainService {
    private final DomainRepository domainRepository;

    @Transactional
    public SingleResponse update(Long id, DomainRequestDto requestDto) {
        // update에 접근하기 위한 임시 객체
        Domain domain= domainRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시글이 없습니다.")
        );
        domain.update(requestDto);
        Data data = new Data(domain);
        return getSingleResponse(data);
    }

    public <T> SingleResponse<T> getSingleResponse(T data) {
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.data = data;
        setSuccessResponse(singleResponse);

        return singleResponse;
    }

    public <T> ListResponse<T> getListResponse(ArrayList<T> dataList) {
        ListResponse listResponse = new ListResponse();
        listResponse.dataList = dataList;
        setSuccessResponse(listResponse);

        return listResponse;
    }

    void setSuccessResponse(CommonResponse response) {
        response.success = true;
        response.error = "null";
    }

    // 에러 응답
    public CommonResponse getErrorResponse(String code, String message) {
//        CommonResponse response = new CommonResponse();
        SingleResponse response= new SingleResponse();
        response.success = false;
        response.data = null;
        response.error = message;
        return response;
    }

    public CommonResponse getSuccessResponse() {
        SingleResponse response = new SingleResponse();
        response.success = true;
        response.data = true;
        response.error = null;
        return response;
    }

}
