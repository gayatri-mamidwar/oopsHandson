package interfaces.stack;

public class ArrayStack implements Stack{

    @Override
    public void push(int value) {
        System.out.println("Added to ArrayStack");
    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }
}
