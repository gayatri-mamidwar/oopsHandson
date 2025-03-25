package DesignPatterns.PrototypeAndRegistryPattern;

public class Client {
    public static void main(String[] args) {

        Student s = new Student();
        IntelligentStudent i = new IntelligentStudent();

        Student s2 = s.copy();
        Student i2 = i.copy();

        System.out.println();

        StudentRegistry studentRegistry = new StudentRegistry();
        s.setAge(30);
        s.setBatch("Apr24");
        s.setName("Gaytri");
        studentRegistry.add("Apr24", s);

        Student st = studentRegistry.get("Apr24").copy();
    }
}
