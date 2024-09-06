package com.example.personmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int age;
    private int cc;
    private String email;
    private int nif;
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }


    public static class PersonBuilder{
        private Person person;

        public PersonBuilder() {
            this.person = new Person();
        }

        public PersonBuilder withName(String name){
            person.setName(name);
            return this;
        }
        public PersonBuilder withAge(int age){
            person.setAge(age);
            return this;
        }
        public PersonBuilder withCC(int cc){
            person.setCc(cc);
            return this;
        }

        public PersonBuilder withEmail(String email){
            person.setEmail(email);
            return this;
        }

        public PersonBuilder withRole(String role){
            if(role == null){
                person.setRole(Role.EXTERN);
                return this;
            }
            for(Role r : Role.values()){
                if(r.name().equals(role)){
                    person.setRole(r);
                    return this;
                }
            }
            person.setRole(Role.EXTERN);
            return this;
        }

        public PersonBuilder withNif(int nif){
            person.setNif(nif);
            return this;
        }

        public Person build(){
            return person;
        }

    }

}
