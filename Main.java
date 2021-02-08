////////////////////////////////////////////////////////////////////////////////
/// @file Main.java
/// 
/// @brief
/// Programed by: Maxwell G. Simpson
/// Doxygen File Commenting
////////////////////////////////////////////////////////////////////////////////

// Imports
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////////
/// @brief Main class for starting and calling game loops
////////////////////////////////////////////////////////////////////////////////
public class Main {

	////////////////////////////////////////////////////////////////////////////
	/// @brief Main method for game loops
	/// @param args Input text for starting program
	public static void main(String[] args) {
		
		// Introduction
		printBarrier();
		System.out.println("Hello and welcome to solo TicTacToe!");
		printBarrier();
		pause(1000);
		
		// Initialize scanner
		Scanner input = new Scanner(System.in);
		
		// Game Loop
		int winner = 0;
		Board board = new Board();
		System.out.println("Game is starting!");
		System.out.println("You are o's type the row and column number when prompted.");
		pause(1000);
		
		while(winner == 0){
			// Show board
			System.out.println("Current board");
			printBarrier();
			board.printBoard();
			printBarrier();
			pause(1000);
			
			// Get input
			System.out.print("What row would you like to place in:");
			int row = input.nextInt();
			System.out.print("What column would you like to place in:");
			int column = input.nextInt();
			printBarrier();
			
			// Place play
			if (board.playerPlay(column, row)){
				// Check for winners
				checkWinner(board);
				// Bot play
				board.botPlay();
				// Check for winners
				checkWinner(board);
			}else{
				System.out.println("Invalid location nice try!");
				System.out.println("Terminating execution");
				printBarrier();
				System.exit(0);
			}
			
		}	
	}
	
	////////////////////////////////////////////////////////////////////////////
	/// @brief Class to check for winners and stalemates
	/// @param board Board for checking who has won 
	public static void checkWinner(Board board){
		if(board.playerOneWin()){
			// Player win	
			board.printBoard();
			printBarrier();
			System.out.println("Player has won");
			System.exit(0);
		}else if(board.botWin()){
			// Bot wins
			board.printBoard();
			printBarrier();
			System.out.println("Bot has won");
			System.exit(0);
		}else{
			// Stale mate
			if(board.isBoardFull()){
				System.out.println("Stalemate neither wins");
				System.exit(0);;
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////////////
	/// @brief Method for clearing line with dashes
	public static void printBarrier (){
		System.out.println("-------------------------------------------------------------");
	}	
	
	////////////////////////////////////////////////////////////////////////////
	/// @brief Method for pausing for a certain amount of time.
	/// @param time Miliseconds to pause the game for
	public static void pause(int time){
		try{
			Thread.sleep(time);
		}catch(Exception e){}
	}
	
	
	
}
