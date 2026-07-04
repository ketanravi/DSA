package src.DsaPatterns.TwoPointer;
/*
Given an array arr[] consisting of only 0's and 1's. Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.

Examples :

Input: arr[] = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
Explanation:  After segregation, all the 0's are on the left and 1's are on the right. Modified array will be [0, 0, 0, 0, 0, 1, 1, 1, 1, 1].
Input: arr[] = [1, 1]
Output: [1, 1]
Explanation: There are no 0s in the given array, so the modified array is [1, 1]
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 1

 */
public class Rearrange0And1 {
    void segregate0and1(int[] arr) {
        int i=0;
        int n = arr.length;
        int j=n-1;

        while(i<j){
            if(arr[i]==0){
                i++;
            }
            else{
                if(arr[j]==0){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    j--;
                }
                else{
                    j--;
                }
            }
        }

    }
}
