class Encryption
{
    public static void main ( String[] Argos )
    {
        String testWord = "ZONKER";
        int shift = 3;
        String encryptedWord = encrypt(testWord,shift);
        System.out.println(testWord + " with a shift of " + shift + "= " + encryptedWord);
        decrypt(encryptedWord);

    }

    public static String encrypt(String word, int shift)
    {
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = (char)((int)word.charAt(i) + shift);
            if (letter > 122 || (letter > 90 && letter < 97)) {
                letter -= 26;
            }
            newWord += letter;
        }
        return newWord;
    }

    public static void decrypt(String encryptedWord)
    {
        String word = encryptedWord;
        for (int i = 0; i < 26; i++) {
            String newWord = "";
            for (int j = 0; j < word.length(); j++) {
                char letter = (char) ((int) word.charAt(j) + 1);
                if (letter > 122 || (letter > 90 && letter < 97)) {
                    letter -= 26;
                }
                newWord += letter;
            }
            word = newWord;
            System.out.println(newWord);
        }

    }
}
