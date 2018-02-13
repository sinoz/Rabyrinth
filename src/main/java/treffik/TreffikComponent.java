package treffik;

import com.badlogic.gdx.utils.Disposable;

/** @author I.A */
public interface TreffikComponent extends Disposable {
	void update(float deltaTime);

	void render(float deltaTime);

	void resize(int width, int height);

	void pause();

	void resume();
}
