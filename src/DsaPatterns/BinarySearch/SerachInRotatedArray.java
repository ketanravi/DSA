package src.DsaPatterns.BinarySearch;
/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */
public class SerachInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,1));
    }
    public static int search(int[] nums, int target) {
        int rotatedAt = findKRotation(nums);
        if(rotatedAt==0){
            return binarySearch(nums,0,nums.length-1,target);
        }

        int leftSearch = binarySearch(nums,0,rotatedAt-1,target);
        if(leftSearch!=-1)
            return leftSearch;
        int rightSearch = binarySearch(nums,rotatedAt,nums.length-1,target);
        if(rightSearch!=-1)
            return rightSearch;
        return -1;
    }
    public static int findKRotation(int arr[]) {
        int n = arr.length;
        int low=0,high=n-1;
        int res=0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid]>arr[high]){
                low=mid+1;
            }
            else{
                res=arr[mid]<arr[res] ? mid:res;
                high=mid-1;
            }
        }
        return res;
    }
    public static int binarySearch(int[] arr, int low, int high, int target){
        int res=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]<target){
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return res;
    }
    // calling either left search or right search
    public static int searchV2(int[] nums, int target) {
        int rotatedAt = findKRotation(nums);
        if(rotatedAt==0){
            return binarySearch(nums,0,nums.length-1,target);
        }
        if(target<nums[0]){
            int rightSearch = binarySearch(nums,rotatedAt,nums.length-1,target);
            if(rightSearch!=-1)
                return rightSearch;
        }
        else{
            int leftSearch = binarySearch(nums,0,rotatedAt-1,target);
            if(leftSearch!=-1)
                return leftSearch;
        }
        return -1;
    }
    public static int searchInOnePass(int[] nums,int target){
        int low=0,high=nums.length-1;
        int res=-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid]==target)
                return mid;

            if(nums[mid]>nums[high]){//part 1
                if(target>nums[mid]){
                    low=mid+1;
                }
                else{
                    // target is smaller than mid and smaller is both in first part and second part so
                    if(nums[0]>target){
                        low = mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
            }
            else{
                if(target<nums[mid]){
                    high=mid-1;
                }
                else{
                    // target is greater than mid and greater is both in first part and second part so
                    if(nums[high]<target){
                        high = mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
            }
        }
        return res;
    }
}
