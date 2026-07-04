package src.DsaPatterns.Heap.KClosest;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.



Example 1:

Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers in each row is:
- Row 0: 2
- Row 1: 4
- Row 2: 1
- Row 3: 2
- Row 4: 5
The rows ordered from weakest to strongest are [2,0,3,1,4].
Example 2:

Input: mat =
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]],
k = 2
Output: [0,2]
Explanation:
The number of soldiers in each row is:
- Row 0: 1
- Row 1: 4
- Row 2: 1
- Row 3: 1
The rows ordered from weakest to strongest are [0,2,3,1].


Constraints:

m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.
 */
public class KWeakestRowsInMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[] res = kWeakestRowsOptimized(mat,3);
        for(int i:  res){
            System.out.println(i);
        }

    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<mat.length;i++){
            int count1 = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1)
                    count1++;
                else
                    break;
            }
            map.put(i,count1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return b[0]-a[0];
        });

        for(int key : map.keySet()){
            pq.add(new int[]{map.get(key), key});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int count=k-1;

        while(!pq.isEmpty()){
            res[count--] =  pq.poll()[1];


        }
        return res;
    }
    public static int[] kWeakestRowsOptimized(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return b[0]-a[0];
        });


        for(int i=0;i<mat.length;i++){
            int countOf1 = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1)
                    countOf1++;
                else {
                    break;
                }
            }
            pq.add(new int[]{countOf1, i});
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        int count=k-1;

        while(!pq.isEmpty()){
            res[count--] =  pq.poll()[1];


        }
        return res;
    }


}
