package src.TUF.ArrayIV;

import java.util.HashMap;

/*
Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.


Example 1

Input: nums = [10, 5, 2, 7, 1, 9],  k=15

Output: 4

Explanation:

The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.

Example 2

Input: nums = [-3, 2, 1], k=6

Output: 0

Explanation:

There is no sub-array in the array that sums to 6. Therefore, the output is 0.

Constraints

 1<=n<=105
 -105<=nums[i]<=105
 -109<= k<=109
 */
public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int nums[] = {-38,534,204,-848,-223,-762,767,277,-717};
        int k=-1066;
        System.out.println(longestSubarrayWithNegatives(nums,k));

    }
    // work only for positive cases
    public static int longestSubarray(int[] nums, int k) {
        int left=0,right=0;
        int n= nums.length;
        int sum = nums[0];
        int max=0;
        while(right<n){
            while(left<=right && sum>k){
                sum-=nums[left];
                left++;
            }
            if(sum==k){
                max= Math.max(max,right-left+1);
            }

            right++;
            if(right<n)
                sum+=nums[right];


        }
        return max;

    }
    public static int longestSubarrayWithNegatives(int[] nums, int k) {
        int maxLen=0;
        int sum=0;
        int n = nums.length;
        HashMap<Integer,Integer> prefixMap = new HashMap<>();

        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==k){
                maxLen = Math.max(maxLen,i+1);
            }
            // targetsum - sum
            int remainingSum = sum-k;
            if(prefixMap.containsKey(remainingSum)){
                maxLen = Math.max(maxLen,i-prefixMap.get(remainingSum));
            }

            if(!prefixMap.containsKey(sum)){
                prefixMap.put(sum,i);
            }

        }
        return maxLen;

    }

}
