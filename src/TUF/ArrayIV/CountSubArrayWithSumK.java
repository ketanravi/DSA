package src.TUF.ArrayIV;

import java.util.HashMap;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.


Example 1

Input: nums = [1, 1, 1], k = 2

Output: 2

Explanation: In the given array [1, 1, 1], there are two subarrays that sum up to 2: [1, 1] and [1, 1]. Hence, the output is 2.

Example 2

Input: nums = [1, 2, 3], k = 3

Output: 2

Explanation: In the given array [1, 2, 3], there are two subarrays that sum up to 3: [1, 2] and [3]. Hence, the output is 2.
 */
public class CountSubArrayWithSumK {

    public static void main(String[] args) {

        int nums[] = {6,8,4,-6,-4,6,-7,0,-8,-1,-8,-9,9,4,0,7,9,9,7,2,8,-1,9,-4,2,1,-7,6,2
};
        System.out.println(subarraySum(nums,-2));
    }
    public static int subarraySum(int[] nums, int k) {
        int count=0;
        int currSum=0;
        HashMap<Integer,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);

        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            int remSum = currSum-k;

            count+=prefixSumMap.getOrDefault(remSum,0);
            prefixSumMap.put(currSum,prefixSumMap.getOrDefault(currSum,0)+1);

        }
        return count;
    }
}
