import jv.sys.Program;

public class Player extends Program {
    
    private String guess;
    
    /* Set a guess */
    public void setGuess(String[] randGuess) {
        guess = randGuess[getRandom(0, randGuess.length)];
    } // end setGuess() method
    
    /* Get the guess */
    public String getGuess() {
        return guess;
    } // end getGuess() method
} // end class

