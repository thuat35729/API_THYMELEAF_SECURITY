package com.example.advenced_restful_api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name ="student")
public class Student {
    @Id
//    @Column(name="email")
    private String email;
//    @Column(name="fullname")
    private String fullname;
//    @Column(name="marks")
    private Double marks;
//    @Column(name="country")
    private String country;
//    @Column(name="gender")
    private boolean gender;
}
