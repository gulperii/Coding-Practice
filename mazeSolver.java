public class work6 {

	public static void main(String[] args) {
		mazeSolver();
		System.out.println(GCD(6, 8));
		
		
	}
	

	public static void mazeSolver(){
		
		int[][] maze = {{0,0,0,0,1,0},
						{1,1,0,1,1,1},
						{0,1,0,0,0,1},
						{1,1,0,1,1,0},
						{1,0,0,0,0,2},
						{1,1,1,1,1,0}};
		
		int pos_x = 5;
		int pos_y = 5;
		
		if(solve(maze, pos_x, pos_y)){
			System.out.println("Found!");
		}
		else{
			System.out.println("Not found!");
		}
		
	}
	
	public static boolean solve(int[][] maze, int pos_x, int pos_y){
		
		if(pos_x < 0 || pos_x > 5 || pos_y < 0 || pos_y > 5
				|| maze[pos_x][pos_y] == 1){
			return false;
		}
		
		if(maze[pos_x][pos_y] == 2){
			return true;
		}
		
		maze[pos_x][pos_y] = 1;
		
		if(solve(maze, pos_x, pos_y + 1)){
			return true;
		}
		
		if(solve(maze, pos_x, pos_y - 1)){
			return true;
		}
		
		if(solve(maze, pos_x + 1, pos_y)){
			return true;
		}
		
		if(solve(maze, pos_x - 1, pos_y)){
			return true;
		}
		
		return false;
		
	}
	
	
	public static int GCD(int x ,int y)
	{   
	   if(y == 0) 
	     return x;
	   else
	     return GCD(y, x % y);
	}

}
