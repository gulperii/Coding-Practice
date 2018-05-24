import java.util.Scanner;

public class quiz{
	public static void main(String[] args) {
		 
	Scanner console= new Scanner(System.in);
    String kelime = console.nextLine();
	String harf = console.nextLine();
	int sayı = console.nextInt();
	
	for(int i =0; i <= (kelime.length())-1;i++) {
		if(((kelime.substring(i,i+1)).equals(harf))){
			for(int a=1; a<=sayı-1; a++) {
				System.out.print(kelime.substring(i,i+1));
			}
		}
		System.out.print(kelime.substring(i,i+1));
	}
		
	
	}
}
	
