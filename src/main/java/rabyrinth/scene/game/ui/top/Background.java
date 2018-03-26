package rabyrinth.scene.game.ui.top;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public final class Background extends Table {
	public Background(Skin skin) {
		super(skin);

		setBackground("default-background");

		add(new ExitButton(skin)).left();
		add(new SoundToggle(skin));
		add(new LevelDisplay(1, skin));
	}
}
