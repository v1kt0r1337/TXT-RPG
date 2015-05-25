package game;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This parser reads user input and tries to interpret it as an
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line first line as a command word. 
 * It returns the command as a list of Strings.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a not valid string.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.10
 */
public class CommandParser
{
    private Scanner reader;

    /**
     * Create a parser to read from the terminal window.
     */
    public CommandParser() 
    {
        reader = new Scanner(System.in);
    }

    /**
     * @return list of commands from the user.
     */
    public ArrayList<String> getCommand() 
    {
        String inputLine;   
        
        ArrayList<String> words = new ArrayList<String>();

        Scanner tokenizer = null;

        while (words.size() == 0) {
            System.out.print("> ");
            inputLine = reader.nextLine();
            tokenizer = new Scanner(inputLine);

            while (tokenizer.hasNext()) {
                words.add(tokenizer.next()); //.toLowerCase());
            }
        }
        return words;
    }
}
