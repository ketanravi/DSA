package src.DsaPatterns.Kadanes;
/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSumSubArray {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
//    public static int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int currSum = 0;
//        int maxSum = Integer.MIN_VALUE;
//        int i=0;
//
//        while(i<n){
//            currSum+=nums[i];
//            maxSum = Math.max(currSum,maxSum);
//            if(currSum<0){
//                currSum=0;
//            }
//            i++;
//        }
//        return maxSum;
//    }
public static int maxSubArray(int[] nums) {
    int n = nums.length;
    int currSum = nums[0];
    int maxSum = nums[0];
    int i=1;

    while(i<n){
        int v1=currSum+nums[i];
        int v2=nums[i];
        currSum= Math.max(v1,v2);
        maxSum = Math.max(currSum,maxSum);
        i++;
    }
    return maxSum;
}
}
