import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class hangman_1{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		String word = getWord();
		String dashed = initial(word);
		String pdashed= dashed;
		int lives = 8;
		System.out.println("Welcome to The Hangman");
		System.out.println("You have 8 lives left.");
		while(lives>=0 && !found(dashed)) {
			System.out.println("Now your word looks like this: "+ dashed);
			System.out.print("Your guess: ");
			String guess = console.nextLine().toUpperCase();
			while(!guessCheck(guess)) {
				System.out.print("Your new guess: ");
				guess = console.nextLine().toUpperCase();
			}
			dashed = wordCheck(guess,word,dashed);
			if(!lifeCheck(dashed,pdashed,guess)) {
				lives --;
			}
			System.out.println("You have "+ lives + " lives left." );
			pdashed = dashed;
		}
		if(lives<0)
			System.out.println("You have lost!");
		else {
			System.out.println("Now your word looks like this: "+word);
			System.out.println("Congratulations! You have won.");
		}


	}
	public static boolean found(String dashed) {
		if(-1==dashed.indexOf("-")) {
			return true;
		}else {
			return false;
		}
	}

	public static Boolean guessCheck(String guess) {
		if(guess.length()>1) {
			System.out.println("You should enter one letter!");
			return false;
		}else if(!(guess.charAt(0)>=65 && guess.charAt(0)<=95)){
			System.out.println("You can't enter numbers or symbols");
			return false;

		}else {
			return true;
		}
	}

	public static Boolean lifeCheck(String dashed, String pdashed, String guess) {
		if(dashed.indexOf(guess)==-1) {
			return false;
		}else {
			return !(dashed.equals(pdashed));
		}
	}

	public static String wordCheck(String guess, String word, String dashed) {

		if(word.indexOf(guess)==-1) {
			System.out.println("There are no "+ guess + "'s in the word");
			return dashed;
		}
		else {
			if(word.charAt(word.length()-1)==(guess.charAt(0))) {
				word=word.substring(0,word.length()-1);
				
			}
			String temp=word ;
			while(temp.indexOf(guess)!=-1) {
				int l = word.length();
				int a = temp.indexOf(guess) + l-temp.length() ;
				dashed = dashed.substring(0,a)+guess + dashed.substring(a+1);
				temp= temp.substring(a+1);
			}
		}
		System.out.println("Good guess!");
		return dashed+guess; 
	}



	public static String initial(String str) {
		int len = str.length();
		String w1="";
		int length = str.length();
		for(int a=1;a<=length;a++) {
			w1 += "-";}	
		return w1;
	}



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
