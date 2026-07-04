package src.TUF.ArrayI;

import java.util.Arrays;

/*
    Longest Consecutive Sequence in an Array
Medium

Given an array nums of n integers.



Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.


Example 1

Input: nums = [100, 4, 200, 1, 3, 2]

Output: 4

Explanation:

The longest sequence of consecutive elements in the array is [1, 2, 3, 4], which has a length of 4. This sequence can be formed regardless of the initial order of the elements in the array.

Example 2

Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]

Output: 9

Explanation:

The longest sequence of consecutive elements in the array is [0, 1, 2, 3, 4, 5, 6, 7, 8], which has a length of 9.
     */
public class LargestConsecutiveIntegers {
    public static void main(String[] args) {
        int[] nums = {17,12,-8,-11,14,-19,9,-4,-11,-12,-8,5,15,14,9,-19,12,5,0,18,13,-1,3,19,16,-13,-11,9};
        int len = nums.length;
        int maxCount=1;
        Arrays.sort(nums);

        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                count++;
            }
            else{
                if(nums[i]!=nums[i-1]){
                    maxCount = Math.max(maxCount,count);
                    count=1;
                }
            }

        }
        maxCount = Math.max(maxCount,count);
        System.out.println(maxCount);
    }
}
