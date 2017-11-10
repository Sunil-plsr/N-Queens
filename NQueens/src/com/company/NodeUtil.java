package com.company;

import com.company.Model.Node;
import com.company.Model.State;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NodeUtil {

    private static NodeUtil defaultInstance = new NodeUtil();

    public static NodeUtil getInstance() {

        return defaultInstance;
    }


    //caluclates the huristic value for the given game state
    public int calculateHuristicValue(State state) {
        int heuristic = 0;
        int[] presentState = state.getState();
        for (int queen = 0; queen < presentState.length - 1; queen++) {
            int columnValue = queen;
            int rowVal = presentState[columnValue];
            for (int row = rowVal + 1, col = columnValue + 1; row < presentState.length
                    && col < presentState.length; row++, col++) {
                if (presentState[col] == row) {
                    heuristic++;
                }
            }

            int currentQueen = columnValue;
            for (int otherQueens = 0; otherQueens < presentState.length; otherQueens++) {
                if (presentState[otherQueens] == presentState[currentQueen] && otherQueens != currentQueen) {
                    heuristic++;
                }
            }

            for (int row = rowVal - 1, col = columnValue + 1; row >= 0
                    && col < presentState.length; row--, col++) {
                if (presentState[col] == row) {
                    heuristic++;
                }
            }


        }

        return heuristic;

    }


    private Integer[] ins(int size, int val) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        list.remove(val);
        return list.toArray(new Integer[list.size()]);
    }

    public PriorityQueue<Node> calculateHeuristicForSuccessors(Node node) {

        PriorityQueue<Node> nodes = new PriorityQueue<Node>();
        int[] state = node.getState().getState();

        for (int i = 0; i < state.length; i++) {

            //This is for normal problem
            /*Integer[] value = this.nei(state[i], state.length);*/

            //This is for BONUS
            Integer[] value = this.ins(state.length, state[i]);

            for (int j = 0; j < value.length; j++) {
                State s = new State(node.getState());
                s.setState(value[j], i);
                Node newNode = new Node(s);
                newNode.setHeuristicVal(this.calculateHuristicValue(s));
                nodes.add(newNode);
            }
        }

        return nodes;
    }




    private Integer[] nei(int i, int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (i > 0)
            list.add(i-1);
        if (i < max-1)
            list.add(i+1);

        return list.toArray(new Integer[list.size()]);
    }

}
