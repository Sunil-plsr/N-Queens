package com.company.Model;

import java.util.Random;

public class State {

    private int state[];
    private static Random random = new Random();



    public State(int size) {
        this.state = new int[size];

        //initializing state with random values
        for (int index = 0; index < state.length; index++) {
            state[index] = random.nextInt(size);
        }

    }

    public State(State state) {

        this.state = new int[state.getState().length];
        for (int index = 0; index < this.state.length; index++) {
            this.state[index] = (Integer) state.getState()[index];
        }

    }

    public int[] getState() {
        return state;
    }


    public State setState(int value, int index) {
        state[index] = value;
        return this;
    }

}
