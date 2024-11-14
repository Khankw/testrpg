package textrpg;

import java.util.ArrayList;

public class SceneManager extends Thread {
	private SceneManager() {
	}

	private static SceneManager instance = new SceneManager();

	public static SceneManager getInstance() {
		return instance;
	}

	private ArrayList<Scene> scenes = new ArrayList<>();

	private int curSceneNumber = 0;

	private boolean isRun = true;

	public void run() {
		while (isRun) {
			if (scenes.size() > 0) {
				Scene scene = scenes.get(curSceneNumber);
				scene.update();
			}

			System.out.println("Scene");
			if (InputManager.isInput())
				System.out.println(InputManager.getInput());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("씬 인터럽트");
				break;
			}
		}
	}

	public void addScene(Scene scene) {
		scenes.add(scene);
	}

	public void changeScene(int sceneNum) {
		if (sceneNum < 0 || sceneNum >= scenes.size())
			return;

		curSceneNumber = sceneNum;
	}
}
