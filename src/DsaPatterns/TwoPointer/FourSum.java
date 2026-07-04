package src.DsaPatterns.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
4 Sum
Medium

Given an integer array nums and an integer target. Return all quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:



a, b, c, d are all distinct valid indices of nums.


nums[a] + nums[b] + nums[c] + nums[d] == target.


Notice that the solution set must not contain duplicate quadruplets. One element can be a part of multiple quadruplets. The output and the quadruplets can be returned in any order.


Example 1

Input: nums = [1, -2, 3, 5, 7, 9], target = 7

Output: [[-2, 1, 3, 5]]

Explanation:

nums[1] + nums[0] + nums[2] + nums[3] = 7

Example 2

Input: nums = [7, -7, 1, 2, 14, 3], target = 9

Output: []

Explanation:

No quadruplets are present which add upto 9

Constraints

1 <= nums.length <= 200
-104 <= nums[i] <= 104
-104 <= target <= 104
 */
public class FourSum {
    public static void main(String[] args) {
        int nums[] ={1, -2, 3, 5, 7, 9};
        int target = 7;
        List<List<Integer>> res = fourSum(nums, target);
        for(int counter=0;counter<res.size();counter++){
            System.out.print("[");
            for(int i=0;i<res.get(counter).size();i++){
                System.out.print(res.get(counter).get(i));
                if(i!=res.get(counter).size()-1){
                    System.out.print(",");
                }
            }

            System.out.print("]");
            if(counter!=res.size()-1){
                System.out.print(", ");
            }


        }
        System.out.println("]");
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            // skip duplicates :: if i>0 then check if value at i-1 and i is same, if so move next i because it will be duplicate
            if(i>0 && nums[i-1]==nums[i])
                continue;
            for(int j=i+1;j<n;j++){
                // skip duplicates :: if j>0 then check if value at j-1 and j is same, if so move next j because it will be duplicate
                if(j>i+1 && nums[j-1]==nums[j])
                    continue;
                int leftPtr=j+1;
                int rightPtr=n-1;

                // now need to find next two which sums the current i,jvalue to target two pointer approach

                while(leftPtr<rightPtr){
                    long sum = (long) nums[i]+nums[j]+nums[leftPtr]+nums[rightPtr];

                    if(sum<target){
                        leftPtr++;
                    }
                    else if(sum>target){
                        rightPtr--;
                    }
                    else{
                        List<Integer> quadruplets = Arrays.asList(nums[i],nums[j],nums[leftPtr],nums[rightPtr]);
                        res.add(quadruplets);
                        leftPtr++;
                        rightPtr--;

                        // skip duplicates
                        while(leftPtr<rightPtr && nums[leftPtr]==nums[leftPtr-1])
                            leftPtr++;
                        while(leftPtr<rightPtr && nums[rightPtr]==nums[rightPtr+1])
                            rightPtr--;

                    }
                }
            }
        }
        return res;
    }
}
