package Generics;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        //Old pair class with d.t as Object
        PairOld pairOld = new PairOld();
        pairOld.setFirst("Gayatri");
        pairOld.setSecond("Mdr");

        pairOld.setSecond(5);           //in Object type, it will accept value of any d.t

        //New Pair class with T,V as d.t
        Pair<String, String> pairNew = new Pair<>();
        pairNew.setFirst("Pritam");
        pairNew.setSecond("Domal");

        //pairNew.setSecond(5);           //Now with new Pair its not accepting Integer d.t for second.bcz we mentioned it as String

        Pair<Double, Integer> pairNew1 = new Pair<>();
        pairNew1.setFirst(5.0);
        pairNew1.setSecond(10);

        //Its allowing bcz passing string as i/p & accepting return type as string only
        String str = pairNew1.doSomething("Generic From method");

        //Its not allowing bcz passing string as i/p & accepting return type as Integer
//        Integer str = pairNew1.doSomething("Generic From method");

        Integer integer = pairNew1.doSomething(4);

        //Bcz of backward compatibility java still allow to use Raw type
        //in this case it automatically assumes both types to be Object
        Pair pairobj = new Pair();

        Animal animal = new Animal();
        animal.setName("Something");

        Animal animal1 = new Animal();
        animal1.setName("Big ANimal");

        Dog dog = new Dog();
        dog.setName("dubby");

        Dog dog1 = new Dog();
        dog1.setName("Robert");

        Cat cat = new Cat();
        cat.setName("Catty");

        //In parent reference we can store any references of child. Inside List<Animal> we can store Dog, Cat, Animal refrences
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.add(animal1);
        animals.add(dog);
        animals.add(cat);

        AnimalUtility.printAnimalUtility(animals);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        dogs.add(dog1);

        AnimalUtility.printAnimalUtility(dogs);     //it will throw err if not writing <T extends Animal>

    }
}
