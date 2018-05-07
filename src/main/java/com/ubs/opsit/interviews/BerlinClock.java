package com.ubs.opsit.interviews;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BerlinClock implements TimeConverter {

	private Lamp topRowSecondsLamp;
	final private List<Lamp> firstRowHourLamp = new ArrayList<Lamp>(4);
	final private List<Lamp> secondRowHourLamp = new ArrayList<Lamp>(4);
	final private List<Lamp> firstRowMinLamp = new ArrayList<Lamp>(11);
	final private List<Lamp> secondRowMinLamp = new ArrayList<Lamp>(4);

	final private static int noOfLampsInHourFirstRow = 4;
	final private static int noOfLampsInMinFirstRow = 11;
	final private static int valueOfLampsInHourFirstRow = 5;
	final private static int valueOfLampsInMinFirstRow = 5;
	final private static String timeSeparator = ":";
	final private static String CLRF = "\r\n";

	public BerlinClock() {
		this.topRowSecondsLamp = new Lamp(Color.YELLOW);
		for (int i = 0; i < noOfLampsInHourFirstRow; i++) {
			this.firstRowHourLamp.add(new Lamp(Color.RED));
			this.secondRowHourLamp.add(new Lamp(Color.RED));
			this.secondRowMinLamp.add(new Lamp(Color.YELLOW));
		}
		for (int i = 0; i < noOfLampsInMinFirstRow; i++) {
			if ((i + 1) % 3 == 0) {
				this.firstRowMinLamp.add(new Lamp(Color.RED));
			} else {
				this.firstRowMinLamp.add(new Lamp(Color.YELLOW));
			}
		}
	}

	private void updateLampState(List<Lamp> lamps, Integer noOfLampsToLightenUp) {
		for (int i = 0; i < noOfLampsToLightenUp; i++) {
			lamps.get(i).setState(State.ON);
		}
	}

	@Override
	public String convertTime(String aTime) {
		String[] time = aTime.split(timeSeparator);
		validateTime(time);
		if (Integer.parseInt(time[2]) % 2 == 0) {
			this.topRowSecondsLamp.setState(State.ON);
		}
		updateLampState(this.firstRowHourLamp, Integer.parseInt(time[0]) / valueOfLampsInHourFirstRow);
		updateLampState(this.secondRowHourLamp, Integer.parseInt(time[0]) % valueOfLampsInHourFirstRow);
		updateLampState(this.firstRowMinLamp, Integer.parseInt(time[1]) / valueOfLampsInMinFirstRow);
		updateLampState(this.secondRowMinLamp, Integer.parseInt(time[1]) % valueOfLampsInMinFirstRow);
		return getTime();
	}

	private void validateTime(String[] time) {
		try {
			Integer seconds = Integer.parseInt(time[2]);
			Integer hour = Integer.parseInt(time[0]);
			Integer min = Integer.parseInt(time[1]);
			if (time.length != 3) {
				throw new IllegalArgumentException("Time format is not correct");
			}
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("Time format is not correct");
		}
	}

	public String getTime() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.topRowSecondsLamp.toString()).append(CLRF);
		this.firstRowHourLamp.stream().forEach(lamp -> sb.append(lamp.toString()));
		sb.append(CLRF);
		this.secondRowHourLamp.stream().forEach(lamp -> sb.append(lamp.toString()));
		sb.append(CLRF);
		this.firstRowMinLamp.stream().forEach(lamp -> sb.append(lamp.toString()));
		sb.append(CLRF);
		this.secondRowMinLamp.stream().forEach(lamp -> sb.append(lamp.toString()));
		return sb.toString();
	}
}
