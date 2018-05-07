package com.ubs.opsit.interviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import junit.framework.Assert;

public class BerlinClockUnitTest {

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTime() {
		BerlinClock berlinClock = new BerlinClock();
		berlinClock.convertTime("test:test:test");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidHourTime() {
		BerlinClock berlinClock = new BerlinClock();
		berlinClock.convertTime("test:59:59");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMinTime() {
		BerlinClock berlinClock = new BerlinClock();
		berlinClock.convertTime("11:test:59");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidSecTime() {
		BerlinClock berlinClock = new BerlinClock();
		berlinClock.convertTime("11:59:sec");
	}

	@Test
	public void testLampDefaultState() {
		Lamp lamp = new Lamp(Color.RED);
		assertThat(State.OFF).isEqualTo(lamp.getState());
	}

	@Test
	public void testSetState() {
		Lamp lamp = new Lamp(Color.RED);
		lamp.setState(State.ON);
		assertThat(State.ON).isEqualTo(lamp.getState());
	}

	@Test
	public void testBerlinClockInitialState() {
		BerlinClock clock = new BerlinClock();
		String theExpectedBerlinClockOutput = "O\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO";
		assertThat(clock.getTime()).isEqualTo(theExpectedBerlinClockOutput);
	}

}
