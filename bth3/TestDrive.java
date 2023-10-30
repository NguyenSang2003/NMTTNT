package bth3;

public class TestDrive {
	public static void main(String[] args) {

		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");

		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);

		IInformedSearchAlgo greedy = new GreedyBestFirstSearchAlgo();
		Node rootG = nodeS;
		String startG = "D";
		String goalG = "G";
		Node resultG = greedy.execute(rootG, goalG);
		System.out.println("Greedy Search Algo" + NodeUtils.printPath(resultG));
		Node result2 = greedy.execute(rootG, startG, goalG);
		System.out.println("Greedy Search Algo Start :" + startG + " -> " + goalG + ":" + NodeUtils.printPath(result2));

		System.out.println("");

		IInformedSearchAlgo Astar = new AStarSearchAlgo();
		Node rootA = nodeS;
		String startA = "D";
		String goalA = "G";
		Node resultA = Astar.execute(rootA, goalA);
		System.out.println("AStar Search Algo " + NodeUtils.printPath(resultA));
		Node resultA2 = Astar.execute(rootA, startA, goalA);
		System.out.println("AStar Search Algo Start :" + startA + " -> " + ":" + goalA + NodeUtils.printPath(resultA2));
	}
}