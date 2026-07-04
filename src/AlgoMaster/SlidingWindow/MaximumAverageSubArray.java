package AlgoMaster.SlidingWindow;
/*
    LEETCODE - 643. Maximum Average Subarray I
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
public class MaximumAverageSubArray {
    public static void main(String[] args){
        int nums[] = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(getMaximumAvgSubArrayLengthK(nums,k));
    }

    private static double getMaximumAvgSubArrayLengthK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        long sum = 0;
        while(right<k){
            sum+=nums[right];
            right++;
        }
        right--;
        double maxAvg = ((double)sum)/ k;
        while(left<=right && left<nums.length && right<nums.length ){
            int currSize = right-left+1;
            if(currSize==k){
                double currAvg = ((double)sum)/ k;
                maxAvg = Math.max(maxAvg, currAvg);
                sum-=nums[left];
                left++;

            }
            right++;
            if(right< nums.length)
                sum+=nums[right];

        }
        return maxAvg;
    }
}
