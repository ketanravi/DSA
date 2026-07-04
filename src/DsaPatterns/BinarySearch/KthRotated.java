package src.DsaPatterns.BinarySearch;
/*
Given an increasing sorted rotated array arr[] of distinct integers. The array is right-rotated k times. Find the value of k.
Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2 times it will look like this:
After 1st Rotation : [9, 2, 4, 6]
After 2nd Rotation : [6, 9, 2, 4]

Examples:

Input: arr[] = [5, 1, 2, 3, 4]  4 5 6 7 1 2 3
Output: 1
Explanation: The given array is [5, 1, 2, 3, 4]. The original sorted array is [1, 2, 3, 4, 5]. We can see that the array was rotated 1 times to the right.
Input: arr = [1, 2, 3, 4, 5]
Output: 0
Explanation: The given array is not rotated.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 107
 */
public class KthRotated {
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,1};
        System.out.println(findKRotation(arr));
    }
    public static int findKRotation(int arr[]) {
        int n = arr.length;
        int low=0,high=n-1;
        int res=-1;
        if(arr[high]>=arr[low])
            return 0;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid==0 && arr[mid]>arr[mid+1]) {
                return mid + 1;
            }
            else if(mid==n-1 && arr[mid]<arr[mid-1]){
                return mid;

            }
            if(arr[mid-1]>arr[mid] && arr[mid]<arr[mid+1]){
                return mid;
            }
            else if(arr[mid]>arr[high]){
                low=mid+1;
            }
            else if(arr[mid]<arr[low])
            {
                high=mid-1;
            }
            else{
                high=low;
            }
        }
        return res;

    }
}
