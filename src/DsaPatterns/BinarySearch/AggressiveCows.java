package src.DsaPatterns.BinarySearch;

import java.util.Arrays;

/*
You are given an array with unique elements of stalls[], which denote the positions of stalls. You are also given an integer k which denotes the number of aggressive cows. The task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples:

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[2] and
the third cow can be placed at stalls[3].
The minimum distance between cows in this case is 3, which is the largest among all possible ways.
Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows in this case is 4, which is the largest among all possible ways.
Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: There are 6 stalls and only 5 cows, we try to place the cows such that the minimum distance between any two cows is as large as possible.
The minimum distance between cows in this case is 1, which is the largest among all possible ways.
Constraints:
2 ≤ stalls.size() ≤ 106
0 ≤ stalls[i] ≤ 108
2 ≤ k ≤ stalls.size()
 */
public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {10, 1, 2, 7, 5};
        System.out.println(aggressiveCows(stalls,3));
    }
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);// need to sort arrays so that easy to compare
        int n = stalls.length;

        int low=1,high=stalls[n-1] - stalls[0];// maximum distance possible
        int res=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(canAssignKCows(stalls,n,k,mid)){
                res=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return res;


    }
    public static boolean canAssignKCows(int[] stalls, int n, int k, int mid){
        int cow=1;
        int pos = stalls[0];
        for(int i=0;i<n;i++){
            int distance = stalls[i]-pos;// distance between prev cow placed stall and current one which we think to place
            if(distance<mid){// if distance is less than mid, means we cannot place with this distance between adjacent
                continue;
            }
            else{
                cow++;// cow can be assigned at ith stall
                pos=stalls[i];// if cow placed that will be used for comparison
            }
        }
        if(cow>=k)// if all cow placed
            return true;
        return false;// not placed with this distance(mid)

    }
}
