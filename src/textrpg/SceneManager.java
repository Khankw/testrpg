package textrpg;

import java.util.ArrayList;

public class SceneManager {
	private SceneManager() {}
	private static SceneManager instance = new SceneManager();
	public static SceneManager getInstance() {
		return instance;
	}
	
	private ArrayList<Scene> scenes=new ArrayList<>();
	
	private int curSceneNumber = 0;
	
	private boolean isRun =true;
	
	public void run() {
		while(isRun) {
			Scene scene =scenes.get(curSceneNumber);
			scene.update();
		}
	}
	
	public void addScene(Scene scene) {
		scenes.add(scene);
	}
	
	public void changeScene(int sceneNum) {
		if(sceneNum <0 || sceneNum >= scenes.size())
			return;
		
		curSceneNumber = sceneNum;
	}
}
