package hridoy.aiz.serviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivPlayStop;
    String audiolink = "https://dl.dropboxusercontent.com/s/5ey5xwb7a5ylqps/game_of_thrones.mp3?dl=0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPlayStop = (ImageView) findViewById(R.id.ivPlayStop);
        ivPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
