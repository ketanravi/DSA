package AlgoMaster.PrefixSum;

import java.util.HashMap;

/*
    Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

    A subarray is a contiguous part of an array.



    Example 1:

    Input: nums = [4,5,0,-2,-3,1], k = 5
    Output: 7
    Explanation: There are 7 subarrays with a sum divisible by k = 5:
    [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
    Example 2:

    Input: nums = [5], k = 9
    Output: 0


    Constraints:

    1 <= nums.length <= 3 * 104
    -104 <= nums[i] <= 104
    2 <= k <= 104
 */
public class SubArraySumDivisibleByK {


    public static void main(String[] args){
        int[] arr;
        arr = new int[]{4,0,-2,-3,1};
        int k = 5;
        System.out.println(countSubArraySumDivisibleByK(arr,k));


    }
    public static int countSubArraySumDivisibleByK(int [] nums, int k){
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        int count=0;
        int prefixSum=0;
        for(int i=0; i< nums.length;i++){
            prefixSum+=nums[i];// Update the prefix sum with the current number
            // Compute remainder of the current cumulative sum
            int rem = prefixSum%k;
            // Handle negative remainders by converting them into a positive range [0,K-1]
            if(rem<0)
                rem+=k;

            // If we have seen this remainder before, then there exist 'remainderCount.get(remainder)' subarrays ending at current index

            if(hmap.containsKey(rem)) {
                count += hmap.get(rem);// update count
            }
            // Update the remainder count in the map
            hmap.put(rem,hmap.getOrDefault(rem,0)+1);
        }
        return count;
    }
}
