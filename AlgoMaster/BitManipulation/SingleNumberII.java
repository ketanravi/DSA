package AlgoMaster.BitManipulation;
/*
        Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

        You must implement a solution with a linear runtime complexity and use only constant extra space.



        Example 1:

        Input: nums = [2,2,3,2]
        Output: 3
        Example 2:

        Input: nums = [0,1,0,1,0,1,99]
        Output: 99


        Constraints:

        1 <= nums.length <= 3 * 104
        -231 <= nums[i] <= 231 - 1
        Each element in nums appears exactly three times except for one element which appears once.
 */
public class SingleNumberII {
    public static void main(String[] args){
        int nums [] = { 1,2,1,1,2,2,3};
        int res = findSingleNumbers(nums);
        System.out.println(res);
    }

    // Brute force will be use hashmap with o(n) space
    // 2nd approach will use count set bits at position O(n)*32 time complexity
    /*
     int missing =0;
    int count = 0;
    for(int i =0; i<32;i++){//checking each bit position
        count = 0;
       for(int num :nums){
           count += ((num & (1<<i))==0?0:1);//checking if the position is set bit
       }
      count %=3;//calculating count of position in mod of 3
      missing |= count<<i;  //creating missing number using count
    }
    return missing;
     */
    //3rd approach sort it then check previous O(nlogn)
    //4th approach below use ones to keep track if occured once, twos if occured twice . put in ones if not in twos and put in twos if not in ones and delete from ones
    public static int findSingleNumbers(int[] nums) {
        int ones =0, twos = 0;
        for(int i=0;i<nums.length;i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

}
