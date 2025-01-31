package inheritance.constructorChaining;

public class D extends C {
    D(){

        /* Java uses implicit super() to call default constructor. but parent class constructor dont hv default constructor &
                        want to call parameterized constructor. we need to explicitly write super by passing arg */

        super(5);       //call to super must be first stmt in constructor
        System.out.println("default constructor of D is executed");
    }
}
