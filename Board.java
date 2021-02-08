////////////////////////////////////////////////////////////////////////////////
/// @file Board.java
///
/// Controls board functions.
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
/// @brief Class for controlling board
////////////////////////////////////////////////////////////////////////////////
public class Board {
	
	// Public
	
	////////////////////////////////////////////////////////////////////////////
	/// @brief Constructor
	Board(){
		// Clear board
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = ' ';
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////////////
	/// @brief Print board 
	void printBoard(){
		System.out.println("  1   2   3");
		System.out.println("1 " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println("  - - - - -");
		System.out.println("2 " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("  - - - - -");
		System.out.println("3 " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	}
	 
	////////////////////////////////////////////////////////////////////////////
	/// @brief Adds player play to board
	boolean playerPlay(int x, int y){
		x -= 1;
		y -= 1;
		
		// Error Checking
		if((x > 2 || x < 0)|| (y > 2 || y < 0)){
			System.out.println("Nice try but that's out of the array");
			System.out.println("Terminating program");
			System.exit(0);
		}
		
		if(board[y][x] == ' '){
			board[y][x] = 'O';
		}else{
			return false;
		}
		return true;
	}
	
	////////////////////////////////////////////////////////////////////////////
	/// @brief Bot plays spot in TicTacToe
	public void botPlay(){
		boolean botPlayed = false;
		// Find and play in open spot
		while (botPlayed == false){
			// Get possible spot
			int x = (int)(Math.random()*((2-0)+1))+0;
			int y = (int)(Math.random()*((2-0)+1))+0;
			
			// Check spot
			if(board[x][y] == ' '){
				// Play into spot
				board[x][y] = 'X';
				botPlayed = true;
			}
		}	
	}
	
	////////////////////////////////////////////////////////////////////////////
	/// @brief Checks if board is full
	public boolean isBoardFull(){
		int emptySpots = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == ' '){
					emptySpots++;
				}
			}
		}
		
		if(emptySpots == 0){
			return true;
		}else{
			return false;
		}
		
	}
	
	////////////////////////////////////////////////////////////////////////////
	/// @brief Player one win checker
	public boolean playerOneWin(){
		for(int i = 0; i < 3; i++){
			if(board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O'){
				return true;
			}else if(board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O'){
				return true;
			}
		}
		if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'){
			return true;
		}else if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'){
			return true;
		}
		return false;
	}
	
	////////////////////////////////////////////////////////////////////////////
	/// @brief Bot win checker
	public boolean botWin(){
		for(int i = 0; i < 3; i++){
			if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X'){
				return true;
			}else if(board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X'){
				return true;
			}
		}
		if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'){
			return true;
		}else if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'){
			return true;
		}
		return false;
	}
	
	// Private
	private char[][] board = new char[3][3]; //< Board Array
	
}
