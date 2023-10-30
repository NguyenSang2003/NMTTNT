package bth3;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		List<Node> visited = new LinkedList<>();
		frontier.add(root);
		visited.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				List<Node> listCurrent = current.getChildrenNodes();
				for (Node node : listCurrent) {
					if (!frontier.contains(node) && !visited.contains(node)) {
						node.setParent(current);
						frontier.add(node);
						visited.add(node);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node begin = execute(root, start);
		begin.setParent(null);
		return execute(begin, goal);
	}

}
