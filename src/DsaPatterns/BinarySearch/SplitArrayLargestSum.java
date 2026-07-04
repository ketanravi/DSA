package src.DsaPatterns.BinarySearch;
/*
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.


Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        System.out.println(splitArray(nums,3));
    }
    public static int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(n<k)
            return 0;
        int low=nums[0];
        int high = nums[0];

        for(int i=0;i<n;i++){
            low = Math.max(low,nums[i]);
            high+=nums[i];
        }
        int res=0;

        while(low<=high){
            int guessSum = low+(high-low)/2;
            if(arrayCanBeSplittedWithSum(nums,k,guessSum)){
                res=guessSum;
                high=guessSum-1;//since we have to minimize;
            }
            else{
                low=guessSum+1;
            }
        }
        return res;
    }

    public static boolean arrayCanBeSplittedWithSum(int nums[], int k, int guessSum){
        int count=1;
        int sum=0;

        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=guessSum){
                sum+=nums[i];
            }
            else{ // since sum become greater after adding this curr element so reset sum to current element and increase count of subarray
                count++;//  subarray found
                sum=nums[i];// next subarray Start
            }
        }
        if(count<=k)
            return true;
        else
            return false;
    }
}
