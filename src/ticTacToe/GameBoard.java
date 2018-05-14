package ticTacToe;

import java.util.ArrayList;

public class GameBoard 
{
	private char [] [] board = new char [3] [3];
	private int plays;
	
	public GameBoard()
	{
		plays = 0;
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				board[row][col] = ' ';
			}//for
		}//for
	}//GameBoard
	
	public boolean play(boolean x, int row, int column)
	{
		if (board[row][column] == ' ')
		{
			if(x == true)
				board[row][column] = 'X';
			else
				board[row][column] = 'O';
			plays++;
			return true;
		}//if
		
		else
			return false;
	}//play
	
	public int playCount()
	{
		return plays;
	}//playCount
	
	
	public char checkWin()
	{
		//Horizontal
		if(board[0][0] == board[0][1] && board[0][1] == board[0][2])
			return board[0][0];
		else if (board[1][0] == board[1][1] && board[1][1] == board[1][2])
			return board[1][0];
		else if(board[2][0] == board [2][1] && board[2][1] == board[2][2])
			return board [2][0];
		//Diagonal
		else if(board [0][0] == board [1][1] && board [1][1] == board [2][2])
			return board[0][0];
		else if(board [0][2] == board[1][1] && board[1][1] == board [2][0])
			return board [0][2];
		//Vertical
		else if (board[0][0] == board [1][0] && board [1][0] == board[2][0])
			return board [0][0];
		else if (board [0][1] == board [1][1] && board [1][1] == board [2][1])
			return board [0][1];
		else if (board [0][2] == board [1][2] && board [1][2] == board [2][2])
			return board [0][2];
		//Tie
		else if (plays == 9)
			return 'T';
		else
			return ' ';
	}//CheckWin
	
	public void showBoard()
	{
		System.out.println(" " + board [0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
		System.out.println("---+---+---");
		System.out.println(" " + board[1][0] + " | " + board [1][1] + " | " + board[1][2] + " ");
		System.out.println("---+---+---");
		System.out.println(" " + board[2][0] + " | " + board [2][1] + " | " + board[2][2]);
	}//showBoard

}
