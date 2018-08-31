package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.domain.ReaderDto;
import com.crud.kodillalibrary.domain.ReaderDtos;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {
    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstname(),
                readerDto.getLastname(),
                readerDto.getSignUpDate(),
                readerDto.getRents());
    }

    public ReaderDtos mapToReaderDto(final Reader reader) {
        return new ReaderDtos(
                reader.getId(),
                reader.getFirstname(),
                reader.getLastname(),
                reader.getSignUpDate().toString());
    }

    public List<ReaderDtos> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(t -> new ReaderDtos(t.getId(),t.getFirstname(),t.getLastname(),t.getSignUpDate().toString()))
                .collect(Collectors.toList());
    }
}