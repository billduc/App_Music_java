/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_music;

import static app_music.Player_Music.btn_play;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author billd
 */

public class getMusic 
{
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player player;
    public long pauselocation;
    public long totallong;
    public String filelocal;
    
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
    
    public void Pause(){
        if (player != null){
            try {
                pauselocation =  FIS.available();
                player.close();
            } catch (IOException ex) {
                Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void play(String path){
        try {
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            
            totallong = FIS.available();
            filelocal = path + "";
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Thread(){
            @Override
            public void run() {
                try {
                    super.run(); //To change body of generated methods, choose Tools | Templates.
                    player.play();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }.start();
        
    }
    
     public void resume(){
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
        
        new Thread(){
            @Override
            public void run() {
                try {
                    super.run(); //To change body of generated methods, choose Tools | Templates.
                    player.play();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(getMusic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }.start();
        
    }
}