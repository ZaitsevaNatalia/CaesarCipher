import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zajan on 26.01.2017.
 */
public class WordPlay
{

    public static void main(String[] args) throws Exception
    {
        //testIsVowel();
        testReplaceVowels();
        //testEmphasize();
    }

    public static boolean isVowel(String ch)
    {
        String vowelLetters = "aeiou";

        int length = vowelLetters.length();
        boolean result = false;
        for (int i = 0; i < length; i++)
        {
            String letter = vowelLetters.substring(i, i+1);
            if (ch.toLowerCase().equals(letter))
            {
                result = true;
                break;
            }

            else
                result = false;
        }
        return result;
    }

    public static void testIsVowel() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String letter = reader.readLine();

        System.out.print(isVowel(letter));
    }

    public static String replaceVowels(String phrase, char ch)
    {
        String newPhrase = "";

        int length = phrase.length();
        for (int i = 0; i < length; i ++)
        {
            String letter = phrase.substring(i, i+1);
            boolean isVowel = isVowel(letter);
            newPhrase = isVowel ? newPhrase + ch : newPhrase + letter;
        }

        return newPhrase;
    }

    public static void testReplaceVowels() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String phrase = reader.readLine();
        String letter = reader.readLine();
        char ch = letter.charAt(0);

        System.out.print(replaceVowels(phrase, ch));
    }

    public static String emphasize(String phrase, char ch)
    {
        int length = phrase.length();
        String newPhrase = "";
        for (int i = 0; i < length; i ++)
        {
            String letter = phrase.substring(i, i + 1);
            String chString = Character.toString(ch);
            if (i%2 == 0)
                newPhrase = letter.toLowerCase().equals(chString.toLowerCase()) ? newPhrase + '*' : newPhrase + letter;
            else
                newPhrase = letter.toLowerCase().equals(chString.toLowerCase())? newPhrase + '+' : newPhrase + letter;
        }

        return newPhrase;
    }

    public static void testEmphasize() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String phrase = reader.readLine();
        String letter = reader.readLine();
        char ch = letter.charAt(0);
        System.out.print(emphasize(phrase, ch));
    }
}
