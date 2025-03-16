package DesignPatterns.SingletonPattern;

public class DoubleCheckLazySingleton {
    private static DoubleCheckLazySingleton instance;           //static instance

    private DoubleCheckLazySingleton(){                     //private constructor
    }

    public static DoubleCheckLazySingleton getInstance(){       //static getInstance()
        if(instance == null){
            synchronized (DoubleCheckLazySingleton.class) {     //bcz instance is static so used class
                if(instance == null){
                    instance = new DoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }
}
