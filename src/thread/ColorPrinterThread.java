package thread;

import java.io.IOException;

import model.Flag;
import ui.ConsoleLineInterface;

public class ColorPrinterThread extends Thread{
	
	private Flag flag;
	
	private int sleep;
	private int height;
	private int max;
	private int color;
	private int x;
	private int y;
		
	private ConsoleLineInterface cli;
	
	public ColorPrinterThread (Flag flag, int color, int sleep, int height, int max, int initialRow, ConsoleLineInterface cli) {
		this.flag = flag;
		this.color = color;
		this.sleep = sleep;
		this.height = height;
		this.max = max;
		x = 1;
		y = initialRow;
		this.cli = cli;
	}
	
	@Override
	public void run() {
		try {
			printFlag();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printFlag () throws InterruptedException, IOException {
		cli.clearInterface();
		cli.positionCursor(x, y);
		int initialRow = y;
		
		int columns = 1;
		while (columns < max) {
			columns++;
			for (int i = 0; i < height; i++) {
				cli.updateUI(flag.printFlagPortion(color), x, y);
				Thread.sleep(sleep);
				y++;
			}
			x++;
			y = initialRow;
		}
	}

}
