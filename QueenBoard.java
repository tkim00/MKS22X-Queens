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

  private boolean addQueen(int r, int c) {
  	if (board[r][c]==0) {
  		board[r][c] = -1;
  		return true;
  	}
  	return false;
  }
  private boolean removeQueen(int r, int c) {
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
  				output+="_ ";for (int x = 0; x < board.length; x++) {
      solveR(x);
    }
  			}
  		}
  		output+="\n";
  	}
  	return output;
  }

  public boolean solve() {
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board.length; c++) {
        if (board[r][c]!=0) {
          throw new IllegalStateException("Board has to be cleared!");
        }
      }
    }
    return solveR(0);
  }
  public boolean solveR(int col) {
    if (col >= board.length) {
      return true;
    }
    for (int r = 0; r < board.length; r++) {
      if (addQueen(r, col)) {
        if (solveR(col+1)) {
          return true;
        }
        removeQueen(r, col);
      }
    }
    return false;
  }
}
