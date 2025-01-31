package interfaces.stack;

public class StackFactory {

    public static Stack createStackByType(String stackType){
        Stack stack = null;
        if(stackType.equalsIgnoreCase("Array")){
            stack = new ArrayStack();
        }
        else if(stackType.equalsIgnoreCase("LinkedList")){
            stack = new LinkedListStack();
        }
        else if(stackType.equalsIgnoreCase("Queue")){
            stack = new QueueStack();
        }
        return stack;
    }
}
