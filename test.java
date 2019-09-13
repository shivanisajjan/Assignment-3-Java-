import java.util.*;
import java.io.*;
public class test{
    public static void s() throws IOException{
        String FileName="ipl.csv";
        BufferedReader Buff = new BufferedReader(new FileReader(FileName));
		String text = Buff.readLine();
        String name = text.getClass();
        System.out.println(name);
    }
    public static void main(String[] args) throws IOException{
        test.s();
    }
}