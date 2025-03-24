package DesignPatterns.BuilderPattern;

public class Client {
    public static void main(String[] args) {

        /*
        Using Builder no need to set all attributes of obj. also sequence of attri doesnt matter
         */
        Student student = Student.getBuilder()
                .setAge(20)
                .setGradYear(2021)
                .setPhoneNumber("6726356789")
                .setBatch("Jan24Mrng")
                .setName("Gayatri")
                .build();

        //student is an Object reference
        //Student student = new Student(student);         //here builder is helping Student to create obj.only through builder can create student obj

        System.out.println(student);
        System.out.println(student.name);           //using reference u can access the values
    }
}
