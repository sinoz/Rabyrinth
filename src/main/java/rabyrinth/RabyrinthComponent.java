package rabyrinth;

import com.badlogic.gdx.utils.Disposable;

/** @author I.A */
public interface RabyrinthComponent extends Disposable {
	void update(float deltaTime);

	void render(float deltaTime);

	void resize(int width, int height);

	void show();

	void hide();

	void pause();

	void resume();
}
