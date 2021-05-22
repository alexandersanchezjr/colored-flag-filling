package model;

public class Flag {
	
	private final String ESC = "\u001b[";

	public synchronized String printFlagPortion (int color) {
		return ESC + color + "m ";
	}
}