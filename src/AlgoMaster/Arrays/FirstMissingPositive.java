package AlgoMaster.Arrays;
/*

        Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

        You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.



        Example 1:

        Input: nums = [1,2,0]
        Output: 3
        Explanation: The numbers in the range [1,2] are all in the array.
        Example 2:

        Input: nums = [3,4,-1,1]
        Output: 2
        Explanation: 1 is in the array but 2 is missing.
        Example 3:

        Input: nums = [7,8,9,11,12]
        Output: 1
        Explanation: The smallest positive integer 1 is missing.


        Constraints:

        1 <= nums.length <= 105
        -231 <= nums[i] <= 231 - 1

 */
public class FirstMissingPositive {
    public static void main(String[] args){
        int arr[] = {1,2,0};
        System.out.println(firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] nums){
        int n = nums.length;;
        int checkArray[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            checkArray[i]=0;// filling all array with 0
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && nums[i]<=nums.length)
                checkArray[nums[i]-1]=1;// whenever found any positive number, mark it as 1 in the check array to mark that this positive element is present
        }
        // now check the array from 0 to max, if any index is marked as 0  in the check array, that means (index+1)element is the first positive missing number
        for(int i=0;i<nums.length;i++){
            if(checkArray[i]==0)
                return i+1;
        }
        return n+1;// if all number are present from 1 to n, then the first missing positive number will be n+1
    }
}
