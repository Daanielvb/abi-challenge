package com.ambev.abichallenge.distance;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Edge {

    private String id;
    private Node origin;
    private Node destination;
    private int distance;

}
