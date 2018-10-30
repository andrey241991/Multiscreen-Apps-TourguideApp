package com.example.home_pc.tourguideapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home_pc.tourguideapp.entity.Place;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailedActivity extends AppCompatActivity {

    public static final String PLACE_KEY = "place key";
    private Place place;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    @BindView(R.id.txt_title) TextView txtTitle;
    @BindView(R.id.txt_description) TextView txtDescription;
    @BindView(R.id.image) ImageView image;
    @BindView(R.id.btn_volume_off) ImageButton btnVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        ButterKnife.bind(this);
        place = getIntent().getParcelableExtra(PLACE_KEY);
        initViews();
        mediaPlayer = MediaPlayer.create(this, R.raw.swag);
        startAudio();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

    }

    private void initViews() {
        txtTitle.setText(place.getName());
        txtDescription.setText(place.getDescription());
        image.setImageResource(place.getImage());
        btnVolume.setOnClickListener(v -> {
           if(mediaPlayer.isPlaying()){
              pauseAudio();
           }else{
              startAudio();
           }
        });
    }

    private void pauseAudio() {
        mediaPlayer.pause();
        btnVolume.setImageResource(R.drawable.ic_volume_on);
    }

    private void startAudio() {
        mediaPlayer.start();
        btnVolume.setImageResource(R.drawable.ic_volume_off);
    }

    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                pauseAudio();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                startAudio();
            }
        }
    };


    private void releaseAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseAudio();
    }
}
