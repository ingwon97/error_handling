package com.example.errorhandling.dto;

import com.example.errorhandling.domain.Domain;
import lombok.Getter;

@Getter
public class PostDataDto {
    private String title;
    private String content;
    private String author;

    public PostDataDto(Domain domain) {
        this.title = domain.getTitle();
        this.content = getContent();
        this.author = getAuthor();
    }
}
