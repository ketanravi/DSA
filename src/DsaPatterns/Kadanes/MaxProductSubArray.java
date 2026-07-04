package src.DsaPatterns.Kadanes;
/*
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currentMinProduct = nums[0];
        int currentMaxProduct = nums[0];

        int i=1;
        while(i<nums.length){
            int v1 = nums[i];
            int v2 = currentMinProduct * nums[i];
            int v3 = currentMaxProduct * nums[i];

            currentMinProduct = Math.min(v1,Math.min(v2,v3));
            currentMaxProduct = Math.max(v1,Math.max(v2,v3));

            maxProduct = Math.max(maxProduct, Math.max(currentMaxProduct,currentMinProduct));
            i++;


        }
        return maxProduct;

    }
    //Another approach
    public static int maxProduct2(int[] nums) {
        int prefixSum=1;
        int suffixSum=1;
        int result=Integer.MIN_VALUE;
        int n = nums.length;


        for(int i=0;i<n;i++){
            if(prefixSum==0)
                prefixSum=1;
            if(suffixSum==0)
                suffixSum=1;

            prefixSum*=nums[i];
            suffixSum*=nums[n-i-1];
            result = Math.max(result,Math.max(prefixSum,suffixSum));
        }
        return result;
    }
}
