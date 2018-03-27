package rabyrinth.scene.game.world;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public final class WorldInputProcessor implements InputProcessor {
	private final World world;

	public WorldInputProcessor(World world) {
		this.world = world;
	}

	@Override
	public boolean keyDown(int i) {
		return false;
	}

	@Override
	public boolean keyUp(int i) {
		return false;
	}

	@Override
	public boolean keyTyped(char c) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Vector3 clickCoordinates = new Vector3(screenX, screenY,0);
		Vector3 position = world.getCamera().unproject(clickCoordinates);

		world.getAvatar().moveTo(position.x, position.y);

		return true;
	}

	@Override
	public boolean touchUp(int i, int i1, int i2, int i3) {
		return false;
	}

	@Override
	public boolean touchDragged(int i, int i1, int i2) {
		return false;
	}

	@Override
	public boolean mouseMoved(int i, int i1) {
		return false;
	}

	@Override
	public boolean scrolled(int i) {
		// TODO

		return false;
	}
}
