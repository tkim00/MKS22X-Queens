public class QueenBoard {
  private int[][]board;

  public QueenBoard(int size) {
  	/*
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        board[r][c] = 0;
        //System.out.println("success");
      }
    }*/
    board = new int[size][size];
  }
  
  public boolean addQueen(int r, int c) {
  	if (board[r][c]==0) {
  		board[r][c] = -1;
  		return true;			
  	}
  	return false;
  }
  public boolean removeQueen(int r, int c) {
  	if (board[r][c]==-1) {
  		board[r][c] = 0;
  		return true;
  	}
  	return false;
  }
  
  public String toString() {
  	String output = "";
  	for (int r = 0; r < board.length; r++) {
  		for (int c = 0; c < board[r].length; c++) {
  			if (board[r][c] == -1) {
  				output+="Q ";
  			} else {
  				output+="_ ";
  			}
  		}
  		output+="\n";
  	}
  	return output;
  }
}
