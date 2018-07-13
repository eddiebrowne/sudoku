package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;


public class Main {
	public static void main(String[] args){
		
		
		Random rand = new Random();
		
		int sum = 0;
		int runs = 10000;
		boolean mulligan = false;
		int mulls = 0;
		int total;
		HashMap<Integer, Integer> rolls = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < runs; i++)
		{
			total = 0;
			int multiplier = 2* (rand.nextInt(6) + 1);
			int one = 0;
			int two = 0;
			
			do
			{
				one = rand.nextInt(6) + 1;
				two = rand.nextInt(6) + 1;
				
				total += multiplier * (one + two);
				
				if(!mulligan){
					if(total < 49 && rand.nextDouble() >= .95){
						total = 0;
						multiplier = 2* (rand.nextInt(6) + 1);
						one = rand.nextInt(6) + 1;
						two = rand.nextInt(6) + 1;
						
						total = multiplier * (one + two);
						mulligan = true;
						
						mulls++;
					}
				}
				//System.out.println(total);
			}			
			while(one == two);
			
			if(rolls.containsKey(total))
			{
				rolls.put(total, rolls.get(total).intValue() + 1);
			}
			else
			{
				rolls.put(total, 1);
			}
			
			sum+=total;
			
			
			mulligan = false;
		}
		
		
		
		System.out.println(sum/runs + ". Mulls: " + mulls + ". Rolls: " + rolls.size());
		
		
		Iterable<Integer> keys = rolls.keySet();
		
		int max = 0;
		for(Integer key : keys)
		{
			if(key > max)
			{
				max = key;
			}
		}
		
		for(int i = 4; i <= max; i+=2)  
		{
			System.out.print(i+":");
			if(rolls.containsKey(i)){
				int value = rolls.get(i);
				
				for(int j = 0; j < value; j+=10)
				{
					System.out.print("*");
				}				
			}
			
			System.out.println();			
		}
		
		
		/*
		int[][] initial = new int[9][9];
		
		initial[0][1] = 8;
		initial[0][3] = 7;
		initial[0][5] = 6;
		initial[0][7] = 1;
		
		initial[1][0] = 1;
		initial[1][1] = 9;
		initial[1][2] = 6;
		initial[1][5] = 8;
		initial[1][7] = 4;
		initial[1][8] = 7;
		
		initial[2][3] = 3;
		initial[2][5] = 4;
		initial[2][8] = 9;
		
		initial[3][0] = 6;
		initial[3][6] = 1;
		initial[3][7] = 2;
		initial[3][8] = 8;
		
		initial[4][1] = 5;
		initial[4][3] = 1;
		initial[4][5] = 2;
		initial[4][7] = 9;
		
		initial[5][0] = 2;
		initial[5][1] = 3;
		initial[5][2] = 1;
		initial[5][8] = 4;
		
		initial[6][0] = 8;
		initial[6][3] = 4;
		initial[6][5] = 1;
		
		initial[7][0] = 9;
		initial[7][1] = 1;
		initial[7][3] = 8;
		initial[7][6] = 7;
		initial[7][7] = 5;
		initial[7][8] = 6;
		
		initial[8][1] = 7;
		initial[8][3] = 9;
		initial[8][5] = 5;
		initial[8][7] = 8;
				
		//initial[4][4] = 4;
		Grid grid = new Grid(initial);
		Game game = new Game(grid);
		
		grid.Print();
		
		System.out.println("---- Column Linear ----");
		
		game.Solve().Print();
		
		System.out.println("---- Random Placement ----");
		
		Game randPlacementSolve = new Game(new Grid(initial));
		
		randPlacementSolve.SolveRandomPlacement().Print();
		
		System.out.println("---- Random Guesses ----");
		
		Game randGuessesSolve = new Game(new Grid(initial));
		
		Grid solution = randGuessesSolve.SolveRandomGuess();
		
		if(solution!=null) solution.Print();
		
		
		// Tests
		
//		System.out.println();
//		for(int i = 1; i < 10; i++){
//			grid.Set(0, 0, i);
//			System.out.println(i + " row " + game.IsRowValid(grid, 0, 0));
//		}
//		
//		System.out.println();
//		grid.Set(0, 0, 0);
//		grid.Print();
//		for(int i = 1; i < 10; i++){
//			grid.Set(0, 0, i);
//			System.out.println(i + " col " + game.IsColumnValid(grid, 0, 0));
//		}
//
//		System.out.println();
//		grid.Set(0, 0, 0);
//		grid.Print();
//		for(int i = 1; i < 10; i++){
//			grid.Set(0, 0, i);
//			System.out.println(i + " box " + game.IsBoxValid(grid, 0, 0));
//		}
		
		
		
//		System.out.println();
//		for(int i = 1; i < 10; i++){
//			grid.Set(0, 6, i);
//			System.out.println(i + " row " + game.IsRowValid(grid, 0, 6));			
//		}
//		
//		System.out.println();
//		grid.Set(0, 6, 0);
//		grid.Print();
//		for(int i = 1; i < 10; i++){
//			grid.Set(0, 6, i);
//			System.out.println(i + " col " + game.IsColumnValid(grid, 0, 6));			
//		}
//
//		System.out.println();
//		grid.Set(0, 6, 0);
//		grid.Print();
//		for(int i = 1; i < 10; i++){
//			grid.Set(0, 6, i);
//			System.out.println(i + " box " + game.IsBoxValid(grid, 0, 6));			
//		}
		*/
	}
}
