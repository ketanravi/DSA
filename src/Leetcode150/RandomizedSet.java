package Leetcode150;

import java.util.*;

public class RandomizedSet {

    private Map<Integer,Integer> hmap;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        hmap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(hmap.containsKey(val))
            return false;
        hmap.put(val,list.size());//putting in map with index as current list size
        list.add(val);//adding in list also
        return true;
    }

    public boolean remove(int val) {
        if(!hmap.containsKey(val))
            return false;
//Get removal index of element from map, e.g. val '2' from map (2,0) => index=0
        int valIndex = hmap.get(val);
// to replace with element to be removed
        int lastElement = list.get(list.size()-1);
//Swap - Set lastElem at removal index since that value should be deleted anyway. then remove last elem.
        list.set(valIndex,lastElement);
// removing last element from list as already swapped
        list.remove(list.size()-1);

        hmap.put(lastElement,valIndex);//putting entry of last element in map
        hmap.remove(val);//finally removing value to be removed from map
        return true;
    }

    public int getRandom() {
        int rand = random.nextInt(list.size());
        return list.get(rand);
    }

    public static void main(String[] args){
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(3));
        System.out.println(obj.insert(4));
        System.out.println(obj.getRandom());
        System.out.println(obj.insert(5));
        System.out.println(obj.remove(3));
        System.out.println(obj.getRandom());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

