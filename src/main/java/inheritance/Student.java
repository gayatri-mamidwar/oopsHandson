package inheritance;

public class Student extends User{
    private double psp;

    public Student(String name, String email, String password){
        //this.name = setName(name);          //we can't use this here bcz name is coming from User class.

        System.out.println("Student constructor is executed.");
        setName(name);
        setEmail(email);
        setPassword(password);
        psp = 0.0;
    }

    public void solveProblems(){
        System.out.println("Student is solving problems");
    }
}
