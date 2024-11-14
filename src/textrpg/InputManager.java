package textrpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager extends Thread {
	private InputManager() {
	}

	private static InputManager instance = new InputManager();

	public static InputManager getInstance() {
		return instance;
	}

	private StringBuffer buffer = new StringBuffer();
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static String input = "";

	public void run() {
		while (true) {
			try {
				try {
					buffer.setLength(0);
					buffer.append(reader.readLine());
					input = buffer.toString();
					
					if(input.equals("exit")) {
System.out.println("인터럽틔 진입");
TextRPG.getInstance().exit();
//						interrupt();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				sleep(100);
			} catch (InterruptedException e) {
				System.out.println("인풋 인터럽트");
				break;
			}
		}
	}

	public static String getInput() {
		return input;
	}

	public static boolean isInput() {
		return !input.isBlank();
	}

}
