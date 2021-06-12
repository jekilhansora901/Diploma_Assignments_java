import java.util.Scanner;

public class Sheldon_Cooper {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int array[] = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            array[i] = sc.nextInt();
        }
        if (Sheldon_Cooper.isSetSum(array, array.length, sc.nextInt())) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    static boolean isSetSum(int set[], int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }
        if (set[n - 1] > sum) {
            return isSetSum(set, n - 1, sum);
        }
        return isSetSum(set, n - 1, sum) || isSetSum(set, n - 1, sum - set[n - 1]);
    }

}
