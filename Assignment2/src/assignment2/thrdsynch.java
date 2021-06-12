package assignment2;
class x implements Runnable
{
    public void run()
    {
        for(int i = 1; i<=5;i++)
        {
            System.out.println("\tThread x : "+i);
        }
        System.out.println("End of ThreadN");
    }
}
 class thrdsynch
{
    public static void main(String args[])
    {
        x runnable = new x();
        Thread threadn = new Thread(runnable);
        threadn.start();
        System.out.println("End of main thread");
    }
}
