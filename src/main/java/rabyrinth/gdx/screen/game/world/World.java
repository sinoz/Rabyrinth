package rabyrinth.gdx.screen.game.world;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.common.collect.ImmutableMap;
import rabyrinth.gdx.asset.Avatars;
import rabyrinth.gdx.asset.Queens;
import rabyrinth.gdx.screen.game.world.frame.FrameSet;

/** @author Sino */
public final class World implements Disposable {
	private TiledMap tiledMap;

	private final Viewport viewport;

	private final OrthographicCamera camera;
	private final BatchTiledMapRenderer renderer;

	private final Entity avatar;
	private final Entity queen;

	private final Animation<TextureRegion> downAnimation;
	private final Animation<TextureRegion> upAnimation;
	private final Animation<TextureRegion> leftAnimation;
	private final Animation<TextureRegion> rightAnimation;

	private float stateTime;

	/** Simple flag to decide whether this world should be rendered or not. */
	private boolean mayRender;

	/** Creates a new {@link World}. */
	public World(AssetManager assets) {
		float appWidth = Gdx.graphics.getWidth();
		float appHeight = Gdx.graphics.getHeight();
		if (Gdx.app.getType() == Application.ApplicationType.Android) {
			appWidth = 640;
			appHeight = 480;
		}

		camera = new OrthographicCamera();
		camera.setToOrtho(false, appWidth, appHeight);

		if (Gdx.app.getType() == Application.ApplicationType.Android) {
			viewport = new FitViewport(appWidth, appHeight, camera);
		} else {
			viewport = new ScreenViewport(camera);
		}

		/* Map */
		tiledMap = new TmxMapLoader().load("resources/maps/tmx/levels/1.tmx");
		renderer = new OrthogonalTiledMapRenderer(tiledMap);

		/* Avatar */
		TextureAtlas avatarAtlas = assets.get(Avatars.KNUCKLES);

		Array<TextureAtlas.AtlasRegion> avatarDownFrames = avatarAtlas.findRegions("down");
		Array<TextureAtlas.AtlasRegion> avatarUpFrames = avatarAtlas.findRegions("up");
		Array<TextureAtlas.AtlasRegion> avatarLeftFrames = avatarAtlas.findRegions("left");
		Array<TextureAtlas.AtlasRegion> avatarRightFrames = avatarAtlas.findRegions("right");

		FrameSet avatarFrames = new FrameSet(ImmutableMap.<Direction, Array<TextureAtlas.AtlasRegion>>builder()
				.put(Direction.SOUTH, avatarDownFrames)
				.put(Direction.NORTH, avatarUpFrames)
				.put(Direction.EAST, avatarRightFrames)
				.put(Direction.WEST, avatarLeftFrames)
				.build());

		downAnimation = new Animation<TextureRegion>(0.25F, avatarDownFrames, Animation.PlayMode.LOOP);
		upAnimation = new Animation<TextureRegion>(0.25F, avatarUpFrames, Animation.PlayMode.LOOP);
		rightAnimation = new Animation<TextureRegion>(0.25F, avatarRightFrames, Animation.PlayMode.LOOP);
		leftAnimation = new Animation<TextureRegion>(0.25F, avatarLeftFrames, Animation.PlayMode.LOOP);

		avatar = new Entity(this, avatarFrames);

		/* Queen */
		TextureAtlas queenAtlas = assets.get(Queens.KNUCKLES_QUEEN);

		Array<TextureAtlas.AtlasRegion> queenDownFrames = queenAtlas.findRegions("down");
		FrameSet queenFrames = new FrameSet(ImmutableMap.<Direction, Array<TextureAtlas.AtlasRegion>>builder()
				.put(Direction.SOUTH, queenDownFrames)
				.build());

		queen = new Entity(this, queenFrames);
	}

	/** Updates the world and its subordinates. */
	public void update(float deltaTime) {
		avatar.update(deltaTime);
		queen.update(deltaTime);

		stateTime += deltaTime;

		if (avatar.currentDirection == Direction.SOUTH) {
			avatar.getSprite().setRegion(downAnimation.getKeyFrame(stateTime));
		} else if (avatar.currentDirection == Direction.NORTH) {
			avatar.getSprite().setRegion(upAnimation.getKeyFrame(stateTime));
		} else if (avatar.currentDirection == Direction.EAST) {
			avatar.getSprite().setRegion(rightAnimation.getKeyFrame(stateTime));
		} else if (avatar.currentDirection == Direction.WEST) {
			avatar.getSprite().setRegion(leftAnimation.getKeyFrame(stateTime));
		}

		camera.update();
	}

	/** Draws the world and its subordinates. */
	public void render(float deltaTime) {
		if (mayRender) {
			// renders the map using the camera coordinate system
			renderer.setView(camera);
			renderer.render();

			// draws the entities onto the sprite batch of the map renderer
			renderer.getBatch().begin();
			avatar.draw(renderer.getBatch());
			queen.draw(renderer.getBatch());
			renderer.getBatch().end();
		}
	}

	/** Enables rendering of the game world. */
	public void show() {
		mayRender = true;
	}

	/** Disables rendering of the game world. */
	public void hide() {
		mayRender = false;
	}

	/** Reacts to a resize event, properly scaling the world. */
	public void resize(int width, int height) {
		viewport.update(width, height, false);
	}

	@Override
	public void dispose() {
		tiledMap.dispose();
		renderer.dispose();
		avatar.dispose();
	}

	public int getTileWidth() {
		return tiledMap.getTileSets().getTileSet(0).getProperties().get("tilewidth", Integer.class);
	}

	public int getTileHeight() {
		return tiledMap.getTileSets().getTileSet(0).getProperties().get("tileheight", Integer.class);
	}

	public int getMapWidth() {
		return tiledMap.getProperties().get("width", Integer.class);
	}

	public int getMapHeight() {
		return tiledMap.getProperties().get("height", Integer.class);
	}

	public TiledMap getTiledMap() {
		return tiledMap;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public BatchTiledMapRenderer getRenderer() {
		return renderer;
	}

	public Entity getAvatar() {
		return avatar;
	}

	public Entity getQueen() {
		return queen;
	}
}
