package thread;

import model.Flag;

public class ColorPrinterThread extends Thread{
	private final String ESC   	= 	"\u001b[";
	private final String UP    	= 	ESC + "A";
	private final String DOWN  	= 	ESC + "B";
	private final String RIGHT 	= 	ESC + "C"; 
	
	private Flag flag;
	
	private int sleep;
	private int width;
	private int max;
	private boolean mode;
	private int color;
	
	private String printedFlag;
	
	public ColorPrinterThread (Flag flag, int color, int sleep, int width, int max) {
		this.flag = flag;
		this.color = color;
		this.sleep = sleep;
		this.width = width;
		this.max = max;
	}
	
	public void printFlag () {
		printedFlag += ESC+"2J";
		printedFlag += ESC+"0G"+ESC+"0d";
//		printedFlag += ESC + color + "m";
		
		while (width < max) {
			
		}
	}
	
	public String getPrintedFlag () {
		return printedFlag;
	}
}
