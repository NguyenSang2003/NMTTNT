package bth7;

public class TestGA_NQueenAlgo {
	public static void main(String[] args) {
		GA_NQueenAlgo geneticAlgorithm = new GA_NQueenAlgo();

		// Khởi tạo quần thể
		geneticAlgorithm.initPopulation();

		// Thực hiện thuật toán
		Node solution = geneticAlgorithm.execute();

		// Hiển thị kết quả
		System.out.println("Best Solution:");
		solution.displayBoard();
		System.out.println("Heuristic: " + solution.getH());
	}
}
