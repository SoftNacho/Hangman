import java.util.*;

public class HangmanGame {
	
	private Scanner keyboard = new Scanner(System.in);
	private String [] words = new String [5];
	private String response;
	char anotherGame;
	
	public HangmanGame(){
		words[0] = "crabs";
		words[1] = "gator";
		words[2] = "plaid";
		words[3] = "purse";
		words[4] = "crown";
		
	}//end constructor
	
	
	private String initGame(String [] words){
		
		int index = (int)(Math.random()*words.length);
		String hiddenWord = words[index];
		return hiddenWord;
		
	}//end initGame
	
	
	public void playGame(){
		System.out.println("Hangman by Lisa Gentil");
		
		do{
			System.out.print("Do you want to play Hangman? (y or n) ");
			response = keyboard.nextLine();
			
		}//end do
		
		while(!((response.equalsIgnoreCase("y")) || (response.equalsIgnoreCase("n"))));
		
		while(response.equalsIgnoreCase("y")){
			String hiddenWord = initGame(words);
			StringBuilder guessedWord = new StringBuilder();
			do{
				for (int i = 0; i < hiddenWord.length(); i++)
			        guessedWord.append('*');
			      int numberOfCorrectLettersGuessed = 0, numberOfMisses = 0;
			      
			      while (numberOfCorrectLettersGuessed < hiddenWord.length()) {
			        System.out.print("(Guess) Enter a letter in word " + guessedWord
			            + " > ");
			        String s = keyboard.nextLine();
			        char letter = s.charAt(0);
			        
			        if (guessedWord.indexOf(letter + "") >= 0) {
			          System.out.println("\t" + letter + " is already in the word");
			        }//end if
			        
			        else if (hiddenWord.indexOf(letter) < 0) {
			          System.out.println("\t" + letter + " is not in the word");
			          numberOfMisses++;
			        }//end else if
			        
			        else {
			          int k = hiddenWord.indexOf(letter);
			          while (k >= 0) {
			            guessedWord.setCharAt(k, letter);
			            numberOfCorrectLettersGuessed++;
			            k = hiddenWord.indexOf(letter, k + 1);  
			            }//end while  
			          }//end else  
			        }//end while
			      System.out.println("The word is " + hiddenWord + ". You missed "
			          + numberOfMisses + ((numberOfMisses <= 1) ? " time" : " times"));
			
			 System.out.print("Do you want to guess for another word? Enter y or n> ");
		      anotherGame = keyboard.nextLine().charAt(0);
		    }//end do
			while (anotherGame == 'y'); 
			}//end while
		
		System.out.print("Hangman ends.");
		}//end playGame
	
		
	}//end Hangman

