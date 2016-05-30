package app_music;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.tritonus.share.sampled.file.TAudioFileFormat;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author billd
 */
public class Testplay {

    public long pauselocation;
    public long totallong;
    public String link;
    public static int begin;
    public static int end;
    public static Player player = null;
    private BufferedInputStream BIS;
    private Thread threadsong;

    public void play(String psong) {
        try {
            link = psong;
            BIS = new BufferedInputStream(new URL(link).openStream());
            //player = new AdvancedPlayer(BIS);
            player = new Player(BIS);
            totallong = BIS.available();
            System.out.println("totallong: " + totallong);
            System.out.println("link: "+ link);

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
        threadsong = new Thread(){
            @Override
            public void run() {
                super.run(); //To change body of generated methods, choose Tools | Templates.
                try {
                    player.play();
                    
                } catch (JavaLayerException ex) {
                    Logger.getLogger(Testplay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        };
        threadsong.start();
    }

    public void pause() {
        if (player != null) {
            try {
                pauselocation = BIS.available();
                //player.close();
                threadsong.suspend();
                System.out.println("pauselocaeion: " + pauselocation);
                //System.out.println("time: " + time);
            } catch (IOException ex) {
                Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public void resume() {
        threadsong.resume();
    }

    public void Stop() {
        if (player != null) {
            player.close();
            totallong = 0;
            pauselocation = 0;
            Player_Music.haspause = false;
            Player_Music.playing = false;
            Player_Music.btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Play-icon.png")));
        }
    }
    
    private static long getDurationWithMp3Spi(File file) throws UnsupportedAudioFileException, IOException {
        Long microseconds;
        int mili;
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
        if (fileFormat instanceof TAudioFileFormat) {
            Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
            String key = "duration";
            microseconds = (Long) properties.get(key);
            mili = (int) (microseconds / 1000);
            int sec = (mili / 1000) % 60;
            int min = (mili / 1000) / 60;
            System.out.println("time = " + min + ":" + sec);

        } else {
            throw new UnsupportedAudioFileException();
        }
        return mili;

    }

}
