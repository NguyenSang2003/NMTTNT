package bth7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		initPopulation();
		int k = 0;
		while (k < MAX_ITERATIONS) {
			List<Node> newPopulation = new ArrayList<>();
			for (int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				Node child = reproduce(x, y);
				if (MUTATION_RATE < rd.nextDouble(Node.N)) {
					mutate(child);
					newPopulation.add(child);
//					if (child.getH() == 0) {
//					return child;
				}
			}
			population = newPopulation;
			k++;
		}
		Collections.sort(population);
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
		int i = rd.nextInt(Node.N);
		int r = rd.nextInt(Node.N);
		node.setRow(i, r);
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		// Enter your code here
		int c = rd.nextInt(Node.N);
		Node n = new Node();
		n.generateBetterCandidates();
		for (int i = 0; i < Node.N; i++) {
			if (i <= c) {
				n.setRow(i, x.getRow(i));
			} else {
				n.setRow(i, y.getRow(i));
			}
		}
		return n;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		// Enter your code here
		int k = rd.nextInt(Node.N);
		Node best = population.get(k).getBestCandidate();

		return best;
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		// Enter your code here
		int k = rd.nextInt(Node.N);
		Node n = population.get(k);

		return n;
	}
}
