import java.util.*;
public class Main{

	public static void main(String[] args) {
		
		char[][] board = {{' ', ' ', ' '},
			          {' ', ' ', ' '},
			          {' ', ' ', ' '}};
		
		printBoard(board);
		
		while(true) {
			playerTurn(board);
			if(isGameFinished(board)) {
				break;
			}
			printBoard(board);
			computerTurn(board);
			if(isGameFinished(board)) {
				break;
			}
			printBoard(board);
		}	
		
		printBoard(board);
	}

	private static boolean isGameFinished(char[][] board) {
		
		if(hasContestantWon(board, 'X')) {
			printBoard(board);
			System.out.println("Player wins!");
			return true;
		}
		if(hasContestantWon(board, 'O')) {
			printBoard(board);
			System.out.println("Computer wins!");
			return true;
		}
		// Checks if board is full.
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean hasContestantWon(char[][] board, char symbol) {
		   // check rows
		if((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
		   (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol)	||
		   (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
		   
		   //check columns
		   (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
		   (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol)	||
		   (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
		   
		   //check diagonals
		   (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)	||
		   (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
			return true;
		}
		return false;
	}

	private static void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerMove;
		while(true) {
			computerMove = rand.nextInt(9) + 1;
			if(isValidMove(board, computerMove)) {
				break;
			}
		}
		System.out.println("Computer choose: " + computerMove);
		placeMove(board, computerMove, 'O');
	}

	private static void playerTurn(char[][] board) {
		int userInput;
		while(true) {
			System.out.print("Where would you like to play? (1-9): ");
			Scanner sc = new Scanner(System.in);
			userInput = sc.nextInt();
			if(isValidMove(board, userInput)) {
				break;
			}
			else {
				System.out.println(userInput + " is not a valid move.");
			}
		}
		placeMove(board, userInput, 'X');
	}

	// Checks if a position is occupied.
	private static boolean isValidMove(char[][] board, int position) {
		switch(position) {
		 case 1: 
			return (board[0][0] == ' ');
		 case 2: 
			return (board[0][1] == ' ');
		 case 3: 
			return (board[0][2] == ' ');
		 case 4: 
			return (board[1][0] == ' ');
		 case 5: 
			return (board[1][1] == ' ');
		 case 6: 
			return (board[1][2] == ' ');
		 case 7: 
			return (board[2][0] == ' ');
		 case 8: 
			return (board[2][1] == ' ');
		 case 9: 
			return (board[2][2] == ' ');
		 default:
			return false;
		}
	}

	// Prints TicTacToe game board.
	private static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	}
	
	// Place an 'X' or 'O' at a certain position on the game board.
	private static void placeMove(char[][] board, int position, char symbol) {
		switch(position) {
		 case 1: 
			 board[0][0] = symbol;
			 break;
		 case 2: 
			 board[0][1] = symbol;
			 break;
		 case 3: 
			 board[0][2] = symbol;
			 break;
		 case 4: 
			 board[1][0] = symbol;
			 break;
		 case 5: 
			 board[1][1] = symbol;
			 break;
		 case 6: 
			 board[1][2] = symbol;
			 break;
		 case 7: 
			 board[2][0] = symbol;
			 break;
		 case 8: 
			 board[2][1] = symbol;
			 break;
		 case 9: 
			 board[2][2] = symbol;
			 break;
		}
	}
}
