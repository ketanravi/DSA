package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


/*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.



    Example 1:

    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output:
    [
    [1,1,6],
    [1,2,5],
    [1,7],
    [2,6]
    ]
    Example 2:

    Input: candidates = [2,5,2,1,2], target = 5
    Output:
    [
    [1,2,2],
    [5]
    ]


    Constraints:

    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30
 */
public class UniqueCombinationSum {
    public static void main(String[] args){
        int candidates[] = {10,1,2,7,6,1,5};
        int target = 8;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinationsForTargetSum(candidates,0,target,ds,ans);
        System.out.println(ans);
    }

    private static void findCombinationsForTargetSum(int[] candidates, int index, int target, List<Integer> ds, List<List<Integer>> ans) {
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1])
                continue;
            if(candidates[i]>target)
                break;
            ds.add(candidates[i]);
            findCombinationsForTargetSum(candidates,i+1,target-candidates[i],ds,ans);
            ds.remove(ds.size()-1);

        }
    }

}
