package Interview;

public class Starter {
    int wheels;
    Starter(int wheels){
        wheels=wheels;
    }
    public static void main(String args[]){
        Starter s = new Starter(4);
        System.out.println(s.wheels);
    }
}
