package AlgoMaster.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
         * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
         *
         * Notice that the solution set must not contain duplicate triplets.
         *
         *
         *
         * Example 1:
         *
         * Input: nums = [-1,0,1,2,-1,-4]
         * Output: [[-1,-1,2],[-1,0,1]]
         * Explanation:
         * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
         * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
         * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
         * The distinct triplets are [-1,0,1] and [-1,-1,2].
         * Notice that the order of the output and the order of the triplets does not matter.
         * Example 2:
         *
         * Input: nums = [0,1,1]
         * Output: []
         * Explanation: The only possible triplet does not sum up to 0.
         * Example 3:
         *
         * Input: nums = [0,0,0]
         * Output: [[0,0,0]]
         * Explanation: The only possible triplet sums up to 0.
         *
         *
         * Constraints:
         *
         * 3 <= nums.length <= 3000
         * -105 <= nums[i] <= 105
 */
public class ThreeSum {
    public static void main(String[] args){
        int arr[] = {-1,0,1,2,-1,-4};
        System.out.println(findAllTripletWithSum0(arr));

    }

    public static List<List<Integer>> findAllTripletWithSum0(int arr[]){
        List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(arr);
            int len = arr.length;
        for(int i=0;i<len-2;i++){
            if(i==0 || arr[i]!=arr[i-1]){
                int left = i+1;
                int right = len-1;
                while(left<right){
                    int sum = arr[i]+arr[left]+arr[right];
                    if(sum==0){
                        result.add(Arrays.asList(arr[i],arr[left],arr[right]));
                        while(left<right && arr[left]==arr[left+1])
                            left++;
                        while(left<right && arr[right]==arr[right-1])
                            right--;
                        left++;
                        right--;
                    } else if (sum<0) {
                        left++;
                    } else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
