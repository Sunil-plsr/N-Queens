package com.company.Model;

public class Result {
    int numberOfRestarts;
    int numberOfCurrentStateChanges;
    int numberOfTotalStateChanges;
    Node node;

    public Result(int numberOfRestarts, int numberOfTotalStateChanges, int numberOfStateChanges, Node node) {
        this.numberOfRestarts = numberOfRestarts;
        this.numberOfTotalStateChanges = numberOfTotalStateChanges;
        this.numberOfCurrentStateChanges = numberOfStateChanges;
        this.node = node;
    }

    public Result() {
    }

    public int getNumberOfRestarts() {
        return numberOfRestarts;
    }

    public void setNumberOfRestarts(int numberOfRestarts) {
        this.numberOfRestarts = numberOfRestarts;
    }

    public int getNumberOfCurrentStateChanges() {
        return numberOfCurrentStateChanges;
    }

    public void setNumberOfCurrentStateChanges(int numberOfCurrentStateChanges) {
        this.numberOfCurrentStateChanges = numberOfCurrentStateChanges;
    }

    public int getNumberOfTotalStateChanges() {
        return numberOfTotalStateChanges;
    }

    public void setNumberOfTotalStateChanges(int numberOfTotalStateChanges) {
        this.numberOfTotalStateChanges = numberOfTotalStateChanges;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
