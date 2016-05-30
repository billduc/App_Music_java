/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_music;

import static app_music.Player_Music.btn_play;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.tritonus.share.sampled.file.TAudioFileFormat;

/**
 *
 * @author billd
 */
public class getMusic {

    FileInputStream FIS;
    BufferedInputStream BIS;

    public BasicPlayer bsplayer;
    public Player player;
    public long pauselocation;
    public long totallong;
    public String filelocal;
    public static int begin;
    public static int end;
    public long time;
    public int daphat;

    public getMusic() {
        bsplayer = new BasicPlayer();
    }

    public void bsplay(String path) {
        File f = new File(path);
        try {
            bsplayer.open(f);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void Pause() {
        if (player != null) {
            try {
                pauselocation = FIS.available();
                player.close();
            } catch (IOException ex) {
                Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void play(String path) {
        try {
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);

            player = new Player(BIS);

            try {
                time = getDurationWithMp3Spi(new File(path));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
            }

            totallong = FIS.available();
            filelocal = path + "";

        } catch (FileNotFoundException ex) {
            Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
        }

        new Thread() {
            @Override
            public void run() {
                super.run(); //To change body of generated methods, choose Tools | Templates.
                int sec = (int) (time / 1000);
                int d = sec / 100;
                daphat = 0;
                int pro = 1;
                for(int i = 0; i< sec ;++i){
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (i == daphat)
                    {
                        Player_Music.jProgressBar1.setValue(pro);
                        pro++;
                        daphat+=d;
                    }
                }
               
                //this.setPriority(1);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    super.run(); //To change body of generated methods, choose Tools | Templates.
                    player.play();

                    if (player.isComplete()) {
                        totallong = 0;
                        pauselocation = 0;
                        Player_Music.haspause = false;
                        Player_Music.playing = false;
                        Player_Music.btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Play-icon.png")));
                    }
                } catch (JavaLayerException ex) {
                    Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
                }
                //this.setPriority(2);
            }

        }.start();

    }

    public void resume() {
        try {
            FIS = new FileInputStream(filelocal);
            BIS = new BufferedInputStream(FIS);
            FIS.skip(totallong - pauselocation);
            player = new Player(BIS);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    super.run(); //To change body of generated methods, choose Tools | Templates.

                    player.play();
                    if (player.isComplete()) {
                        totallong = 0;
                        pauselocation = 0;
                        Player_Music.haspause = false;
                        Player_Music.playing = false;
                        Player_Music.btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Play-icon.png")));
                    }

                } catch (JavaLayerException ex) {
                    Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.start();

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
