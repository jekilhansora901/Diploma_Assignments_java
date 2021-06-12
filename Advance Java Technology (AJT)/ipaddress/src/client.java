import java.net.*;
import java.io.*;
public class client {
    public static void main(String [] arg)
    {
        try
        {
            Socket s = new Socket("localhost",777);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            System.out.println("Enter Stirng : ");
            str=br.readLine();
            OutputStream os = s.getOutputStream();
            PrintStream pr = new PrintStream(os);
            pr.println(str);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str2;
            while((str2 = br2.readLine())!=null)
            System.out.println("Server String : "+str2);
        }
        catch(IOException i)
        {
            System.out.println("Error : "+i.getMessage());
        }
    }
}
