package com.ambev.abichallenge.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class OrderRequest {

    @Id
    @GeneratedValue
    private long id;

    private String store;

    private String location;

    private int quantity;

    private boolean completed;



}
