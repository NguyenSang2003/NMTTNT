package bth6_queen;

import java.util.List;

public class HillClimbingSearch {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	int randomRestarts = 0;

	public Node execute(Node initialState) {
		Node currentState = initialState;

		while (true) {
			// Tính giá trị heuristic cho trạng thái hiện tại
			int currentHeuristic = currentState.getH();

			// Tạo danh sách trạng thái con
			List<Node> candidates = currentState.generateAllCandidates();

			// Tạo biến để lưu trạng thái con có giá trị heuristic tốt nhất
			Node nextBestState = null;
			int nextBestHeuristic = currentHeuristic;

			// Lặp qua tất cả trạng thái con
			for (Node candidate : candidates) {
				int candidateHeuristic = candidate.getH();

				// Nếu trạng thái con có giá trị heuristic tốt hơn
				if (candidateHeuristic < nextBestHeuristic) {
					// Cập nhật trạng thái con tốt nhất
					nextBestState = candidate;
					nextBestHeuristic = candidateHeuristic;
				}
			}

			// Nếu không còn trạng thái con nào tốt hơn, kết thúc tìm kiếm
			if (nextBestState == null) {
				return currentState;
			}

			// Di chuyển đến trạng thái con tốt nhất
			currentState = nextBestState;
			stepClimbed++;
		}
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		int maxRandomRestarts = 1000;
		Node bestSolution = null;

		for (int i = 0; i < maxRandomRestarts; i++) {
			Node currentState = initialState;

			// Thực hiện tìm kiếm bằng Hill Climbing cho một lần khởi đầu ngẫu nhiên
			Node localSolution = execute(currentState);

			if (bestSolution == null || localSolution.getH() < bestSolution.getH()) {
				bestSolution = localSolution;
			}
			stepClimbedAfterRandomRestart += stepClimbed;
			stepClimbed = 0;
		}
		randomRestarts++;
		return bestSolution;
	}

}
