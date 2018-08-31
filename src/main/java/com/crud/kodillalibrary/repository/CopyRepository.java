package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Override
    List<Copy> findAll();

    Optional<Copy> findById(Long id);

    @Override
    Copy save(Copy copy);

    @Override
    void delete(Long id);

    List<Copy> findByStatus(String bookStatus);
}