package com.example.keht.sound;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;
    HashMap<Integer, Integer> soundPoolMap;
    int soundID = 1;
    Button sound1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(25)
                .setAudioAttributes(audioAttributes)
                .build();

        soundPoolMap = new HashMap<Integer, Integer>();
        soundPoolMap.put(soundID, soundPool.load(this, R.raw.beep, 1));

        sound1 = (Button) findViewById(R.id.sound);


        sound1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float leftVolume = curVolume/maxVolume;
                float rightVolume = curVolume/maxVolume;
                int priority = 1;
                int no_loop = 0;
                float normal_playback_rate = 1f;
                soundPool.play(soundPoolMap.get(soundID), leftVolume, rightVolume, priority, no_loop, normal_playback_rate);
            }
        });

    }
}
