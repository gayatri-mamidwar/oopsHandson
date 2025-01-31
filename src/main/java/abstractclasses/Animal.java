package abstractclasses;

public abstract class  Animal {
    private String name;
    private int age;

    public void walk(){
        System.out.println("Animal is walking");
    }

    //Everyone under me should know how to eat
    public abstract void eat();
}

/* Interfaces?
1) reason1 -> U can't inherit multiple classes
2) reason2 -> abstract classes can have attributes & method definitons for its childrens
3) reason3 -> Entities => abstract class , Behaviours => interface
 */