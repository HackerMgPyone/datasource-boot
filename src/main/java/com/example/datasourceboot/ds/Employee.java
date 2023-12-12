package com.example.datasourceboot.ds;

import java.sql.Date;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hiredDate;
    private double salary;

    public Employee(int id, String firstName, String lastName, String email, String phoneNumber, Date hiredDate, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hiredDate = hiredDate;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hiredDate=" + hiredDate +
                ", salary=" + salary +
                '}';
    }
}
