package copyconstructor;

public class Exam {

    private int examId;
    private int score;
    private ReattemptExam reattemptExam;

    public Exam() {
    }

    public Exam(int examId, int score) {
        this.examId = examId;
        this.score = score;
        this.reattemptExam = new ReattemptExam(1);      //in param constructor, write like this for reference type
    }

    public Exam(Exam other){
        this.examId = other.examId;
        this.score = other.score;
        //this.reattemptExam = other.reattemptExam;       //shallow copy. its copying references only
        this.reattemptExam = new ReattemptExam(other.reattemptExam);
    }
}
