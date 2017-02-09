import java.io.*;

public class CaesarCipher
{
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static int key1 = 23;
    public static int key2 = 17;
    public static  String input = "First Legion";

    public static void main(String[] args) throws Exception
    {
        //String string = encrypt("First Legion", 17);
        String string = encryptTwoKeys(input, key1, key2);
        printString(string);
        //testCaesar();


    }

    public static String encrypt(String input, int key)
    {
        String answer = "";

        String shiftedAlphabet = shiftAlphabet(key);
        for (int i = 0; i < input.length(); i++)
        {
            String letter = input.substring(i, i+1);
            int indexOfAlphabet = alphabet.indexOf(letter.toUpperCase());
            String encryptedLetter = searchEncryptedLetter(indexOfAlphabet, letter, shiftedAlphabet);
            answer = answer + encryptedLetter;

        }

        return answer;
    }

    public static String shiftAlphabet(int key)
    {
        String answer = "";

        for (int i = 0; i < alphabet.length(); i++)
        {
            int length = alphabet.length();

            if (i + key < length)
                answer = answer + alphabet.charAt(i + key);
            else
                answer = answer + alphabet.charAt(i + key - length);
        }

        return answer;
    }

    public static String searchEncryptedLetter(int index, String letter, String alphabet)
    {
        String alphabetToLowerCase = doToLowerCase(alphabet);

        if (alphabet.contains(letter))
            return alphabet.substring(index, index + 1);
        else if (alphabetToLowerCase.contains(letter))
            return alphabetToLowerCase.substring(index, index + 1);
        else
            return letter;
    }

    public static String doToLowerCase(String alphabet)
    {
        String answer = "";
        for (int i = 0; i < alphabet.length(); i++ )
        {
            answer = answer + alphabet.substring(i, i + 1).toLowerCase();
        }

        return answer;
    }


    public static void printString(String phrase)
    {
        System.out.println(phrase);
    }

    public static void testCaesar()
    {
        String phrase = readFromFile();
        String ecrypted = encrypt(phrase, key1);
        System.out.println("key is " + key1 + "\n" + ecrypted);
    }

    public static String readFromFile()
    {
        String answer = "";

        try(FileReader reader = new FileReader("message1.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                answer = answer + ((char)c);
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        return answer;
    }

    public static String encryptTwoKeys(String input, int key1, int key2)
    {
        String answer = "";

        String shiftedAlphabet1 = shiftAlphabet(key1);
        String shiftedAlphabet2 = shiftAlphabet(key2);

        for (int i = 0; i < input.length(); i++)
        {
            String letter = input.substring(i, i+1);
            int indexOfAlphabet = alphabet.indexOf(letter.toUpperCase());
            if (i%2 != 0)
            {
                String encryptedLetter = searchEncryptedLetter(indexOfAlphabet, letter, shiftedAlphabet2);
                answer = answer + encryptedLetter;
            }
            else
            {
                String encryptedLetter = searchEncryptedLetter(indexOfAlphabet, letter, shiftedAlphabet1);
                answer = answer + encryptedLetter;
            }
        }

        return answer;
    }
}
