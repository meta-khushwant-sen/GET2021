import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;


public class NQueens {

static private int N=4;
/**
 * Printing the solution board
 * @param board 2-D array representing the board
 */
static void printSol(int board[][]){
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			if(board[i][j]==1){
				System.out.print("1\t");
			}else{
				System.out.print("0\t");
			}
			
		}
		System.out.print("\n");
	}
}
/**
 * Checking weather the box is safe or not
 * @param board 2-D array representing the board
 * @param row representing row of the board
 * @param col representing column of the board
 * @return true if safe otherwise false
 */
static boolean toPlaceOrNot(int board[][],int row,int col){
	int i,j;
	for(i=0;i<col;i++){
		if(board[row][i]==1){   
			return false;
		}
	}
	for(i=row,j=col;i>=0&&j>=0;i--,j--){
		if(board[i][j]==1){
			return false;
		}
	}
	for(i=row,j=col;j>=0&&i<N;i++,j--){
		if(board[i][j]==1){
			return false;
		}
	}
	return true;
}
/**
 * place the queen at safe position and backtrack if not appropriate
 * @param board 2-D array representing the board
 * @param col 
 * @return
 */
static boolean nQueenSolver(int board[][],int col){
	if(col>=N){
		return true;
	}
	for(int i=0;i<N;i++){
		if(toPlaceOrNot(board,i,col)){
			board[i][col]=1;
			if(nQueenSolver(board,col+1)){
				return true;
			}
			board[i][col]=0;
		}
	}
	return false;
}
boolean solveQueen(boolean test){
	 int board[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		if(!nQueenSolver(board,0)){
			System.out.println("\n Solution Not Found");
			return false;
		}
		if(!test){
		printSol(board);
		}
		return true;
}
@Test
public static void main(String args[]){
	NQueens queens=new NQueens();
	queens.solveQueen(false);
	assertEquals(true,queens.solveQueen(true));
	assertNotEquals(false,queens.solveQueen(true));

}
}
