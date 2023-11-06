package bth5;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class GreedySearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
//		 fontier = ProrityQueue(PuzzeUtilComparatorByH)
//		 explored = Arraylist()()
//		 fontier.add(model.getinitialState)
//		 while(!frontier.isEmpty)
//			current = fontier.poll
//			if(current.getH1() == 0 ) return current
//			else {list<Node> children = model.getSuccesor
//			for(Node child : children) {
//				if (!fontier.contain(child) && !explored.contain(child))
//					child.setG(current.getG+1)
//					frontier.add(child)
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		Set<Node> explored = new HashSet<Node>();
		frontier.add(model.getInitialState());
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getH() == 0) {
				return current;
			} else {
				List<Node> children = model.getSuccessors(current);
				for (Node child : children) {
					if (!frontier.contains(child) && !explored.contains(child)) {
						current.setG(current.getG() + 1);
						frontier.add(child);
					}
				}
			}
		}
		return null;
	}

}
