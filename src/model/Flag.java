package model;

public class Flag {
	
	private final String ESC   	= "\u001b[";

	
	private int sleep;
	private int width;
	private int max;
	private boolean mode;

	public synchronized String printFlagPortion (int color) {
		return ESC + color + "m";
	}
}
