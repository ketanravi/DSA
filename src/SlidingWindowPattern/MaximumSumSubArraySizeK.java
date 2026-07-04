package SlidingWindowPattern;

public class MaximumSumSubArraySizeK {
    public static void main(String[] args){
        int nums[] = {2, 1, 5, 1, 3, 2};
        int k=3;
        System.out.println(findMaxSumSubArraySizeK(nums,k));

    }

    private static int findMaxSumSubArraySizeK(int[] nums, int k) {
        if(k > nums.length)
            return 0;

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
        return max;
    }

}
