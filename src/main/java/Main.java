import jv.ansi.Color;
import jv.sys.Program;

public class Main extends Program {
    
    public static void main(String[] args) {
        
        final var game = new Game();
        
        String input;
        boolean startGame;
        final String[][] title = {
            {"### #        ##                        "}, 
            {" #  ### ### #   # # ###  ##  ## ### ###"},
            {" #  # # ##  # # # # ##   #   #  ##  #  "},
            {" #  # # ### # # ### ### ##  ##  ### #  "},
            {" #           ##                        "},
            {"              MASTER                   "},
        };
        
        final String[][] line = {
            {"=".repeat(title[0][0].length())}
        };
        
        clearTerminal();
        printOnTerminal(Color.BLUE, line);
        printOnTerminal(Color.GREEN, title);
        printOnTerminal(Color.BLUE, line);
        System.out.println("enter 'start-game' to play it");
        input = userInput("user-in: ");
        
        startGame = input.toLowerCase().equals("start-game");
        
        if (startGame) {
            game.startGame();
        } else {
            System.out.println("No game start");
            return;
        }
        
        
    } // end main() method
} // end class

