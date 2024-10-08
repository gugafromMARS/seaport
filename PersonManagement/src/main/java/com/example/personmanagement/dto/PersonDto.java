package com.example.personmanagement.dto;


import com.example.personmanagement.model.Role;

public class PersonDto {


    private String name;
    private int cc;
    private String email;
    private int nif;
    private String role;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static PersonDtoBuilder builder(){
        return new PersonDtoBuilder();
    }

    public static class PersonDtoBuilder{
        private PersonDto personDto;

        public PersonDtoBuilder() {
            this.personDto = new PersonDto();
        }

        public PersonDtoBuilder withName(String name){
            personDto.setName(name);
            return this;
        }
        public PersonDtoBuilder withCC(int cc){
            personDto.setCc(cc);
            return this;
        }
        public PersonDtoBuilder withEmail(String email){
            personDto.setEmail(email);
            return this;
        }

        public PersonDtoBuilder withNif(int nif){
            personDto.setNif(nif);
            return this;
        }

        public PersonDtoBuilder withRole(Role role){
            personDto.setRole(role.name());
            return this;
        }

        public PersonDto build(){
            return personDto;
        }


    }
}
