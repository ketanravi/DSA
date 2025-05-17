package AlgoMaster.Arrays;
/*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.



    Example 1:

    Input: nums = [0,1,0,3,12]    1 0 0 3 12   1 3 0 0 12
    Output: [1,3,12,0,0]
    Example 2:

    Input: nums = [0]
    Output: [0]


    Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1


    Follow up: Could you minimize the total number of operations done?
 */
import java.util.Arrays;
public class MoveZeroes {
    public static void main(String[] args){
        int nums[] = {12,0,0,3,12};
        moveZeroesOptimized(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    public static void moveZeroes(int[] nums) {
        //keep left right at 0
        int left=0,right=0;
        while(left< nums.length && right< nums.length){
            //increment right till first non-zero index
            if(nums[right]==0){
                right++;
            }
            // if right element is non-zero but  there was previous zero that is left at zero then swap
            else if(nums[right]!=0 && nums[left]==0){
                int temp = nums[left];
                nums[left]=nums[right];
                nums[right]= temp;
                left++;
            }
            // if there is no zeros till now increment both left and right
            else{
                left++;right++;
            }
        }
    }
    public static void moveZeroesOptimized(int[] nums){
        int lastZeroPosition = 0; // This marks the last zero swap position

        // Loop through the array
        for (int current = 0; current < nums.length; current++) {
            if (nums[current] != 0) {
                // Perform the swap
                int temp = nums[lastZeroPosition];
                nums[lastZeroPosition] = nums[current];
                nums[current] = temp;
                lastZeroPosition++;
            }
        }
    }
}
