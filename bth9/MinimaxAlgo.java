package bth9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimaxAlgo {
	private Node bestMove;

	public void execute(Node node) throws CloneNotSupportedException {
		int v = minValue(node);
		System.out.println("Value at the root node: " + v);
		System.out.println("Best move for MIN player: " + bestMove);
	}

	// Max không chia đc thì min thắng
	// Min không chia đc thì max thắng

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) throws CloneNotSupportedException {
		if (node.isTerminal()) {
			return UTILITY(node);
		}
		int v = Integer.MIN_VALUE;
		bestMove = null; // Đặt giá trị ban đầu cho nước đi tốt nhất

		for (Node child : node.getSuccessors()) {
			int minValue = minValue(child);
			if (minValue > v) {
				v = minValue;
				bestMove = child; // Cập nhật nước đi tốt nhất
			}
		}
		return v;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) throws CloneNotSupportedException {
		if (node.isTerminal()) {
			return UTILITY(node);
		}
		int v = Integer.MAX_VALUE;
		bestMove = null; // Đặt giá trị ban đầu cho nước đi tốt nhất

		for (Node child : node.getSuccessors()) {
			v = Math.min(v, maxValue(child));
		}
		return v;
	}

	// Phương thức này cần được triển khai để tính giá trị tiện ích cho mỗi nút lá
	private int UTILITY(Node node) {
		int sum = 0;
		for (Integer value : node.getData()) {
			sum += value;
		}
		return sum;
	}
}
