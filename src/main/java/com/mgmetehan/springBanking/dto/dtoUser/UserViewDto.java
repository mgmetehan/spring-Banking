package com.mgmetehan.springBanking.dto.dtoUser;

import com.mgmetehan.springBanking.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserViewDto {
    private long id;

    private String username;

    private String surname;

    private String password;

    private String identificationNumber;

    private String city;

    private String mobileNumber;

    private String email;

    private Date createdAtDate;

    public static UserViewDto of(User user) {
        return new UserViewDto(user.getId(), user.getUsername(), user.getSurname(), user.getPassword(), user.getIdentificationNumber(),
                user.getCity(), user.getMobileNumber(), user.getEmail(), user.getCreatedAtDate());
    }
}
