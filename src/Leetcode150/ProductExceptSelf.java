package Leetcode150;
/*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation.



    Example 1:

    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
    Example 2:

    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]


    Constraints:

    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


    Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductExceptSelf {
    public static void main(String[] args){
        int arr[] = {1,2,3,4};
        // int arr[] = {2,3,0,0};
        //int arr[] = {-1,1,0,-3,3};
        int result[] = productExceptSelf(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int product = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                zeroCount++;// Counting total zeroes in array
            else
                // if not zero taking total product without zeroes
                // ( for case if only 1 zero then for that element product except self will be answer)
                product=product*nums[i];

        }
        int result[] = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            // if there are more than 1 zero then all elements will be 0 because for any element product will be 0
            if(zeroCount>1){
                result[i] = 0;
            }
            // if there is only 1 zero
            else if(zeroCount==1){
                if(nums[i]==0)
                    //then for that element product except self will be answer
                    result[i] = product;
                else
                    // for rest of the elements product will be 0
                    result[i] = 0;
            }
            // if there are no zeroes then product except self will be total product/element
            else{
                result[i] = product/nums[i];
            }
        }
        return result;

    }
}
