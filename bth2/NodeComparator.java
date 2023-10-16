package bth2;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		int re = Double.compare(o1.getPathCost(), o2.getPathCost());
		if (re == 0) {
			return o1.getLabel().compareTo(o2.getLabel());
		} else {
			return re;
		}
	}

}
