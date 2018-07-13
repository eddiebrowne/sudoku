package Recursion;

import java.util.Random;


public class Game {
	Grid _grid;
	
	private Random random = new Random();
	
	static int guesses;	
	int [][] solution = new int[9][9];
	
	public Game(Grid grid){
		_grid = grid;
		guesses = 0;
	}
	
	public Grid SolveRandomGuess()
	{
		return IsSolvedRandomGuess(_grid, random.nextInt(9)+1, random.nextInt(9)+1) ? _grid : null;
	}
	
	
	public Grid SolveRandomPlacement()
	{
		return IsSolvedRandomPlacement(_grid, random.nextInt(9)+1, random.nextInt(9)+1) ? _grid : null;
	}
	
	public Grid Solve(){
		return IsSolved(_grid, 0, 0) ? _grid : null;
	}
	
	public boolean IsSolved(Grid grid, int x, int y){
		if(x == 9){
			System.out.println(guesses);
			guesses = 0;
			solution = grid.grid;
			return true;
		}
		
		int newX = 0;
		int newY = 0;
		
		if(y == 8){
			newY = 0;
			newX = x + 1;			
		}
		else{
			newY = y + 1;
			newX = x;
		}
		
		if(grid.Value(x, y) != 0){
			return IsSolved(grid, newX, newY);	
		}
				
		for(int guess = 1; guess < 10; guess++){
			if(IsValid(grid, x, y, guess)){
				grid.Set(x, y, guess);
				++guesses;
				if(IsSolved(grid, newX, newY)){
					return true;
				}
			}
		}

		grid.Set(x, y, 0); // reset the guess
		return false;
	}

	public boolean IsSolvedRandomGuess(Grid grid, int x, int y)
	{
		if(x == 9){
			System.out.println(guesses);
			guesses = 0;
			solution = grid.grid;
			return true;
		}

		int newX = 0;
		int newY = 0;
		
		if(y == 8){
			newY = 0;
			newX = x + 1;			
		}
		else{
			newY = y + 1;
			newX = x;
		}
		
		if(newX > 8 || newY> 8 || x > 9 || y > 8){
			System.out.println("newX: " + newX + " newY: " + newY + " x: " + x + " y: " + y);
		}
		
		if(grid.Value(x, y) != 0){
			return IsSolvedRandomGuess(grid, newX, newY);
		}
		
		int guess = random.nextInt(9);				
		while(!IsValid(grid, x, y, guess)){			
			if(IsValid(grid, x, y, guess)){
				grid.Set(x, y, guess);
				++guesses;
				if(IsSolvedRandomGuess(grid, newX, newY)){
					return true;
				}
			}
			guess = random.nextInt(9);
		}
		grid.Set(x, y, 0); // reset the guess
		return false;
	}
	
	public boolean IsSolvedRandomPlacement(Grid grid, int x, int y)
	{
		if(IsComplete(grid)){
			System.out.println(guesses);
			guesses = 0;
			solution = grid.grid;
			return true;
		}

		int newX = random.nextInt(9);
		int newY = random.nextInt(9);
	
		if(newX > 8 || newY> 8 || x > 9 || y > 8){
			System.out.println("newX: " + newX + " newY: " + newY + " x: " + x + " y: " + y);
			newX = random.nextInt(9);
			newY = random.nextInt(9);
		}
		
		if(grid.Value(x, y) != 0){
			return IsSolvedRandomPlacement(grid, newX, newY);
		}
		
		for(int guess = 1; guess < 10; guess++){
			if(IsValid(grid, x, y, guess)){
				grid.Set(x, y, guess);
				++guesses;
				if(IsSolvedRandomPlacement(grid, newX, newY)){
					return true;
				}
			}
		}

		grid.Set(x, y, 0); // reset the guess
		return false;
	}
		
	private boolean IsComplete(Grid grid) {
		
		boolean isComplete = true;
		
		for(int i = 0; i < 9 && isComplete; i++){
			for(int j = 0; j < 9 && isComplete; j++){
				isComplete = grid.Value(i, j) > 0;				
			}	
		}
		
		return isComplete;
		
	}

	public boolean IsValid(Grid grid, int x, int y, int guess){
		return IsRowValid(grid, x, y, guess) && IsColumnValid(grid, x, y, guess) && IsBoxValid(grid, x, y, guess);
	}	
	
	public boolean IsRowValid(Grid grid, int x, int y, int guess){
		boolean isValid = true;
		
		for(int i = 0; i < 9 && isValid; i++){
			int value = grid.Value(i,y);
			if(value == guess){
				isValid = false;
			}
		}
		
		return isValid;
	}
	
	public boolean IsColumnValid(Grid grid, int x, int y, int guess){
		boolean isValid = true;
		
		for(int i = 0; i < 9 && isValid; i++){
			int value = grid.Value(x,i);
			if(value == guess){
				isValid = false;
			}			
		}	

		return isValid;
	}
	
	public boolean IsBoxValid(Grid grid, int x, int y, int guess){
		boolean isValid = true;	
		
		int[] offsets = grid.DetermineOffsets(x, y);
		for(int i = 0; i < 3 && isValid; i++){
			for(int j = 0; j < 3 && isValid; j++){
				int xOffset = offsets[0] + i;
				int yOffset = offsets[1] + j;
				int value = grid.Value(xOffset,yOffset);
				if(value == guess){
					isValid = false;
				}
			}
		}
		return isValid;
	}
	
	
}
