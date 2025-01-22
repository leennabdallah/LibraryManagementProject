package com.libraryManagementSystem.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowersRequestDTO {
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
}
