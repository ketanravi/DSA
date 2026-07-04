package src.DsaPatterns.PrefixSum;

import java.util.HashMap;

/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */
public class ContiguousSubArrayOf0s1s {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();


        int zeroes = 0;
        int ones = 0;
        int res=0;

        for(int i=0;i<n;i++){
            if(nums[i]==0)
                zeroes++;
            else
                ones++;

            int diff = zeroes-ones;

            if(diff==0){
                res = Math.max(res,i+1);
                continue;
            }

            if(hmap.containsKey(diff)){
                res = Math.max(res, i-hmap.get(diff));
            }
            else{
                hmap.put(diff,i);
            }


        }
        return res;
    }
}
