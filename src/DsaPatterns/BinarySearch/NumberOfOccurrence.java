package src.DsaPatterns.BinarySearch;
/*
Number of occurrence
Difficulty: EasyAccuracy: 59.34%Submissions: 401K+Points: 2Average Time: 20m
Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[].

Examples :

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.
Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
1 ≤ target ≤ 106
 */
public class NumberOfOccurrence {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(countFreq(arr,3));
    }
    static int countFreq(int[] arr, int target) {
        int left = smallestGreaterUpperBound(arr,target);
        int right = largestSmallerLowerBound(arr,target);

        return  right!=-1 || left!=-1 ? right-left+1: 0;

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
