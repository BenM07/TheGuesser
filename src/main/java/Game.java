import jv.ansi.Color;
import jv.sys.Program;

public class Game extends Program {
    
    private String[] typeList = {"animal", "thing", "food"};
    private String[] wordList = null;
    
    private String animal = "dog,cat,pig,bird,chicken";
    private String thing = "bag,pencil,pen,paper,ball,eyeglasses";
    private String food = "spaghetti,fried chicken,fried egg,chocolate,hamburger,potato chips";
    
    /* Get the type of the word */
    public String getTypeWord(String type) {
        
        
        String word = "";
        
        switch(type) {
            case "animal":
                wordList = animal.split(",");
                word = wordList[getRandom(0, wordList.length)];
            break;
            case "thing":
                wordList = thing.split(",");
                word = wordList[getRandom(0, wordList.length)];
            break;
            case "food":
                wordList = food.split(",");
                word = wordList[getRandom(0, wordList.length)];
            break;
        } // end switch
        
        
        return word;

    } // end getTypeWord() method
    
    /* Start the game */
    public void startGame() {
        
        clearTerminal();
        
        final var game = new Game();
        Player two, three;
        String playAgain;
        String startGame, userGuess;
        boolean isStartGame = false;
        String typeWord, targetWord, winner;
        
        
        String text = "Guess the word!\nThe type of the word you need to guess is ";
        
        int typeLength = typeList.length;
        final String[][] gameStart = {
            {" ##                  ##  #           #  "},
            {"#   # # ###  ##  ## #   ###  ## ### ### "},
            {"# # # # ##   #   #   #   #  # # #    #  "},
            {"# # ### ### ##  ##    #  ## ### #    ## "},
            {" ##                 ##                  "}
        };
        
        final String[][] line = {
            {"=".repeat(gameStart[0][0].length())}
        };
        
        typeWord = typeList[getRandom(0, typeLength)];
        targetWord = getTypeWord(typeWord);
        
        two = new Player();
        three = new Player();
        two.setGuess(wordList);
        three.setGuess(wordList);
        do {
            
            three.setGuess(wordList);
            
        } while(three.getGuess().equals(two.getGuess()));

        
        printOnTerminal(Color.BLUE, line);
        printOnTerminal(Color.GREEN, gameStart);
        printOnTerminal(Color.BLUE, line);
        
        printOnTerminal(Color.YELLOW, line);
        System.out.println(text + typeWord + "\nwith the first letter " + String.valueOf(targetWord.charAt(0)).toUpperCase());
        System.out.println("enter 'start-guess' to start guessing");
        printOnTerminal(Color.YELLOW, line);
        startGame = userInput("user-in: ");
        
        isStartGame = startGame.toLowerCase().equals("start-guess");
        if (isStartGame) {
            System.out.println(Color.RED + "Player two: " + two.getGuess() + Color.RESET);
            System.out.println(Color.BLUE + "Player three: " + three.getGuess() + Color.RESET);
            
            do {
                
                userGuess = userInput("enter your guess: ");
                
            } while(userGuess.equals(two.getGuess()) || userGuess.equals(three.getGuess()));
            
            boolean isPlayer2Right = two.getGuess().equals(targetWord);
            boolean isPlayer3Right = three.getGuess().equals(targetWord);
            boolean isUserRight = userGuess.toLowerCase().equals(targetWord);
            
            if (isUserRight) {
                winner = "You are the winner of today!";
            } else if (isPlayer2Right) {
                winner = "The winner of today is Player2";
            } else if (isPlayer3Right) {
                winner = "The winner of today is Player3";
            } else {
                winner = "no one is right!, try again!";
            } // end nested ifelse/elseif
                
                System.out.println("-------------");
                System.out.println(Color.GREEN + "The target word is " + targetWord + Color.RESET);
                System.out.println(Color.GREEN + winner + Color.RESET);
                playAgain = userInput(Color.BLUE + "enter y to try again and n to exit: " + Color.RESET);
                if (playAgain.toLowerCase().equals("y")) {
                    game.startGame();
                } else if (playAgain.toLowerCase().equals("n")) {
                    System.out.println("The Game is Over!");
                    return;
                } // end nested ifelse
        } // end if 
        
        
        

    } // end startGame() method
} // end class

