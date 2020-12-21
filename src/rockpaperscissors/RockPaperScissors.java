
package rockpaperscissors;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Shanell Spann
 * Course: IT-DEV 140  Programming with JAVA
 * Assignment 4
 * Date:  10/16/2020
 * Description: Create a program that allows a user to play Rock-Paper-Scissors with a computer as the 2nd player.  
 * Purpose: Practice using random numbers, booleans, if statements, and methods. 
 */
public class RockPaperScissors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean playAgain = true;
		
	while(playAgain){
            int randomNumber = getRandomNumber();	
            String computerChoice = computerChoice(randomNumber);
            String userChoice = userChoice();
            boolean win = isWin(computerChoice, userChoice);
            boolean lose = isLose(computerChoice, userChoice);
			
            if(win){
		JOptionPane.showMessageDialog(null, String.format("YOU WIN! Computer chose %s", computerChoice));
            }
            else if(lose){
		JOptionPane.showMessageDialog(null, String.format("YOU LOST! Computer chose %s", computerChoice));
            }
            else{
		JOptionPane.showMessageDialog(null, String.format("IT'S A TIE! Computer also chose %s", computerChoice));
            }
			
            playAgain = playAgain();
	}	
    }
	
	
    public static int getRandomNumber()
    {  // get a random # between 1-3
	Random number = new Random();	
	return number.nextInt(3);
    }
	
    public static String computerChoice(int number)
    {   // determine computer's choice
	if(number == 0){
            return "rock";
	}
	else if(number == 1){
            return "paper";
	}
	else{
            return "scissors";
	}
    }
	
    public static boolean playAgain()
    {	// determine if user wants to play again
	int n = JOptionPane.showConfirmDialog(null, "Wanna play again?", "Rock, Paper, Scissors Game", JOptionPane.YES_NO_OPTION);
		
	if(n == JOptionPane.YES_OPTION){
            return true;
	}else{
            return false;
	}	
    }
	
    public static String userChoice()
    {	// determine user choice
	String userChoice = "";
		
	while(!(userChoice.equalsIgnoreCase("rock")) && !(userChoice.equalsIgnoreCase("paper")) && !userChoice.equalsIgnoreCase("scissors"))
        {
            userChoice = JOptionPane.showInputDialog("Rock, Paper, or Scissors?");
			
            if(!(userChoice.equalsIgnoreCase("rock")) && !(userChoice.equalsIgnoreCase("paper")) && !userChoice.equalsIgnoreCase("scissors"))
            {
                JOptionPane.showMessageDialog(null, "Invalid input.");
            }
			
	}
		
	return userChoice;
    } 
	
    public static boolean isWin(String computerInput, String userInput)
    {	// user wins
	if(userInput.equalsIgnoreCase("rock")){
            if(computerInput.equalsIgnoreCase("scissors"))
            {
		return true;
            }
	}
	else if(userInput.equalsIgnoreCase("paper")){
            if(computerInput.equalsIgnoreCase("rock"))
            {
		return true;
            }	
	}
	else if(userInput.equalsIgnoreCase("scissors")){
            if(computerInput.equalsIgnoreCase("paper"))
            {
		return true;
            }	
	}
        
	return false;	
    }
	
    public static boolean isTie(String computerInput, String userInput)
    {	// game is a tie
	if(userInput.equalsIgnoreCase("rock"))
        {
            if(computerInput.equalsIgnoreCase("rock"))
            {
		return true;
            }
	}
	else if(userInput.equalsIgnoreCase("paper"))
        {
            if(computerInput.equalsIgnoreCase("paper"))
            {
		return true;
            }
			
	}
	else if(userInput.equalsIgnoreCase("scissors"))
        {
            if(computerInput.equalsIgnoreCase("scissors"))
            {
		return true;
            }		
	}
	return false;	
    }
	
    public static boolean isLose(String computerInput, String userInput)
    {	// determine if the user loses
	if(userInput.equalsIgnoreCase("rock"))
        {
            if(computerInput.equalsIgnoreCase("paper"))
            {
		return true;
            }
	}
	else if(userInput.equalsIgnoreCase("paper"))
        {
            if(computerInput.equalsIgnoreCase("scissors"))
            {
		return true;
            }
			
	}
	else if(userInput.equalsIgnoreCase("scissors"))
        {
            if(computerInput.equalsIgnoreCase("rock"))
            {
		return true;
            }
			
	}
	return false;	
    }
}

