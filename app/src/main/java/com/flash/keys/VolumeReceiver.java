package com.flash.keys;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.os.Handler;

import java.util.Objects;

public class VolumeReceiver extends BroadcastReceiver {

    static boolean genesis;

    @Override
    public void onReceive(final Context context, Intent intent) {

        final CameraManager camManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        final String[] cameraId = {null};
        assert camManager != null;

        AudioManager manager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        if (Objects.equals(intent.getAction(), "android.media.VOLUME_CHANGED_ACTION") && (manager != null
                && !manager.isMusicActive()) && genesis) {

            try {
                cameraId[0] = camManager.getCameraIdList()[0];
                camManager.setTorchMode(cameraId[0], true);
                genesis = false;
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            if (!genesis) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        try {
                            cameraId[0] = camManager.getCameraIdList()[0];
                            camManager.setTorchMode(cameraId[0], false);
                            genesis = true;
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }, 30000);
            }
        }
    }
}