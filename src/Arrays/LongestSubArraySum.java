package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum {


//    Given an array arr containing n integers and an integer k.
//    Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value k.
/*
        Input :
        arr[] = {10, 5, 2, 7, 1, 9}, k = 15
        Output : 4
        Explanation:
        The sub-array is {5, 2, 7, 1}.
* */

    public static int getLongSubArrraySize(int arr[], int k){
        int longestSubArraySize = 0;
        int arrLength =  arr.length;
        long prefixSumTillIndex = 0;
        Map<Long,Integer> indexSumPair = new HashMap<>();
        for(int i=0;i<arrLength;i++){
            prefixSumTillIndex+=arr[i];
            if(prefixSumTillIndex==k)
                longestSubArraySize = Math.max(longestSubArraySize,i+1);
            long rem = prefixSumTillIndex - k;
            if(indexSumPair.containsKey(rem))
            {
                longestSubArraySize = Math.max(longestSubArraySize,i-indexSumPair.get(rem));
            }
            if(!indexSumPair.containsKey(prefixSumTillIndex))
                indexSumPair.put(prefixSumTillIndex,i);

        }

        return longestSubArraySize;
    }
    public static void main(String[] args){
        int[] arr;
        arr = new int[]{1,0,3,1,1,1,1,4,2,3};
        int k = 7;
        System.out.println(getLongSubArrraySize(arr,k));


    }


}
