package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.domain.CopyDto;
import com.crud.kodillalibrary.domain.CopyDtos;
import com.crud.kodillalibrary.mapper.CopyMapper;
import com.crud.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/copy")
public class CopyController {
    @Autowired
    private DbService service;

    @Autowired
    private CopyMapper copyMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getCopies")
    public List<CopyDtos> getCopies() {
        return copyMapper.mapToCopyDtoList(service.getAllCopy());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopy")
    public CopyDtos getCopy(@RequestParam Long id) throws CopyNotFoundException {
        return copyMapper.mapToCopyDto(service.getCopy(id).orElseThrow(CopyNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCopy")
    public void deleteCopy(@RequestParam String id) {
        service.deleteCopy(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCopy")
    public CopyDtos updateCopy(@RequestBody CopyDto copyDto) {

        return copyMapper.mapToCopyDto(service.saveCopy(copyMapper.mapToCopy(copyDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCopy")
    public void createCopy(@RequestBody CopyDto copyDto) {
        service.saveCopy(copyMapper.mapToCopy(copyDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "countByStatus")
    public long countByStatus(@RequestParam String title,@RequestParam String bookStatus) {
        List<Copy> copies = service.countByStatus(bookStatus);

        return copies.stream()
                .filter(copy -> copy.getBookId().getTitle().equals(title))
                .count();
    }
}