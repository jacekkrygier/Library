package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RentDtos {
    private Long id;
    private String bookTitle;
    private String readerName;
    private String readerSurname;
    private String rentDate;
    private String returnDate;
}