package com.ambev.abichallenge.distance

import com.ambev.abichallenge.entity.Type
import spock.lang.Specification
import spock.lang.Unroll

import static com.ambev.abichallenge.ObjectMother.buildVehicle
import static com.ambev.abichallenge.ObjectMother.buildVehicleRequest

class ShortestPathTest extends Specification {


    public static Set<Node> nodes = new HashSet<>();
    public static Set<Edge> edges = new HashSet<>();

    static {
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

    def "Initialize properly"(){
        when:
        Node a = new Node("A")
        Djisktra djisktra = new Djisktra(nodes, edges, a)


        then:
        djisktra.nodes == nodes
        djisktra.edges == edges
        djisktra.origin == a
        djisktra.visited.isEmpty()
        djisktra.distances[0] == 0
        djisktra.distances[1] == Integer.MAX_VALUE
        djisktra.distances.size() == edges.size()
    }

    def "Find right neighbours"(){
        given:

        Djisktra djisktra = new Djisktra(nodes, edges, new Node("D"))

        when:
        def adjacents = djisktra.getAdjacents(new Node("D"))


        then:
        adjacents.size() == 3
        adjacents.get(new Node("F")) == 8

    }

    def "Find closets neighbour"(){
        given:

        Djisktra djisktra = new Djisktra(nodes, edges, new Node("D"))

        when:
        def adjacents = djisktra.getAdjacents(new Node("D"))
        def closest = djisktra.getClosest(adjacents)


        then:
        closest == new Node("B")

    }






}
