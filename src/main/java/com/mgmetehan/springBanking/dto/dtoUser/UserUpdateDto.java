package com.mgmetehan.springBanking.dto.dtoUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    private String username;

    private String surname;

    private String password;

    private String identificationNumber;

    private String city;

    private String mobileNumber;

    private String email;

    private Date createdAtDate;
}
