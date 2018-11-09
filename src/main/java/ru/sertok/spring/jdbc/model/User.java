package ru.sertok.spring.jdbc.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String password;
    private Date birthDate;
}
