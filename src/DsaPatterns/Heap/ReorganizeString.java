package src.DsaPatterns.Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static class Pair{
        char ch;
        int frequency;

        Pair(int frequency, char ch){
            this.frequency = frequency;
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(reorganizeString(str));
    }
    public static String reorganizeString(String s) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1, Pair p2)->{
            if(p1.frequency==p2.frequency)
                return p2.ch-p1.ch;
            return p2.frequency-p1.frequency;
        });
        StringBuilder res = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();


        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(char key : map.keySet()){
            pq.add(new Pair(map.get(key),key));
        }
        int k = 0;

        while(!pq.isEmpty()){

            Pair currentTop = pq.poll();
            if(res.isEmpty() || res.charAt(k-1)!=currentTop.ch){
                res.append(currentTop.ch);
                k++;
                currentTop.frequency--;
                if(currentTop.frequency>0)
                    pq.add(currentTop);
            }
            else{
                if(pq.isEmpty())
                    return "";
                Pair secondTop = pq.poll();
                res.append(secondTop.ch);
                k++;
                secondTop.frequency--;
                if(secondTop.frequency>0)
                    pq.add(secondTop);
                pq.add(currentTop);


            }
        }
        return res.toString();

    }
}
