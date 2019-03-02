package com.hackerrank.challenges.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();
        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        return null; // TODO
    }

    public void addEdge(int source, int destination) {
        // TODO:
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s =  getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s, d, visited);
    }

    public boolean hasPathDFS(Node source, Node destination, HashSet visited) {
        if (visited.contains(source)) {
            return false;
        }

        visited.add(source.id);
        if (source == destination) {
            return false;
        }

        for (Node child : source.adjacent) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }


        return false;
    }

}
