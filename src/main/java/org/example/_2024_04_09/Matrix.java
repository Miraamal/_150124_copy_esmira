package org.example._2024_04_09;

public class Matrix {

//    public int[][] getMatrix(int h, int l) {
//
//    }
    public static void main(String[] args) {
//        int[] array = {12, 34, 56, 7, 89};
//
//        for (int i = 0; i < args.length; i++) {
//            System.out.println(array[i]);
//        }

        System.out.println("*******************************************************");


        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }
}