package textrpg;

public abstract class Scene {
	private int foreSceneNumber;
	
	public Scene(int sceneNumber) {
		this.foreSceneNumber = sceneNumber;
	}
	
	abstract public void update();
}
