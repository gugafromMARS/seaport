package com.example.personmanagement.dto;




public class PersonDto {

    private Long id;
    private String name;
    private int cc;
    private String email;

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



    public static PersonDtoBuilder builder(){
        return new PersonDtoBuilder();
    }

    public static class PersonDtoBuilder{
        private PersonDto personDto;

        public PersonDtoBuilder() {
            this.personDto = new PersonDto();
        }

        public PersonDtoBuilder withId(Long id){
            personDto.setId(id);
            return this;
        }

        public PersonDtoBuilder withName(String name){
            personDto.setEmail(name);
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


        public PersonDto build(){
            return personDto;
        }


    }
}
