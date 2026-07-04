package Interview;

import java.util.Date;

public class AlternateSum {
    public static void main(String[] args) {
        int n=2000000;
        Date date = new Date();
        System.out.println(findAlternateSum(n));
        System.out.println(new Date().getTime()-date.getTime());
    }

    private static long findAlternateSum(int n) {// 1 2 3 4 5 6 7 8 9 10
        long result =0;
        long start = 1;
        long step = 2;
        long i=start;
       while(true){
            result+=i;
            i+=step;
            if(i>n){
                start= start*2;
                if(start>n)
                    break;
                i=start;
                step= step *2;
            }
        }
//       System.out.println(start);
//       System.out.println(step);
//       System.out.println(i);
        return result-(start/2);
    }
}
