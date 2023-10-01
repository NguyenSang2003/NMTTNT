package bth1_task2;

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		Environment env = new Environment(Environment.LocationState.CLEAN, Environment.LocationState.DIRTY,
				Environment.LocationState.DIRTY, Environment.LocationState.CLEAN);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATION_A);
//còn phần action trong class AgentProgram chưa sửa
		env.step(3);
	}
}
