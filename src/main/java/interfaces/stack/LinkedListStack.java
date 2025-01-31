package interfaces.stack;

public class LinkedListStack implements Stack{
    @Override
    public void push(int value) {
        System.out.println("Added to LinkedListStack");
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
