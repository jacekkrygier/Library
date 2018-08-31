package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CopyDto {
    private Long id;
    private String status;
    private Book bookId;
    private List<Rent> rents;

    public CopyDto(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}