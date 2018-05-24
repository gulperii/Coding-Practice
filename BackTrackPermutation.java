import java.util.Scanner;
public class backtrackPerm{
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("What do you want to permute? ");
		String s = console.next();
		permutation(s);
	}
	
	public static void permutation(String s) {
		permute(s,"");	
	}
	
	private static void permute(String s,String chosen) {
		if(s.length() == 0) {
			System.out.println(chosen);
		}
		else {
			for(int i=0;i<s.length();i++) {
				String ch = s.substring(i, i+1);
				String rest=s.substring(0,i)+s.substring(i+1);
				permute(rest,chosen+ch);
			}
		}
	}
}
