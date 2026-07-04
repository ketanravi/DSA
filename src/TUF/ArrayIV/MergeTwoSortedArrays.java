package src.TUF.ArrayIV;
/*
Given two integer arrays nums1 and nums2. Both arrays are sorted in non-decreasing order.



Merge both the arrays into a single array sorted in non-decreasing order.



The final sorted array should be stored inside the array nums1 and it should be done in-place.


nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s.


nums2 has a length of n.

Example 1

Input: nums1 = [-5, -2, 4, 5], nums2 = [-3, 1, 8]  i=4,j=2

-5 -3 -2 1 4 5

Output: [-5, -3, -2, 1, 4, 5, 8]

Explanation:

The merged array is: [-5, -3, -2, 1, 4, 5, 8], where [-5, -2, 4, 5] are from nums1 and [-3, 1, 8] are from nums2

Example 2

Input: nums1 = [0, 2, 7, 8], nums2 = [-7, -3, -1]

Output: [-7, -3, -1, 0, 2, 7, 8]

Explanation:

The merged array is: [-7, -3, -1, 0, 2, 7, 8], where [0, 2, 7, 8] are from nums1 and [-7, -3, -1] are from nums2

Constraints
    n == nums2.length.
    m + n == nums1.length.
    0 <= n, m <= 1000
    -104 <= nums1[i], nums2[i] <= 104
Both nums1 and nums2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int nums1[] = {-5, -2, 4, 5,0,0,0};
        int nums2[] ={-3, 1, 8};
        int n = nums2.length;
        int m = nums1.length-n;

        merge(nums1,m,nums2,n);
        for(int el: nums1){
            System.out.print(el+" ");
        }

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int ind = m + n - 1;

        while (j >= 0) {
            // if first array element from last is greater than 2nd array element from last
            if (i >= 0 && nums1[i] >= nums2[j]) {
                // put 1st array current element to last of the result array
                nums1[ind] = nums1[i];

                ind--;
                i--;
            }
            // else 2nd array element from last is greater than 1st array element from last
            else {
                // put 2nd array current element to last of the result array
                nums1[ind] = nums2[j];

                ind--;
                j--;
            }
        }
    }
}
