package AlgoMaster.Arrays;

/*
        Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

        Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

        Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
        Return k.
        Custom Judge:

        The judge will test your solution with the following code:

        int[] nums = [...]; // Input array
        int[] expectedNums = [...]; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        If all assertions pass, then your solution will be accepted.



        Example 1:

        Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
        Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
        Example 2:

        Input: nums = [0,0,1,1,1,2,2,3,3,4]
        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
        Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).


        Constraints:

        1 <= nums.length <= 3 * 104
        -100 <= nums[i] <= 100
        nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesSortedArray {
    public static void main(String[] args){
  //     int nums[] = {0,0,0,2,2,2,2,3,3,4};
//        int nums[] = {1,2,3};
        int nums[]={1,1,2,3};
        int uniqueCountsIndex = removeDuplicates(nums);
        for(int i=0;i<uniqueCountsIndex;i++){
            System.out.print(nums[i]+" ");
        }

    }
    public static int removeDuplicates(int[] nums){
//        int i=0,j=1;
//        int total = nums.length;
//        if(total<=1)
//            return 1;
//        while(i<total && j<total){
//            // if elements are dupllicate with previous just check next numbers till unique found
//            if(nums[i]==nums[j]){
//                j++;
//            }
//            // if unique found replace with duplicate once one place ahead which i+1
//            else{
//                i++;
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//                // also increase j to check now other next because this is already processed and array is sorted
//                j++;
//            }
//        }
//        //return the answer where current i is at
//        return i+1;
        // amother approach

        if(nums.length<=1)
            return 1;
        int j=1;// since first element will always be unique so we have to swap starting from 2nd element only
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]) {// if previous is not equal to current
                nums[j] = nums[i];// put unique one in duplicated position
                j++;//increase position j
            }
        }
        return j;

    }

}
