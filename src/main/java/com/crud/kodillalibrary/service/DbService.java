package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.domain.Rent;
import com.crud.kodillalibrary.repository.BookRepository;
import com.crud.kodillalibrary.repository.CopyRepository;
import com.crud.kodillalibrary.repository.ReaderRepository;
import com.crud.kodillalibrary.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private RentRepository rentRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
    public List<Copy> getAllCopy() {
        return copyRepository.findAll();
    }
    public List<Rent> getAllBorrowings() {
        return rentRepository.findAll();
    }

    public Optional<Book> getBook(final Long id) {
        return bookRepository.findById(id);
    }
    public Optional<Reader> getReader(final Long id) {
        return readerRepository.findById(id);
    }
    public Optional<Copy> getCopy(final Long id) {
        return copyRepository.findById(id);
    }
    public Optional<Rent> getRent(final Long id) {
        return rentRepository.findById(id);
    }

    public Book saveBook(final Book book) {
        book.getCopies().stream()
                .forEach(t -> t.setBookId(book));
        return bookRepository.save(book);
    }
    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }
    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }
    public Rent saveRent(final Rent rent) {
        return rentRepository.save(rent);
    }

    public void deleteBook(final Long id) {
        bookRepository.delete(id);
    }
    public void deleteReader(final Long id) {
        readerRepository.delete(id);
    }
    public void deleteCopy(final Long id) {
        copyRepository.delete(id);
    }
    public void deleteRent(final Long id) {
        rentRepository.delete(id);
    }

    public List<Copy> countByStatus(final String bookStatus) {
        return copyRepository.findByStatus(bookStatus);
    }

    public void saveTest() {
        Book book = new Book("titlesTest2", "authorTest2", 2222);
        Copy copy = new Copy("statusTest2");
        copy.setBookId(book);
        book.getCopies().add(copy);

        bookRepository.save(book);
    }
}