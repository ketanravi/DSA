package src.DsaPatterns.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

/*
You are given a 2D array arr[][] which represents a set of intervals, where each element arr[i] = [start, end] defines an interval.
Your task is to determine if any two intervals in the given set overlap.

Note: Two intervals [a, b] and [c, d] overlap if they have at least one common value, i.e., a ≤ d and c ≤ b.

Examples:

Input: n = 4, arr[][] = [[1, 3], [5, 7], [2, 4], [6, 8]]
Output: true
Explanation: The intervals [1, 3] and [2, 4] overlap.
Input: n = 4, arr[][] = [[1, 3], [7, 9], [4, 6], [10, 13]]
Output: false
Explanation: No pair of intervals overlap.
Constraints:
1 ≤ arr[i][0] < arr[i][1] ≤ 105
2 ≤ arr.size() ≤ 105
 */
public class OverlappingIntervals {
    public static void main(String[] args) {
        int arr[][] = {{1,3},{5,7},{8,9},{10,13}};
        System.out.println(isIntersect(arr));
    }
    static boolean isIntersect(int[][] intervals) {
        int n = intervals.length;
        if(n<=1){
            return false;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int start1 =  intervals[0][0];
        int end1 = intervals[0][1];

        for(int i=1;i<n;i++){
            int start2 =  intervals[i][0];
            int end2 = intervals[i][1];

            if(end1>=start2){
                return true;
            }
            start1=start2;
            end1=end2;
        }
        return false;

    }
}
