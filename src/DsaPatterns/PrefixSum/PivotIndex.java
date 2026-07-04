package src.DsaPatterns.PrefixSum;
/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */
public class PivotIndex {
    public static int pivotIndex(int[] nums, int k) {
        int totalSum=0;
        int preSumExcludingIndex=0;
        int postSumAfterIndex=0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }

        // For first element presum is 0 and postsum is excluding that element that is totalsum-nums[0]
        if(preSumExcludingIndex==totalSum-nums[0])
            return 0;

        for(int i=1;i<n;i++){
            // presum till index
            preSumExcludingIndex+=nums[i-1];
            //post sum excluding current index (total-currentElement-preSum)
            postSumAfterIndex= totalSum-nums[i]-preSumExcludingIndex;
            // if bot equal
            if(preSumExcludingIndex==postSumAfterIndex)
                return i;

        }

        return -1;

    }
}
