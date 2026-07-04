package SlidingWindowPattern;

/*
        You are given an integer array nums consisting of n elements, and an integer k.

        Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.



        Example 1:

        Input: nums = [1,12,-5,-6,50,3], k = 4
        Output: 12.75000
        Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
        Example 2:

        Input: nums = [5], k = 1
        Output: 5.00000


        Constraints:

        n == nums.length
        1 <= k <= n <= 105
        -104 <= nums[i] <= 104
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AverageSumSubArrayK {
    public static void main(String[] args){
        int num[] = {1,12,-5,-6,50,3};
        int k=4;
        System.out.println(findAverageSumSubArrayK(num,k));
    }

    public static List<Double> findAverageSumSubArrayK(int[] nums, int k){
        List<Double> res = new ArrayList<>();
        if(k > nums.length)
            return res;

        int leftBoundary = 0;
        int rightBoundary = k;
        Double subArraySum = 0.0;

        for(int i=0;i<k;i++){
            subArraySum+=nums[i];
        }
        res.add(subArraySum/k);

        while(rightBoundary < nums.length ){
            subArraySum-=nums[leftBoundary];
            subArraySum+=nums[rightBoundary];
            leftBoundary++;rightBoundary++;
            res.add(subArraySum/k);
        }
        return res;

    }
}
