package com.ubs.opsit.interviews;

public class Lamp {

	private Color color;
	private State state;

	public Lamp(Color color) {
		this.color = color;
		this.state = State.OFF;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.state == State.OFF)
			sb.append(this.state);
		else
			sb.append(this.color);
		return sb.toString();
	}

}
