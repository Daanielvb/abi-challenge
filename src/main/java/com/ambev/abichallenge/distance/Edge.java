package com.ambev.abichallenge.distance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Edge {

    private Node origin;
    private Node destination;
    private int distance;

}
