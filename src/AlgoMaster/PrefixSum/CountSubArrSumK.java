package AlgoMaster.PrefixSum;
/*
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.



    Example 1:

    Input: nums = [1,1,1], k = 2
    Output: 2
    Example 2:

    Input: nums = [1,2,3], k = 3
    Output: 2


    Constraints:

    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107
 */
import java.util.HashMap;

public class CountSubArrSumK {
    public static void main(String[] args){
        int nums[] = {1,1,1};
        int k = 2;
        System.out.println(subarraySumEqualsK(nums,k));
    }
    public static int subarraySumEqualsK(int [] nums, int k){
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        int count=0;
        int prefixSum=0;
        for(int i=0; i< nums.length;i++){
            prefixSum+=nums[i];// Update the prefix sum with the current number


            // Each entry in the hashmap `h` represents how many times we have seen a prefix sum of a specific value.
            // We're checking if there's a contiguous subarray from a previous prefix sum to the current prefix sum.
            // Hence, if (prefixSum - k) is in the hashmap, that means we’ve seen that previous prefix sum in h before.

            if(hmap.containsKey(prefixSum-k)) {
                // If (prefixSum - k) exists in `map`, it means there's a subarray ending at the current index
                // whose sum equals k. The count of such subarrays is equal to the value of map.get(prefixSum - k),
                // as it represents how many times that previous prefix sum has occurred.

                count += hmap.get(prefixSum - k);// update count
            }

            // Add the current prefix sum to the hashmap
            // This allows future iterations to find subarrays ending here.
            hmap.put(prefixSum,hmap.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
