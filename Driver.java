public class Driver {
	public static void main(String[] args) {
		QueenBoard board = new QueenBoard(4);
		System.out.println(board.addQueen(0, 1));
		System.out.println(board);
		System.out.println(board.removeQueen(0, 0));
		System.out.println(board.removeQueen(0, 1));
		System.out.println(board);
	}
}
