package com.company;

import com.company.Model.Node;
import com.company.Model.Result;
import com.company.Model.State;

import java.util.*;

public class NQueens {

    private static Random ran = new Random();
    private int noOfQueens;
    private Node current;


    public NQueens(int value) {
        this.noOfQueens = value;
    }


    public Node makeNode(State currentState) {
        Node newNode = new Node(currentState);
        newNode.setHeuristicVal(NodeUtil.getInstance().calculateHuristicValue(currentState));
        return newNode;
    }


    public Result hillClimbingWithRandomRestart() {
        int restarts = -1;
        Object[] obj;
        Node result;
        int totalSteps = 0;
        int currentSteps = 0;
        do {
            obj = hillClimbingg();
            result = (Node) obj[0];
            currentSteps = (Integer) obj[1];
            totalSteps = totalSteps + currentSteps;

            restarts++;
        }
        while (result.getHeuristicVal() != 0);

        Result r = new Result(restarts, totalSteps, currentSteps, result);
        return r;
    }


    public Object[] hillClimbingg() {
        current = makeNode(new State(this.noOfQueens));
        int steps = 0;
        while (true) {
            Node neighbour = getBestSuccessors(current);

            steps++;
            if (current.getHeuristicVal().compareTo(neighbour.getHeuristicVal()) <= 0) {
                return new Object[] { current, steps };
            }
            current = neighbour;
        }
    }



    public Node getBestSuccessors(Node current) {

        PriorityQueue<Node> allSuccessors = NodeUtil.getInstance().calculateHeuristicForSuccessors(current);
        Iterator<Node> iterator = allSuccessors.iterator();
        int heuristicValue = -1;
        ArrayList<Node> bestSuccessors = new ArrayList<Node>();

        while (iterator.hasNext()) {
            Node currentNode = (Node) iterator.next();
            if (heuristicValue == -1) {
                heuristicValue = currentNode.getHeuristicVal();
                bestSuccessors.add(currentNode);
            }
            else if (heuristicValue == currentNode.getHeuristicVal())
                bestSuccessors.add(currentNode);
            else
                break;
        }

        return bestSuccessors.get(ran.nextInt(bestSuccessors.size()));

    }



}