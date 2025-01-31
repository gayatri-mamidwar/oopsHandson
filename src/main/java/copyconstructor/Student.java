package copyconstructor;

public class Student {

    private int id;
    private int age;
    private double psp;
    private int gradYear;
    private Exam enrollmentExam;

    public Student() {
    }

    //Why we are not passing Exam in constructor as parameter?
    public Student(int id, int age, double psp, int gradYear) {
        this.id = id;
        this.age = age;
        this.psp = psp;
        this.gradYear = gradYear;
        this.enrollmentExam = new Exam(1, 0);   //at the time of Student constructor Exam get automatically initialized
    }

    Student(Student other){
        this.id = other.id;
        this.age = other.age;
        this.psp = other.psp;
        this.gradYear = other.gradYear;

        // just Copying the references. so address will be same for both
        //this.enrollmentExam = other.enrollmentExam;                       //shallow copy

        this.enrollmentExam = new Exam(other.enrollmentExam);               //deep copy
    }
}
