package com.example.errorhandling.dto;

import java.util.List;

public class ListResponse<T> extends CommonResponse {
    public List<T> dataList;
}
