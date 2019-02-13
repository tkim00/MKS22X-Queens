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
      for (int i = 1; c+i < board.length; i++) {
        board[r][c+i] += 1;
        if (r+i < board.length) { //only add if there are any space below
          board[r+i][c+i] += 1;
        }
        if (r-i > 0) { //only add if there are any space above
          board[r-i][c+i] += 1;
        }
      }
  		return true;
  	}
  	return false;
  }
  private boolean removeQueen(int r, int c) {
  	if (board[r][c]==-1) {
  		board[r][c] = 0;
      for (int i = 1; c+i < board.length; i++) {
        board[r][c+i] -= 1;
        if (r+i < board.length) { //only remove if there are any space below
          board[r+i][c+i] -= 1;
        }
        if (r-i > 0) { //vice versa
          board[r-i][c+i] -= 1;
        }
      }
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

  public boolean solve() {
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board.length; c++) {
        if (board[r][c]!=0) {
          throw new IllegalStateException("Board has to be cleared!");
        }
      }
    }
    return solveR(0); //helper function to pass column as a parameter
  }
  public boolean solveR(int col) {
    if (col >= board.length) {
      return true;
    }
    for (int r = 0; r < board.length; r++) {
      if (addQueen(r, col)) { //if Queen is addable
        if (solveR(col+1)) { //proceeds to the next column
          return true;
        }
        removeQueen(r, col); //if Queen cannot be added at all in a column, remove the Queen previous to that column
      }
    }
    return false;
  }
  public int countSolutions() {
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board.length; c++) {
        if (board[r][c]!=0) {
          throw new IllegalStateException("Board has to be cleared!");
        }
      }
    }
    return countSolutionsR(0, 0);
  }
  public int countSolutionsR(int col, int sols) {
    if (col >= board.length) {
      sols++;
      return sols;
    }
    for (int r = 0; r < board.length; r++) {
      if (addQueen(r, col)) {
        sols += countSolutionsR(col+1, sols);
        removeQueen(r, col);
      }
    }
    return sols;
  }
}
