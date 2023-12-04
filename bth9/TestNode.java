package bth9;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) throws Exception {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));

		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);

		System.out.println("[7] --> " + node.getSuccessors());
	}
}