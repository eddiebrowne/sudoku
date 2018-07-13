package Recursion;

public class Grid {

	
	int[][] grid = new int[9][9];
	
	
	public Grid(){		
	}
	
	public Grid(int[][] initial){		
		grid = DeepCopy(initial);
	}
		
	private int[][] DeepCopy(int[][] initial) {
		int[][] copy = new int[9][9];
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				copy[i][j] = initial[i][j];
			}	
		}
		
		return copy;
	}

	public int Value(int x, int y){
		//System.out.println(x +","+ y);
		return grid[x][y];
	}
	
	public Grid Set(int x, int y, int guess)
	{
		grid[x][y] = guess;
		return this;
	}
	
	public int[] DetermineOffsets(int x, int y){
		int[] offsets = new int[2];
		
		switch(Square(x, y))
		{
			case 1:
				offsets = new int[]{3,0};
				break;
			case 2:
				offsets = new int[]{6,0};
				break;
			case 3:
				offsets = new int[]{0,3};
				break;
			case 4:
				offsets = new int[]{3,3};
				break;
			case 5:
				offsets = new int[]{6,3};
				break;
			case 6:
				offsets = new int[]{0,6};
				break;
			case 7:
				offsets = new int[]{3,6};
				break;
			case 8:
				offsets = new int[]{6,6};
				break;			
		}
		
		return offsets;		
	}
	
	private int Square(int x, int y){
		int square;
		//System.out.println(x + "," + y);
		if(x < 3 && y < 3){
			square = 0;			
		}
		else if(x < 6 && x > 2 && y < 3){
			square = 1;
		}
		else if(x > 5 && y < 3){
			square = 2;			
		}
		else if(x < 3 && y > 2 && y < 6){
			square = 3;			
		}
		else if(x > 2 && x < 6 && y > 2 && y < 6){
			square = 4;
		}
		else if(x > 5 && y > 2 && y < 6){
			square = 5;			
		}
		else if(x < 3 && y > 5){
			square = 6;			
		}
		else if(x > 2 && x < 6 && y > 5){
			square = 7;
		}
		else{
			square = 8;			
		}
		return square;
	}
	
	public void Print(){
		int x = 0;
		int y = 0;
		String str = "";
		for(int i= 0; i < 81; i++){
			str += grid[x++][y] + " ";
			if(x > 8){
				y++;
				x = 0;
				str += "\n";
			}
			
		}
		System.out.println(str);
	}
	
}
