package bth2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TreeSearch implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<>();
		Set<Node> explored = new HashSet<>();

		frontier.add(root);
		explored.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				explored.add(current);
				List<Edge> children = current.getChildren();

			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
