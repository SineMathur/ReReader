/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rereader;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.awt.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ReUI extends javax.swing.JFrame {

    private static String[] words = new String[0];
    private Boolean timerEnabled = false;
    private Timer timer = new Timer();
    private int positionWords = 0;
    private static Image[] images = new Image[0];
    private ReConfig config = ReGlobals.initGlobals();
    private static int fileStatus = 0;
    private static String content;

    /**
     * Creates new form ReUI
     */
    public ReUI() {
        initComponents();
        reTimer();
        
//        set sizes of new frames
        statusFrame.setSize(251, 80);
        optionFrame.setSize(178, 160);

//        set default item of combo box
        setDefaultLang();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectedDocument = new javax.swing.JFileChooser();
        statusFrame = new javax.swing.JFrame();
        reProgressBar = new javax.swing.JProgressBar();
        reProgressLabel = new javax.swing.JLabel();
        optionFrame = new javax.swing.JFrame();
        defaultLang = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        wordSpeed = new javax.swing.JTextField();
        inputPosition = new javax.swing.JTextField();
        chkPosition = new javax.swing.JCheckBox();
        textPic = new javax.swing.JPanel();
        openFile = new javax.swing.JButton();
        reading = new javax.swing.JButton();
        showStatus = new javax.swing.JCheckBox();
        showOption = new javax.swing.JCheckBox();

        statusFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                statusFrameWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                statusFrameWindowClosing(evt);
            }
        });

        reProgressLabel.setText("Welcome to ReReader");

        javax.swing.GroupLayout statusFrameLayout = new javax.swing.GroupLayout(statusFrame.getContentPane());
        statusFrame.getContentPane().setLayout(statusFrameLayout);
        statusFrameLayout.setHorizontalGroup(
            statusFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reProgressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statusFrameLayout.setVerticalGroup(
            statusFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reProgressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        optionFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                optionFrameWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                optionFrameWindowClosing(evt);
            }
        });

        defaultLang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("words per second");

        wordSpeed.setText("250");

        inputPosition.setText("0");

        chkPosition.setText("position in text");

        javax.swing.GroupLayout optionFrameLayout = new javax.swing.GroupLayout(optionFrame.getContentPane());
        optionFrame.getContentPane().setLayout(optionFrameLayout);
        optionFrameLayout.setHorizontalGroup(
            optionFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(defaultLang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(optionFrameLayout.createSequentialGroup()
                        .addComponent(wordSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(optionFrameLayout.createSequentialGroup()
                        .addComponent(chkPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionFrameLayout.setVerticalGroup(
            optionFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(optionFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkPosition))
                .addGap(20, 20, 20)
                .addComponent(defaultLang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout textPicLayout = new javax.swing.GroupLayout(textPic);
        textPic.setLayout(textPicLayout);
        textPicLayout.setHorizontalGroup(
            textPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        textPicLayout.setVerticalGroup(
            textPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        openFile.setText("open file");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });

        reading.setText("Start");
        reading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readingActionPerformed(evt);
            }
        });

        showStatus.setText("show status");
        showStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showStatusItemStateChanged(evt);
            }
        });

        showOption.setText("show options");
        showOption.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showOptionItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reading)
                                .addGap(48, 48, 48)
                                .addComponent(openFile))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(showStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(showOption, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                        .addGap(0, 177, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textPic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reading)
                    .addComponent(openFile))
                .addGap(32, 32, 32)
                .addComponent(showStatus)
                .addGap(18, 18, 18)
                .addComponent(showOption)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readingActionPerformed
        if (words.length == 0) {
            JOptionPane.showMessageDialog(null, "No file selected");
        } else {
            //        init timer
            handleTimer();

        }
    }//GEN-LAST:event_readingActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        int returnVal = selectedDocument.showOpenDialog(this);

        if (returnVal == 0) {
            String file = selectedDocument.getSelectedFile().toString();

            ReStatus.setLabel("Reading Files");

            try {
                fileStatus = 1;

                content = ReFile.readFileEncoded(file);
//                System.out.println(content);
                content = ReText.reFromatText(content);

//                words = ReText.splitText(content);
//                words = ReText.proofWords(words);
//                images = ReImage.generateImageList(words);
                fileStatus = 2;
                positionWords = 0;

//                System.out.println(Arrays.deepToString(words));
            } catch (IOException ex) {
                System.out.println("There was nothing to load.");
            }
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void showStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showStatusItemStateChanged
        // TODO add your handling code here:
        if (statusFrame.isVisible()) {
            statusFrame.setVisible(false);
        } else {
            statusFrame.setVisible(true);
        }
    }//GEN-LAST:event_showStatusItemStateChanged

    private void showOptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showOptionItemStateChanged
        // TODO add your handling code here:
        if (optionFrame.isVisible()) {
            optionFrame.setVisible(false);
        } else {
            optionFrame.setVisible(true);
        }
    }//GEN-LAST:event_showOptionItemStateChanged

    private void optionFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_optionFrameWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_optionFrameWindowClosed

    private void statusFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_statusFrameWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusFrameWindowClosed

    private void optionFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_optionFrameWindowClosing
        // TODO add your handling code here:
        if (showOption.isSelected()) {
            showOption.setSelected(false);
        }
    }//GEN-LAST:event_optionFrameWindowClosing

    private void statusFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_statusFrameWindowClosing
        // TODO add your handling code here:
        if (showStatus.isSelected()) {
            showStatus.setSelected(false);
        }
    }//GEN-LAST:event_statusFrameWindowClosing

    private void setDefaultLang() {
        String[] dics = ReReader.getDictionaries();
        String[] dicParts;
        String dicName = "auto";
        StringBuilder sb = new StringBuilder();
        int end;

        defaultLang.removeAllItems();
        defaultLang.addItem(dicName);

        dicName = "";

        for (int i = 0; i < dics.length; i++) {
            if (dics[i].contains(".")) {
                dicParts = dics[i].split("\\.");

                if (dicParts.length > 2) {
                    end = dicParts.length - 1;

                    dicParts = Arrays.copyOfRange(dicParts, 0, end - 1);

                    for (int j = 0; i < dicParts.length; j++) {
                        sb.append(dicParts[j]);
                    }

                    dicName = sb.toString();
                } else {
                    if(dicParts.length > 0) {
                        dicName = dicParts[0];
                    }
                }
            } else {
                dicName = dics[i];
            }
            
            if(dicName.length() > 0) {
                defaultLang.addItem(dicName);
            }
        }
    }

    private void handleTimer() {
        if (timerEnabled == false) {
            reading.setText("Stop");
            timerEnabled = true;

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (positionWords < images.length) {
//                        textField.setText(words[positionWords]);

                        drawImage(images[positionWords]);

                        positionWords++;
                    } else {
                        timer.cancel();
                        timer = new Timer();
                        positionWords = 0;
                        reading.setText("Start");
                        timerEnabled = false;
                    }
                }
            }, 0, getPeriod());
        } else {
            reading.setText("Start");
            timerEnabled = false;

            timer.cancel();
            timer = new Timer();
        }
    }

    private void drawImage(Image image) {
        Graphics2D gfx = (Graphics2D) textPic.getGraphics();
        gfx.clearRect(0, 0, textPic.getWidth(), textPic.getHeight());
        gfx.drawImage(image, null, this);
        gfx.dispose();
    }

    private int getPeriod() {
        int amount = Integer.parseInt(wordSpeed.getText());
                
        if (amount < 1 || amount > 2000) {

//            set a default value of 50 words per second
            return 200;
        } else {

            return Math.round(60 * 1000 / amount);
        }
    }

    public static int getProgressBar() {
        return reProgressBar.getValue();
    }

    public static void setProgressBar(int value) {
        if (value >= 0) {
            reProgressBar.setValue(value);
        }
    }

    public String getProgressLabel() {
        return reProgressLabel.getText();
    }

    public static void setProgressLabel(String value) {
        if (value.length() > 0) {
            reProgressLabel.setText(value);
        }
    }

    public static String getDefaultLang() {
        
        return defaultLang.getSelectedItem().toString();
    }
    
    private static void reTimer() {
        Timer timer = new Timer();

//        0 listen 
//        1 processing
//        2 processing done
//        3 inactive
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                switch (fileStatus) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        fileStatus = 1;
                        words = ReText.splitText(content);
                        images = ReImage.generateImageList(words);

                        ReUI.setProgressLabel("Ready to read");
                        fileStatus = 3;
                        break;
                    default:
                        break;
                }
            }
        }, 0, 50);
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkPosition;
    private static javax.swing.JComboBox defaultLang;
    private javax.swing.JTextField inputPosition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton openFile;
    private static javax.swing.JFrame optionFrame;
    private static javax.swing.JProgressBar reProgressBar;
    private static javax.swing.JLabel reProgressLabel;
    private javax.swing.JButton reading;
    private javax.swing.JFileChooser selectedDocument;
    private javax.swing.JCheckBox showOption;
    private javax.swing.JCheckBox showStatus;
    private static javax.swing.JFrame statusFrame;
    private javax.swing.JPanel textPic;
    private javax.swing.JTextField wordSpeed;
    // End of variables declaration//GEN-END:variables
}
