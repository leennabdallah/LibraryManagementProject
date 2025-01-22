package com.libraryManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "availability")
    private boolean availability=true;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;


    @OneToMany
    @JoinColumn(name="book_id", referencedColumnName = "id")
    private Set<BorrowingTransactions> transactions= new HashSet<>();
}
