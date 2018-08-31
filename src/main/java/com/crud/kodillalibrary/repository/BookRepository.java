package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

    Optional<Book> findById(Long id);

    @Override
    Book save(Book book);

    @Override
    void delete(Long id);
}