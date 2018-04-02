package rabyrinth.gdx.screen.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.asset.Skins;
import rabyrinth.gdx.screen.event.ActivateButtonClickedListener;
import rabyrinth.gdx.screen.event.QueenReachedListener;
import rabyrinth.gdx.screen.event.SelectedInstructionListener;
import rabyrinth.gdx.screen.game.ui.side.SideBackground;
import rabyrinth.gdx.screen.game.ui.top.TopBackground;
import rabyrinth.gdx.screen.game.world.World;

import java.util.ArrayDeque;
import java.util.Deque;

/** @author Sino */
public final class GameScreen implements Screen {
	/** The queue of {@link InstructionType}s to perform. */
	private final Deque<InstructionType> instructionQueue = new ArrayDeque<InstructionType>(16);

	/** The event bus to publish user interface events onto. */
	private final EventBus eventBus;

	/** Manages assets. */
	private final AssetManager assets;

	/** The user interface table for this game scene to add components to. */
	private final Table table;

	/** The stage to add user interface components onto. */
	private final Stage stage;

	/** The game world. */
	private final World world;

	/** The top and side elements. */
	private final SideBackground sideBackground;
	private final TopBackground topBackground;

	/** Creates a new {@link GameScreen}. */
	public GameScreen(Stage stage, AssetManager assets, EventBus eventBus) {
		Skin skin = assets.get(Skins.DEFAULT);

		this.stage = stage;
		this.assets = assets;

		this.eventBus = eventBus;

		this.table = new Table(skin);
		this.world = new World(assets, eventBus);

		this.sideBackground = new SideBackground(skin, eventBus);
		this.topBackground = new TopBackground(skin, eventBus);

		configureTable();
		subscribeListeners();
	}

	private void subscribeListeners() {
		eventBus.register(new ActivateButtonClickedListener(sideBackground.getJournal(), world, instructionQueue));
		eventBus.register(new SelectedInstructionListener(sideBackground.getJournal(), instructionQueue));
		eventBus.register(new QueenReachedListener(this, assets));
	}

	/** Configures the {@link GameScreen#table}. */
	private void configureTable() {
		table.setFillParent(true);

		table.add(topBackground)
				.prefHeight(96F)
				.top()
				.left()
				.expandX()
				.fillX();

		table.add(sideBackground)
				.prefWidth(250F)
				.top()
				.right()
				.expandY()
				.fillY();

		stage.addActor(table);
	}

	@Override
	public void hide() {
		table.setVisible(false);
		world.hide();
	}

	@Override
	public void show() {
		table.setVisible(true);
		world.show();
	}

	@Override
	public void render(float deltaTime) {
		world.update(deltaTime);
		world.render(deltaTime);

		stage.act(deltaTime);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		world.resize(width, height);
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {
		// TODO
	}

	@Override
	public void resume() {
		// TODO
	}

	@Override
	public void dispose() {
		world.dispose();
	}

	public World getWorld() {
		return world;
	}

	public SideBackground getSideBackground() {
		return sideBackground;
	}

	public TopBackground getTopBackground() {
		return topBackground;
	}
}
