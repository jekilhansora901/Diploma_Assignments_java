import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Hotel_Trip {

    private static Stack<Integer> stack = new Stack<Integer>();

    private static int sumStack = 0;
    private static boolean flag = false;
    static String tmps = new String();

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            int i = 0;
            StringTokenizer strToken = new StringTokenizer(input, " ");
            int data[] = new int[strToken.countTokens()];
            while (strToken.hasMoreElements()) {
                data[i] = Integer.parseInt((String) strToken.nextElement());
                i++;
            }
            int sum = sc.nextInt();
            populateSubset(data, 0, data.length, sum);
        } catch (Exception e) {

        }
    }

    public static void populateSubset(int[] data, int fromIndex, int endIndex, int sum) {

        if (sumStack == sum) {   
            print(sort(stack));
        }

        for (int cIndex = fromIndex; cIndex < endIndex; cIndex++) {

            if (sumStack + data[cIndex] <= sum) {
                stack.push(data[cIndex]);
                sumStack += data[cIndex];

                populateSubset(data, cIndex + 1, endIndex, sum);
                sumStack -= (Integer) stack.pop();
            }
        }
    }
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
            if (y > pivot) {
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

    private static void print(Stack<Integer> stack) {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer i : stack) {
            sb.append(i).append(",");
        }
        sb = sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        if (!(tmps.equals(sb.toString()))) {
            System.out.println(sb.toString());
            tmps = sb.toString();
        }
    }

}
