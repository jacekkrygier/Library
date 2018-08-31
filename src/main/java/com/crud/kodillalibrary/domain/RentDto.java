package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RentDto {
    private Long id;
    private Copy copyId;
    private Reader reader;
    private Date rentDate;
    private Date returnDate;
}