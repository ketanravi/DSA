package src.DsaPatterns.Kadanes;
/*
Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.

Note that the subarray needs to be non-empty after deleting one element.



Example 1:

Input: arr = [1,-2,0,3]
Output: 4
Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
Example 2:

Input: arr = [1,-2,-2,3]
Output: 3
Explanation: We just choose [3] and it's the maximum sum.
Example 3:

Input: arr = [-1,-1,-1,-1]
Output: -1
Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.


Constraints:

1 <= arr.length <= 105
-104 <= arr[i] <= 104


 */
public class MaxSubArraySumWithOneDeletion {
    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,-1};
        System.out.println(maximumSum(arr));
    }
    public static int maximumSum(int[] arr) {
        int maxSum = arr[0];
        int noDeletionSum = arr[0];// no element has deleted till now
        int oneDeletionSum= Integer.MIN_VALUE;// one element is deleted, in starting if first element itself deleted so it should be minimum possible

        int i=1;

        while(i< arr.length){
            // keep previous no deletion and one deletion subarray sum
            int prevNoDeletionSum=noDeletionSum;
            int prevOneDeletionSum=oneDeletionSum;

            noDeletionSum = Math.max(arr[i]+noDeletionSum,arr[i]); // without deletion max sum till index
            int v2=0;
            if(prevOneDeletionSum==Integer.MIN_VALUE){
                v2=arr[i];// for starting since we have not found sum after 1 at most deleted
            }
            else{
                v2=prevOneDeletionSum+arr[i];// if we have deleted one earlier, then current index will be included since we cannot delete more than 1
            }
            oneDeletionSum = Math.max(prevNoDeletionSum,v2); // maximum of previous sum after any one delete before that or after including current index with prev one deltion
            maxSum = Math.max(maxSum, Math.max(oneDeletionSum,noDeletionSum));// max of all
            i++;
        }
        return  maxSum;

    }
    // simpler version
    public static int maxSumV2(int arr[]){
        int maxSum = arr[0];
        int noDeletionSum = arr[0];// no element has deleted till now
        int oneDeletionSum= 0;// one element is deleted, in starting if first element itself deleted so it should be 0 sum

        int i=1;

        while(i< arr.length){

//// max of either one deleted earlier so include current OR exclude current which means nodelete sum till now
            oneDeletionSum = Math.max(oneDeletionSum+arr[i], noDeletionSum);
            noDeletionSum = Math.max(arr[i]+noDeletionSum,arr[i]); // without deletion max sum till index
            maxSum = Math.max(maxSum, Math.max(oneDeletionSum,noDeletionSum));// max of all
            i++;
        }
        return  maxSum;
    }
}
