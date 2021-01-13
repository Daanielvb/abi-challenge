package com.ambev.abichallenge.distance;

import java.util.*;

public class Djisktra {

    Set<Edge> edges;

    Set<Node> nodes;

    Node origin;

    Set<Node> visited;

    List<Integer> distances;

    public Djisktra(Set<Node> nodes, Set<Edge> edges, Node origin){
        this.nodes = nodes;
        this.edges = edges;
        this.origin = origin;
        this.visited = new HashSet<>();
        initDistances();
    }

    private void initDistances(){
        this.distances = new LinkedList<>();
        //source node
        this.distances.add(0);
        for (int i = 1; i < this.nodes.size(); i++){
            this.distances.add(Integer.MAX_VALUE);
        }
    }

    public void runAlgorithm(){
        Map<Node, Integer>  adjacents = getAdjacents(this.origin);
        while(adjacents.size() > 0) {
            Node closest = getClosest(adjacents);
            if (!visited.contains(closest)) {
                visitNode(closest);
            }
        }
    }

    public int shortestPath(Node location){
        return 1;
    }

    void visitNode(Node node){}

    Node getClosest(Map<Node, Integer>  adjacents){
        Map.Entry<Node, Integer> min = Collections.min(adjacents.entrySet(),
                Comparator.comparing(Map.Entry::getValue));
        adjacents.remove(min.getKey());
        return min.getKey();
    }

    Map<Node, Integer> getAdjacents(Node node){
        Map<Node, Integer> adjacents = new HashMap<>();
        for (Edge edge : edges){
            if (edge.getOrigin().equals(node)){
                adjacents.put(edge.getDestination(), edge.getDistance());
            } else if (edge.getDestination().equals(node)){
                adjacents.put(edge.getOrigin(), edge.getDistance());
            }
        }
        return adjacents;
    }


}
