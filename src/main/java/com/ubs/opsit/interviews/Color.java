package com.ubs.opsit.interviews;

public enum Color {

	RED("R"), YELLOW("Y");

	private String value;

	private Color(String value) {
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
