package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

/*

        Given an integer array nums that may contain duplicates, return all possible
        subsets
         (the power set).

        The solution set must not contain duplicate subsets. Return the solution in any order.



        Example 1:

        Input: nums = [1,2,2]
        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
        Example 2:

        Input: nums = [0]
        Output: [[],[0]]


        Constraints:

        1 <= nums.length <= 10
        -10 <= nums[i] <= 10

 */
public class PrintAllSubset2 {
    public static void main(String[] args){
        int arr[] = {4,4,4,1,4};
        List<Integer> ds = new ArrayList<>();
        HashSet<List<Integer>> ans = new HashSet<>();
        Arrays.sort(arr);
        findAllSubsets(arr,0,ds,ans);
        System.out.println(ans);

    }
    public static void findAllSubsets(int arr[], int index, List<Integer> ds, HashSet<List<Integer>> ans){
        if(index==arr.length){
            ans.add(new ArrayList<>(ds));
        }
        if(index<arr.length) {
            ds.add(arr[index]);
            findAllSubsets(arr, index + 1, ds, ans);
            ds.remove(ds.size() - 1);
            findAllSubsets(arr, index + 1, ds, ans);
        }
    }
}
