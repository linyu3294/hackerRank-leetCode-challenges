package com.company;

public class Main {

  public static void swap(int[][] matrix, int i, int j, int x, int y) {
    int temp = matrix[i][j];
    matrix[i][j] = matrix[x][y];
    matrix[x][y] = temp;
  }

  public static int[][] rotate(int[][] matrix) {
    int midpoint = 0;
    if (matrix.length % 2 == 0) {
      midpoint = matrix.length / 2;
    } else if (matrix.length % 2 == 1) {
      midpoint = (matrix.length - 1) / 2;
    }
    // Swaps the top half of the square with the bottom half of the square.
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < midpoint; j++) {
        swap(matrix, j, i, matrix.length - j - 1, i);
//        System.out.print(matrix[j][i]);
      }
    }
    // Swaps halfs diagonally - bottom left corner with top right corner.
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i+1; j < matrix.length; j++) {
        swap(matrix, i, j, j, i);
//        System.out.print(matrix[i][j]);
      }
    }
    return matrix;
  }

  public static void printArr(int[][] matrix) {
    for (int[] arr : matrix) {
      for (int num : arr) {
        if (num < 10) {
          System.out.print(num + "  ");
        } else {
          System.out.print(num + " ");
        }
      }
      System.out.print("\n");
    }
    System.out.print("\n\n\n");
  }

  public static void main(String[] args) {
    // write your code here

    System.out.println("Test1 Input:");
    int[][] test1 =
        new int[][] {
          new int[] {1, 2, 3},
          new int[] {4, 5, 6},
          new int[] {7, 8, 9}
        };
    printArr(test1);

    System.out.println("Expected Result:");
    int[][] result1 =
        new int[][] {
          new int[] {7, 4, 1},
          new int[] {8, 5, 2},
          new int[] {9, 6, 3}
        };
    printArr(result1);

    System.out.println("Actual Result:");
    printArr(rotate(test1));


    int[][] test2 =
        new int[][] {
          new int[] {1, 2, 3, 4, 5},
          new int[] {6, 7, 8, 9, 10},
          new int[] {11, 12, 13, 14, 15},
          new int[] {16, 17, 18, 19, 20},
          new int[] {21, 22, 23, 24, 25}
        };
    printArr(test2);

    System.out.println("Expected Result:");
    int[][] result2 =
            new int[][] {
                    new int[] {21, 16, 11, 6, 1},
                    new int[] {22, 17, 12, 7, 2},
                    new int[] {23, 18, 13, 8, 3},
                    new int[] {24, 19, 14, 9, 4},
                    new int[] {25, 20, 15, 10, 5}
            };
    printArr(result2);

    System.out.println("Actual Result:");
    printArr(rotate(test2));
  }
}
