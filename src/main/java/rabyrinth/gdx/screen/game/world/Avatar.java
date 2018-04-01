package rabyrinth.gdx.screen.game.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;

/** @author Sino */
public final class Avatar implements Disposable {
	/** The game world this avatar is currently on. */
	private final World world;

	/** The sprite for this avatar. */
	private final Sprite sprite;

	/** Creates a new {@link Avatar}. */
	public Avatar(World world, Texture texture) {
		this.world = world;
		this.sprite = new Sprite(texture);
	}

	/** Moves this avatar to the specified tile coordinates. */
	public void moveTo(float tileX, float tileY) {
		if (tileX < 0 || tileX >= world.getMapWidth()) {
			return;
		}

		if (tileY < 0 || tileY >= world.getMapHeight()) {
			return;
		}

		sprite.setPosition(tileX * world.getTileWidth(), tileY * world.getTileHeight());
	}

	/** Updates this avatar. */
	public void update() {
		// TODO
	}

	/** Draws this avatar. */
	public void draw(Batch batch) {
		sprite.draw(batch);
	}

	@Override
	public void dispose() {
		sprite.getTexture().dispose();
	}

	public float getTileX() {
		return sprite.getX() / world.getTileWidth();
	}

	public float getTileY() {
		return sprite.getY() / world.getTileHeight();
	}
}
