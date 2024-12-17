package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
    GamePanel gp;

    public Config(GamePanel gp) {
        this.gp = gp;
    }

    public void saveConfig() {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"));
            // FULLSCREEN
            // LEAVE BLANK FOR NOW SINCE HINDE PA NAMAN NEEDED

            // MUSIC VOL
            bw.write(String.valueOf(gp.music.volumeScale));
            bw.newLine();

            // SFX VOL
            bw.write(String.valueOf(gp.SFX.volumeScale));
            bw.newLine();

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadConfig() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));

            // MUSIC
            String s = br.readLine();
            gp.music.volumeScale = Integer.parseInt(s);

            // SFX
            s = br.readLine();
            gp.SFX.volumeScale = Integer.parseInt(s);

            br.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
