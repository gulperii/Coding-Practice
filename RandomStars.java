import java.util.Random;

public class RandomStarts {

	public static void main(String[] args) throws InterruptedException {
		
		Random rand = new Random();
		
		int starsInaRow = 3;
		for(int i=1;i<=2000;i++){
			for(int j =1; j<=starsInaRow;j++ ){
				randomSpace(rand);
				System.out.print("*");
			}
			System.out.println();
			Thread.sleep(70);
		}
	}

	public static void randomSpace(Random rand) {
		for(int i=1;i<=rand.nextInt(2000);i++){
			System.out.print(" ");
		}
		
	}
	
	
}
