import java.util.*;
public class rec{
	public static void main(String[] args) {
		System.out.println(digitMatch(10,10));
		int[] numbers = {1,8,3,4,9,0,11};
		System.out.println(Arrays.toString(bubblesort(numbers)));
	}
	public static int digitMatch(int a, int b){
	    if(a<0 || b<0){
	        throw new IllegalArgumentException();
	    }
	    else{
	        if(a==0&&b==0){
	            return 1;
	        }
	        else{
	            int result = 0;
	            if(a%10==b%10){
	                result ++;
	            }
	            if(a/10==0 || b/10==0){
	                return result;
	            }
	            return result + digitMatch(a/10,b/10);
	            
	}
	    }}
	public static int[] bubblesort(int[] numbers) {
	   // boolean swapped = true;
	    for(int i = numbers.length - 1; i > 0 ; i--) {
	       // swapped = false;
	        for (int j = 0; j < i; j++) {
	            if (numbers[j] > numbers[j+1]) {
	                int temp = numbers[j];
	                numbers[j] = numbers[j+1];
	                numbers[j+1] = temp;
	               // swapped = true;
	            }
	        }
	    }
	    return numbers;
	}
	public static int[] bubble(int[] arr) {
		int temp;
		for(int i=arr.length-1; i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}}}
		return arr;
				}
			}
		}
		
		public static String longer(Scanner console) {
			String longest="";
			String word="";
			while(!word.equals("goodbye")) {
				if(word.length()>longest.length()) {
					longest = word;
				}
				System.out.println("enter word");
				word=console.next();
				}
			return longest;
				 }
		public static int sum(Scanner cosnoel) {
			
	}

}
