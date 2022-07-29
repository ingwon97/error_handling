package com.example.errorhandling.dto;

import com.example.errorhandling.domain.Domain;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Data {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long id;
    private String title;
    private String content;
    private String author;

    public Data(Domain domain) {
        this.id = domain.getId();
        this.title = domain.getTitle();
        this.content = domain.getContent();
        this.author = domain.getAuthor();
        this.createdAt = domain.getCreatedAt();
        this.modifiedAt = domain.getModifiedAt();
    }
}
