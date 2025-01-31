package inheritance;

public class Client {
    public static void main(String[] args) {

        Student student = new Student("Gayatri", "gayatri@gmail.com", "pass");
        student.login("gayatri@gmail.com","pass");
        student.solveProblems();

        Instructor instructor = new Instructor();
        instructor.login("", "");
        instructor.takeClass();

        TA ta = new TA();
        ta.login("", "");
        ta.acceptHR();
    }
}


/*
WHENEVER WE CREATE AN OBJECT OF CHILD, PARENT CONSTRUCTOR IS ALSO CALLED
 */