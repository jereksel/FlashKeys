package com.flash.keys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean volumeReceiver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(Utils.tint(getColor(android.R.color.white)));

        final ImageView imageview = findViewById(R.id.imageView);

        if (!volumeReceiver) {
            imageview.setImageResource(R.drawable.off);
        }

        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (volumeReceiver) {
                    imageview.setImageResource(R.drawable.off);
                    volumeReceiver = false;
                    VolumeReceiver.genesis = false;
                } else {
                    imageview.setImageResource(R.drawable.on);
                    volumeReceiver = true;
                    VolumeReceiver.genesis = true;
                }
            }
        });
    }
}