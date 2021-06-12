package codevitta;
import java.util.Stack;
public class zombie {
    public static Stack<Integer> sort(Stack<Integer> s) {

        if (s.isEmpty()) {
            return s;
        }
        int pivot = s.pop();

        // partition
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        while (!s.isEmpty()) {
            int y = s.pop();
            if (y < pivot) {
                left.push(y);
            } else {
                right.push(y);
            }
        }
        sort(left);
        sort(right);

        // merge
        Stack<Integer> tmp = new Stack<>();
        while (!right.isEmpty()) {
            tmp.push(right.pop());
        }
        tmp.push(pivot);
        while (!left.isEmpty()) {
            tmp.push(left.pop());
        }
        while (!tmp.isEmpty()) {
            s.push(tmp.pop());
        }
        return s;
    }
    public static void main(String[] args) {
        int[] data = {5, 2, 1, 9, 0, 10};
        Stack<Integer> myStack = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            myStack.push(data[i]);
        }
        System.out.println(sort(myStack));
    }
}
