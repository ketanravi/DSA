package src.DsaPatterns.PrefixSum;

import java.util.HashMap;

/*
Given an array arr[] containing both positive and negative integers, the task is to find the length of the longest subarray with a sum equals to 0.

Note: A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements while maintaining their original order.

Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [0, -4, 3, 1, 0]
Constraints:
1 ≤ arr.size() ≤ 106
−103 ≤ arr[i] ≤ 103
 */
public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = {-31,-48,-90, 54, 20, 95, 6, -86, 22};
        System.out.println(maxLength(arr));
    }
    static int maxLength(int arr[]) {
        int res=0;
        int prefixSum=0;
        int k=0;

        int left=0,right=0;
        HashMap<Integer,Integer> hmap= new HashMap<>();


        while(right<arr.length){

            prefixSum+=arr[right];

            if(prefixSum==0){
                res = right+1;
            }
            if(hmap.containsKey(prefixSum)){
                res = Math.max(res,right-hmap.get(prefixSum));
            }
            else{

                hmap.put(prefixSum,right);
            }
            right++;

        }
        return res;

    }
}
