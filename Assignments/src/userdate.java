import java.util.Date;
import java.io.*;
public class userdate {
    public static void main(String[] args) {
        int year;
        Date dt = new Date();
        System.out.println("Enter The Year : ");
        year = dt.getYear();
        System.out.println(year);
    }
}
