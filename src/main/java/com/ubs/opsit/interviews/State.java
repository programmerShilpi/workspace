package com.ubs.opsit.interviews;

public enum State {

	ON("Y"), OFF("O");

	private String value;

	private State(String value) {
		this.value = value;

	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
