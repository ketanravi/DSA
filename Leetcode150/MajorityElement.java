package Leetcode150;

/*
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



    Example 1:

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2


    Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109


    Follow-up: Could you solve the problem in linear time and in O(1) space?
 */


import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args){
        int nums[] = {2,2,3,3,3,3,2};
        System.out.println(findMajorityElementOptimized(nums));
    }
    // 1st Approach using hashmap o(n) space
    public static int findMajorityElement(int[] nums){
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(nums[i]))
                hmap.put(nums[i],hmap.get(nums[i])+1);
            else
                hmap.put(nums[i],1);
        }
        for(Integer i : hmap.keySet()){
            if(hmap.get(i)>nums.length/2)
                return (int)i;
        }
        return 0;
    }
    // 2nd Approach O(1) space
    public static int findMajorityElementOptimized(int[] nums){
        int count = 0;
        int candidate = nums[0];
        for(int i=0;i<nums.length;i++){
            if(count==0){
                count=1;
                candidate = nums[i];
            }
            else if(nums[i]==candidate){
                count++;
            }
            else{
                count--;
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate){
                count++;
                if(count>nums.length/2)
                    return candidate;
            }
        }
        return 0;
    }
}
