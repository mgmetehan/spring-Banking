package com.mgmetehan.springBanking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String surname;

    private String password;

    @Column(name = "identification_number")
    private String identificationNumber;

    private String city;

    @Column(name = "mobile_number")
    private String mobileNumber;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date createdAtDate=new Date();

}
