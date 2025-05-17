package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
        Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

        The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
        frequency
         of at least one of the chosen numbers is different.

        The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



        Example 1:

        Input: candidates = [2,3,6,7], target = 7
        Output: [[2,2,3],[7]]
        Explanation:
        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
        7 is a candidate, and 7 = 7.
        These are the only two combinations.
        Example 2:

        Input: candidates = [2,3,5], target = 8
        Output: [[2,2,2,2],[2,3,3],[3,5]]
        Example 3:

        Input: candidates = [2], target = 1
        Output: []


        Constraints:

        1 <= candidates.length <= 30
        2 <= candidates[i] <= 40
        All elements of candidates are distinct.
        1 <= target <= 40
 */
public class CombinationSum {
    public static void main(String[] args){
        int candidates[] = {2,3,6,7};
        int target = 7;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationsForTargetSum(candidates,0,target,ds,ans);
        System.out.println(ans);

    }
    public static void findCombinationsForTargetSum(int[] candidates,int index,int target, List<Integer> ds, List<List<Integer>> ans){
        if(index == candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[index]<=target){
            ds.add(candidates[index]);
            // case for pick
            // not increasing index because we can use the same element as next candidate for making combinations
            // but reducing the target as we are including it in combination
            findCombinationsForTargetSum(candidates,index,target-candidates[index],ds,ans);
            ds.remove(ds.size()-1);
        }
        // not reducing the target as we are not including the element as this is the case of not pick
        findCombinationsForTargetSum(candidates,index+1,target,ds,ans);

    }
}
