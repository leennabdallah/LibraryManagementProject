package com.libraryManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "author_book")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthorBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name="book_id")
    Book book;

    @ManyToOne
    @JoinColumn(name="author_id")
    Author author;
}
