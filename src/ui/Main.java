package ui;

public class Main {
	
	private static ConsoleLineInterface cli;

	public static void main(String[] args) throws InterruptedException {
		cli = new ConsoleLineInterface ();
		cli.startProgram();
	}

}
