package src.DsaPatterns.BinarySearch.BinarySearchOn2DArray;
/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */
public class SearchIn2DArray {
    public static void main(String[] args) {
        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrixOptimized(matrix,16));
    }

    public static boolean searchMatrixOptimized(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m*n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int row = mid/n;
            int col = mid%n;
            if(target==matrix[row][col]){
                return true;
            }
            else if(target<matrix[row][col]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }

        return false;

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix,target);
        if(row==-1)
            return false;
        int low=0,high=matrix[row].length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(target==matrix[row][mid]){
                return true;
            }
            else if(target<matrix[row][mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }

        return false;

    }
    public int searchRow(int matrix[][], int target){
        int res=-1;
        int low=0,high=matrix.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(matrix[mid][0]<=target){
                res=mid;
                low=mid+1;

            }
            else{
                high=mid-1;
            }
        }
        return res;
    }
}
