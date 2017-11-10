package com.company;

import com.company.Model.Node;
import com.company.Model.Result;
import com.company.Model.State;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nEnter value of N for a N*N chess board = ");

        Scanner in;
        in = new Scanner(System.in);
        int noOfQueens = in.nextInt();


        NQueens randomRestart = new NQueens(noOfQueens);
        Result result = randomRestart.hillClimbingWithRandomRestart();

        System.out.println("Solution for "+ noOfQueens + " Queens Problem(Max:40):");

        //printing N Queens Solution
        State solution = ((Node) result.getNode()).getState();
        for (int i = 0; i < solution.getState().length; i++) {
            for (int j = 0; j < solution.getState().length; j++) {

                if (solution.getState()[j] == i)
                    System.out.print(" Q ");
                else
                    System.out.print(" * ");

            }
            System.out.println();
        }

        System.out.println("\n\nNumber of Restarts :" + result.getNumberOfRestarts());
        System.out.println("Number of current State changes :" + result.getNumberOfCurrentStateChanges());
        System.out.println("Number of total State changes :" + result.getNumberOfTotalStateChanges());


    }
}
