package src.DsaPatterns.Heap.KClosest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int k=4,x=3;
        System.out.println(findClosestElements(arr,k,x));

    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return b[0]-a[0];
        }
        );
        for(int i=0;i<arr.length;i++){
            int d=Math.abs(x-arr[i]);
            pq.add(new int[]{d,arr[i]});
            if(pq.size()>k)pq.remove();
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            int[] arr1=pq.remove();
            ans.add(arr1[1]);
        }
        Collections.sort(ans);
        return ans;

    }
    public List<Integer> findClosestElementsUsingTwoPointer(int[] arr, int k, int x) {

        int start = 0;
        int end = arr.length - 1;
        while (end - start >= k) {
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            } else {
                end--;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
