package src.TUF.ArrayIII;
/*
Given an integer array nums. Return the number of inversions in the array.



Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.



It indicates how close an array is to being sorted.


A sorted array has an inversion count of 0.


An array sorted in descending order has maximum inversion.

Example 1

Input: nums = [2, 3, 7, 1, 3, 5]

Output: 5

Explanation:

The responsible indexes are:

nums[0], nums[3], values: 2 > 1 & indexes: 0 < 3

nums[1], nums[3], values: 3 > 1 & indexes: 1 < 3

nums[2], nums[3], values: 7 > 1 & indexes: 2 < 3

nums[2], nums[4], values: 7 > 3 & indexes: 2 < 4

nums[2], nums[5], values: 7 > 5 & indexes: 2 < 5

Example 2

Input: nums = [-10, -5, 6, 11, 15, 17]

Output: 0

Explanation:

nums is sorted, hence no inversions present.
 */
public class CountInversions {
    public static void main(String[] args) {
        int nums[] = {2, 3, 7, 1, 3, 5};
        int n = nums.length;
        System.out.println(mergeSort(nums,0,n-1));

    }
    public static long mergeSort(int[] nums,int low, int high){
        long cnt = 0;

        if(low<high){
            int mid = low + (high-low)/2;
            cnt+=mergeSort(nums,low,mid);
            cnt+=mergeSort(nums,mid+1,high);

            cnt+=merge(nums,low,mid,high);

        }
        return cnt;
    }
    public static long merge(int[] nums, int low,int mid, int high){
        int temp[] = new int[high-low+1];

        int left=low;
        int right = mid+1;
        int index=0;

        long cnt =0;

        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp[index++]=nums[left++];
            }
            else{
                temp[index++]=nums[right++];
                cnt+=(mid-left+1);
            }
        }
        while(left<=mid){
            temp[index++]=nums[left++];
        }
        while(right<=high){
            temp[index++]=nums[right++];
        }
        System.arraycopy(temp,0,nums,low,high-low+1);
        return cnt;
    }
}
