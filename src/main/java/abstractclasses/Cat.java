package abstractclasses;

public class Cat extends Animal {
    private String type;

    public void meow(){
        System.out.println("Cat is meowing");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }
}
