package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("/res/Sound/Adventure.wav");
        // palagyan sound
        /*
         * soundURL[0] = getClass().getResource("/res/Sound/Adventure.wav");
         */

        soundURL[1] = getClass().getResource("/res/Sound/DamMons.wav");
        soundURL[2] = getClass().getResource("/res/Sound/hurt.wav");
        soundURL[3] = getClass().getResource("/res/Sound/Swoosh.wav");
        soundURL[4] = getClass().getResource("/res/Sound/coin.wav");

    }

    public void setFile(int i) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {

        }
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }

    public void play() {
        clip.start();
    }
}
