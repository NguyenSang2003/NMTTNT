package bth1_task1;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState) {
		envState = new EnvironmentState(locAState, locBState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		// TODO
		envState.setAgentLocation(location);
		this.agent = agent; // có this. để phân biệt agent
							// tham số ở phương thức với agent đối tượng
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	// cập nhật tình trạng môi trường khi mà agent thực hiện 1 hành động
	public EnvironmentState executeAction(Action action) {
		// TODO
		if (action == SUCK_DIRT) {
			// đặt tên cho vị trí của agent để lấy đc vị trí của nó
			String agent = envState.getAgentLocation();
			envState.setLocationState(agent, LocationState.CLEAN);
		} else if (action == MOVE_RIGHT) {
			envState.setAgentLocation(LOCATION_B);
		} else {
			envState.setAgentLocation(LOCATION_A);
		}
		return envState;
	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		// TODO
		String agentLocate = envState.getAgentLocation();
		LocationState locateState = envState.getLocationState(agentLocate);
		Percept p1 = new Percept(agentLocate, locateState);
		return p1;
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
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
