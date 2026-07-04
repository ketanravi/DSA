package src.DsaPatterns.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for(int i=0;i< res.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if(end1>=start2){
                end1 = Math.max(end1,end2);
            }
            else{
                res.add(new int[]{start1,end1});
                start1 = start2;
                end1 = end2;
            }
        }
        res.add(new int[]{start1,end1});
        return res.toArray(new int[res.size()][]);

    }
}
