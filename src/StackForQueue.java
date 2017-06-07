import java.util.Stack;

public class StackForQueue {
    public static void main(String args[] ) {
        System.out.println("Heya");
    }
}

class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void Push(int x) {
        input.push(x);
    }

    public int Peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.peek());
        return output.peek();
    }

    public void Pop() {
        Peek();
        output.pop();
    }

    public boolean Empty() {
        return input.empty() && output.empty();
    }
}