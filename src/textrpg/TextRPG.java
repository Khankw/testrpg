package textrpg;

public class TextRPG {
	private TextRPG() {
	}

	private static TextRPG instance = new TextRPG();

	public static TextRPG getInstance() {
		return instance;
	}
	
	private SceneManager scene;
	private InputManager input;
	private Thread sceneThread;
	private Thread inputThread;
	
	public void run() {
		init();
		play();
	}
	
	private void init() {
		scene = SceneManager.getInstance();
		input = InputManager.getInstance();
		sceneThread = new Thread(scene); 
		inputThread = new Thread(input); 
	}

	private void play() {
		sceneThread.start();
		inputThread.start();
	}
	
	public void exit() {
		sceneThread.interrupt();
		inputThread.interrupt();
	}
}
