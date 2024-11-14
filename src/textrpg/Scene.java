package textrpg;

public abstract class Scene {
	private final int prevSceneNum;
	private SceneManager scene;
	
	public Scene(int sceneNumber) {
		this.prevSceneNum = sceneNumber;
		scene = SceneManager.getInstance();
	}
	
	abstract public void update();
	
	public void movePrevScene () {
		scene.changeScene(prevSceneNum);
	}
}
