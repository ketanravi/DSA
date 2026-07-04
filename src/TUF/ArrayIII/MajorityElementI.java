package src.TUF.ArrayIII;
/*
Given an integer array nums of size n, return the majority element of the array.



The majority element of an array is an element that appears more than n/2 times in the array. The array is guaranteed to have a majority element.


Example 1

Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]

Output: 7

Explanation:

The number 7 appears 5 times in the 9 sized array

Example 2

Input: nums = [1, 1, 1, 2, 1, 2]

Output: 1

Explanation:

The number 1 appears 4 times in the 6 sized array


Constraints

n == nums.length.
1 <= n <= 105
-104 <= nums[i] <= 104
One value appears more than n/2 times.


 */
public class MajorityElementI {
    public static void main(String[] args) {
        int nums[] = {7, 0, 0, 1, 7, 7, 2, 7, 7};

        System.out.println(majorityElement(nums));

    }
    public static int majorityElement(int[] nums) {
        int size = nums.length;
        int majorityElement = nums[0];
        int count=1;

        for(int i=1;i<size;i++){
            if(count==0){
                majorityElement = nums[i];
                count++;
            }
            else if(majorityElement==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        count=0;
        for(int i=0;i<size;i++){
            if(nums[i]==majorityElement){
                count++;
            }
        }
        return count>size/2?majorityElement:-1;
    }
}
