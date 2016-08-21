package ruvar.sig.mastor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;
import android.media.AudioManager;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startar videon
        VideoView videoView = (VideoView)findViewById(R.id.videoView);
        String path = "android.resource://ruvar.sig.mastor/" + R.raw.mastor;
        videoView.setVideoPath(path);
        videoView.start();

        //sätt mediavolymen
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxvolym = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,maxvolym,0);
    }
}
