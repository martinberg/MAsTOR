package ruvar.sig.mastor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;
import android.media.AudioManager;
import android.content.Context;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    int tot = 10;

    public void onBackPressed(){
        if(count == tot){
            count=0;
            finish();
            System.exit(0);
        } else {
            Toast.makeText(getApplicationContext(), "Klicka bakåt " + (tot - count) + " gånger.", Toast.LENGTH_SHORT).show();
            count++;
        }
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startar videon
        VideoView videoView = (VideoView)findViewById(R.id.videoView);
        String path = "android.resource://ruvar.sig.mastor/" + R.raw.mastor_full;
        videoView.setVideoPath(path);
        videoView.start();

        //sätt mediavolymen
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxvolym = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,maxvolym,0);

        //loopa videon
        videoView.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);

            }
        });


        /*
        funkar ej ännu
        onBackPressed();*/
    }
}
