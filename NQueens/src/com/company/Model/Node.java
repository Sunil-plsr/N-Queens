package com.company.Model;

public class Node implements Comparable<Node> {

    private Integer heuristicVal;
    private State state;

    public Node(State state) {
        this.state = state;
    }

    public Integer getHeuristicVal() {
        return heuristicVal;
    }

    public void setHeuristicVal(int heuristicVal) {
        this.heuristicVal = heuristicVal;
    }

    public State getState() {
        return state;
    }

    @Override
    public int compareTo(Node node) {
        return this.getHeuristicVal() - node.getHeuristicVal();
    }

    @Override
    public String toString() {
        return heuristicVal + "->" + this.state.toString();
    }

}
