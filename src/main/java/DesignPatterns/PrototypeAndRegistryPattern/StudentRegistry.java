package DesignPatterns.PrototypeAndRegistryPattern;

import java.util.HashMap;

public class StudentRegistry {

    //create private hashmap for fast look up
    private HashMap<String, Student> students;

    //inside constructor initialize Hashmap. it will create new hashmap for each obj
    public StudentRegistry(){
        students = new HashMap<>();
    }

    //implement methods for easy use
    public void add(String key, Student student){
        students.put(key, student);
    }

    public void remove(String key){
        students.remove(key);
    }

    public Student get(String key){
        return students.get(key);
    }

}
