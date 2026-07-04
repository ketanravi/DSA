package src.TUF.ArrayII;

import java.util.List;

/*
Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.

The rotation must be done in place, meaning the input 2D matrix must be modified directly.


Example 1

Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: matrix = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

Example 2

Input: matrix = [[0, 1, 1, 2], [2, 0, 3, 1], [4, 5, 0, 5], [5, 6, 7, 0]]
Output: matrix = [[5, 4, 2, 0], [6, 5, 0, 1], [7, 0, 3, 1], [0, 5, 1, 2]]


 */
public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4 ,5 ,6}, {7, 8, 9}};
        rotateMatrix(matrix);
        System.out.print("[");
        for(int[] nums: matrix){
            System.out.print("[");
            for(int i=0;i<nums.length;i++){
                System.out.print(nums[i]);
                if(i!=nums.length-1){
                    System.out.print(",");
                }
            }
            System.out.print("]");

        }
        System.out.println("]");

    }
    public static void rotateMatrix(int[][] matrix) {

    }
}
