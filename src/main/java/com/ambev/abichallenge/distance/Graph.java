package com.ambev.abichallenge.distance;

import lombok.Data;

import java.util.Set;

@Data
public class Graph {

    private Set<Node> nodes;
    private Set<Edge> edges;

}
