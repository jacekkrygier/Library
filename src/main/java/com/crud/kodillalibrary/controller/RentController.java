package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.domain.Rent;
import com.crud.kodillalibrary.domain.RentDto;
import com.crud.kodillalibrary.domain.RentDtos;
import com.crud.kodillalibrary.mapper.RentMapper;
import com.crud.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/rent")
public class RentController {
    @Autowired
    private DbService service;
    @Autowired
    private RentMapper rentMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBorrowings")
    public List<RentDtos> getBorrowings() {
        return rentMapper.mapToRentDtoList(service.getAllBorrowings());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRent")
    public RentDtos getRent(@RequestParam Long id) throws RentNotFoundException{
        return rentMapper.mapToRentDto(service.getRent(id).orElseThrow(RentNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteRent")
    public void deleteRent(@RequestParam String id) {
        service.deleteRent(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateRent")
    public RentDtos updateBorrowing(@RequestBody RentDto rentDto) {
        return rentMapper.mapToRentDto(service.saveRent(rentMapper.mapToRent(rentDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createRent")
    public void createBorrowing(@RequestBody RentDto rentDto) {
        Optional<Copy> copy = service.getCopy(rentDto.getCopyId().getId());
        if(copy.get().getStatus().equals("w obiegu")) {
            service.saveRent(rentMapper.mapToRent(rentDto));
            copy.get().setStatus("wypozyczona");
            service.saveCopy(copy.get());
        }
        else {
            System.out.println("Book is borrowed or lost");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "returnBook")
    public void returnBook(@RequestBody RentDto rentDto) {
        Optional<Copy> copy = service.getCopy(rentDto.getCopyId().getId());
        Optional<Rent> rent = service.getRent(rentDto.getId());

        if(rent.get().getReturnDate() == null) {

            rent.get().setReturnDate(new Date());
            service.saveRent(rent.get());

            copy.get().setStatus("w obiegu");
            service.saveCopy(copy.get());
        }
        else {
            System.out.println("Wrong borrowing");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "lostBook")
    public void lostBook(@RequestBody RentDto rentDto) {
        Optional<Copy> copy = service.getCopy(rentDto.getCopyId().getId());
        if(copy.get().getStatus().equals("wypozyczona")) {
            copy.get().setStatus("zagubiona");
            service.saveCopy(copy.get());
        }
        else {
            System.out.println("Wrong borrowing");
        }
    }
}