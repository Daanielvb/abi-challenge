package com.ambev.abichallenge.distance;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class LocationMap {

    public static Set<Node> nodes = new HashSet<>();
    public static Set<Edge> edges = new HashSet<>();

    static{
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        edges.add(new Edge(a, b, 5));
        edges.add(new Edge(b, d, 3));
        edges.add(new Edge(b, c, 7));
        edges.add(new Edge(c, e, 4));
        edges.add(new Edge(d, e, 10));
        edges.add(new Edge(d, f, 8));

        nodes.addAll(Arrays.asList(a, b, c, d, e, f));
    }
}
