package bth5;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();

		p.readInput("src/bth5_txt/PuzzleMap.txt", "src/bth5_txt/PuzzleGoalState.txt");

		Node initialState = p.getInitialState();
		Node tmp = new Node(initialState);
		System.out.println(initialState.equals(tmp));
//		Node goalState = p.getGoalState();
		System.out.println(p.getInitialState());
		System.out.println("H: " + initialState.getH());
		System.out.println("H1: " + p.computeH1(tmp));
		System.out.println("H2: " + p.computeH2(tmp));

//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
		System.out.println(p.getGoalState());
		Node re = p.moveWhiteTile(initialState, 'r');

		System.out.println(re);
		System.out.println(re.getH());
		System.out.println(initialState);
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(init, goal));

		System.out.println(p.getInitialState());
		System.out.println(p.getGoalState());

		List<Node> children = p.getSuccessors(initialState);
		System.out.println("Size: " + children.size());
		for (Node child : children) {
			System.out.println(child.getH() + " " + p.computeH1(child));
		}
		GreedySearch gd = new GreedySearch();
		Node result = gd.execute(p);
		System.out.println(result.getH());
		System.out.println(result);

		AStarSearch gds = new AStarSearch();
		Node results = gds.execute(p);
		System.out.println(results);
	}
}
