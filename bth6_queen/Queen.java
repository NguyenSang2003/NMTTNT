package bth6_queen;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		// Enter your code here
		// chỉ đi xuống 1 row (ko qa trái phải)
		this.setRow(this.getRow() + 1);
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		// Enter your code here
		// nếu q cùng dòng hay q trên cùng 1 đường chéo thì sẽ ăn đc nhau và trả về true
		return this.row == q.getRow() || Math.abs(this.row - q.getRow()) == Math.abs(this.column - q.getColumn());
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
