import java.util.Scanner;
public class Milk_Man_and_His_Bottles {
    public static void main(String[] args) {
        
          Scanner sc=new Scanner(System.in);
          int array[] = {1,5,7,10};
          int n=sc.nextInt();
          for(int i=1;i<=n;i++)
          { 
            System.out.println(Milk_Man_and_His_Bottles.coinChange(array, sc.nextInt()));
          }
    }
    public static int coinChange(int[] tmparr, int amt)
    {
        int n = tmparr.length;
        int[] count = new int[amt + 1];		// count[i] stores minimum no of coins required to make value "i"
        //int[] from = new int[amt + 1];		// from[i] stores maximum denomination used to make value "i"

        count[0] = 1;		// coz it will take minimum 1 coin to make value "1" using maximum denomination tmparr[0] i.e. 1 here 
        for (int i = 0 ; i < amt; i++)		// i stores value
		{
            //if (count[i] > 0)
                for (int j = 0; j < n; j++)
                {
                    int p = i + tmparr[j];	// p = current minimum no coins to make i + newly available denomination i.e. tmparr[j] so no of coins increase // by 1
                    if (p <= amt)
                    {
                        if (count[p] == 0 || count[p] > count[i] + 1) //min coins to make p == 0 or it is > min coins for i + 1(new denomination) then go inside
                        {
                            count[p] = count[i] + 1;
							//from[p] = j;
                        }
                    }
                }
		}
		
				if (count[amt] == 0)
					return 0;

				/*int[] result = new int[count[amt] - 1];
				int k = amt;
			/*while (k > 0)
			{
				result[count[k] - 2] = tmparr[from[k]];
				k = k - tmparr[from[k]];
			}*/

		return (count[amt]-1);
    }
}
