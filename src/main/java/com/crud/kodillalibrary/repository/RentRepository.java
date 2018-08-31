package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {

    @Override
    Rent save(Rent rent);

    Optional<Rent> findById(Long id);

    @Override
    List<Rent> findAll();

    @Override
    void delete(Long id);
}