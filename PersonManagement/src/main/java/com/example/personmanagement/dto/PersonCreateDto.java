package com.example.personmanagement.dto;

public class PersonCreateDto {

    private String name;
    private int age;
    private int cc;
    private String email;
    private String role;
    private int nif;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonCreateDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cc=" + cc +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", nif=" + nif +
                '}';
    }
}
