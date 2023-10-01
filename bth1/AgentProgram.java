package bth1;

import bth1.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// TODO
		if (p.getLocationState() == LocationState.DIRTY)
			return Environment.SUCK_DIRT;
		else if (p.getAgentLocation() == Environment.LOCATION_A)
			return Environment.MOVE_RIGHT;// A đang trái nên qua B la phải hoặc ngược lại
		else
			return Environment.MOVE_LEFT;
//		return NoOpAction.NO_OP;

	}
}