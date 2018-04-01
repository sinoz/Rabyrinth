package rabyrinth.gdx.screen.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.EventBus;
import rabyrinth.gdx.asset.Avatars;
import rabyrinth.gdx.asset.Skins;
import rabyrinth.gdx.asset.Sounds;
import rabyrinth.gdx.event.AssetsLoaded;

/** @author Sino */
public final class LoadingScreen implements Screen {
	private final Stage stage;
	private final AssetManager assets;
	private final EventBus events;

	public LoadingScreen(Stage stage, AssetManager assets, EventBus eventBus) {
		this.stage = stage;
		this.assets = assets;
		this.events = eventBus;

		enqueueRequiredAssets();
	}

	private void enqueueRequiredAssets() {
		// skins
		assets.load(Skins.DEFAULT);

		// we really, really, REALLY need the skins to be loaded before showing the user
		// interface, so we wait for it to finish.
		assets.finishLoading();

		// the rest of resources are to be loaded while rendering the loading interface

		// avatar
		assets.load(Avatars.KNUCKLES);

		// sounds / Music
		assets.load(Sounds.CHAOS);
		assets.load(Sounds.DO_YOU_KNOW_THE_WAE);
		assets.load(Sounds.HE_DOES_NOT_KNOW_THE_WAE);
		assets.load(Sounds.MUSIC_THE_WAE);
		assets.load(Sounds.MY_BROS);
		assets.load(Sounds.ALSO_LOOKING_FOR_WAE);
		assets.load(Sounds.MUST_PRAY);
		assets.load(Sounds.YOU_DO_NOT_KNOW_THE_WAE);
		assets.load(Sounds.YOU_NEED_EBOLA);
	}

	@Override
	public void show() {
		// TODO
	}

	@Override
	public void render(float deltaTime) {
		// keep loading until all assets have been loaded
		if (assets.update()) {
			// now that all assets have been loaded, lets publish an event to possibly
			// trigger a screen switch (going from loading screen to the main menu)
			events.post(new AssetsLoaded());
		}

		stage.act(deltaTime);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {
		// TODO
	}

	@Override
	public void resume() {
		// TODO
	}

	@Override
	public void hide() {
		// TODO
	}

	@Override
	public void dispose() {
		// nothing
	}
}
