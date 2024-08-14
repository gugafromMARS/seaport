package com.example.accesscontrol.model;


import javax.persistence.*;

@Entity
@Table(name = "access")

public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
