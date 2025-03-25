package DesignPatterns.PrototypeAndRegistryPattern;

public class IntelligentStudent extends Student {
    private int iq;

    public IntelligentStudent() {
    }

    //copy constructor for actual copying
    public IntelligentStudent(IntelligentStudent intelligentStudent){
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
    }

    //manage copying process
    public IntelligentStudent copy(){
        IntelligentStudent copy = new IntelligentStudent(this);
        return copy;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
