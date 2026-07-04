package src.TUF.ArrayII;

import java.util.Arrays;

public class ClosestSumTarget {
    public static void main(String[] args) {
        int arr[] = {7,8,9};
        System.out.println(threeSumClosest(arr,-1));

    }
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closestSumToTarget=Integer.MAX_VALUE-1;
        int result=0;

        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int j=i+1;
            int k=n-1;

            while(j<k){
                int tripletSum = nums[i]+nums[j]+nums[k];
                if(tripletSum==target){
                    return target;
                }

                else if(tripletSum>target){
                    k--;
                }
                else{
                    j++;
                }


                if(Math.abs(closestSumToTarget-target)>Math.abs(tripletSum-target)){
                    closestSumToTarget = tripletSum;

                }



            }
            int sum = closestSumToTarget-target;
            System.out.println(sum);
        }
        return closestSumToTarget;
    }
}
