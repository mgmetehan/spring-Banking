package com.mgmetehan.springBanking.dto.dtoUser;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreateDto {

    private String username;

    private String surname;

    private String password;

    private String identificationNumber;

    private String city;

    private String mobileNumber;

    private String email;

}
