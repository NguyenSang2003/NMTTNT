package bth8;

import java.util.Collections;
import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int v = maxValue(node, Integer.MAX_VALUE, Integer.MIN_VALUE);
		System.out.println(v);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v) "alpha đc gán cho giá trị math.MAX(alpha,v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}
		int max = Integer.MIN_VALUE;
		List<Node> children = node.getChildren();
//		sắp xếp các nút con ngược lại để duyệt từ phải qua trái.
		Collections.sort(children, Collections.reverseOrder(Node.LabelComparator));

		for (Node child : children) {
			max = Math.max(max, minValue(child, alpha, beta));
			if (max >= beta) {
				return max;
			}
			alpha = Math.max(max, alpha);
		}
		return max;
	}

	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}
		int min = Integer.MAX_VALUE;
		List<Node> children = node.getChildren();
//			sắp xếp các nút con ngược lại để duyệt từ phải qua trái.
		Collections.sort(children, Collections.reverseOrder(Node.LabelComparator));

		for (Node child : children) {
			min = Math.min(min, maxValue(child, alpha, beta));
			if (min <= alpha) {
				return min;
			}
			beta = Math.min(beta, min);
		}
		return min;
	}
}
