package bth2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		if (root == null || goal == null) {
			return null;
		}

		// Frontier cho BFS là Queue
		Queue<Node> queue = new LinkedList<>();

		// Add cấu trúc dữ liệu để lưu các đỉnh đã duyệt
		// List, set, ...
		// List<Node> explored = new ArrayList<>();
		Set<Node> visited = new HashSet<>();

		queue.offer(root);// khi offer sai ko gây ra ngoại lệ
		visited.add(root);

		while (!queue.isEmpty()) {
			// lấy poll ra từng đỉnh 1 trong queue để so sánh với goal
			Node current = queue.poll();
			// tìm goal
			if (current.getLabel().equals(goal)) {
				return current;
			}

			for (Edge e : current.getChildren()) {
				Node end = e.getEnd();
				double cost = e.getWeight();
				if (!visited.contains(end) && !queue.contains(end)) {
					end.setPathCost(cost + current.getPathCost());
					end.setParent(current);
					queue.add(end);
					visited.add(end);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();

		queue.add(root);
		visited.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}

			for (Node n : current.getChildrenNodes()) {
				if (n.getLabel().equals(start)) {
					n.setParent(current);
					queue.clear();
					visited.clear();
					execute(n, goal);
				}
			}
		}
		return null;
	}

}
