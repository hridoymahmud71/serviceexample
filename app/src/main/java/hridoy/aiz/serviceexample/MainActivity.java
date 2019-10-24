package hridoy.aiz.serviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MusicStoppedListener {

    ImageView ivPlayStop;
    String audiolink = "https://dl.dropboxusercontent.com/s/5ey5xwb7a5ylqps/game_of_thrones.mp3?dl=0";
    boolean musicPlaying = false;
    Intent serviceIntent;
    private MusicStoppedListener musicStoppedListener;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPlayStop = (ImageView) findViewById(R.id.ivPlayStop);
        ivPlayStop.setImageResource(R.mipmap.play);

        serviceIntent = new Intent(this, HridoyPlayService.class);

        ivPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!musicPlaying) {
                    playAudio();
                    ivPlayStop.setImageResource(R.mipmap.stop);
                    musicPlaying = true;
                } else {
                    stopPlayService();
                    ivPlayStop.setImageResource(R.mipmap.play);
                    musicPlaying = false;
                }
            }
        });
    }

    private void stopPlayService() {
        try {
            stopService(serviceIntent);
        } catch (SecurityException e) {
            Toast.makeText(this, "Error :" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void playAudio() {
        serviceIntent.putExtra("AudioLink", audiolink);

        serviceIntent.setAction(android.content.Intent.ACTION_VIEW);
        serviceIntent.setDataAndType(Uri.parse(audiolink), "audio/*");

        try {
            startService(serviceIntent);
        } catch (SecurityException e) {
            Toast.makeText(this, "Error :" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onMusicStopped() {
        ivPlayStop.setImageResource(R.mipmap.play);
        musicPlaying = false;
    }
}
