package Interview;


import java.util.*;

public class Student{

    private String name;
    private double cgpa;
    private int order;

    Student(String name, double cgpa, int order){
        this.name = name;
        this.cgpa = cgpa;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

//    public List<Student> getListOfStudents(){
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student("Ravi",9.8,1));
//        studentList.add(new Student("Raj",9.2));
//        studentList.add(new Student("Ravi",9.9));
//        return studentList;
//    }

    public static void main(String[] args){

        PriorityQueue<Student> queue = new PriorityQueue<>(new CGPAComparator());
        queue.add(new Student("Ravi",9.8,1));
        queue.add(new Student("Chandan",9.2,2));
        queue.add(new Student("Chandan",9.2,3));
        queue.add(new Student("Naman",9.9,4));
        queue.add(new Student("Raghav",9.9,5));

        while (!queue.isEmpty()) {
            Student s = queue.poll();
            System.out.println("Name -> "+ s.name+" Cgpa -> "+s.cgpa + " Order -> "+s.order);
        }

    }
    static class CGPAComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            if(s1.getCgpa() - s2.getCgpa()<0)
                return 1;
            else if(s1.getCgpa() - s2.getCgpa()>0)
                return -1;
            else {
                if( s1.getName().compareToIgnoreCase(s2.getName())==0){
                    return s1.getOrder()- s2.getOrder();
                }
                else{
                    return s1.getName().compareToIgnoreCase(s2.getName());
                }
            }
        }
    }


}
