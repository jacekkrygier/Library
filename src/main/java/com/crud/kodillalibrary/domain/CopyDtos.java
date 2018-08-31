package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CopyDtos {
    private Long id;
    private String status;
    private Long bookId;

    public CopyDtos(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}