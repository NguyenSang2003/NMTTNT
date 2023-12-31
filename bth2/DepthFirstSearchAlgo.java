package bth2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	// Giống BFS
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		if (root == null || goal == null) {
			return null;
		}

		// Frontier của DFS là Stack
		Stack<Node> stack = new Stack<>();
		Set<Node> visited = new HashSet<>();

		stack.add(root);
		visited.add(root);

		while (!stack.isEmpty()) {
			Node current = stack.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			for (Edge e : current.getChildren()) {
				Node end = e.getEnd();
				double cost = e.getWeight();
				if (!visited.contains(end) && !stack.contains(end)) {
					end.setPathCost(cost + current.getPathCost());
					end.setParent(current);
					stack.add(end);
					visited.add(end);
				}
			}
		}

		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> stack = new Stack<>();
		Set<Node> visited = new HashSet<>();

		stack.add(root);
		visited.add(root);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			}

			for (Node n : current.getChildrenNodes()) {
				if (n.getLabel().equals(start)) {
					n.setParent(current);
					stack.clear();
					visited.clear();
					execute(n, goal);
				}
			}
		}
		return null;
	}
}
