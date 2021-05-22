package ui;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import model.Flag;
import thread.ColorPrinterThread;

public class ConsoleLineInterface {
	private final String ESC = "\u001b[";
	final int YELLOW = 43;
	final int BLUE = 44;
	final int RED = 41;
	
	ColorPrinterThread yellowPortion;
	ColorPrinterThread bluePortion;
	ColorPrinterThread redPortion;
	Flag flag;
	
	BufferedWriter bw;
	
	public ConsoleLineInterface () {
		flag = new Flag ();
		bw = new BufferedWriter (new OutputStreamWriter (System.out));
		yellowPortion = new ColorPrinterThread (flag, YELLOW, 5, 10, 120, 0, this);
		bluePortion = new ColorPrinterThread (flag, BLUE, 15, 5, 120, 10, this);
		redPortion = new ColorPrinterThread (flag, RED, 20, 5, 120, 15, this);

	}
	
	public void startProgram () {
		yellowPortion.start();
		bluePortion.start();
		redPortion.start();
	}
	
	public synchronized void updateUI (String message, int x, int y) throws IOException {
		bw.write(ESC + x + "G" + ESC + y +"d");
		bw.write(message);
		bw.flush();
	}
	
	public void clearInterface () throws IOException {
		bw.write(ESC + "2J");
		bw.flush();
	}
	
	public void positionCursor (int x, int y) throws IOException {
		bw.write(ESC + x + "G" + ESC + y + "d");
		bw.flush();
	}
	
}
