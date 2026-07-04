package src.DsaPatterns.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.



Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.



Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100
 */
public class TaskScheduler {

//    static class Pair{
//        int frequency;
//        char task;
//
//        Pair(int frequency, char task){
//            this.frequency = frequency;
//            this.task = task;
//        }
//    }
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n=2;
        System.out.println(leastInterval(tasks,n));
    }
    public static int leastInterval(char[] tasks, int n) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);

        int[] frequencyMap = new int[26];
        int[] nextInterval = new int[26];

        for(char task: tasks){
            frequencyMap[task-'A']++;
            nextInterval[task-'A']=1;// keepin info that this task next can be picked only after this interval initially all can be picked after 1
        }

        for(int i=0;i<26;i++){
            if(frequencyMap[i]!=0)
                pq.offer(new int[] {frequencyMap[i],i});// adding all in heap
        }


        int intervals = 1;


        while(!pq.isEmpty()) {
            ArrayList<int[]> waitQueue = new ArrayList<>();
            while (!pq.isEmpty()) {// checking if found
                int[] currentTop = pq.poll();
                int frequency = currentTop[0];
                int currentIndex = currentTop[1];
                if (nextInterval[currentIndex] <= intervals) {// if this task can be picked based on interval
                    if (frequency > 1) {// if one found to be picked by cpu
                        currentTop[0]--;// reduce frequency
                        pq.offer(currentTop);// add back to heap
                    }
                    nextInterval[currentIndex] = intervals + n + 1;//next interval only after which this item again can be picked because we picked this just now
                    break;
                }
                else {
                    waitQueue.add(currentTop);// if cannot be picked push in wait queue
                }
            }
            intervals++;// either picked or any element cannot be picked interval will increment
            for (int[] ints : waitQueue) {
                pq.offer(ints);// putting all waiting queue task back in heap
            }
        }
        return intervals-1;// since we have moved to the next interval, so return current - 1;

    }
}
