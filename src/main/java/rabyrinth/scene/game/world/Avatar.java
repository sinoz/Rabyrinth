package rabyrinth.scene.game.world;

import com.badlogic.gdx.Gdx;
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
	public Avatar(World world) {
		this.world = world;
		this.sprite = new Sprite(new Texture(Gdx.files.internal("resources/knuckles.png")));
	}

	/** Moves this avatar to the specified tile coordinates. */
	public void moveTo(float tileX, float tileY) {
		sprite.setPosition(tileX, tileY);
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
}