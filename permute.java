public class perma{
	public static void main(String[] args) {
		perma("abcd"," ");
	}
	
	public static void perm(String s) {
		perma(s,"");
		
	}
	public static void perma(String s, String chosen) {
		if(s.length()==0) {
			System.out.println(chosen);
			
		}
		else {
			String rest = "";
			for(int i=0;i<s.length();i++) {
				String ch=s.substring(i,i+1);
				
			    rest = s.substring(0,i)+s.substring(i+1);
				
				perma(rest,ch+chosen);
			}System.out.println(rest);
		}
	}
}
