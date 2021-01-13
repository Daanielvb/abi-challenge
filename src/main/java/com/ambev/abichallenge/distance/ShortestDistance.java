package com.ambev.abichallenge.distance;

import lombok.Data;

import java.util.*;


@Data

//TODO: Vogella Djikstra algorithm not working as it should
public class ShortestDistance {

    private Set<Node> nodes;
    private Set<Edge> edges;
    private Set<Node> visitedNodes;
    private Set<Node> unvisitedNodes;
    private Map<Node, Integer> distances;
    private Map<Node, Node> predecessors;

    public ShortestDistance(Set<Node> nodes, Set<Edge> edges){
        this.nodes = nodes;
        this.edges = edges;
    }

    public int find(Node origin, Node destination){
        if (!nodes.contains(origin) || !nodes.contains(destination)){
            return Integer.MAX_VALUE;
        }

        return 0;
    }

    public void calculateDistances(Node origin) {
        this.unvisitedNodes = new HashSet<>();
        this.visitedNodes = new HashSet<>();
        this.distances = new HashMap<Node, Integer>();
        this.predecessors = new HashMap<Node, Node>();
        this.distances.put(origin, 0);
        unvisitedNodes.add(origin);
        while (unvisitedNodes.size() > 0) {
            Node node = getMinimum(unvisitedNodes);
            visitedNodes.add(node);
            unvisitedNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Node node) {
        Set<Node> adjacentNodes = getNeighbours(node);
        for (Node target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
                distances.put(target, getShortestDistance(node)  + getDistance(node, target));
                predecessors.put(target, node);
                this.unvisitedNodes.add(target);
            }
        }
    }

    private int getDistance(Node origin, Node destination) {
        for (Edge edge : edges) {
            if (edge.getOrigin().equals(origin) && edge.getDestination().equals(destination)) {
                return edge.getDistance();
            }
        }
        return Integer.MAX_VALUE;
    }


    private Set<Node> getNeighbours(Node node) {
        Set<Node> neighbors = new HashSet<>();
        for (Edge edge : edges) {
            if (edge.getOrigin().equals(node) && visitedNodes.contains(edge.getDestination())){
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }


    private Node getMinimum(Set<Node> neighbours) {
        Node min = null;
        for (Node node : neighbours) {
            if (min == null) {
                min = node;
            } else {
                if (getShortestDistance(node) < getShortestDistance(min)) {
                    min = node;
                }
            }
        }
        return min;
    }

    private Integer getShortestDistance(Node destination) {
        return distances.getOrDefault(destination, Integer.MAX_VALUE);
    }

    public LinkedList<Node> getPath(Node target) {
        LinkedList<Node> path = new LinkedList<>();
        Node step = target;

        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }


}
