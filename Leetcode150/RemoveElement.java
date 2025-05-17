package Leetcode150;
/*
        Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

        Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

        Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
        Return k.
        Custom Judge:

        The judge will test your solution with the following code:

        int[] nums = [...]; // Input array
        int val = ...; // Value to remove
        int[] expectedNums = [...]; // The expected answer with correct length.
                                    // It is sorted with no values equaling val.

        int k = removeElement(nums, val); // Calls your implementation

        assert k == expectedNums.length;
        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < actualLength; i++) {
            assert nums[i] == expectedNums[i];
        }
        If all assertions pass, then your solution will be accepted.



        Example 1:

        Input: nums = [3,2,2,3], val = 3
        Output: 2, nums = [2,2,_,_]
        Explanation: Your function should return k = 2, with the first two elements of nums being 2.
        It does not matter what you leave beyond the returned k (hence they are underscores).
        Example 2:

        Input: nums = [0,1,2,2,3,0,4,2], val = 2
        Output: 5, nums = [0,1,4,0,3,_,_,_]
        Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
        Note that the five elements can be returned in any order.
        It does not matter what you leave beyond the returned k (hence they are underscores).


        Constraints:

        0 <= nums.length <= 100
        0 <= nums[i] <= 50
        0 <= val <= 100
 */
public class RemoveElement {
    public static void main(String[] args){
        int arr[]={0,1,2,2,3,0,4,2}; // 0 1 3 0 4 2 2 2
        int val = 2;
        int n = removeElement(arr,val);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }

    }
    public static int removeElement(int[] nums, int val) {
        int i=0,j=0;
        // while both elements present for comparison
        while(i<nums.length && j<nums.length){
            // if the element is equal to value to be deleted
            if(nums[i]==val){
                int temp = nums[i];
                //if next number is not equal to value, swap the number otherwise increment to find first non match to value
                if(nums[j]!=val) {
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                //if a number found and  if next number is also same as value just increment and try to find first non match
                else{
                    j++;
                }
            }
            // else if the current number is not equal to value just try to find number equal to val
            else{
                i++;
                j++;
            }
        }
        // current position of i will be the length till which there will be no element equal to value ( No given element exist)
        return i;
    }
}
