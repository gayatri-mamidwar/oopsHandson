package DesignPatterns.SingletonPattern;

public class Client {
    public static void main(String[] args) {

        /* Singlton using Eager initialization. it will return same obj
        EagerSingleton obj1 = EagerSingleton.getInstance();
        System.out.println(obj1.hashCode());

        EagerSingleton obj2 = EagerSingleton.getInstance();
        System.out.println(obj2.hashCode());
         */

        /* LazySinglton using synchronized at method level
        LazySingleton obj1 = LazySingleton.getInstance();
        System.out.println(obj1.hashCode());

        LazySingleton obj2 = LazySingleton.getInstance();
        System.out.println(obj2.hashCode());
         */

        //Double checking using lazy initializing better for multithreaded env
        DoubleCheckLazySingleton obj1 = DoubleCheckLazySingleton.getInstance();
        System.out.println(obj1.hashCode());

        DoubleCheckLazySingleton obj2 = DoubleCheckLazySingleton.getInstance();
        System.out.println(obj2.hashCode());

    }
}
