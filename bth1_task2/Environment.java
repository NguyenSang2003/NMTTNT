package bth1_task2;

import java.util.Random;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";

	public enum LocationState {
		CLEAN, DIRTY
	}

	private int score = 0;
	private EnvironmentState envState;
	private boolean isDone = false;
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState, LocationState locCState,
			LocationState locDState) {
		envState = new EnvironmentState(locAState, locBState, locCState, locDState);
	}

	public void addAgent(Agent agent, String location) {
		envState.setAgentLocation(location);
		this.agent = agent;
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	public EnvironmentState executeAction(Action action) {
		String agentLocation = envState.getAgentLocation();

		if (action == SUCK_DIRT) {
			envState.setLocationState(agentLocation, LocationState.CLEAN);
			score += 500;

		} else if (agentLocation.equals(Environment.LOCATION_A)) {
			if (action == Environment.MOVE_RIGHT) {
				envState.setAgentLocation(LOCATION_B);
				score -= 10;
			} else if (action == Environment.MOVE_DOWN) {
				envState.setAgentLocation(LOCATION_C);
				score -= 10;
			} else {
				envState.setAgentLocation(LOCATION_C);
				score -= 100;
			}
		} else if (agentLocation.equals(Environment.LOCATION_B)) {
			if (action == Environment.MOVE_LEFT) {
				envState.setAgentLocation(LOCATION_A);
				score -= 10;
			} else if (action == Environment.MOVE_DOWN) {
				envState.setAgentLocation(LOCATION_D);
				score -= 10;
			} else {
				envState.setAgentLocation(LOCATION_B);
				score -= 100;
			}
		} else if (agentLocation.equals(Environment.LOCATION_C)) {
			if (action == Environment.MOVE_UP) {
				envState.setAgentLocation(LOCATION_A);
				score -= 10;
			} else if (action == Environment.MOVE_RIGHT) {
				envState.setAgentLocation(LOCATION_D);
				score -= 10;
			} else {
				envState.setAgentLocation(LOCATION_C);
				score -= 100;
			}
		} else if (agentLocation.equals(Environment.LOCATION_D)) {
			if (action == Environment.MOVE_LEFT) {
				envState.setAgentLocation(LOCATION_C);
				score -= 10;
			} else if (action == Environment.MOVE_UP) {
				envState.setAgentLocation(LOCATION_B);
				score -= 10;
			} else {
				envState.setAgentLocation(LOCATION_D);
				score -= 100;
			}
		}
		return envState;
	}

	// Phương thức tính điểm
	public void Score() {
		System.out.println("Tổng điểm: " + this.score);
	}

	public Percept getPerceptSeenBy() {
		String agentLocate = envState.getAgentLocation();
		LocationState locateState = envState.getLocationState(agentLocate);
		return new Percept(agentLocate, locateState);
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_C) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_D) == LocationState.CLEAN))
			isDone = true;
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;
		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
