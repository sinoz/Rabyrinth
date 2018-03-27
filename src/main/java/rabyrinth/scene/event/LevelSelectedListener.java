package rabyrinth.scene.event;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import rabyrinth.Rabyrinth;
import rabyrinth.scene.game.GameScene;

/** @author Sino */
public final class LevelSelectedListener {
	private final Rabyrinth rabyrinth;
	private final Stage stage;
	private final InputMultiplexer multiplexer;
	private final EventBus eventBus;

	public LevelSelectedListener(Rabyrinth rabyrinth, InputMultiplexer multiplexer, Stage stage, EventBus eventBus) {
		this.rabyrinth = rabyrinth;
		this.multiplexer = multiplexer;
		this.stage = stage;
		this.eventBus = eventBus;
	}

	@Subscribe
	public void levelSelected(LevelSelected levelSelected) {
		rabyrinth.switchTo(new GameScene(stage, multiplexer, eventBus));
	}
}
