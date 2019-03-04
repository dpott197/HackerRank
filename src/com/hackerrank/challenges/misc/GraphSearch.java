package com.hackerrank.challenges.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://tutorialedge.net/artificial-intelligence/breadth-first-search-java/
 */
public class GraphSearch {

    public static void main(String args[]) {
        Node station1 = new Node("Westminster", null, null);
        Node station2 = new Node("Waterloo", station1, null);
        Node station3 = new Node("Trafalgar Square", station1, station2);
        Node station4 = new Node("Canary Wharf", station2, station3);
        Node station5 = new Node("London Bridge", station4, station3);
        Node station6 = new Node("Tottenham Court Road", station5, station4);

        BreadthFirstSearch bfs = new BreadthFirstSearch(station6, station1);

        if (bfs.compute()) {
            System.out.print("Path Found!");
        }

        AbstractSearch searchAlgo = new DepthFirstSearch(station6, station1);

        if (searchAlgo.execute()) {
            System.out.print("Path Found!");
        }

    }

    /**
     * The Node class represents a station
     * in this tutorial and will as such have
     * a string representing the station's name.
     * As well as an ArrayList of nodes that will store
     * any instantiated nodes children.
     */
    public static class Node {

        //    A Unique Identifier for our node
        public String stationName;
        //    An arraylist containing a list of Nodes that
        //    This node is directly connected to - It's child nodes.
        Node leftChild;
        Node rightChild;

        public Node(String stationName, Node firstChild, Node secondChild) {
            this.stationName = stationName;
            this.leftChild = firstChild;
            this.rightChild = secondChild;
        }

        public ArrayList<Node> getChildren() {
            ArrayList<Node> childNodes = new ArrayList<>();
            if (this.leftChild != null) {
                childNodes.add(leftChild);
            }
            if (this.rightChild != null) {
                childNodes.add(rightChild);
            }
            return childNodes;
        }

        //    An auxiliary function which allows
        //    us to remove any child nodes from
        //    our list of child nodes.
        public boolean removeChild(Node n) {
            return false;
        }

        @Override
        public String toString() {
            return "{name: " + stationName + "}";
        }
    }

    public static class BreadthFirstSearch {

        Node startNode;
        Node goalNode;

        public BreadthFirstSearch(Node start, Node goalNode) {
            this.startNode = start;
            this.goalNode = goalNode;
        }

        public boolean compute() {

            if (this.startNode.equals(goalNode)) {
                System.out.println("Goal Node Found!");
                System.out.println(startNode);
            }

            Queue<Node> queue = new LinkedList<>();
            ArrayList<Node> explored = new ArrayList<>();
            queue.add(this.startNode);
            explored.add(startNode);

            while (!queue.isEmpty()) {
                Node current = queue.remove();
                if (current.equals(this.goalNode)) {
                    System.out.println(explored);
                    return true;
                } else {
                    if (current.getChildren().isEmpty())
                        return false;
                    else
                        queue.addAll(current.getChildren());
                }
                explored.add(current);
            }

            return false;

        }

    }

    public static abstract class AbstractSearch {

        Node startNode;
        Node goalNode;

        public AbstractSearch(Node startNode, Node goalNode) {
            this.startNode = startNode;
            this.goalNode = goalNode;
        }

        public abstract boolean execute();

    }

    /**
     * depth first search implementation using a stack structure instead of a queue
     * structure as exhibited in the breadth first search algorithm
     */
    public static class DepthFirstSearch extends AbstractSearch {

        Node startNode;
        Node goalNode;

        public DepthFirstSearch(Node start, Node goalNode) {
            super(start, goalNode);
            this.startNode = start;
            this.goalNode = goalNode;
        }

        public boolean execute() {
            if (this.startNode.equals(goalNode)) {
                System.out.println("Goal Node Found at 0 depth");
                System.out.println(startNode);
            }
            Stack<Node> nodeStack = new Stack<>();
            ArrayList<Node> visitedNodes = new ArrayList<>();

            nodeStack.add(startNode);

            while (!nodeStack.isEmpty()) {
                Node current = nodeStack.pop();
                if (current.equals(goalNode)) {
                    System.out.print(visitedNodes);
                    System.out.println("Goal node found");
                    return true;
                } else {
                    visitedNodes.add(current);
                    nodeStack.addAll(current.getChildren());
                }
            }
            return false;
        }

    }

}
