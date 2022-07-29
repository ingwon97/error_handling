package com.example.errorhandling.dto;

import com.example.errorhandling.domain.Domain;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DomainRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;

    public DomainRequestDto(Domain domain) {
        this.title = domain.getTitle();
        this.content = domain.getContent();
        this.author = domain.getAuthor();
        this.password = domain.getPassword();
    }
}
