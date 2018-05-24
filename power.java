import java.util.Scanner;
public class work3{
	public static void main(String[] args) {
		Scanner con = new Scanner(System.in);
		int n = con.nextInt();
		int a =con.nextInt();
		int sum = 0;
		for(int i = 1; i<=a;i++) {
			sum +=power(n,i);
			if(i==a) {
				System.out.print(power(n,i) + "=" + sum);
			}
			else {
				System.out.print(power(n,i) + "+");
			}
		}
		
		
		
		}
	
	public static int power(int n, int a) {
		if(a==0) {
			return 1;
		}
		return n*power(n,a-1);
	}
	
	public static int betterPower(int n, int a){
		
		if(a == 0){
			return 1;
		}
		
		if(a % 2 == 0){
			int m = betterPower(n, a / 2);
			return m * m;
		}
		else{
			return n * betterPower(n, a - 1);
		}
		
	}
}
