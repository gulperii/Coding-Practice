import java.util.Scanner;
public class work7{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String input = console.next();
		if(isPalindrome(input)) {
		System.out.println("Yes");
		
	}
		else {
			System.out.println("no");
	}}

public static boolean isPalindrome(String input) {
	for(int i=0; i< input.length()/2;i++) {
		if((input.charAt(i) )!=(input.charAt(input.length())-1-i)) {
			return false;
		}
	}
	return true;
}
}
