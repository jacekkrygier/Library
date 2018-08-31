package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.BookDto;
import com.crud.kodillalibrary.domain.BookDtos;
import com.crud.kodillalibrary.mapper.BookMapper;
import com.crud.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/book")
public class BookController {
    @Autowired
    private DbService service;
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDtos> getBooks() {
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDtos getBook(@RequestParam Long id) throws BookNotFoundException{
        return bookMapper.mapToBookDto(service.getBook(id).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam String id) {
        service.deleteBook(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public BookDtos updateBook(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(service.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook")
    public void createBook(@RequestBody BookDto bookDto) {
        service.saveBook(bookMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTest")
    public void createTest(@RequestBody BookDto bookDto) {
        service.saveTest();
    }
}