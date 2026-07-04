package src.DsaPatterns.Kadanes;
/*
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.



Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.


Constraints:

n == nums.length
1 <= n <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
 */
public class MaximumSumCircularArray {
    public static void main(String[] args) {
        int nums[]={-3,-2,-3};
        System.out.println(maxSubarraySumCircular(nums));
    }
    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }

        int currentMax=nums[0];
        int currentMin=nums[0];
        int maxCircularSum=nums[0];


        int i=1;

        while(i< nums.length){
            currentMax = Math.max(nums[i],currentMax+nums[i]);
            currentMin = Math.min(nums[i],currentMin+nums[i]);
            System.out.println("curremtMax:-"+currentMax);
            System.out.println("curremtMin:-"+currentMin);
            System.out.println("maxSum:-"+maxCircularSum);

            maxCircularSum = Math.max(maxCircularSum,Math.max(currentMax, totalSum==currentMin? currentMin : totalSum-currentMin));
            System.out.println("maxSum:-"+maxCircularSum);
            i++;
        }
        return maxCircularSum;
    }
    // another approach
    public static int maxSubarraySumCircular2(int[] nums) {
        int currMin = nums[0], currMax = nums[0], minSum = nums[0], maxSum = nums[0];
        int totalSum = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            currMax = Math.max(nums[i],currMax+nums[i]);
            maxSum = Math.max(maxSum,currMax);

            currMin = Math.min(nums[i],currMin+nums[i]);
            minSum = Math.min(currMin,minSum);

            totalSum += nums[i];
        }
        if(minSum == totalSum) return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
}
