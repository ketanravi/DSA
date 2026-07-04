package SlidingWindowPattern;

import java.util.ArrayList;
import java.util.List;

public class MaxAverageSubArraySum {
    public static void main(String[] args){
        int num[] = {1,12,-5,-6,50,3};
        int k=4;
        System.out.println(findAverageSumSubArrayK(num,k));
    }

    public static Double findAverageSumSubArrayK(int[] nums, int k){
        if(k > nums.length)
            return 0.0;

        int leftBoundary = 0;
        int rightBoundary = k;
        int subArraySum = 0;

        for(int i=0;i<k;i++){
            subArraySum+=nums[i];
        }
        int max = subArraySum;

        while(rightBoundary < nums.length ){
            subArraySum-=nums[leftBoundary];
            subArraySum+=nums[rightBoundary];
            leftBoundary++;rightBoundary++;
            max = Math.max(subArraySum,max);
        }
        return (double)max/k;
    }
}
