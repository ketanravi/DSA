package src.DsaPatterns.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> results = new ArrayList<>();
        boolean insertPosFound=false;



        for(int i=0;i<n;i++){
            int start=intervals[i][0];
            if(start>newInterval[0] && insertPosFound==false){
                insertPosFound=true;
                results.add(newInterval);
            }
            results.add(new int[]{intervals[i][0],intervals[i][1]});

        }
        if(insertPosFound==false){
            results.add(newInterval);
        }
        return merge(results.toArray(new int[results.size()][]));

    }
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
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
