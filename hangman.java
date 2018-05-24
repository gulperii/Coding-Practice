import java.util.*;
import java.io.*;

public class hangman1{
	public static void main(String[] args)  throws FileNotFoundException{
		System.out.println("Welcome to the Hangman."); 
		int lives =8;
		String word = getWord();
		String dashed = slashed(word);
        System.out.println("Your word is " + dashed);
		
        while(lives !=0&&!(found(dashed))) {
        	Scanner console = new Scanner(System.in);
        	System.out.print("Your guess: ");
        	String guess = console.nextLine();
        	while(!(guess.toUpperCase().charAt(0)>=65 && guess.toUpperCase().charAt(0)<=95)) {
        		System.out.print("Invalid input, try again: ");
        		guess = console.next();
        	}
        	guess = guess.toUpperCase();
        	
			lives=game(lives,word,dashed,guess);
			if(guessCheck(word,guess)) {
			dashed=changeIndex(word,dashed,guess);
			}
//			dashed=play1(word,dashed,lives);
//			lives=lives -1;
		}  
	}

	public static String slashed(String str) {
		int len = str.length();
		String w1="";
		int length = str.length();
		for(int a=1;a<=length;a++) {
			w1 += "-";}	
		return w1;
	}
public static int game(int lives,String word,String dashed,String guess) {
//	System.out.println("You have "+lives +" guesses left.");
//	Scanner console = new Scanner(System.in);
//	System.out.print("Your guess: ");
//	String guess = console.nextLine();
//	while(!(guess.toUpperCase().charAt(0)>=65 && guess.toUpperCase().charAt(0)<=95)) {
//		System.out.print("Invalid input, try again: ");
//		guess = console.next();
//	}
//	guess = guess.toUpperCase();
	if(guessCheck(word,guess)) {
		System.out.println("Now your word looks like this: "+changeIndex(word,dashed,guess));
		
		return lives;
	}else {
		System.out.println("Wrong guess.");
		lives--;
		return lives;
	}
	
}
	public static boolean found(String dashed) {
		if(-1==dashed.indexOf("-")) {
			System.out.println("Congratulations!");
			return true;
		}else {
			return false;
		}
	}
	public static Boolean guessCheck(String word, String guess) {
		if(word.indexOf(guess)==-1) {
			System.out.println("There are no " + guess + "'s in the word."); 
			return false;
		}else {
			System.out.println("Good guess");
			return true;
			
		}
	}
//	public static String slashy (String word,String dashed, String g,int l) {
//		if(word.indexOf(g)==-1) {
//			System.out.println("There are no " + g + "'s in the word."); 
//			System.out.println("You have "+ (l-1) + " lives left");
//			return dashed;
//		}else {
//			System.out.println("Good guess");
//
//			System.out.println("The word looks like this: "+ changeIndex(word,dashed,g));
//
//			return changeIndex(word,dashed,g);
//		}
//
//	}

	public static String changeIndex(String word,String dashed,String g) {
		int a = word.indexOf(g);
		return dashed.substring(0,a)+g + dashed.substring(a+1);
	}


//	public static String play1(String word,String dashed, int lives) throws FileNotFoundException {
//
//		Scanner console = new Scanner(System.in);
//		System.out.print("Your guess: ");
//		String guess = console.nextLine();
//		while(!(guess.toUpperCase().charAt(0)>=65 && guess.toUpperCase().charAt(0)<=95)) {
//			System.out.print("Invalid input, try again: ");
//			guess = console.next();
//		}
//		guess = guess.toUpperCase();
//
//		dashed=slashy(word,dashed,guess,lives);
//		return dashed;
//	}

	public static String getWord() throws FileNotFoundException {
		Scanner file = new Scanner(new File("word.txt"));	
		Random rand = new Random();
		int countLine = 0;

		while(file.hasNextLine()) {
			file.nextLine();
			countLine++;
		}

		file.close();

		Scanner file2 = new Scanner(new File("word.txt"));	
		int a = rand.nextInt(countLine);
		for(int b = 1; b<=a; b++) {
			file2.nextLine();
		}
		String word=file2.nextLine();
		return word;

	}
}
