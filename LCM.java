import java.util.Scanner;
public class quiz2{
	public static void main(String[] args) {
		Scanner console= new Scanner(System.in);
		int m = console.nextInt();
		int n = console.nextInt();
		System.out.print(lcm(m,n));
	}
	

public static int lcm(int a, int b) {
	for(int i=Math.min(a,b); i<= a*b; i++) {
		
		if(i%a==0 && i%b== 0) {
			return i;
		}
		
	}
	return a*b;
}
}
