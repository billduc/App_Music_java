/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_music;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author billd
 */
public class Player_Music extends javax.swing.JFrame implements BasicPlayerListener {

    /**
     * Creates new form Player_Music
     */
    private getFile getfile = new getFile();
    private processMussic player = new processMussic();
    private ArrayList<String> ListSong = new ArrayList<>();
    Timer timer = null;
    private getMusic MC = new getMusic();
    public static boolean playing;
    public static boolean haspause;
    int bai = -1;
    private ArrayList<String> listURL;
    private ArrayList<String> listName;
    private Boolean off;
    private Testplay play_onl = new Testplay();
    public static Thread queryThread;
    private getMussicJL bsplay = new getMussicJL();
    
    public Player_Music() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/music-1.png")).getImage());
        playing = false;
        haspause = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNameSong = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_left = new javax.swing.JButton();
        btn_play = new javax.swing.JButton();
        btn_right = new javax.swing.JButton();
        btn_stop = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btn_volume = new javax.swing.JButton();
        btn_mix = new javax.swing.JButton();
        btn_repeat = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSong = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btn_opent = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        inputNameSong_onl = new javax.swing.JTextField();
        btnSearch_onl = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setFocusable(false);

        txtNameSong.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtNameSong.setForeground(new java.awt.Color(0, 51, 255));
        txtNameSong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNameSong, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNameSong)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jProgressBar1.setForeground(new java.awt.Color(0, 0, 255));
        jProgressBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgressBar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_left.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Previous-icon.png"))); // NOI18N
        btn_left.setBorder(null);
        btn_left.setBorderPainted(false);
        btn_left.setContentAreaFilled(false);
        btn_left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_leftActionPerformed(evt);
            }
        });

        btn_play.setBackground(new java.awt.Color(255, 255, 255));
        btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Play-icon.png"))); // NOI18N
        btn_play.setBorder(null);
        btn_play.setBorderPainted(false);
        btn_play.setContentAreaFilled(false);
        btn_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_playActionPerformed(evt);
            }
        });

        btn_right.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Next-icon.png"))); // NOI18N
        btn_right.setBorder(null);
        btn_right.setBorderPainted(false);
        btn_right.setContentAreaFilled(false);
        btn_right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rightActionPerformed(evt);
            }
        });

        btn_stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Stop-icon (1).png"))); // NOI18N
        btn_stop.setBorder(null);
        btn_stop.setBorderPainted(false);
        btn_stop.setContentAreaFilled(false);
        btn_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btn_left)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_play)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_right)
                .addGap(18, 18, 18)
                .addComponent(btn_stop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_left)
                    .addComponent(btn_stop)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_play)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(btn_right))))
                .addGap(40, 40, 40))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_volume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Actions-player-volume-icon.png"))); // NOI18N
        btn_volume.setBorder(null);
        btn_volume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volumeActionPerformed(evt);
            }
        });

        btn_mix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/interface-7.png"))); // NOI18N
        btn_mix.setBorder(null);
        btn_mix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mixActionPerformed(evt);
            }
        });

        btn_repeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/interface-3.png"))); // NOI18N
        btn_repeat.setBorder(null);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_volume)
                .addGap(18, 18, 18)
                .addComponent(btn_mix)
                .addGap(18, 18, 18)
                .addComponent(btn_repeat)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_repeat)
                    .addComponent(btn_mix)
                    .addComponent(btn_volume))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách"));

        tableSong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên bài hát"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableSong);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_opent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/music-folder.png"))); // NOI18N
        btn_opent.setToolTipText("Opent File");
        btn_opent.setBorder(null);
        btn_opent.setBorderPainted(false);
        btn_opent.setContentAreaFilled(false);
        btn_opent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(btn_opent, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_opent, javax.swing.GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Nghe nhạc online")));

        inputNameSong_onl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameSong_onlActionPerformed(evt);
            }
        });
        inputNameSong_onl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputNameSong_onlKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputNameSong_onlKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNameSong_onlKeyTyped(evt);
            }
        });

        btnSearch_onl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnSearch_onl.setBorder(null);
        btnSearch_onl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch_onlActionPerformed(evt);
            }
        });

        jLabel1.setText("Nhập tên bài hát");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(inputNameSong_onl, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch_onl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch_onl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputNameSong_onl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_playActionPerformed
        // TODO add your handling code here:
        if (off) {
            int row = tableSong.getSelectedRow();
            if (playing == false) {
                if (row == -1) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn bài hát", "Thông báo", 0);
                } else if (haspause == false) {
                    bai = row;
                    MC.play(ListSong.get(row));
                    //MC.bsplay(ListSong.get(row));
                    File ftmp = new File(ListSong.get(row));
                    String name = ftmp.getName().toString();
                    txtNameSong.setText(name);
                    playing = true;
                    btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Pause-icon.png")));
                } else {
                    MC.resume();
                    btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Pause-icon.png")));
                    haspause = false;
                    playing = true;
                }
            } else {
                btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Play-icon.png")));
                playing = false;
                MC.Pause();
                haspause = true;
            }
        } else {
            if (playing == false){
                if (haspause == false){
                    play_onl();
                    playing = true;
                    btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Pause-icon.png")));
                }
                else{
                    play_onl.resume();
                    btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Pause-icon.png")));
                    haspause = false;
                    playing = true;
                }
            } else{
                btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Play-icon.png")));
                playing = false;
                play_onl.pause();
                haspause = true;
            }
            
        }
    }//GEN-LAST:event_btn_playActionPerformed

    private void play_onl() {
        int index = tableSong.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bài hát", "Thông báo", 0);
        } else {
            String bai = listURL.get(index);
            this.bai = index;

//         Te playsearch = new PausablePlayer();
            if (queryThread != null && queryThread.isAlive()) {
                queryThread.stop();
            }

            queryThread = new Thread() {
                public void run() {
                    play_onl.play(bai);
                }
            };
            System.out.println(queryThread);
            queryThread.start();
        }
    }

    private void btn_mixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mixActionPerformed
        // TODO add your handling code here:
        play_onl.resume();
    }//GEN-LAST:event_btn_mixActionPerformed

    private void inputNameSong_onlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameSong_onlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameSong_onlActionPerformed

    private void btnSearch_onlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch_onlActionPerformed
        // TODO add your handling code here:
        search_onl();
        off = false;
    }//GEN-LAST:event_btnSearch_onlActionPerformed

    private void search_onl() {
        String textSearch = inputNameSong_onl.getText();
        HttpURLConnectionExample http = new HttpURLConnectionExample();
        String jsonui = null;
        try {
            jsonui = http.sendGet(textSearch);
        } catch (Exception ex) {
            Logger.getLogger(Player_Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            System.out.println(jsonui);
            Object obj = parser.parse(jsonui);
            JSONArray array = (JSONArray) obj;
            int larray = array.size();

            listURL = new ArrayList<>();
            listName = new ArrayList<>();
            DefaultTableModel tbmode = (DefaultTableModel) tableSong.getModel();
            tbmode.getDataVector().removeAllElements();
            for (int i = 0; i < larray; i++) {
                JSONObject obj2 = (JSONObject) array.get(i);
                listURL.add(obj2.get("LinkSong").toString());
                listName.add(obj2.get("TenSong").toString() + " - " + obj2.get("CaSi").toString());
                //System.out.println(listName.get(i));
                tbmode.addRow(new Object[]{i + 1, listName.get(i)});
            }
        } catch (org.json.simple.parser.ParseException pe) {

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
    }
    private void btn_opentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opentActionPerformed
        // TODO add your handling code here:
        off = true;
        String[] listPath = getfile.getListSong("Archivos MP3", "mp3");
        ListSong.addAll(Arrays.asList(listPath));
        DefaultTableModel tablemode = (DefaultTableModel) tableSong.getModel();
        tablemode.getDataVector().removeAllElements();
        File ftg;
        for (int i = 0; i < ListSong.size(); ++i) {
            ftg = new File(ListSong.get(i));
            tablemode.addRow(new Object[]{i + 1, ftg.getName().substring(0, ftg.getName().length() - 4)});
        }

//        for(int i = 0; i < listPath.length; ++i )
//            System.out.println(listPath[i]);
        File f = new File(listPath[0]);
        System.out.println(f.getName());
    }//GEN-LAST:event_btn_opentActionPerformed

    private void btn_volumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volumeActionPerformed
        // TODO add your handling code here:
        play_onl.pause();
    }//GEN-LAST:event_btn_volumeActionPerformed

    private void btn_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stopActionPerformed
        // TODO add your handling code here:
        if (off)
            MC.Stop();
        else
            play_onl.Stop();
    }//GEN-LAST:event_btn_stopActionPerformed

    private void jProgressBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jProgressBar1MouseClicked

    private void btn_rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rightActionPerformed
        // TODO add your handling code here:
        System.out.println("toi " + bai);
        MC.Stop();
        int row = -1;
        if (bai < tableSong.getRowCount() - 1) {
            bai++;
            row = bai;
        } else {
            bai = 0;
            row = 0;
        }
        System.out.println("toi " + row);
        if (playing == false) {
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn bài hát", "Thông báo", 0);
            } else if (haspause == false) {
                tableSong.setRowSelectionInterval(row, row);
                MC.play(ListSong.get(row));
                File ftmp = new File(ListSong.get(row));
                String name = ftmp.getName().toString();
                txtNameSong.setText(name);
                playing = true;
                btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Pause-icon.png")));
            } else {
                MC.resume();
                btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Pause-icon.png")));
                haspause = false;
                playing = true;
            }
        } else {
            btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Play-icon.png")));
            playing = false;
            MC.Pause();
            haspause = true;
        }
    }//GEN-LAST:event_btn_rightActionPerformed

    private void btn_leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_leftActionPerformed
        // TODO add your handling code here:
        MC.Stop();
        int row = -1;
        System.out.println("lui " + bai);
        if (bai > 1) {
            bai--;
            row = bai;
        } else {
            row = tableSong.getRowCount() - 1;
            bai = row;
        }
        System.out.println("lui " + bai);
        if (playing == false) {
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn bài hát", "Thông báo", 0);
            } else if (haspause == false) {
                tableSong.setRowSelectionInterval(row, row);
                MC.play(ListSong.get(row));
                File ftmp = new File(ListSong.get(row));
                String name = ftmp.getName().toString();
                txtNameSong.setText(name);
                playing = true;
                btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Pause-icon.png")));
            } else {
                MC.resume();
                btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Pause-icon.png")));
                haspause = false;
                playing = true;
            }
        } else {
            btn_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aqua-Play-icon.png")));
            playing = false;
            MC.Pause();
            haspause = true;
        }
    }//GEN-LAST:event_btn_leftActionPerformed

    private void inputNameSong_onlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNameSong_onlKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_inputNameSong_onlKeyPressed

    private void inputNameSong_onlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNameSong_onlKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameSong_onlKeyTyped

    private void inputNameSong_onlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNameSong_onlKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_inputNameSong_onlKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Player_Music.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Player_Music().setVisible(true);
        });
    }

    @Override
    public void opened(Object o, Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stateUpdated(BasicPlayerEvent bpe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setController(BasicController bc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch_onl;
    private javax.swing.JButton btn_left;
    private javax.swing.JButton btn_mix;
    private javax.swing.JButton btn_opent;
    public static javax.swing.JButton btn_play;
    private javax.swing.JButton btn_repeat;
    private javax.swing.JButton btn_right;
    private javax.swing.JButton btn_stop;
    private javax.swing.JButton btn_volume;
    private javax.swing.JTextField inputNameSong_onl;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableSong;
    private javax.swing.JLabel txtNameSong;
    // End of variables declaration//GEN-END:variables
}
