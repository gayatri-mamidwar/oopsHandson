package Generics;

import java.util.List;

public class AnimalUtility {
//    public static void printAnimalUtility(List<Animal> animals){  //here it was only accepting Animal Class obj bcz of List<Animal>
//        for(Animal animal : animals){
//            System.out.println(animal.getName());
//        }
//    }

    //We need to mention type parameter before return type in <>
    //Here, it will accept whatever classes are extending from Animal, i.e. Dog, Cat, Animal
    public static <T extends Animal> void printAnimalUtility(List<T> animals){

        //In this, we can only do Animal specific things. not DOg/Cat specific 
        for(Animal animal : animals){
            System.out.println(animal.getName());
        }
    }
}
