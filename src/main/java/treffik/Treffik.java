package treffik;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/** @author I.A */
public final class Treffik {
	/** The title of this game application. */
	public static final String TITLE = "tReffik";

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = TITLE;
		config.width = 800;
		config.height = 600;
		config.resizable = true;

		new LwjglApplication(new TreffikListener(), config);
	}
}
