package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.BookDto;
import com.crud.kodillalibrary.domain.BookDtos;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear(),
                bookDto.getCopies());
    }
    public BookDtos mapToBookDto(final Book book){
        return new BookDtos(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear());
    }

    public List<BookDtos> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(t -> new BookDtos(t.getId(),t.getTitle(),t.getAuthor(),t.getPublicationYear()))
                .collect(Collectors.toList());

    }
}