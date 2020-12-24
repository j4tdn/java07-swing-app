/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.CardType;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EnumMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import utils.ForegroundUtils;
import view.sub.PnCircle;
import view.sub.PnRect;
import view.sub.PnSpecial;
import view.sub.PnStar;
import view.sub.PnTriangle;

/**
 *
 * @author ADMIN
 */
public class FrGuessingApp extends javax.swing.JFrame {

    private Timer timer;
    private JPanel crosswordPanel;
    //private JButton previousClickedButton;
    //private Border defaultBorder;
    //private final Border highlightBorder = BorderFactory.createEtchedBorder(Color.blue, Color.black);
    private final Image imageDogPng = new ImageIcon(getClass().getResource("/images/dog.png")).getImage();
    private final Image imageDogGif = new ImageIcon(getClass().getResource("/images/dog.gif")).getImage();
    private final Image imageResume = new ImageIcon(getClass().getResource("/images/resume.png")).getImage();
    private final Image imagePause = new ImageIcon(getClass().getResource("/images/pause.png")).getImage();
    private final EnumMap<CardType, JPanel> cardMap;
    private final EnumMap<CardType, String> questionsMap;
    private int limitedTime = 12;
    private boolean isPause = true;

    /**
     * Creates new form FrGuessingApp
     */
    public FrGuessingApp() {
        cardMap = new EnumMap<>(CardType.class);
        cardMap.put(CardType.Star, new PnStar());
        cardMap.put(CardType.Rect, new PnRect());
        cardMap.put(CardType.Triangle, new PnTriangle());
        cardMap.put(CardType.Circle, new PnCircle());
        cardMap.put(CardType.Special, new PnSpecial());

        questionsMap = new EnumMap<>(CardType.class);
        questionsMap.put(CardType.Star, new String("What is the superpower make SO better ?"));
        questionsMap.put(CardType.Rect, new String("What is the best thing in your life ?"));
        questionsMap.put(CardType.Triangle, new String("What did SO leave their last job ?"));
        questionsMap.put(CardType.Circle, new String("What can travel around the world while staying in a corner ?"));
        questionsMap.put(CardType.Special, new String("I'm tall when I'm young and I'm short when I'm old. What am I ?"));

        initComponents();
        initComponentsManually();
        initEvent();
    }

    private void initComponentsManually() {
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Guessing APP");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Image image = new ImageIcon(getClass().getResource("/images/haha.png")).getImage();
        setIconImage(image);

        lbTime.setForeground(new Color(0, 0, 0, 0));
        btnPause.setBackground(new Color(0, 0, 0, 0));
        btnPause.setVisible(false);

        btnCursor(btnStart);
        btnCursor(btnOpen);
        btnCursor(btnDelete);

    }

    private void initEvent() {
        pnTopEvents();
        pnBottomEvents();
        btnPauseEvent();
    }

