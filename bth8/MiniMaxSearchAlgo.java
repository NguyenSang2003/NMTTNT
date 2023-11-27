package bth8;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int res = maxValue(node);
		System.out.println(res);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}

		int max = Integer.MIN_VALUE;
		List<Node> successors = node.getChildren();
//		sắp xếp các nút con trước khi duyệt qua chúng để đảm bảo thứ tự đúng.
		Collections.sort(successors, node.LabelComparator);
		
		for (Node successor : successors) {
			int minValue = minValue(successor);
			max = Math.max(max, minValue);
		}
		return max;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}

		int min = Integer.MAX_VALUE;
		List<Node> successors = node.getChildren();
//		sắp xếp các nút con trước khi duyệt qua chúng để đảm bảo thứ tự đúng.
		Collections.sort(successors, node.LabelComparator);
		
		for (Node successor : successors) {
			int maxValue = maxValue(successor);
			min = Math.min(min, maxValue);
		}
		return min;
	}
}
