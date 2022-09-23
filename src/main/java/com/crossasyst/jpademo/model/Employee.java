package com.crossasyst.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

    private String firstName;

    private String lastName;

    private String city;

    private Long zipcode;
}
