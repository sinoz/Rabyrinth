package rabyrinth.scene.game.ui.top;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.google.common.eventbus.EventBus;

public final class Background extends Table {
	public Background(Skin skin, EventBus eventBus) {
		super(skin);

		setBackground("default-background");

		add(new ExitButton(skin, eventBus)).left();
		add(new SoundToggle(skin));
		add(new LevelDisplay(1, skin));
	}
}
