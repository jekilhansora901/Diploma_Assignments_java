import java.io.*;
import java.net.*;
public class Ipaddress {
    public static void main(String[] args) {
        try
        {
            String site;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a Web Site Name : ");
            site = br.readLine();  
            InetAddress ip = InetAddress.getByName(site);
            System.out.println("The IP Address is : "+ ip);
        }
        catch(IOException e)
        {
            System.out.println("Website not found..");
        }
    }
}
