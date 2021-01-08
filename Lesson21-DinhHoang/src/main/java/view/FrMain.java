package view;

import beans.Question;
import common.QuestionIcon;
import common.Topic;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import service.ProcessingQuestionsAndAnswers;

public class FrMain extends javax.swing.JFrame implements Runnable {

    private final ProcessingQuestionsAndAnswers process;
    private final Font font = new Font("Tahoma", Font.PLAIN, 48);
    private final Icon imagePause = new ImageIcon(new ImageIcon(getClass().getResource("/images/icons/resume.png"))
            .getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH));
    private final Icon imageContinue = new ImageIcon(getClass().getResource("/images/icons/pause.png"));
    private final Icon imageDog = new ImageIcon(getClass().getResource("/images/gif/dog.png"));
    private final Icon gifDog = new ImageIcon(getClass().getResource("/images/gif/dog.gif"));
    private final Icon gifClaps = new ImageIcon(getClass().getResource("/images/gif/claps04.gif"));
    private final Icon gifFireWork = new ImageIcon(getClass().getResource("/images/gif/firework.gif"));
    private final Dimension defaultDimension = new Dimension(105, 25);
    private final Dimension dimension = new Dimension(105, 30);
    private final Dimension dimensionQuestionButtons = new Dimension(80, 60);
    private final Dimension dimensionAnswerButtons = new Dimension(80, 80);
    private final Topic[] topic = Topic.values();
    private final QuestionIcon[] questionIcon = QuestionIcon.values();

    private final Map<Integer, JButton> questionButtons = new LinkedHashMap<>();
    private final Map<Integer, JButton> answerButtons = new LinkedHashMap<>();
    private List<Question> questions;
    private int numberOfQuestions = 0;
    private int lengthOfAnswer = 0;
    private int currentQuestion = 0;
    private int length = 0;
    private int locationInAnswer = 0;

    private boolean status = true;
    private boolean start = false;
    private static Thread thread;
    private int second = -1;

    public FrMain() {
        process = new ProcessingQuestionsAndAnswers();

        initComponents();
        initComponentsManually();
        initEvents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTop = new javax.swing.JPanel();
        pnBot = new javax.swing.JPanel();
        btStart = new javax.swing.JButton();
        btOpen = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        pnCenterTop = new javax.swing.JPanel();
        pnCenterLeft = new javax.swing.JPanel();
        pnTitleColor = new javax.swing.JPanel();
        lbQuestion = new javax.swing.JLabel();
        lbGif = new javax.swing.JLabel();
        pnCenterCenter = new javax.swing.JPanel();
        btPause = new javax.swing.JButton();
        lbClock = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnbTN = new javax.swing.JMenu();
        itGD = new javax.swing.JMenuItem();
        itSK = new javax.swing.JMenuItem();
        sprTN = new javax.swing.JPopupMenu.Separator();
        itCS = new javax.swing.JMenuItem();
        itKH = new javax.swing.JMenuItem();
        mnbTG = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));
        getContentPane().add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnBot.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 15));

        btStart.setIcon(new javax.swing.ImageIcon("H:\\java07\\java07-repository-app\\Lesson21-DinhHoang\\target\\classes\\images\\icons\\defcon.png")); // NOI18N
        btStart.setText("Bắt đầu");
        btStart.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btStart.setPreferredSize(null);
        btStart.setRolloverEnabled(false);
        pnBot.add(btStart);

        btOpen.setIcon(new javax.swing.ImageIcon("H:\\java07\\java07-repository-app\\Lesson21-DinhHoang\\target\\classes\\images\\icons\\defcon.png")); // NOI18N
        btOpen.setText("Mở ô chử");
        btOpen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btOpen.setPreferredSize(new java.awt.Dimension(101, 25));
        pnBot.add(btOpen);

        btReset.setIcon(new javax.swing.ImageIcon("H:\\java07\\java07-repository-app\\Lesson21-DinhHoang\\target\\classes\\images\\icons\\defcon.png")); // NOI18N
        btReset.setText("Xóa ô chử");
        btReset.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnBot.add(btReset);

        getContentPane().add(pnBot, java.awt.BorderLayout.PAGE_END);

        pnCenter.setLayout(new java.awt.BorderLayout());

        pnCenterTop.setBackground(new java.awt.Color(51, 255, 0));
        pnCenterTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 60));
        pnCenter.add(pnCenterTop, java.awt.BorderLayout.PAGE_START);

        pnCenterLeft.setPreferredSize(new java.awt.Dimension(0, 0));

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
                        .addComponent(btPause))
                    .addGroup(pnCenterCenterLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbClock)))
                .addGap(510, 510, 510))
        );
        pnCenterCenterLayout.setVerticalGroup(
            pnCenterCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterCenterLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btPause)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnCenterCenterLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbClock, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnCenter.add(pnCenterCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));

        mnbTN.setText("Tài nguyên");

        itGD.setText("Gia đình");
        mnbTN.add(itGD);

        itSK.setText("Sức khỏe");
        mnbTN.add(itSK);
        mnbTN.add(sprTN);

        itCS.setText("Cuộc sống");
        mnbTN.add(itCS);

        itKH.setText("Khoa học");
        mnbTN.add(itKH);

        jMenuBar1.add(mnbTN);

        mnbTG.setText("Tác giả");
        jMenuBar1.add(mnbTG);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
        FrMain main = new FrMain();
        main.setVisible(true);
        thread = new Thread(main);
        thread.start();
        thread.suspend();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btPause;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btStart;
    private javax.swing.JMenuItem itCS;
    private javax.swing.JMenuItem itGD;
    private javax.swing.JMenuItem itKH;
    private javax.swing.JMenuItem itSK;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbClock;
    private javax.swing.JLabel lbGif;
    private javax.swing.JLabel lbQuestion;
    private javax.swing.JMenu mnbTG;
    private javax.swing.JMenu mnbTN;
    private javax.swing.JPanel pnBot;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnCenterCenter;
    private javax.swing.JPanel pnCenterLeft;
    private javax.swing.JPanel pnCenterTop;
    private javax.swing.JPanel pnTitleColor;
    private javax.swing.JPanel pnTop;
    private javax.swing.JPopupMenu.Separator sprTN;
    // End of variables declaration//GEN-END:variables

    private void initComponentsManually() {
        setExtendedState(FrMain.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.WHITE);
        pnBot.setPreferredSize(new Dimension(0, 60));
        pnBot.setBackground(Color.WHITE);
        btStart.setPreferredSize(defaultDimension);
        btOpen.setPreferredSize(defaultDimension);
        btReset.setPreferredSize(defaultDimension);

        setNameMenuBar();
        questions = process.getAllQuestionsInTheTopic(itGD.getName());
        pnCenterTop.setPreferredSize(new Dimension(0, 200));
        layoutCenterLeft();
        layoutCenterCenter();
        createQuestionButtons();
        createAnswerButtons(currentQuestion);
    }

    private void setNameMenuBar() {
        int i = 0;
        for (Component com : mnbTN.getMenuComponents()) {
            if (com instanceof JMenuItem) {
                com.setName(String.valueOf(topic[i++]));
            }
        }
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

        Image image = new ImageIcon(getClass().getResource("/images/imageClocks/clock339.jpg"))
                .getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        lbClock.setIcon(new ImageIcon(image));
        lbClock.setFont(new Font("Tahoma", Font.PLAIN, 100));

        btPause.setPreferredSize(new Dimension(48, 48));
        btPause.setIcon(imagePause);
    }

    private void initEvents() {
        menubarEvents();
        btUtilEvents();
    }

    private void menubarEvents() {
        mnbResourcesEvent();
        mnbAuthorEvent();
    }

    private void mnbResourcesEvent() {
        for (Component com : mnbTN.getMenuComponents()) {
            if (com instanceof JMenuItem) {
                com.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItemHandle(com.getName());
                    }
                });
            }
        }
    }

    private void menuItemHandle(String topic) {
        questions.clear();
        questions = process.getAllQuestionsInTheTopic(topic);
        createQuestionButtons();
        currentQuestion = 0;
        createAnswerButtons(currentQuestion);
        lbQuestion.setText(questions.get(currentQuestion).getQuestion());
        lbGif.setIcon(imageDog);
    }

    private void createQuestionButtons() {
        pnTop.removeAll();
        pnTop.repaint();
        if (numberOfQuestions < questions.size()) {
            for (int i = numberOfQuestions; i < questions.size(); i++) {
                JButton button = new JButton();
                button.setPreferredSize(dimensionQuestionButtons);
                button.setIcon(new ImageIcon(getClass().getResource(questionIcon[i % 5].getQuestionIcon())));
                button.setName(String.valueOf(i));
                questionButtons.put(i, button);
                btQuestionEvents(button);
            }
            numberOfQuestions = questions.size();
        }
        for (int i = 0; i < questions.size(); i++) {
            pnTop.add(questionButtons.get(i));
        }
        pnTop.revalidate();
    }

    private void btQuestionEvents(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (Integer.parseInt(button.getName()) != currentQuestion) {
                    createAnswerButtons(Integer.parseInt(button.getName()));
                    lbQuestion.setText(questions.get(currentQuestion).getQuestion());
                    lbGif.setIcon(imageDog);
                    thread.suspend();
                    second = 15;
                    lbClock.setText(String.valueOf(second));
                    btPause.setIcon(imagePause);
                    status = false;
                }
            }
        });
    }

    private void createAnswerButtons(int thQuestion) {
        pnCenterTop.removeAll();
        pnCenterTop.repaint();
        length = questions.get(thQuestion).getAnswer().length();
        if (lengthOfAnswer < length) {
            for (int i = lengthOfAnswer; i < length; i++) {
                JButton button = new JButton();
                button.setFont(font);
                button.setPreferredSize(dimensionAnswerButtons);
                button.setName(String.valueOf(i));
                answerButtons.put(i, button);
                btElementButtonEvents(button);
            }
            lengthOfAnswer = length;
        }
        for (int i = 0; i < length; i++) {
            pnCenterTop.add(answerButtons.get(i));
            answerButtons.get(i).setText("");
        }
        pnCenterTop.revalidate();
        currentQuestion = thQuestion;
    }

    private void mnbAuthorEvent() {
        mnbTG.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "AUTHOR: DANG DINH HOANG");
            }
        });
    }

    private void btElementButtonEvents(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                openTheButton(button);
            }
        });
    }

    private void openTheButton(JButton button) {
        locationInAnswer = Integer.parseInt(button.getName());
        button.setText(String.valueOf(questions.get(currentQuestion).getAnswer().charAt(locationInAnswer)));
        thread.suspend();
        btPause.setIcon(imagePause);
        for (int i = 0; i < lengthOfAnswer; i++) {
            if (answerButtons.get(i).getText().isEmpty()) {
                return;
            }
        }
        lbGif.setIcon(gifClaps);
    }

    @Override
    public void run() {
        while (true) {
            if (start) {
                second = 15;
                start = false;
            }
            if (second >= 0) {
                lbClock.setText(String.valueOf(second--));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
                if (second == 0) {
                    btOpenHandle(imageDog);
                }
            } else {
                thread.suspend();
            }
        }
    }

    private void btUtilEvents() {
        btStartEvent();
        btOpenTheBoxEvent();
        btResetEvent();
        btPauseEvent();
    }

    private void btStartEvent() {
        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                thread.resume();
                start = true;
                lbGif.setIcon(gifDog);
                btPause.setIcon(imageContinue);
                status = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btStart.setSize(defaultDimension);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btStart.setSize(dimension);
            }
        });
    }

    private void btOpenTheBoxEvent() {
        btOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                thread.suspend();
                btOpenHandle(gifClaps);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btOpen.setSize(defaultDimension);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btOpen.setSize(dimension);
            }
        });
    }

    private void btOpenHandle(Icon gifClaps) {
        lbGif.setIcon(gifClaps);
        for (int i = 0; i < lengthOfAnswer; i++) {
            answerButtons.get(i).setText(String.valueOf(questions.get(currentQuestion).getAnswer().charAt(i)));
        }
        btPause.setIcon(imagePause);
        status = false;
    }

    private void btResetEvent() {
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lbGif.setIcon(imageDog);
                for (int i = 0; i < lengthOfAnswer; i++) {
                    answerButtons.get(i).setText("");
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btReset.setSize(defaultDimension);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btReset.setSize(dimension);
            }
        });
    }

    private void btPauseEvent() {
        btPause.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (status) {
                    thread.suspend();
                    btPause.setIcon(imagePause);
                    status = false;
                } else {
                    thread.resume();
                    btPause.setIcon(imageContinue);
                    status = true;
                }
            }
        });
    }
}
