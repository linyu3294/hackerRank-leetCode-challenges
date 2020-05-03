package com.company;

import java.io.*;
import java.util.*;

public class Solution {
 private static List<int[][]> magicSquares = new ArrayList<>();

  // Since there can be only 8 magic squares.
  // And each Magic Square is just a reflection and rotation
  // of a single magic square. We can load a list
  // containing all possible permutations of magic squares
  // in a single list.
  // In formingMagicSquare() method, we can call
  // loadingMagicSqaures method to create a reference list
  // of all magic squares, and compare the non-magic
  // square matrix against each in the list to find
  // an cost of transformation.
  static  List<int[][]> loadMagicSquares() {

    int msquare1[][] = {
      {8, 1, 6},
      {3, 5, 7},
      {4, 9, 2}
    };
    magicSquares.add(msquare1);
    int msquare2[][] = {
      {6, 1, 8},
      {7, 5, 3},
      {2, 9, 4}
    };
    magicSquares.add(msquare2);
    int msquare3[][] = {
      {4, 9, 2},
      {3, 5, 7},
      {8, 1, 6}
    };
    magicSquares.add(msquare3);
    int msquare4[][] = {
      {2, 9, 4},
      {7, 5, 3},
      {6, 1, 8}
    };
    magicSquares.add(msquare4);
    int msquare5[][] = {
      {8, 3, 4},
      {1, 5, 9},
      {6, 7, 2}
    };
    magicSquares.add(msquare5);
    int msquare6[][] = {
      {4, 3, 8},
      {9, 5, 1},
      {2, 7, 6}
    };
    magicSquares.add(msquare6);
    int msquare7[][] = {
      {6, 7, 2},
      {1, 5, 9},
      {8, 3, 4}
    };
    magicSquares.add(msquare7);
    int msquare8[][] = {
      {2, 7, 6},
      {9, 5, 1},
      {4, 3, 8}
    };
    magicSquares.add(msquare8);

    return magicSquares;
  }

  // Complete the formingMagicSquare function below.
  static int formingMagicSquare(int[][] s) {
    int lowestCost = 90;
    loadMagicSquares();
    int numOfMagicSqrs = magicSquares.size();


    for (int i = 0; i < numOfMagicSqrs; i++) {
      int[][] magicSquare = magicSquares.get(i);
      int squareCost = 0;
      String sStr = "";

      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          if (k < 2) {
            sStr = sStr + magicSquare[j][k] + " ";
          } else {
            sStr = sStr + magicSquare[j][k] + "\n";
          }

            squareCost = squareCost +
                  (Math.abs(s[j][k] - magicSquare[j][k]));
        }
      }
      if (squareCost< lowestCost) {lowestCost = squareCost;}
      System.out.println(sStr);
      System.out.println("current square costs = " + squareCost + "\n\n");
    }

    return lowestCost;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

//    int[][] s = new int[][] {{5, 3, 4}, {1, 5, 8}, {6, 4, 2}};
    int[][] s =
      {{4, 8, 2},
       {4, 5, 7},
       {6, 1, 6}
      };
    String sStr = "";
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (j < 2) {
          sStr = sStr + s[i][j] + " ";
        } else {
          sStr = sStr + s[i][j] + "\n";
        }
      }
    }
    System.out.println(sStr);


    int lowestCost = formingMagicSquare(s);
    System.out.println("The lowest cost to transform s to a magic sqauare is : " + lowestCost+ "\n\n");
    scanner.close();
  }
}
