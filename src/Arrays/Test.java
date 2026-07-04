package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        // Sample HashMap with keys as integers and values as doubles (as Strings)
        HashMap<Integer, Double> hashMap = new HashMap<>();
        hashMap.put(0, 0.2);
        hashMap.put(10, 0.4);
        hashMap.put(15, 0.8);

        // Convert HashMap to TreeMap for sorted keys
        TreeMap<Integer, Double> treeMap = new TreeMap<>(hashMap);

        // Example values to test
        int[] testValues = {5, 12, 16, 10,0,15,23}; // Example values to check

        for (int value : testValues) {
            Double result = getValueForClosestKey(treeMap, value);
            if (result != null) {
                System.out.println("For value " + value + ", the closest key less than or equal is mapped to: " + result);
            } else {
                System.out.println("No key in the range less than or equal to " + value);
            }
        }
    }

    // Method to get the value associated with the greatest key <= given value
    public static Double getValueForClosestKey(TreeMap<Integer, Double> treeMap, int value) {
        // Find the highest key less than or equal to the given value
        Map.Entry<Integer, Double> entry = treeMap.floorEntry(value);
        if (entry != null) {
            return entry.getValue();
        }
        return null; // No key less than or equal to the value
    }
}
