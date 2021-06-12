import java.util.Scanner;
public class Milk_Man_and_His_Bottles {
    public static void main(String[] args) {
        
          int arr[] = {1,5,7,10};
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          for(int i=1;i<=n;i++)
          { 
            System.out.println(Milk_Man_and_His_Bottles.coinChange(arr, sc.nextInt()));
          }
    }
    public static int coinChange(int[] tmparr, int amt)
    {
        int n = tmparr.length;
        int[] count = new int[amt + 1];
        int[] from = new int[amt + 1];

        count[0] = 1;
        for (int i = 0 ; i < amt; i++)
            if (count[i] > 0)
                for (int j = 0; j < n; j++)
                {
                    int p = i + tmparr[j];
                    if (p <= amt)
                    {
                        if (count[p] == 0 || count[p] > count[i] + 1)
                        {
                            count[p] = count[i] + 1;
                            from[p] = j;
                        }
                    }
                }

        if (count[amt] == 0)
            return 0;

        int[] result = new int[count[amt] - 1];
        int k = amt;
        while (k > 0)
        {
            result[count[k] - 2] = tmparr[from[k]];
            k = k - tmparr[from[k]];
        }

        return result.length;
    }
}
