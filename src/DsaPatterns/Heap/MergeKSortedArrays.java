package src.DsaPatterns.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
You are given a 2D matrix mat[][] of size n x m. Each row in the matrix is sorted in non-decreasing order. Your task is to merge all the rows and return a single sorted array that contains all the elements of the matrix.

Examples :

Input: mat[][] = [[1, 3, 5, 7],
                [2, 4, 6, 8],
                [0, 9, 10, 11]]
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Explanation: Merging all elements from the 3 sorted arrays and sorting them results in: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
Input: mat[][] = [[1, 2, 3, 4],
                [2, 2, 3, 4],
                [5, 5, 6, 6],
                [7, 8, 9, 9]]
Output: [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
Explanation: Merging all elements from the 4 sorted arrays and sorting them results in:[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
Constraints:
1 ≤ n * m ≤ 105
1 ≤ mat[i][j] ≤ 106
 */
public class MergeKSortedArrays {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},{2, 2, 3, 4},{5, 5, 6, 6},{7, 8, 9, 9}};
        System.out.println(mergeArrays(mat));
    }
    public static ArrayList<Integer> mergeArrays(int[][] mat) {
        int m =  mat.length;
        int n = mat[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        // add first element of each row like we compare in merge two sorted
        for(int i=0;i<m;i++) {
            int[] temp = new int[3];
            temp[0] = mat[i][0];
            temp[1] = i;
            temp[2] = 0;
            pq.offer(temp);
        }

        // while pq is not empty poll out as it will be smallest and then check which row's column to increment based on smallest found in row number
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int currVal = temp[0];
            int currRow = temp[1];
            int currCol = temp[2];
            res.add(currVal);
            int nextCol = currCol+1;// increment column number



            if(nextCol<n){
                // if column left insert next element at next column in that row in pq
                int nextValInCurrentRow = mat[currRow][nextCol];// find next value in that row
                pq.offer(new int[]{nextValInCurrentRow,currRow,nextCol});
            }
        }
        return res;
    }

}
