
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jekil
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    Client()
    {
        try
        {
        // TODO code application logic here
            Socket s = new Socket("localhost",777);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        while(true)
        {
            String str2;
            while((str2 = br2.readLine())!=null)
                System.out.println("Order : "+str2);
        }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
            new Client();
        }
    
}
