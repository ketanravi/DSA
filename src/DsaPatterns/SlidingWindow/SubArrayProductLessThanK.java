package src.DsaPatterns.SlidingWindow;
/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.



Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0


Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106
 */
public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        int arr[] = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(arr,100));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int low=0;
        int cnt = 0;
        int n = nums.length;
        long product = 1;
        int res=0;
        if(k<=1)
            return 0;

        for(int high=0;high<n;high++){
            product*=nums[high];
            // if product is greater than or equal to k shrink window
            while(product>=k){
                product/=nums[low];
                low++;
            }
            if(product<k){
                res+=(high-low+1);
            }
        }
        return res;

    }
}
