package com.mycode.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    @NotNull(message = "Not null")
    @Pattern(message = "Bad format person name",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    @Size(min = 2, max = 30)
    private String lastName;
    @NotNull(message = "Not null")
    private String firstName;
    @NotNull(message = "Not null")
    private String middleName;
    @NotNull(message = "Not null")
    @Max(message = "No more then 85", value = 85)
    private Integer age;
    @NotNull(message = "Not null")
    private Integer salary;
    @NotNull(message = "Not null")
    @Pattern(message = "Email address has invalid format",  regexp = "^[A-Za-z0-9+_.-]+@(.+)*$")
    private String email;
    @NotNull(message = "Not null")
    private String placeOfWork;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    @Override
    public String toString() {
        return  lastName + ' '
                + firstName + ' '
                + middleName + ' '
                + age + ' '
                + salary + ' '
                + email + ' '
                + placeOfWork + ' ';
    }
}
