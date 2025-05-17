package AlgoMaster.PrefixSum;

import java.util.HashMap;

/*
        Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



        Example 1:

        Input: nums = [0,1]
        Output: 2
        Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
        Example 2:

        Input: nums = [0,1,0]
        Output: 2
        Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
        Example 3:

        Input: nums = [0,1,1,1,1,1,0,0,0]
        Output: 6
        Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.


        Constraints:

        1 <= nums.length <= 105
        nums[i] is either 0 or 1.
 */
public class ContiguousSubArray {

    public static void main(String[] args){
        int[] arr;
        arr = new int[]{0,1,1,1,1,1,0,0,0};
        System.out.println(getContiguousSubarrayWithEqual0_1(arr));
    }
    public static int getContiguousSubarrayWithEqual0_1(int arr[]){

        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,-1);
        int maxLength= 0;
        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum+= (arr[i]==0) ? -1 : 1;
            if(hmap.containsKey(sum)){
                maxLength = Math.max(maxLength, i-hmap.get(sum));
            }
            else {
                hmap.put(sum, i);
            }
        }
        return maxLength;

    }

}
