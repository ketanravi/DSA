package src.DsaPatterns.Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.



Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]


Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
 */
public class NextGreaterElementII {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,3};
        int[] res = nextGreaterElements(nums);
        Arrays.stream(res).forEach(i -> System.out.print(i + " "));
    }
    public static int[] nextGreaterElements(int[] nums) {
            Stack<Integer> st= new Stack<>();

            int n = nums.length;
            int res[] = new int[n];

            for(int i=2*n-1;i>=0;i--){

                // while stack is not empty and top of stack is smaller than current array element
                while(!st.empty() && st.peek()<=nums[i%n]){
                    st.pop();
                }
                // if index is less than n we need to find next greater
                if(i<n){
                    // if stack is empty means no greater element exists, otherwise top will be next greater
                    res[i] = st.empty()?-1:st.peek();
                }

                // push to the stack after processing
                st.add(nums[i%n]);
            }
            return res;

    }
}
