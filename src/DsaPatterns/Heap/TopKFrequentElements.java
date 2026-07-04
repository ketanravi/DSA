package src.DsaPatterns.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]



Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

1->3
2->2
3->1

2,2
3,1

1,3

 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int nums[] ={1,1,1,2,2,3};
        int k=2;

        int[] res= topKFrequent(nums,k);
        for( int num : res){
            System.out.println(num+" ");

        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.frequency));
        HashMap<Integer,Integer> hmap = new HashMap<>();

        for(int num: nums){
            hmap.put(num,hmap.getOrDefault(num,0)+1);
        }

        for(int key: hmap.keySet()){
            Pair pair = new Pair(hmap.get(key),key);

            if(pq.size()<k){
                pq.add(pair);
                continue;
            }
            //System.out.println(hmap.get(key)+ "->"+key);
            Pair currentTopPair = pq.element();
            if(pair.frequency<currentTopPair.frequency) {
                continue;
            }
            pq.poll();
            pq.add(pair);
        }
        int i=0;
        while(!pq.isEmpty()){
            int num = pq.poll().element;
            res[i++] =  num;
        }

        return res;
    }
// have not used pair class but int[]
    public int[] topKFrequentOptimized(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashMap<Integer,Integer> hmap = new HashMap<>();

        for(int num: nums){
            hmap.put(num,hmap.getOrDefault(num,0)+1);
        }

        for(int key: hmap.keySet()){
            if(pq.size()<k){
                pq.add(new int[]{hmap.get(key),key});
                continue;
            }
            //System.out.println(hmap.get(key)+ "->"+key);

            if(hmap.get(key)<pq.peek()[0]) {
                continue;
            }
            pq.poll();
            pq.add(new int[]{hmap.get(key),key});
        }
        int i=0;
        while(!pq.isEmpty()){
            int num = pq.poll()[1];
            res[i++] =  num;
        }

        return res;
    }
    public int[] topKFrequentOptimizedAndSimple(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashMap<Integer,Integer> hmap = new HashMap<>();

        for(int num: nums){
            hmap.put(num,hmap.getOrDefault(num,0)+1);
        }

        for(int key: hmap.keySet()){
            pq.add(new int[]{hmap.get(key),key});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int i=0;
        while(!pq.isEmpty()){
            int num = pq.poll()[1];
            res[i++] =  num;
        }

        return res;
    }
    static class Pair{
        int frequency;
        int element;

        Pair(int frequency, int element){
            this.frequency = frequency;
            this.element = element;
        }
    }
}


