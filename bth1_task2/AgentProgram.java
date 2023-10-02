package bth1_task2;

import java.util.Random;

public class AgentProgram {

	private Random random;

	public AgentProgram() {
		random = new Random();
	}

	public Action execute(Percept p) {
		String agentLocate = p.getAgentLocation();
		if (p.getLocationState() == Environment.LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		} else {
			if (agentLocate.equals(Environment.LOCATION_A)) {
				int ramdonAction = random.nextInt(2);
				if (ramdonAction == 0) {
					return Environment.MOVE_RIGHT;
				} else {
					return Environment.MOVE_DOWN;
				}
			} else if (agentLocate.equals(Environment.LOCATION_B)) {
				int ramdonAction = random.nextInt(2);
				if (ramdonAction == 0) {
					return Environment.MOVE_LEFT;
				} else {
					return Environment.MOVE_DOWN;
				}
			} else if (agentLocate.equals(Environment.LOCATION_C)) {
				int ramdonAction = random.nextInt(2);
				if (ramdonAction == 0) {
					return Environment.MOVE_RIGHT;
				} else {
					return Environment.MOVE_UP;
				}
			} else if (agentLocate.equals(Environment.LOCATION_D)) {
				int ramdonAction = random.nextInt(2);
				if (ramdonAction == 0) {
					return Environment.MOVE_LEFT;
				} else {
					return Environment.MOVE_UP;
				}
			} else {
				// Trường hợp không xác định, trả về hành động ngẫu nhiên (UP, DOWN, LEFT,
				// RIGHT)
				int randomAction = random.nextInt(4); // Số ngẫu nhiên từ 0 đến 3
				if (randomAction == 0) {
					return Environment.MOVE_UP;
				} else if (randomAction == 1) {
					return Environment.MOVE_DOWN;
				} else if (randomAction == 2) {
					return Environment.MOVE_LEFT;
				} else {
					return Environment.MOVE_RIGHT;
				}
			}
		}
	}

}
