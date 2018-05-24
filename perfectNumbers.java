import java.util.Scanner;
public class perfect{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int a = console.nextInt();
		perfect(a);
		
		}
		

	
	public static int sum(int a) {
		int sum=0;
	
		for(int i=1;i<=a-1;i++) {
			if(a%i==0) {
			sum +=i;
		}
		}
      if (sum==a) {
    	  return 1;
      }
      return 0;
		}
	
	public static void perfect(int a) {
		
		for(int i= 1;i<=a;i++) {
		if (sum(i)== 1) {
			
			System.out.print(i + " ");
		}
		
	

	}
}
}
