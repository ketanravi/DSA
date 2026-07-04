package src.TUF.ArrayI;

import java.util.ArrayList;
import java.util.List;

/*

Given an integer array nums of even length consisting of an equal number of positive and negative integers.Return the answer array in such a way that the given conditions are met:



Every consecutive pair of integers have opposite signs.


For all integers with the same sign, the order in which they were present in nums is preserved.


The rearranged array begins with a positive integer.

Example 1

Input : nums = [2, 4, 5, -1, -3, -4]

Output : [2, -1, 4, -3, 5, -4]

Explanation:

The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4 maintain their relative positions

Example 2

Input : nums = [1, -1, -3, -4, 2, 3]

Output : [1, -1, 2, -3, 3, -4]

Explanation:

The positive number 1, 2, 3 maintain their relative positions and -1, -3, -4 maintain their relative positions

 */
public class RearrangePosNeg {
    public static void main(String[] args) {
        int arr[] = {2, 4, 5, -1, -3, -4};
        int len = arr.length;

        List<Integer> pos = new ArrayList<>(len/2);
        List<Integer> neg = new ArrayList<>(len/2);

        for (int j : arr) {
            if (j > 0) {
                pos.add(j);
            } else {
                neg.add(j);
            }
        }
        for(int i=0;i<len/2;i++){
            arr[2*i]=pos.get(i);
            arr[2*i+1]=neg.get(i);
        }
        for (int j : arr) {
            System.out.println(j);
        }



    }
}
