package rabyrinth.scene;

import com.badlogic.gdx.utils.Disposable;

/** @author Sino */
public interface Scene extends Disposable {
	void update();

	void render();

	void hide();

	void show();

	void resize(int width, int height);
}
