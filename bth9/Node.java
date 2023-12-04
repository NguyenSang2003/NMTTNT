package bth9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();
	private List<Node> children = new ArrayList<Node>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() throws CloneNotSupportedException {
		List<Node> successors = new ArrayList<>();

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) > 1) {
				Node clone = new Node();
				clone.addAll(data);

				int value = clone.data.get(i);
				clone.data.set(i, value - 1);
				clone.data.add(1);

				successors.add(clone);

				if (!clone.isTerminal()) {
					successors.addAll(clone.getSuccessors()); // Gọi lại để chạy thêm tiếp cho đến
																// khi nó trở thành nút lá
				}
			}
		}

		return successors;
	}

	// Check whether a node is terminal or not
	// có phải nút lá hay ko
	// Không chia đc sắp xếp giảm dần phần tử đầu tiên có <= 2 thì là nút lá
	public boolean isTerminal() {
		// Enter your code here
		for (Integer integer : data) {
			if (integer > 2) {
				return false;
			}
		}
		return true;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

}
