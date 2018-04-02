package rabyrinth.gdx;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/** @author Sino */
public final class DesktopLauncher { // TODO create core and desktop modules
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 800;
		config.height = 600;

		new LwjglApplication(new GdxGame(), config);
	}
}
