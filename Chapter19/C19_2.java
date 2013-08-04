enum Chess
{
	Red,Blue,Empty
}
enum Check
{
	Row, Column, Diagnal, ReverseDiagnal
}
public class C19_2 {

	public static Chess getWinner(Chess[][] board)
	{
		for(int i = 0; i < board.length; i++)
		{
			Chess color = getWinnerColor(board, i, Check.Row);
			if(Chess.Empty != color)
				return color;
			color = getWinnerColor(board, i, Check.Column);
			if(Chess.Empty != color)
				return color;
		}
		Chess color = getWinnerColor(board, -1, Check.Diagnal);
		if(Chess.Empty != color)
			return color;
		color = getWinnerColor(board, -1, Check.ReverseDiagnal);
		return color;
	}
	private static Chess getWinnerColor(Chess[][] board, int index, Check check) {
		Chess color = getColor(board, index, 0, check);
		for(int i = 1; i < board.length; i++)
		{
			Chess cur = getColor(board, index, i, check);
			if(cur != color)
				return Chess.Empty;
		}
		return color;
	}
	private static Chess getColor(Chess[][] board, int row, int col, Check check) {
		if(check == Check.Row)
		{
			return board[row][col];
		}
		else if(check == Check.Column)
		{
			return board[col][row];
		}
		else if(check == Check.Diagnal)
		{
			return board[col][col];
		}
		else
		{
			return board[board.length - 1 - col][col];
		}
			
	}

}
