package rabyrinth.scene.game;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;
import rabyrinth.scene.Scene;
import rabyrinth.scene.game.event.ActivateButtonClickedListener;
import rabyrinth.scene.game.event.SelectedInstructionListener;
import rabyrinth.scene.game.world.World;

import java.util.ArrayDeque;
import java.util.Deque;

/** @author Sino */
public final class GameScene implements Scene {
	/** The skin assets. */
	private final Skin skin = new Skin(new FileHandle("resources/ui/uiskin.json"));

	/** The queue of {@link InstructionType}s to perform. */
	private final Deque<InstructionType> instructionQueue = new ArrayDeque<>(16);

	/** The event bus to publish user interface events onto. */
	private final EventBus eventBus;

	/** The user interface table for this game scene to add components to. */
	private final Table table;

	/** The stage to add user interface components onto. */
	private final Stage stage;

	/** The game world. */
	private final World world;

	/** The top and side elements. */
	private final rabyrinth.scene.game.ui.side.Background sideBackground;
	private final rabyrinth.scene.game.ui.top.Background topBackground;

	/** Creates a new {@link GameScene}. */
	public GameScene(Stage stage, InputMultiplexer multiplexer, EventBus eventBus) {
		this.stage = stage;

		this.eventBus = eventBus;

		this.table = new Table(skin);
		this.world = new World(multiplexer);

		this.sideBackground = new rabyrinth.scene.game.ui.side.Background(skin, eventBus);
		this.topBackground = new rabyrinth.scene.game.ui.top.Background(skin, eventBus);

		configureTable();
		subscribeListeners();
	}

	private void subscribeListeners() {
		eventBus.register(new ActivateButtonClickedListener(sideBackground.getJournal(), world, instructionQueue));
		eventBus.register(new SelectedInstructionListener(sideBackground.getJournal(), instructionQueue));
	}

	/** Configures the {@link GameScene#table}. */
	private void configureTable() {
		table.setFillParent(true);

		table.add(topBackground)
				.prefHeight(100F)
				.top()
				.left()
				.expandX()
				.fillX();

		table.add(sideBackground)
				.prefWidth(100F)
				.top()
				.right()
				.expandY()
				.fillY();

		stage.addActor(table);
	}

	@Override
	public void update() {
		world.update();
	}

	@Override
	public void render() {
		world.render();
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
	public void resize(int width, int height) {
		world.resize(width, height);
	}

	@Override
	public void dispose() {
		world.dispose();
	}
}
