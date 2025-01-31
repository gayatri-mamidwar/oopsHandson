package inheritance.constructorChaining;

public class C extends B {

    C(){
        System.out.println("default constructor of C is executed");
    }

    // parameterized constructor of C
    C(int x){
        this();                     //this() to call current class default constructor. i.e. C()
        System.out.println("parameterized constructor of C is executed");
    }
}


//super -> helps to refer to parent class
//this -> helps to refer to current class 