package rabyrinth.scene.event;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import rabyrinth.Rabyrinth;
import rabyrinth.scene.level.LevelSelectScene;

/** @author Sino */
public final class StartButtonClickedListener {
	private final Rabyrinth rabyrinth;
	private final Stage stage;
	private final EventBus eventBus;

	public StartButtonClickedListener(Rabyrinth rabyrinth, Stage stage, EventBus eventBus) {
		this.rabyrinth = rabyrinth;
		this.stage = stage;
		this.eventBus = eventBus;
	}

	@Subscribe
	public void startButtonClicked(StartButtonClicked startButtonClicked) {
		rabyrinth.switchTo(new LevelSelectScene(stage, eventBus));
	}
}
