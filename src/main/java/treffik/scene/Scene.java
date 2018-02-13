package treffik.scene;

import com.badlogic.gdx.utils.Disposable;

/** @author I.A */
public interface Scene extends Disposable {
	void update(float deltaTime);

	void render(float deltaTime);

	void pause();

	void resume();

	void resize(int width, int height);
}
