package run.sid.sd;

import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import android.view.SurfaceView;

import run.sid.sd.SnapDragons;

public class AndroidLauncher extends AndroidApplication {
    private View view;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.r = config.g = config.b = config.a = 8;
        view = initializeForView(new SnapDragons(), config);


        //initialize(new SnapDragons(), config);
        if (graphics.getView() instanceof SurfaceView) {
            GLSurfaceView glView = (GLSurfaceView) graphics.getView();
            glView.setZOrderOnTop(true);
            glView.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            glView.getHolder().setFormat(PixelFormat.RGBA_8888);
        }


        this.addContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

	public void post(Runnable r){
		handler.post(r);
	}




}
