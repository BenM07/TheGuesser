package jv.sys;

import jv.ansi.Color;

// java | io package
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// java | util package
import java.util.Random;

public abstract class Program {
    
    private static Random rand = new Random();
    
    /* Get Random Value */
    public static int getRandom(int min, int max) {
        return rand.nextInt(max) + min;
    } // end getRandom() method
    
    /* User Input */
    public static String userInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt);
        
        BufferedReader br;
        InputStreamReader stream;
        
        try {
            stream = new InputStreamReader(System.in);
            br = new BufferedReader(stream);
            inputLine = br.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException " + e);
        } // end try/catch
        
        return inputLine;
        
    } // end userInput() method
    
    /* Clear The Terminal */
    public static void clearTerminal() {
        String escape = "\033[H\033[2J";
        System.out.print(escape);
        System.out.flush();
    } // end clearTerminal() method
    
    /* Print On Terminal */
    public static void printOnTerminal(String color, String[][] ascii) {
        
        String format, output = "";
        for (String[] asc : ascii) {
            for (String a : asc) {
                format = color.concat(a) + Color.RESET;
                output += format;
            } // end nested for loop
            output += "\n";
        } // end for loop
        
        System.out.println(output);
        
    } // end printOnTerminal() method
} // end class
