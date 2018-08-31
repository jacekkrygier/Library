package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RENTS")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COPY_ID")
    private Copy copyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @Column(name = "RENT_DATE")
    private Date rentDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;

    public Rent(Copy copyId, Reader reader) {
        this.copyId = copyId;
        this.reader = reader;
    }

}