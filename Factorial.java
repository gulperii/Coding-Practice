public class factorial{
	public static void main(String[] args) {
		System.out.print(factorial(5));
		fact(5);
		
	}
	
	public static int factorial(int n) {
		if(n==0) {
			return 1;
		}
		return n*factorial(n-1);
	}


public static void fact(int n) {
	int a =1;
	for(int i=1;i<=n;i++) {
		a*=i;
	}
	System.out.println(a);
}}
