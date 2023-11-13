package bth6_queen;

public class Test {
	public static void main(String[] args) {
		// Tạo trạng thái ban đầu với một bàn cờ 8x8
		Node initialState = new Node();
		initialState.generateBoard();

		HillClimbingSearch hillClimbing = new HillClimbingSearch();
		Node solution = hillClimbing.execute(initialState);

		System.out.println("Hill Climbing Solution:");
		solution.displayBoard();

		Node solutionWithRandomRestart = hillClimbing.executeHillClimbingWithRandomRestart(initialState);

		System.out.println("Hill Climbing with Random Restart Solution:");
		solutionWithRandomRestart.displayBoard();
	}

}
