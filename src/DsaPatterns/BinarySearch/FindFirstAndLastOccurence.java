package src.DsaPatterns.BinarySearch;
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */
public class FindFirstAndLastOccurence {

    public static void main(String[] args) {
        int nums [] = {5,7,7,8,8,10};
        searchRange(nums,6);
    }
    public static void searchRange(int[] nums, int target) {
        int[] res = new int[2];

        res[0] = smallestGreaterUpperBound(nums,6);
        res[1] = largestSmallerLowerBound(nums,6);

        System.out.println(res[0]+" "+ res[1]);

    }
    public static int smallestGreaterUpperBound(int[] arr, int x) {
        int low=0,high=arr.length-1;
        int res=-1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid]<x){
                low=mid+1;
            }
            else{
                if(arr[mid]==x)
                    res=mid;
                high=mid-1;
            }
        }
        return res;

    }
    public static int largestSmallerLowerBound(int[] arr,int x){
        int low=0,high=arr.length-1;
        int res=-1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid]<=x){
                if(arr[mid]==x)
                    res=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return res;
    }
}
