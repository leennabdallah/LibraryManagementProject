package com.libraryManagementSystem.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "borrowers")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Borrowers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column( name = "name")
    private String name;

    @Column( name = "email")
    private String email;

    @Column ( name = "phone_number")
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name="borrower_id", referencedColumnName = "id")
    private Set<BorrowingTransactions> transactions= new HashSet<>();

}
