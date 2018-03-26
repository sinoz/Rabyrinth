package rabyrinth.scene.game;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import rabyrinth.scene.Scene;
import rabyrinth.scene.game.ui.top.Background;
import rabyrinth.scene.game.world.World;

/** @author I.A */
public final class GameScene implements Scene {
	/** The skin assets. */
	private final Skin skin = new Skin(new FileHandle("resources/ui/uiskin.json"));

	/** The user interface table for this game scene to add components to. */
	private final Table table;

	/** The stage to add user interface components onto. */
	private final Stage stage;

	/** The game world. */
	private final World world;

	/** Creates a new {@link GameScene}. */
	public GameScene(Stage stage, InputMultiplexer multiplexer) {
		this.stage = stage;

		this.table = new Table(skin);
		this.world = new World(multiplexer);

		configureTable();
	}

	/** Configures the {@link GameScene#table}. */
	private void configureTable() {
		table.setFillParent(true);

		table.add(new rabyrinth.scene.game.ui.top.Background(skin))
				.prefHeight(100F)
				.top()
				.left()
				.expandX()
				.fillX();

		table.add(new rabyrinth.scene.game.ui.side.Background(skin))
				.prefWidth(100F)
				.top()
				.right()
				.expandY()
				.fillY();

		stage.addActor(table);
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
		table.setVisible(false);
	}

	@Override
	public void show() {
		table.setVisible(true);
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
		world.dispose();
	}
}
