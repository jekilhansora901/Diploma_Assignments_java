import java.net.*;
import java.io.*;
public class server {
    public static void main(String [] arg)
    {
        try
        {
            ServerSocket ss= new ServerSocket(777);
            Socket s = ss.accept();
            System.out.println("Connection Established..");
            InputStream obj = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(obj));
            String str=br.readLine();
            System.out.println("Client String : "+str);
            String str2=str.toUpperCase();
            OutputStream os = s.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println(str2);
        }
        catch(IOException e)
        {
            System.out.println("Error : "+e.getMessage());
        }
    }
}
