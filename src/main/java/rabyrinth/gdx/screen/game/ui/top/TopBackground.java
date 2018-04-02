package rabyrinth.gdx.screen.game.ui.top;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.GdxGame;

/** @author Sino */
public final class TopBackground extends Table {
	private final ObjectiveLabel objectiveLabel;

	public TopBackground(Skin skin, EventBus eventBus) {
		super(skin);

		setBackground("default-background");
		setDebug(GdxGame.DEBUG_MODE);

		objectiveLabel = new ObjectiveLabel(skin);

		add(new ExitButton(skin, eventBus)).expandX().left();
		add(new SoundToggle(skin)).expandX().center();
		add(new LevelDisplay(1, skin)).expandX().right().row();
		add(objectiveLabel).colspan(3).center();
	}

	public ObjectiveLabel getObjective() {
		return objectiveLabel;
	}
}
