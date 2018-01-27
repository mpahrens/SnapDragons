package run.sid.sd;

import android.graphics.PixelFormat;
import android.hardware.camera2.CameraDevice;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import android.view.SurfaceView;

import android.hardware.camera2.CameraManager;

import run.sid.sd.SnapDragons;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.r = 8;
		config.g = 8;
		config.b = 8;
		config.a = 8;
		if(graphics.getView() instanceof SurfaceView){
			SurfaceView glView = (SurfaceView) graphics.getView();
		  	glView.getHolder().setFormat(PixelFormat.TRANSLUCENT);
		}
        CameraManager cameraManager = getApplicationContext().getSystemService(CameraManager.class);
		initialize(new SnapDragons(), config);
	}

	public void post(Runnable r){
		handler.post(r);
	}




}
