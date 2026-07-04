package AlgoMaster.String;

public class ReverseWordsInString {
    public static void main(String[] args){
        System.out.println(reverseWordsOptimized("a good   example"));
    }
    public static String reverseWordsOptimized(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    static void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    static String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private static void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
}


//    public static String reverseWords(String s) {
//        String result = "";
//        int start=0,end=s.length();
//        for(int i=0;i<s.length();i++){
//            if (s.charAt(i) != ' ') {
//                start = i;
//                break;
//            }
//        }
//        for(int i=s.length()-1;i>=0;i--){
//            if (s.charAt(i) != ' ') {
//                end = i;
//                break;
//            }
//        }
//        for(int i=start;i<=end;i++){
//            if (s.charAt(i) == ' ' && s.charAt(i-1) == ' ') {
//              continue;
//            }
//            result+=s.charAt(i);
//        }
//        System.out.println(start+" "+end);
//        result = reverse(0, result.length()-1, result);
//        System.out.println(result);
//        String res = "";
//        start = 0;
//        for(int i=0;i<result.length();i++){
//            if(result.charAt(i)==' '){
//                System.out.println(start+" "+(i-1));
//                res+= reverse(start,i-1, result)+" ";
//                start=i+1;
//            }
//            else if(i==result.length()-1){
//                res+= reverse(start,i, result);
//            }
//        }
//        //    System.out.println(s);
//        return res;
//
//    }
//    public static String reverse(int start,int end, String result){
//        String r="";
//        char ch;
//        for (int i = start; i <= end; i++) {
//
//            // extracts each character
//            ch = result.charAt(i);
//
//            // adds each character in
//            // front of the existing string
//            r = ch + r;
//        }
//        return r;
//    }

