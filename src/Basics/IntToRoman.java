package Basics;

import java.util.HashMap;
import java.util.Stack;

public class IntToRoman {
    static HashMap<Integer, String> hmap = new HashMap<>();
    static Stack<String> st = new Stack<>();
    public static void main(String[] args) {
        hmap.put(1, "I");
        hmap.put(4, "IV");
        hmap.put(5, "V");
        hmap.put(9, "IX");
        hmap.put(10, "X");
        hmap.put(100,"C");
        hmap.put(500,"D");
        hmap.put(1000,"M");
        hmap.put(40,"XL");
        hmap.put(50,"L");
        hmap.put(90,"XC");
        hmap.put(400,"CD");
        hmap.put(900,"CM");
        System.out.println(intToRoman(1994));// cccxxxiv
    }
    public static String intToRoman(int number){
        String result = "";
        int divisor = 10;
        int place = 1;
        while(number>0) {
            int rem = number % divisor;
            number = number / divisor;
            if (hmap.containsKey(rem * place)) {
                st.push(hmap.get(rem * place));
            } else {
                int temp = rem * place;
                while (temp > 0) {
                    if (hmap.containsKey(temp)) {
                        st.push(hmap.get(temp));
                        temp-=temp;
                    }else{
                        st.push(hmap.get(place));
                        temp-=place;
                    }
//                    st.push(hmap.get(temp));

                }
            }
            place = place * 10;
        }
        while(!st.isEmpty()){
            result+=st.pop();
        }
        return result;



//               String tempResult = "";
//               while(temp>0){
//                   if(temp>=divisor){
//                       tempResult+=hmap.get(divisor);
//                       temp-=divisor;
//                   }
//                   else{
//                       tempResult+=hmap.get(place);
//                       temp-=place;
//                   }
//               }
//               result = tempResult+result;



    }
}
