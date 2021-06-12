import java.util.*;
import java.text.*;
import java.io.*;
public class date_time {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        DateFormat dateformate = new SimpleDateFormat("dd/mm/yyyy HH:MM:SS");
        Date date = new Date();
        System.out.println(dateformate.format(date));
    }
}
