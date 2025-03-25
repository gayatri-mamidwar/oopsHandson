package DesignPatterns.PrototypeAndRegistryPattern;

public class Student {
    private String name;
    private int age;
    private String batch;

    public Student() {
    }

    //copy constructor
    public Student(Student student){
        this.age = student.age;
        this.batch = student.batch;
        this.name = student.name;
    }

    //it will create copy of student using deep copy
    public Student copy(){
        Student student = new Student(this);            //new addr is assigned for copied student
        return student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
