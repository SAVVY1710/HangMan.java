/*
Sai Avula
1.24.24
Hangman.java
Create A game of Hangman
*/
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Hangman
{
    Scanner input;
    PrintWriter pw;
    String newwd;

    public static void main(String[]args)
    {
        Hangman sai = new Hangman();
        sai.runner();
    }
    public void runner()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.print("Would you like to add to the dictionary, yes(1), no(2)? ");
        int ans = scan.nextInt();
        if(ans == 1)
        {
            System.out.print("What is your new word? ");
            String ans2 = scan.next();
            append(ans2);
        }
        int counter = 0;
        tryCatchIt();
        while(input.hasNext())
        {
            counter++;
            String temp = input.next();
        }
        input.close();
        String [] words = new String[counter];
        int num = (int)(Math.random() * counter)-1;
        counter = 0;
        tryCatchIt();
        while(input.hasNext())
        {
            counter++;
            words[counter-1] = input.next();
        }
        input.close();
        String wd = words[num];
        int numoflives = 5;
        newwd = "";
        wd = wd.toUpperCase();
        System.out.println("Here is your random word: \n");
        hang(wd);
        for(int i = 0; i < wd.length(); i++)
        {
            newwd += "-";
        }
        
    }
    public void tryCatchIt()
    {
        File inFile = new File ("dictionary.txt");
        String inFileName = "dictionary.txt";
        //value = "";
        input = null;
        try
        {
            input = new Scanner ( inFile );
        }
        catch ( FileNotFoundException e )
        {
            System.err.println("Cannot find " + inFileName + " file.");
            System.exit(1);
        }
    }
    public void append(String wd)
    {
        pw = null;
        File outFile = new File("dictionary.txt");
        try
        {
            pw = new PrintWriter( new FileWriter(outFile, true) );
        }
        catch (IOException e)
        {
            System.err.println("Cannot append to " +  " dictionary.txt");
            System.exit(1);
        }
        pw.println(wd);
        pw.close();
    }
    public void hang(String wd)
    {
        for(int i = 0; i < wd.length(); i++)
        {
            System.out.print("-");
        }
        System.out.println("\n");
    }
    public void man(int index, String wd, String let)
    {
        String temp = newwd;
        newwd = "";
        for(int i = 0; i < wd.length(); i++)
        {
            if(index == i)
            {
                newwd += let;
            }
            else newwd += temp.charAt(i);
        }
    }
}