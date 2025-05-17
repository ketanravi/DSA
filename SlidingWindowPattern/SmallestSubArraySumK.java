package SlidingWindowPattern;
/*
        Given an array of positive integers nums and a positive integer target, return the minimal length of a
        subarray
         whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



        Example 1:

        Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: The subarray [4,3] has the minimal length under the problem constraint.
        Example 2:

        Input: target = 4, nums = [1,4,4]
        Output: 1
        Example 3:

        Input: target = 11, nums = [1,1,1,1,1,1,1,1]
        Output: 0


        Constraints:

        1 <= target <= 109
        1 <= nums.length <= 105
        1 <= nums[i] <= 104

 */
public class SmallestSubArraySumK {
    public static void main(String[] args){
        int nums[] = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(findSmallestSubArraySumK(nums,target));

    }

    private static int findSmallestSubArraySumK(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int curr=0,start=0;
        int sum=0;
        while(curr<nums.length){
            sum+=nums[curr];
            while(sum>=target){
                min = Math.min(min,curr-start+1);
                sum-=nums[start];
                start++;
            }
            curr++;
        }
        return min;


    }
}
