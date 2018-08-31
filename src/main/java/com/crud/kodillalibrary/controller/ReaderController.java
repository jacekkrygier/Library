package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.ReaderDto;
import com.crud.kodillalibrary.domain.ReaderDtos;
import com.crud.kodillalibrary.mapper.ReaderMapper;
import com.crud.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/reader")
public class ReaderController {
    @Autowired
    private DbService service;

    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDtos> getReaders() {
        return readerMapper.mapToReaderDtoList(service.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReader")
    public ReaderDtos getReader(@RequestParam Long id) throws ReaderNotFoundException{
        return readerMapper.mapToReaderDto(service.getReader(id).orElseThrow(ReaderNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteReader")
    public void deleteReader(@RequestParam String id) {
        service.deleteReader(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateReader")
    public ReaderDtos updateReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(service.saveReader(readerMapper.mapToReader(readerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader")
    public void createReader(@RequestBody ReaderDto readerDto) {
        service.saveReader(readerMapper.mapToReader(readerDto));
    }
}