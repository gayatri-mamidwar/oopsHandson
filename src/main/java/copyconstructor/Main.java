package copyconstructor;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, World!");

        Student st = new Student(101, 27, 90.20, 2019);

        //We want to create new student but via copy it from st
        Student st1 = st;               //this wont create new obj it just refers to same reference addr
        System.out.println(" ");

//        Student st2 = new Student(st.getId());            Not possible bcz we dont have getters & setters. So, we need copy constructor

        Student s3 = new Student(st);   //it will create new obj & hold diff addr
        System.out.println();
    }
}