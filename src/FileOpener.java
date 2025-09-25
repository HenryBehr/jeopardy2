
import java.io.*;

public class FileOpener {
    public static void main(String[] args)
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("stuff.txt"));
            String str;

            while ((str = in.readLine()) != null)
            {
                System.out.println(str);
            }

        }
        catch (IOException e) {
        }
    }
}
