package run.sid.sd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SnapDragons extends ApplicationAdapter {
	Batch batch;
	Stage stage;
	Camera camera;
	Viewport viewport;
	ShapeRenderer shapeRenderer;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new StretchViewport(1920, 1080, camera);
		stage = new Stage(viewport);
		batch = stage.getBatch();
		shapeRenderer = new ShapeRenderer();

		Gdx.graphics.setContinuousRendering(false);
		Gdx.graphics.requestRendering();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().setWorldSize(1920, 1080);
		stage.getViewport().update(width, height, true);
		Gdx.graphics.requestRendering();
	}

	@Override
	public void render() {
		Gdx.gl20.glClearColor(0, 1, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		// draw whatever we have on the stage
		stage.draw();

		// draw red rectangle
		drawRect(10, 10, 1000, 1000);

		// draw a blue box
		fillRect(50, 50, 800, 800);

		// punch a hole in the surface (ie, clear an area) so that we can see the view that is
		// behind this view
		clearRect(200, 200, 1600, 600);
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

	public void drawRect(final int x, final int y, final int width, final int height) {
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.rect(x, y, width, height, Color.RED, Color.RED, Color.RED, Color.RED);
		shapeRenderer.end();
	}

	public void fillRect(final int x, final int y, final int width, final int height) {
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.rect(x, y, width, height, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE);
		shapeRenderer.end();
	}

	public void clearRect(final int x, final int y, final int width, final int height) {
//                Gdx.gl.glEnable(GL20.GL_BLEND);
//                Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);


		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.CLEAR);
		shapeRenderer.rect(x, y, width, height);
		shapeRenderer.end();

//                Gdx.gl.glDisable(GL20.GL_BLEND);
	}
}
