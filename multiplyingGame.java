import java.util.Random;
import java.util.Scanner;
public class mult{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Random rand = new Random();
		quest(rand,console);
			
		}
	
	
	public static void quest(Random rand,Scanner console) {
		int a=rand.nextInt(20)+1;
		int b=rand.nextInt(20)+1;
		System.out.print(a+ " * "+ b + " = ");
		int guess = console.nextInt();
		int count = 0;
		int last = 0;
		
		while(guess == a*b) {
			last=a*b;
			count ++;
			System.out.println("correct");
			a=rand.nextInt(20)+1;
			b=rand.nextInt(20)+1;
			System.out.print(a+ " * "+ b + " = ");
			guess = console.nextInt();
			
		}
		System.out.println("İncorrect. The answer was: "+ a*b);
		if(last==0) {
		System.out.println(" You answered " + count);
		}
		else {
			System.out.println("Last correct answer you gave was "+last +" you answered " + count);
		}
		}
	}
