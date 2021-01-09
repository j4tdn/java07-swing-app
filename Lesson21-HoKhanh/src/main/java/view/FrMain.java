/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.Topic;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.WindowConstants;
import service.QuestionService;
import service.QuestionServiceImpl;
import beans.Question;
import common.ButtonQuestionIcon;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author khanh
 */
public class FrMain extends javax.swing.JFrame {

    private final QuestionService service;
    private final Dimension dimension = new Dimension(105, 25);
    private final Dimension buttonDimension = new Dimension(80, 60);
    private final Font font = new Font("Tahoma", Font.PLAIN, 48);
    private final Icon imagePause = new ImageIcon(new ImageIcon(getClass().getResource("/images/resume.png"))
            .getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH));
    private final Icon imageContinue = new ImageIcon(getClass().getResource("/images/pause.png"));
    private final Icon imageDog = new ImageIcon(getClass().getResource("/images/dog.png"));
    private final Icon gifDog = new ImageIcon(getClass().getResource("/images/dog.gif"));
    private final Icon gifClaps = new ImageIcon(getClass().getResource("/images/claps04.gif"));
    private final Image imageClock = new ImageIcon(getClass().getResource("/images/clock339.jpg"))
            .getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
    private List<Question> questions;
    private final List<JButton> answerButtons ;
    private int currentQuestion = 0;
    private int lengthOfAnswer = 0;
    private final ButtonQuestionIcon[] buttonQuestionIcon = ButtonQuestionIcon.values();
    private boolean status = true;
    private Timer timer;
    private int time=0;

    /**
     * Creates new form FrMain
     */
    public FrMain() {
        service = new QuestionServiceImpl();
        answerButtons = new ArrayList<>();
        initComponents();
        initComponentsManually();
        initEvents();
    }

    private void initComponentsManually() {
        setExtendedState(FrMain.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.WHITE);
        pnBot.setPreferredSize(new Dimension(0, 60));
        pnBot.setBackground(Color.WHITE);
        btnStart.setPreferredSize(dimension);
        btnOpen.setPreferredSize(dimension);
        btnReset.setPreferredSize(dimension);

        setNameMenuItem();
        questions = service.getAllQuestionByTopic(mniFamily.getName());
        layoutCenterLeft();
        layoutCenterCenter();
        createQuestionButtons();
        createAnswerButtons(currentQuestion);

    }

    private void layoutCenterLeft() {
        pnCenterLeft.setLayout(null);
        pnCenterLeft.setBackground(Color.WHITE);
        pnCenterLeft.setPreferredSize(new Dimension(920, 0));
        pnCenterLeft.setBorder(BorderFactory.createEtchedBorder());

        pnTitleColor.setSize(new Dimension(918, 50));
        lbQuestion.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lbQuestion.setText(questions.get(currentQuestion).getQuestion());

        lbGif.setBounds(350, 110, 180, 180);
        lbGif.setIcon(imageDog);
    }

    private void layoutCenterCenter() {
        pnCenterCenter.setBorder(BorderFactory.createEtchedBorder());

        lbClock.setIcon(new ImageIcon(imageClock));
        lbClock.setFont(new Font("Tahoma", Font.PLAIN, 100));

        btnPause.setPreferredSize(new Dimension(48, 48));
        btnPause.setIcon(imagePause);
    }

    private void createAnswerButtons(int question) {
        answerButtons.clear();
        pnCenterTop.removeAll();
        pnCenterTop.repaint();
        lengthOfAnswer = questions.get(question).getAnswer().length();

        for (int i = 0; i < lengthOfAnswer; i++) {
            JButton button = new JButton();
            button.setFont(font);
            button.setPreferredSize(buttonDimension);
            button.setName(String.valueOf(i));
            answerButtons.add( button);
            pnCenterTop.add(button);
            button.setText("");
            buttonAnswerEvents(button);
        }

        pnCenterTop.revalidate();
        currentQuestion = question;
    }

    private void buttonAnswerEvents(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int locationInAnswer = Integer.parseInt(button.getName());
                button.setText(String.valueOf(questions.get(currentQuestion).getAnswer().charAt(locationInAnswer)));

                btnPause.setIcon(imagePause);
                for (JButton btn:answerButtons) {
                    if(btn.getText().isEmpty()){
                        return;
                    }
                }
                lbGif.setIcon(gifClaps);
                status = false;
            }
        });
    }

    private void menuItemEvent() {
        for (Component com : mnTN.getMenuComponents()) {
            com.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    questions.clear();
                    questions = service.getAllQuestionByTopic(com.getName());
                    createQuestionButtons();
                    currentQuestion = 0;
                    createAnswerButtons(currentQuestion);
                    lbQuestion.setText(questions.get(currentQuestion).getQuestion());
                    lbGif.setIcon(imageDog);
                    if(timer!=null){
                        timer.stop();
                        lbClock.setText("");
                    }
                }
            });

        }

    }

    private void setNameMenuItem() {
        mniHealth.setName(Topic.HEALTH.getName());
        mniFamily.setName(Topic.FAMILY.getName());
        mniLife.setName(Topic.LIFE.getName());
        mniScience.setName(Topic.SCIENCE.getName());
    }

    private void createQuestionButtons() {
        pnTop.removeAll();
        pnTop.repaint();
        for (int i = 0; i < questions.size(); i++) {
            JButton button = new JButton();
            button.setPreferredSize(buttonDimension);
            button.setIcon(new ImageIcon(getClass().getResource(buttonQuestionIcon[i % 5].getPath())));
            button.setName(String.valueOf(i));
            pnTop.add(button);
            btnQuestionEvents(button);

        }

        pnTop.revalidate();
    }

    private void btnQuestionEvents(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (Integer.parseInt(button.getName()) != currentQuestion) {
                    createAnswerButtons(Integer.parseInt(button.getName()));
                    lbQuestion.setText(questions.get(currentQuestion).getQuestion());
                    lbGif.setIcon(imageDog);
                    btnPause.setIcon(imagePause);
                    status = false;
                    if(timer!=null){
                        timer.stop();
                        lbClock.setText("");
                    }
                }
            }
        });
    }

    private void initEvents() {
        menuItemEvent();
        btnStartEvent();
        btnOpenEvent();
        btnResetEvent();
        btnPauseEvent();
    }

    private void btnPauseEvent() {
        btnPause.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (status && timer!=null) {

                    btnPause.setIcon(imagePause);
                    timer.stop();
                    status = false;
                } else {

                    btnPause.setIcon(imageContinue);
                    timer.start();
                    status = true;
                }
            }
        });
    }

    private void btnStartEvent() {
        btnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            
                time =12;
                lbGif.setIcon(gifDog);
                btnPause.setIcon(imageContinue);
                status = true;
                if (timer == null) {
                        timer = new Timer(1000, e1 -> {
                            if (time == 0) {
                                timer.stop();
                            }
                            lbClock.setText(Integer.toString(time--));
                        });
                        timer.start();
                    } else {
                        timer.restart();
                    }
            }
        });
    }

    private void btnResetEvent() {
        btnReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lbGif.setIcon(imageDog);
                for (int i = 0; i < lengthOfAnswer; i++) {
                    answerButtons.get(i).setText("");
                }
                if(timer!=null){
                    
                    timer.stop();
                    lbClock.setText("");
                }
            }

        });

    }

    private void btnOpenEvent() {
        btnOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lbGif.setIcon(gifClaps);
                for (int i = 0; i < lengthOfAnswer; i++) {
                    answerButtons.get(i).setText(String.valueOf(questions.get(currentQuestion).getAnswer().charAt(i)));
                }
                btnPause.setIcon(imagePause);
                if (timer != null) {
                    timer.stop();
                }
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
        pnBot = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        pnCenterTop = new javax.swing.JPanel();
        pnCenterLeft = new javax.swing.JPanel();
        pnTitleColor = new javax.swing.JPanel();
        lbQuestion = new javax.swing.JLabel();
        lbGif = new javax.swing.JLabel();
        pnCenterCenter = new javax.swing.JPanel();
        btnPause = new javax.swing.JButton();
        lbClock = new javax.swing.JLabel();
        mnBar = new javax.swing.JMenuBar();
        mnTN = new javax.swing.JMenu();
        mniFamily = new javax.swing.JMenuItem();
        mniHealth = new javax.swing.JMenuItem();
        mniLife = new javax.swing.JMenuItem();
        mniScience = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));
        getContentPane().add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnBot.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 15));

        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btnStart.setText("Bắt đầu");
        btnStart.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnStart.setRolloverEnabled(false);
        pnBot.add(btnStart);

        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btnOpen.setText("Mở ô chử");
        btnOpen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnOpen.setPreferredSize(new java.awt.Dimension(101, 25));
        pnBot.add(btnOpen);

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btnReset.setText("Xóa ô chử");
        btnReset.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnBot.add(btnReset);

        getContentPane().add(pnBot, java.awt.BorderLayout.PAGE_END);

        pnCenter.setLayout(new java.awt.BorderLayout());

        pnCenterTop.setBackground(new java.awt.Color(51, 255, 0));
        pnCenterTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 60));
        pnCenter.add(pnCenterTop, java.awt.BorderLayout.PAGE_START);

        pnTitleColor.setBackground(new java.awt.Color(153, 153, 153));
        pnTitleColor.setPreferredSize(new java.awt.Dimension(510, 40));

        lbQuestion.setBackground(new java.awt.Color(204, 204, 204));
        pnTitleColor.add(lbQuestion);

        lbGif.setText("jLabel1");
        lbGif.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout pnCenterLeftLayout = new javax.swing.GroupLayout(pnCenterLeft);
        pnCenterLeft.setLayout(pnCenterLeftLayout);
        pnCenterLeftLayout.setHorizontalGroup(
            pnCenterLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTitleColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnCenterLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnCenterLeftLayout.createSequentialGroup()
                    .addGap(238, 238, 238)
                    .addComponent(lbGif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(272, Short.MAX_VALUE)))
        );
        pnCenterLeftLayout.setVerticalGroup(
            pnCenterLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTitleColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnCenterLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnCenterLeftLayout.createSequentialGroup()
                    .addGap(170, 170, 170)
                    .addComponent(lbGif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );

        pnCenter.add(pnCenterLeft, java.awt.BorderLayout.LINE_START);

        pnCenterCenter.setPreferredSize(new java.awt.Dimension(150, 180));

        lbClock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnCenterCenterLayout = new javax.swing.GroupLayout(pnCenterCenter);
        pnCenterCenter.setLayout(pnCenterCenterLayout);
        pnCenterCenterLayout.setHorizontalGroup(
            pnCenterCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterCenterLayout.createSequentialGroup()
                .addGroup(pnCenterCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCenterCenterLayout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(btnPause))
                    .addGroup(pnCenterCenterLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbClock)))
                .addGap(510, 510, 510))
        );
        pnCenterCenterLayout.setVerticalGroup(
            pnCenterCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterCenterLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnPause)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnCenterCenterLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbClock, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnCenter.add(pnCenterCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        mnBar.setBackground(new java.awt.Color(153, 153, 153));

        mnTN.setText("Tài nguyên");

        mniFamily.setText("Gia đình");
        mnTN.add(mniFamily);

        mniHealth.setText("Sức khỏe");
        mnTN.add(mniHealth);

        mniLife.setText("Cuộc sống");
        mnTN.add(mniLife);

        mniScience.setText("Khoa học");
        mnTN.add(mniScience);

        mnBar.add(mnTN);

        setJMenuBar(mnBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel lbClock;
    private javax.swing.JLabel lbGif;
    private javax.swing.JLabel lbQuestion;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnTN;
    private javax.swing.JMenuItem mniFamily;
    private javax.swing.JMenuItem mniHealth;
    private javax.swing.JMenuItem mniLife;
    private javax.swing.JMenuItem mniScience;
    private javax.swing.JPanel pnBot;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnCenterCenter;
    private javax.swing.JPanel pnCenterLeft;
    private javax.swing.JPanel pnCenterTop;
    private javax.swing.JPanel pnTitleColor;
    private javax.swing.JPanel pnTop;
    // End of variables declaration//GEN-END:variables
}
