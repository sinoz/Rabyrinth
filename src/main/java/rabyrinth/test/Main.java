package rabyrinth.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import rabyrinth.Rabyrinth;

/** @author Sino */
public final class Main {
	/** The title of this game application. */
	public static final String TITLE = "Rabyrinth";

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = TITLE;
		config.width = 800;
		config.height = 600;
		config.resizable = true;

		new LwjglApplication(new Rabyrinth(), config);
	}
}
