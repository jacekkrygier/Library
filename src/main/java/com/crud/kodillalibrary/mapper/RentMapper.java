package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Rent;
import com.crud.kodillalibrary.domain.RentDto;
import com.crud.kodillalibrary.domain.RentDtos;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RentMapper {
    public Rent mapToRent(final RentDto rentDto) {
        return new Rent(rentDto.getId() ,rentDto.getCopyId(), rentDto.getReader(), rentDto.getRentDate(), rentDto.getReturnDate());
    }

    public RentDtos mapToRentDto(final Rent rent) {
        return new RentDtos(rent.getId(), rent.getCopyId().getBookId().getTitle(), rent.getReader().getFirstname(), rent.getReader().getLastname(), rent.getRentDate().toString(), Objects.toString(rent.getReturnDate(),""));
    }

    public List<RentDtos> mapToRentDtoList(final List<Rent> rentList) {
        return rentList.stream()
                .map(t -> new RentDtos(t.getId(),t.getCopyId().getBookId().getTitle(),t.getReader().getFirstname(),
                        t.getReader().getLastname(), t.getRentDate().toString(), Objects.toString(t.getReturnDate(),"")))
                .collect(Collectors.toList());
    }
}