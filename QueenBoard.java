public class QueenBoard {
  private int[][]board;

  public QueenBoard(int size) {
    for (int x = 0; x < size; i++) {
      for (int y = 0; y < size; i++) {
        board[x][y] = 0;
      }
    }
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
  /*
  public String toString() {
  	for (int x = 0; x < board.length; x++) {
  		for (int y = 0; y < board[x].length; y++) {
  			
  		}
  	}
  }*/
}
