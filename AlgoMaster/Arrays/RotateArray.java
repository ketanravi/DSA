package AlgoMaster.Arrays;

import java.util.Arrays;

/*
        Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



        Example 1:

        Input: nums = [1,2,3,4,5,6,7], k = 3 // 7654321   5671234
        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]
        Example 2:

        Input: nums = [-1,-100,3,99], k = 2
        Output: [3,99,-1,-100]
        Explanation:
        rotate 1 steps to the right: [99,-1,-100,3]
        rotate 2 steps to the right: [3,99,-1,-100]


        Constraints:

        1 <= nums.length <= 105
        -231 <= nums[i] <= 231 - 1
        0 <= k <= 105


        Follow up:

        Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
        Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7};
        int k=3;
        rotateArray(arr,k);
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static void rotateArray(int arr[], int k){
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k);
        reverse(arr,k,arr.length-1);
    }
    public static void reverse(int arr[], int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
