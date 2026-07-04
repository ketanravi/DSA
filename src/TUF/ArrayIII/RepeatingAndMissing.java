package src.TUF.ArrayIII;
/*
Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.



Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.



Note: You are not allowed to modify the original array.


Example 1

Input: nums = [3, 5, 4, 1, 1]

Output: [1, 2]

Explanation:

1 appears two times in the array and 2 is missing from nums

Example 2

Input: nums = [1, 2, 3, 6, 7, 5, 7]

Output: [7, 4]

Explanation:

7 appears two times in the array and 4 is missing from nums.

 */
public class RepeatingAndMissing {
    public static void main(String[] args) {
        int nums[] = {3, 5, 4, 1, 1};
        int res[] = findMissingRepeatingNumbers(nums);
        System.out.println(res[0] +" "+ res[1]);
    }
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        long size = nums.length;
        long sn = (size*(size+1))/2;
        long s2n = (size * (size+1) * (2 *size+1))/6;

        long s = 0, s2= 0;

        for(int i=0;i<size;i++){
            s+=nums[i];
            s2+=(long)nums[i]* (long)nums[i];
        }

        long val1 = s-sn;
        long val2 = s2-s2n;

        val2 = val2/val1;

        long x = (val1+val2)/2;
        long y = x - val1;

        return new int[]{(int)x, (int)y};
    }
}
