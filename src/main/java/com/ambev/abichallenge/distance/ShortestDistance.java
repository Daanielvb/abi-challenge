package com.ambev.abichallenge.distance;

import lombok.Data;

import java.util.Set;


@Data
public class ShortestDistance {

    private static Graph graph;
    private Set<Node> visitedNodes;
    private Set<Node> unvisitedNodes;

    public static int find(Node origin, Node destination){
        if (!graph.getNodes().contains(origin) || !graph.getNodes().contains(destination)){
            return Integer.MAX_VALUE;
        }
        //TODO: Implement Djikstra algorithm
        return 0;
    }





}
