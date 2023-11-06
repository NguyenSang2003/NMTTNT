package bth5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frotier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
		List<Node> container = new ArrayList<>();
		
		Node start = model.getInitialState();
		Node goal = model.getGoalState();
		frotier.add(start);
		
		while (!frotier.isEmpty()) {
			Node current = frotier.poll();
			if (current.equals(goal)) {
				return current;
			} else {
				container.add(current);
				List<Node> listChild = model.getSuccessors(current);
				for (Node node : listChild) {
					if (!frotier.contains(node) && !container.contains(node)) {
						node.setG(current.getG() + 1);
						frotier.add(node);
					} else if (frotier.contains(node) && !container.contains(node)) {
						for (Node node2 : frotier) {
							if (current.equals(node2) && current.getF() < node2.getF()) {
								frotier.remove(node2);
								frotier.add(node);
								break;
							}
						}
					}
				}
			}
		}
		return null;
	}

}