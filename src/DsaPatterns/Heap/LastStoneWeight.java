package src.DsaPatterns.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.



Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
Example 2:

Input: stones = [1]
Output: 1


Constraints:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {4,6,8};
        System.out.println(lastStoneWeight(stones));

    }
    public static int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if(n==1)
            return stones[0];
        if(n==2)
            return Math.abs(stones[1]-stones[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int stone : stones) {
            pq.add(stone);
        }

        while(!pq.isEmpty()){
            if(pq.size()==1)
                return pq.poll();

            int first = pq.poll();
            int second = pq.poll();

            if(first!=second){
                pq.offer(Math.abs(first-second));
            }

        }
        return 0;
    }

    public int lastStoneWeightOptimized(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while(pq.size()>1){

            int first = pq.poll();
            int second = pq.poll();

            if(first!=second){
                pq.offer(Math.abs(first-second));
            }

        }
        if(pq.size()==1)
            return pq.poll();
        return 0;
    }

}
