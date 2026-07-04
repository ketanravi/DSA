package src.TUF.ArrayII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums. Return all triplets such that:



i != j, i != k, and j != k


nums[i] + nums[j] + nums[k] == 0.


Notice that the solution set must not contain duplicate triplets. One element can be a part of multiple triplets. The output and the triplets can be returned in any order.


Example 1

Input: nums = [2, -2, 0, 3, -3, 5]

Output: [[-2, 0, 2], [-3, -2, 5], [-3, 0, 3]]

Explanation:

nums[1] + nums[2] + nums[0] = 0

nums[4] + nums[1] + nums[5] = 0

nums[4] + nums[2] + nums[3] = 0

Example 2

Input: nums = [2, -1, -1, 3, -1]

Output: [[-1, -1, 2]]

Explanation:

nums[1] + nums[2] + nums[0] = 0

Note that we have used two -1s as they are separate elements with different indexes

But we have not used the -1 at index 4 as that would create a duplicate triplet

1 <= nums.length <= 3000
-104 <= nums[i] <= 104
 */
public class ThreeSum {
    public static void main(String[] args) {
        int nums[] = {2, -2, 0, 3, -3, 5};
        List<List<Integer>> res = threeSum(nums);
        System.out.print("[");
        for(int tripletCounter=0;tripletCounter<res.size();tripletCounter++){
            System.out.print("[");
            for(int i=0;i<res.get(tripletCounter).size();i++){
                System.out.print(res.get(tripletCounter).get(i));
                if(i!=res.get(tripletCounter).size()-1){
                    System.out.print(",");
                }
            }

            System.out.print("]");
            if(tripletCounter!=res.size()-1){
                System.out.print(", ");
            }


        }
        System.out.println("]");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            // skip duplicates :: if i>0 then check if value at i-1 and i is same, if so move next i because it will be duplicate
            if(i>0 && nums[i-1]==nums[i])
                continue;

            int j=i+1;
            int k=n-1;

            // now need to find next two which sums the current i value to target two pointer approach

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];

                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    List<Integer> triplets = Arrays.asList(nums[i],nums[j],nums[k]);
                    res.add(triplets);
                    j++;
                    k--;

                    // skip duplicates
                    while(j<k && nums[j]==nums[j-1])
                        j++;
                    while(j<k && nums[k]==nums[k+1])
                        k--;

                }
            }
        }
        return res;
    }
}
