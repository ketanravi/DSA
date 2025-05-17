package Interview;

public class Car extends Vehicle{
    int wheels;
    public Car(){
        System.out.println("Car Constructor Child");
    }
    public Car(int s){
        wheels = s;
        System.out.println("Car Constructor Child");
    }
    public void getVehicleType(){
        System.out.println("Vehicle Type Child Car");
    }
}
