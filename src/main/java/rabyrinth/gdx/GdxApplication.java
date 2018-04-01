package rabyrinth.gdx;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/** @author Sino */
public final class GdxApplication {
	/** The title of this game application. */
	public static final String TITLE = "Rabyrinth";

	/** Indicates whether this application is in debug mode. */
	public static final boolean DEBUG_MODE = false;

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = TITLE;
		config.width = 800;
		config.height = 600;
		config.resizable = true;

		new LwjglApplication(new GdxGame(), config);
	}
}
