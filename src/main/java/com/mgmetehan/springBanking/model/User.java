package com.mgmetehan.springBanking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public User(String username, String surname, String password, String identificationNumber, String city, String mobileNumber, String email) {
        this.username = username;
        this.surname = surname;
        this.password = password;
        this.identificationNumber = identificationNumber;
        this.city = city;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
}
