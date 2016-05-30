package app_music;


import java.io.BufferedInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;


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
    public String filelocal;
    public static int begin;
    public static int end;
    public static AdvancedPlayer player = null;
    
    public void play(String psong) {
            try {
                String song = psong;
                BufferedInputStream in = new BufferedInputStream(new URL(song).openStream());
                player = new AdvancedPlayer(in);
                player.play();
                
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
    }
    
    public void Stop(){
        if (player != null){
            player.close();
            totallong = 0;
            pauselocation = 0;
            Player_Music.haspause=false;
            Player_Music.playing=false;
            Player_Music.btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Play-icon.png")));
        }
    }
    
}
