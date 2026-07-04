package src.TUF.ArrayIV;

import java.util.HashMap;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.


Example 1

Input : nums = [4, 2, 2, 6, 4], k = 6

100 ^ 010 ^ 010 ^ 110 ^ 100
4,1


100
110
010





Output : 4



Explanation : The subarrays having XOR of their elements as 6 are [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]

Example 2

Input :nums = [5, 6, 7, 8, 9], k = 5



Output : 2



Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
 */
public class CountSubArrayWithXorK {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9};
        System.out.println(subarraysWithXorK(nums,5));
    }
    public static int subarraysWithXorK(int[] nums, int k) {
        int count = 0;

        HashMap<Integer,Integer> prefixXorMap = new HashMap<>();
        prefixXorMap.put(0,1);
        int currentXor = 0;
        for(int i=0;i<nums.length;i++){
            currentXor^=nums[i];
            int prefixXorWithK = currentXor^k;
            count+=prefixXorMap.getOrDefault(prefixXorWithK,0);
            prefixXorMap.put(currentXor,prefixXorMap.getOrDefault(currentXor,0)+1);
        }
        return count;
    }
}
