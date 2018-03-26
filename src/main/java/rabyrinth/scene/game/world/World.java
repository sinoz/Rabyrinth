package rabyrinth.scene.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import rabyrinth.RabyrinthComponent;

/** @author I.A */
public final class World implements RabyrinthComponent {
	TiledMap tiledMap;
	OrthographicCamera camera;
	BatchTiledMapRenderer renderer;
	Sprite avatar;

	/** Creates a new {@link World}. */
	public World(InputMultiplexer multiplexer) {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		camera.update();

		tiledMap = new TmxMapLoader().load("resources/maps/tmx/orthogonal.tmx");
		renderer = new OrthogonalTiledMapRenderer(tiledMap);

		avatar = new Sprite(new Texture(Gdx.files.internal("resources/knuckles.png")));

		multiplexer.addProcessor(new WorldInputProcessor(this));
	}

	@Override
	public void update(float deltaTime) {
		camera.update();
	}

	@Override
	public void render(float deltaTime) {
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// renders the map using the camera coordinate system
		renderer.setView(camera);
		renderer.render();

		// draws the avatar's knuckles sprite onto the sprite batch of the map renderer
		renderer.getBatch().begin();
		avatar.draw(renderer.getBatch());
		renderer.getBatch().end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
