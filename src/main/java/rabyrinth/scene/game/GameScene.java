package rabyrinth.scene.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import rabyrinth.scene.Scene;
import rabyrinth.scene.game.world.World;
import rabyrinth.scene.game.world.map.MapController;

/** @author I.A */
public final class GameScene implements Scene {
	/** The skin assets. */
	private final Skin skin = new Skin(new FileHandle("resources/ui/uiskin.json"));

	/** The user interface for this game scene. */
	private final GameInterface gameInterface;

	/** The camera. */
	private final OrthographicCamera camera;

	/** The game world. */
	private final World world;

	/** Creates a new {@link GameScene}. */
	public GameScene(Stage stage) {
		this.gameInterface = new GameInterface(skin, stage);

		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		this.world = new World(camera);
	}

	@Override
	public void update(float deltaTime) {
		world.update(deltaTime);
	}

	@Override
	public void render(float deltaTime) {
		world.render(deltaTime);
	}

	@Override
	public void pause() {
		// TODO
	}

	@Override
	public void hide() {
		gameInterface.hide();
	}

	@Override
	public void show() {
		gameInterface.show();
	}

	@Override
	public void resume() {
		// TODO
	}

	@Override
	public void resize(int width, int height) {
		// TODO
	}

	@Override
	public void dispose() {
		gameInterface.dispose();
		world.dispose();
	}
}