    private void pnTopEvents() {
        //previousClickedButton = btnStar;
        //defaultBorder = btnStar.getBorder();
        Component[] components = pnTop.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        // remove pnCenter's component
                        pnCenterTop.removeAll();
                        // show correct card panel
                        lbQuestion.setText(questionsMap.get(CardType.from(button.getName())));
                        crosswordPanel = cardMap.get(CardType.from(button.getName()));
                        ForegroundUtils.setHiddenForeground(crosswordPanel);
                        ForegroundUtils.setAppearedForeground(crosswordPanel);
                        pnCenterTop.add(crosswordPanel);
                        pnCenterTop.repaint();
                        pnCenterTop.revalidate();
                        // unhighlight previous button
                        //previousClickedButton.setBorder(defaultBorder);
                        // highlight current button
                        //button.setBorder(highlightBorder);
                        //previousClickedButton = button;
                    }
                });
            }
        }
    }

    private void pnBottomEvents() {

        btnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lbImage.setIcon(new ImageIcon(imageDogGif));
                btnPause.setVisible(true);
                
                
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (limitedTime == 0) {
                            timer.stop();
                        } 
                        lbTime.setForeground(Color.black);
                        lbTime.setText(String.valueOf(limitedTime--));
                    }
                });
                timer.start();
            }
        });

        btnOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (pnCenterTop.getComponents().length != 0) {
                    Component[] components = crosswordPanel.getComponents();
                    for (Component cpn : components) {
                        if (cpn instanceof JButton) {
                            JButton button = (JButton) cpn;
                            button.setForeground(Color.black);
                        }
                    }
                }
            }
        });

        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (pnCenterTop.getComponents().length != 0) {
                    ForegroundUtils.setHiddenForeground(crosswordPanel);
                }
            }
        });

    }

    private void btnPauseEvent() {
        btnPause.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isPause) {
                    timer.stop();
                    lbImage.setIcon(new ImageIcon(imageDogPng));
                    btnPause.setIcon(new ImageIcon(imageResume));
                    isPause=false;
                } else {
                    timer.start();
                    lbImage.setIcon(new ImageIcon(imageDogGif));
                    btnPause.setIcon(new ImageIcon(imagePause));
                    isPause=true;
                }
            }
        });
    }

    private void btnCursor(JButton button) {
        //previousClickedButton = btnStart;
        //defaultBorder = btnStart.getBorder();

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setSize(button.getWidth(), button.getHeight() + 7);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setSize(button.getWidth(), button.getHeight() - 7);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTop = new javax.swing.JPanel();
        btnStar = new javax.swing.JButton();
        btnRect = new javax.swing.JButton();
        btnTriangle = new javax.swing.JButton();
        btnCircle = new javax.swing.JButton();
        btnSpecial = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        pnCenterBottom = new javax.swing.JPanel();
        pnCenterBottomLeft = new javax.swing.JPanel();
        pnQuestion = new javax.swing.JPanel();
        lbQuestion = new javax.swing.JLabel();
        pnImage = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        pnCenterBottomRight = new javax.swing.JPanel();
        pnTime = new javax.swing.JPanel();
        lbTime = new javax.swing.JLabel();
        pbPause = new javax.swing.JPanel();
        btnPause = new javax.swing.JButton();
        pnCenterTop = new javax.swing.JPanel();
        pnBottom = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTop.setBackground(new java.awt.Color(255, 255, 255));
        pnTop.setPreferredSize(new java.awt.Dimension(0, 70));
        pnTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnStar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qstar.png"))); // NOI18N
        btnStar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStar.setName("Star"); // NOI18N
        btnStar.setPreferredSize(new java.awt.Dimension(60, 60));
        pnTop.add(btnStar);

        btnRect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qrect.png"))); // NOI18N
        btnRect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRect.setName("Rect"); // NOI18N
        btnRect.setPreferredSize(new java.awt.Dimension(60, 60));
        pnTop.add(btnRect);

        btnTriangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qtriangle.png"))); // NOI18N
        btnTriangle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTriangle.setName("Triangle"); // NOI18N
        btnTriangle.setPreferredSize(new java.awt.Dimension(60, 60));
        pnTop.add(btnTriangle);

        btnCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qcircle.png"))); // NOI18N
        btnCircle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCircle.setName("Circle"); // NOI18N
        btnCircle.setPreferredSize(new java.awt.Dimension(60, 60));
        pnTop.add(btnCircle);

        btnSpecial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qspecial.png"))); // NOI18N
        btnSpecial.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSpecial.setName("Special"); // NOI18N
        btnSpecial.setPreferredSize(new java.awt.Dimension(60, 60));
        pnTop.add(btnSpecial);

        getContentPane().add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnCenter.setLayout(new java.awt.BorderLayout());

        pnCenterBottom.setBackground(new java.awt.Color(255, 255, 255));
        pnCenterBottom.setPreferredSize(new java.awt.Dimension(1000, 340));
        pnCenterBottom.setLayout(new java.awt.BorderLayout());

        pnCenterBottomLeft.setPreferredSize(new java.awt.Dimension(950, 300));
        pnCenterBottomLeft.setRequestFocusEnabled(false);
        pnCenterBottomLeft.setLayout(new java.awt.BorderLayout());

        pnQuestion.setBackground(new java.awt.Color(204, 204, 255));
        pnQuestion.setPreferredSize(new java.awt.Dimension(650, 50));
        pnQuestion.setRequestFocusEnabled(false);
        pnQuestion.setLayout(new java.awt.GridLayout(1, 0));

        lbQuestion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuestion.setPreferredSize(new java.awt.Dimension(56, 20));
        pnQuestion.add(lbQuestion);

        pnCenterBottomLeft.add(pnQuestion, java.awt.BorderLayout.PAGE_START);

        pnImage.setBackground(new java.awt.Color(255, 255, 255));
        pnImage.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnImage.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        lbImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dog.png"))); // NOI18N
        lbImage.setFocusable(false);
        lbImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnImage.add(lbImage);

        pnCenterBottomLeft.add(pnImage, java.awt.BorderLayout.CENTER);

        pnCenterBottom.add(pnCenterBottomLeft, java.awt.BorderLayout.WEST);

        pnCenterBottomRight.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnCenterBottomRight.setLayout(new java.awt.BorderLayout());

        pnTime.setBackground(new java.awt.Color(255, 255, 255));
        pnTime.setPreferredSize(new java.awt.Dimension(340, 300));
        pnTime.setLayout(new java.awt.BorderLayout());

        lbTime.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock339.jpg"))); // NOI18N
        lbTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbTime.setVerifyInputWhenFocusTarget(false);
        pnTime.add(lbTime, java.awt.BorderLayout.CENTER);

        pnCenterBottomRight.add(pnTime, java.awt.BorderLayout.CENTER);

        pbPause.setBackground(new java.awt.Color(255, 255, 255));
        pbPause.setPreferredSize(new java.awt.Dimension(65, 300));

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause.png"))); // NOI18N
        btnPause.setToolTipText("");
        btnPause.setFocusPainted(false);
        btnPause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPause.setIconTextGap(0);
        btnPause.setMargin(new java.awt.Insets(0, 0, 0, 0));

        javax.swing.GroupLayout pbPauseLayout = new javax.swing.GroupLayout(pbPause);
        pbPause.setLayout(pbPauseLayout);
        pbPauseLayout.setHorizontalGroup(
            pbPauseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbPauseLayout.createSequentialGroup()
                .addComponent(btnPause)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        pbPauseLayout.setVerticalGroup(
            pbPauseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbPauseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPause)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        pnCenterBottomRight.add(pbPause, java.awt.BorderLayout.LINE_END);

        pnCenterBottom.add(pnCenterBottomRight, java.awt.BorderLayout.CENTER);

        pnCenter.add(pnCenterBottom, java.awt.BorderLayout.SOUTH);

        pnCenterTop.setBackground(new java.awt.Color(153, 204, 0));
        pnCenterTop.setPreferredSize(new java.awt.Dimension(1176, 130));
        pnCenterTop.setLayout(new java.awt.BorderLayout());
        pnCenter.add(pnCenterTop, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        pnBottom.setBackground(new java.awt.Color(255, 255, 255));
        pnBottom.setPreferredSize(new java.awt.Dimension(0, 50));
        pnBottom.setRequestFocusEnabled(false);

        btnStart.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btnStart.setText("Bắt đầu");
        btnStart.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        pnBottom.add(btnStart);

        btnOpen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btnOpen.setText("Mở ô chữ");
        pnBottom.add(btnOpen);

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btnDelete.setText("Xóa ô chữ");
        pnBottom.add(btnDelete);

        getContentPane().add(pnBottom, java.awt.BorderLayout.PAGE_END);

        jMenu3.setText("Tài nguyên");

        jMenuItem6.setText("Gia đình");
        jMenu3.add(jMenuItem6);

        jMenuItem1.setText("Sức khỏe");
        jMenu3.add(jMenuItem1);

        jMenuItem7.setText("Cuộc sống");
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Khoa học");
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Tác giả");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed

    }//GEN-LAST:event_btnStartActionPerformed

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
            java.util.logging.Logger.getLogger(FrGuessingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrGuessingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrGuessingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrGuessingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrGuessingApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCircle;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnRect;
    private javax.swing.JButton btnSpecial;
    private javax.swing.JButton btnStar;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnTriangle;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbQuestion;
    private javax.swing.JLabel lbTime;
    private javax.swing.JPanel pbPause;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnCenterBottom;
    private javax.swing.JPanel pnCenterBottomLeft;
    private javax.swing.JPanel pnCenterBottomRight;
    private javax.swing.JPanel pnCenterTop;
    private javax.swing.JPanel pnImage;
    private javax.swing.JPanel pnQuestion;
    private javax.swing.JPanel pnTime;
    private javax.swing.JPanel pnTop;
    // End of variables declaration//GEN-END:variables
}
