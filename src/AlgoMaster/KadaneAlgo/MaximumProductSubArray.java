package AlgoMaster.KadaneAlgo;
/*
    Given an integer array nums, find a
    subarray
     that has the largest product, and return the product.

    The test cases are generated so that the answer will fit in a 32-bit integer.



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
public class MaximumProductSubArray {
    public static void main(String[] args){
        int nums[] = {2,-3,-2,4};

        System.out.println(findMaxSubArrayProduct(nums));
    }
    public static int findMaxSubArrayProduct(int[] nums){
        // Edge case: if the array is empty
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize the maximum and minimum product so far with the first element
        int maxProductSoFar = nums[0];
        int minProductSoFar = nums[0];
        // Result variable to store the final answer
        int maxProductResult = nums[0];

        // Iterate over the rest of the array from the second element
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            // Temporarily store the maxProductSoFar for swapping if needed
            int tempMax = maxProductSoFar;

            // Update maxProductSoFar based on the current number and compared products
            maxProductSoFar = Math.max(currentNum, Math.max(maxProductSoFar * currentNum, minProductSoFar * currentNum));

            // Update minProductSoFar similarly to handle mixed signs
            minProductSoFar = Math.min(currentNum, Math.min(tempMax * currentNum, minProductSoFar * currentNum));

            // Update the result with the maximum of potentially new maxProductSoFar
            maxProductResult = Math.max(maxProductResult, maxProductSoFar);
        }
        return maxProductResult;
    }
}
