package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDto {
    private Long id;
    private String firstname;
    private String lastname;
    private Date signUpDate;
    private List<Rent> rents;
}