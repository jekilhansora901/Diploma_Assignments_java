package assignment2;
import java.io.*;
class BRRead {
public static void main(String args[])
throws IOException
{
char c;
BufferedReader br = new
BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter characters, 'e' to Stop Run..");
// read characters
do {
c = (char) br.read();
System.out.println(c);
} while(c != 'e');
}
}