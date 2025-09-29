import java.io.*;

public class FileOpener {
    static int totalCount = 0;
    static int charCount = 0;
    static int[] charCountList = new int[26];

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/stuff.txt"));
            String str;

            while ((str = in.readLine()) != null) {
                totalCount += str.length();

                for (int i = 0; i < 26; i++) {
                    charCountList[i] += countChars(str, i + 97);

                }
            }
            System.out.println("Total characters: " + totalCount);
            for (int i = 0; i < charCountList.length; i++ ) {
                System.out.println((char)(i + 97) + ": " + Math.round((double)charCountList[i]/totalCount * 100) + "%");
            }
        } catch (IOException e) {
        }
    }

    public static int countChars(String str, int character) {
        int countChar = 0;

        for (int c = 0; c < str.length(); c++) {
            if (str.charAt(c) == character) {
                countChar++;
            }
        }
        return countChar;
    }
}
