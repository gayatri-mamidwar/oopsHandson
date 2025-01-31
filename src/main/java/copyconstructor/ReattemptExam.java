package copyconstructor;

public class ReattemptExam {

    private int examId;

    public ReattemptExam() {
    }

    public ReattemptExam(int examId) {
        this.examId = examId;
    }

    public ReattemptExam(ReattemptExam other){
        this.examId = other.examId;
    }
}
