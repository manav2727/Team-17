package com.db.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;


    // getter, setters, contructors
}
