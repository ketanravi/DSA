package src.DsaPatterns.Heap;

import java.util.*;

/*
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.



Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.


Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]


Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        //String words[] ={"the","day","is","sunny","the","the","the","sunny","is","is"};
        String words[] = {"i","love","leetcode","i","love","coding"};
        int k=2;

        List<String> res= topKFrequent(words,k);
        System.out.println(res);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        PriorityQueue<WordFrequencyPair> pq = new PriorityQueue<>((a,b)->{
            if(a.frequency!=b.frequency){
                return Integer.compare(a.frequency,b.frequency);
            }
            return (b.word).compareTo(a.word);
        });
        HashMap<String,Integer> hmap = new HashMap<>();

        for(String word : words){
            hmap.put(word,hmap.getOrDefault(word,0)+1);
        }

        for(String key: hmap.keySet()){

            if(pq.size()<k){
                pq.add(new WordFrequencyPair(key,hmap.get(key)));
                continue;
            }
            if(!pq.isEmpty()) {
                //System.out.println(hmap.get(key)+ "->"+key);
                WordFrequencyPair currentTopPair = pq.element();
                if (hmap.get(key) < currentTopPair.frequency ||
                        (hmap.get(key) == currentTopPair.frequency && key.compareTo(currentTopPair.word) > 0)) {
                    continue;
                }
                pq.poll();
                pq.add(new WordFrequencyPair(key, hmap.get(key)));
            }
        }
        int i=0;
        while(!pq.isEmpty()){
            String word = pq.poll().word;
            res.addFirst(word);
        }

        return res;
    }

    public List<String> topKFrequentSimple(String[] words, int k) {
        List<String> res = new ArrayList<>();
        PriorityQueue<WordFrequencyPair> pq = new PriorityQueue<>((a,b)->{
            if(a.frequency!=b.frequency){
                return Integer.compare(a.frequency,b.frequency);
            }
            return (b.word).compareTo(a.word);
        });
        HashMap<String,Integer> hmap = new HashMap<>();

        for(String word : words){
            hmap.put(word,hmap.getOrDefault(word,0)+1);
        }

        for(String key: hmap.keySet()){
            pq.add(new WordFrequencyPair(key,hmap.get(key)));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int i=0;
        while(!pq.isEmpty()){
            String word = pq.poll().word;
            res.addFirst(word);
        }

        return res;
    }
    static class WordFrequencyPair {
        String word;
        int frequency;

        WordFrequencyPair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
}



