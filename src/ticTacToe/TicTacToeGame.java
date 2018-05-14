package ticTacToe;
//Draden Davis
//Tic Tac Toe

import javax.swing.JOptionPane;
import java.util.Random;

public class TicTacToeGame 
{

	public static void main(String[] args) 
	{
		GameBoard gb = new GameBoard();
		Random rand = new Random();
		int row;
		int column;
		String input;
		
		boolean humanTurn = true;
		boolean gameOver = false;
		
		gb.showBoard();
		
		while(gameOver != true)
		{
			if(humanTurn == true)
			{
				input = JOptionPane.showInputDialog("Please enter the coordinates of the location you want your move, top left is (0 0)");
				row = Integer.parseInt(input.substring(0,1));
				column = Integer.parseInt(input.substring(2, 3));
				
				while(!gb.play(humanTurn, row, column))
				{
					input = JOptionPane.showInputDialog("Please enter the coordinates of the location you want your move, top left is (0 0)");
					row = Integer.parseInt(input.substring(0,1));
					column = Integer.parseInt(input.substring(2, 3));
			
				}//while
				humanTurn = false;
				
			}//if
			
			else
			{
				row = rand.nextInt(3);
				column = rand.nextInt(3);
				while(!gb.play(humanTurn, row, column))
				{
					row = rand.nextInt(3);
					column = rand.nextInt(3);
				}
				humanTurn = true;
			}//else
			
			gb.showBoard();
			System.out.println();
			
			//User win
			if(gb.checkWin() == 'X')
			{
				System.out.println("You have beaten the computer!");
				System.out.println("It took you " + gb.playCount() + " turns");
				gameOver = true;
			}//if
			
			if(gb.checkWin() == 'O')
			{
				System.out.println("You lost to the computer.");
				System.out.println("The computer beat you in " + gb.playCount() + " turns");
				gameOver = true;
			}//if
			
			if(gb.checkWin() == 'T')
			{
				System.out.println("You tied with our computer. Good try!");
				gameOver = true;
			}
		}
		
	}

}
