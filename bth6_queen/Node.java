package bth6_queen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		// Enter your code here
		// số cặp Queen tấn công nhau
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				if (i != j) {
					if (state[i].isConflict(state[j])) {
						heuristic++;
					}
				}
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		// Enter your code here

		for (int i = 0; i < state.length; i++) {
			// tạo bản sao của node ở trạng thái hiện tại
			Node copy = new Node(this);
			copy.state[i].move();
			result.add(copy);
		}
		return result;
	}

	public Node selectNextRandomCandidate() {
		// Enter your code here
		// Lấy danh sách trạng thái con
		List<Node> candidates = generateAllCandidates();

		if (!candidates.isEmpty()) {
			// Chọn một trạng thái con ngẫu nhiên
			Random random = new Random();
			int randomIndex = random.nextInt(candidates.size());
			return candidates.get(randomIndex);
		} else {
			return null; // Trong trường hợp không có trạng thái con nào
		}
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
}
