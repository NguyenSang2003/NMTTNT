package bth3;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {
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
				List<Edge> listCurrent = current.getChildren();
				for (Edge edge : listCurrent) {
					Node n = edge.getEnd();
					double newG = current.getG() + edge.getWeight();
					if (!frontier.contains(n) && !visited.contains(n)) {
						n.setG(newG);
						n.setH(newG + n.getH());
						n.setParent(current);
						frontier.add(n);
						visited.add(n);
					} else if (frontier.contains(n) && newG < n.getG()) {
						n.setParent(current);
						n.setH(newG + (n.getH() - n.getG()));
						n.setG(newG);
					}
				}
			}

		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node startA = execute(root, start);
		startA.setParent(null);
		return execute(startA, goal);
	}

}
