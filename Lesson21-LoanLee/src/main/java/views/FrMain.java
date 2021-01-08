/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import common.ButtonQuestion;
import connection.ConfigurationProvider;
import connection.ConfigurationProviderImpl;
import file.ReadFile;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import model.bean.Topic;

/**
 *
 * @author ADMIN
 */
public class FrMain extends javax.swing.JFrame {

    private final ConfigurationProvider provider = new ConfigurationProviderImpl();
    Properties props;
    ReadFile readFile = new ReadFile();
    int count = 1;
    Timer timer;
    boolean isButtonEnter = false;
    JPanel panelEnable;
    private JButton previousClickedButton;
    private Border defaultBorder;
    //boolean btEnable = false;
    private final Border highlightBorder = BorderFactory.createLineBorder(Color.red, 3);
    private final Container conn = getContentPane();
    private int time = 12;
    private final Font font = new Font("Tahoma", Font.PLAIN, 20);
    Component[] componentPnTop;
    Component[] componentPnCenterTop;
    private int tmp = 0;
    private String ans;
    private int length = 0;
    private boolean isEnable = false;
    List<String> result = null;
    List<Topic> listQA = new ArrayList<>();
    private final Map<JMenuItem, String> cardMap;

    /**
     * Creates new form FrMain
     */
    public FrMain() {
        cardMap = new LinkedHashMap<JMenuItem, String>();
        cardMap.put(mniFamily, "Family");
        cardMap.put(mniHealthy, "Healthy");
        cardMap.put(mniLife, "Life");
        cardMap.put(mniScience, "Science");
        cardMap.put(mnAuthor, "Author");

        initComponents();
        initComponentMatually();
        initEvents();

    }

    public void initComponentMatually() {
        setTitle("TIME");
        setLocationRelativeTo(null);
        Image image = new ImageIcon(getClass().getResource("/images/haha.png")).getImage();
        setIconImage(image);
        conn.add(pnCenter);
        btClock.setBackground(new Color(0, 0, 0, 0));
    }

    public void initEvents() {
        props = provider.getProperties();
        btBottomEvents();
        initMenuEvents();
        initQuestionEvents();
    }

    public void initMenuEvents() {
        mniFamily.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pnTop.removeAll();
                pnCenterTop.removeAll();
                pnCenterTop.repaint();
                String topic = props.getProperty("Family");
                try {
                    result = readFile.read(topic);
                } catch (IOException ex) {
                    Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                createButtonQuestion(topic, result);
                pnTop.repaint();
                pnTop.revalidate();
                initQuestionEvents();
            }
        });
        mniHealthy.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pnTop.removeAll();
                pnCenterTop.removeAll();
                pnCenterTop.repaint();
                String topic = props.getProperty("Health");
                try {
                    result = readFile.read(topic);
                } catch (IOException ex) {
                    Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                createButtonQuestion(topic, result);
                pnTop.repaint();
                pnTop.revalidate();
                initQuestionEvents();
            }
        });
        mniLife.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pnTop.removeAll();
                pnCenterTop.removeAll();
                pnCenterTop.repaint();
                String topic = props.getProperty("Life");
                try {
                    result = readFile.read(topic);
                } catch (IOException ex) {
                    Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                createButtonQuestion(topic, result);
                pnTop.repaint();
                pnTop.revalidate();
                initQuestionEvents();
            }
        });
        mniScience.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pnTop.removeAll();
                pnCenterTop.removeAll();
                pnCenterTop.repaint();
                String topic = props.getProperty("Science");
                try {
                    result = readFile.read(topic);
                } catch (IOException ex) {
                    Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                createButtonQuestion(topic, result);
                pnTop.repaint();
                pnTop.revalidate();
                initQuestionEvents();
            }
        });
        mnAuthor.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pnTop.removeAll();
                pnCenterTop.removeAll();
                pnCenterTop.repaint();
                String topic = props.getProperty("Author");
                try {
                    result = readFile.read(topic);
                } catch (IOException ex) {
                    Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                createButtonQuestion(topic, result);
                pnTop.repaint();
                pnTop.revalidate();
                initQuestionEvents();
            }
        });
    }

    public void initQuestionEvents() {
        componentPnTop = pnTop.getComponents();
        for (Component component : componentPnTop) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        isEnable = true;
                        count = 1;
                        lbImage.setIcon(new ImageIcon(getClass().getResource("/images/dog.png")));
                        pnCenterTop.removeAll();
                        for (int i = 0; i < listQA.size(); i++) {
                            if (button.getName().equals(listQA.get(i).getId())) {
                                char[] ch = listQA.get(i).getAnswer().toCharArray();
                                lbQuestion.setText(listQA.get(i).getQuestion());
                                createButtonAnswer(listQA.get(i).getAnswer());
                                pnCenterTop.repaint();
                                pnCenterTop.revalidate();
                            }
                        }

                    }
                });
            }
        }
    }

    public void createButtonQuestion(String topic, List<String> result) {
        ButtonQuestion[] bq = ButtonQuestion.values();
        listQA.clear();
        List<String> idTopic = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            String[] QA = result.get(i).split("-");
            JButton button = new JButton();
            button.setName(topic + i);
            button.setPreferredSize(new Dimension(70, 70));
            Topic to = new Topic(button.getName(), QA[0], QA[1]);
            listQA.add(to);
            button.setIcon(new ImageIcon(getClass().getResource(bq[i % 5].getVaue())));
            pnTop.add(button);

        }
    }

    public void createButtonAnswer(String answer) {
        ButtonQuestion[] bq = ButtonQuestion.values();
        List<String> idTopic = new ArrayList<>();
        for (int i = 0; i < answer.length(); i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(70, 70));
            button.setName(answer + i);
            button.setFont(new Font(font) {
            });
            pnCenterTop.add(button);

        }
        initAnswerEvents(answer);
    }

    private void initAnswerEvents(String answer) {
        ans = answer;
        componentPnCenterTop = pnCenterTop.getComponents();
        for (int i = 0; i < componentPnCenterTop.length; i++) {
            JButton button = (JButton) componentPnCenterTop[i];
            int a = i;
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {

                    for (int j = 0; j < answer.length(); j++) {
                        if (count == answer.length() && button.getText().isEmpty()) {
                            button.setText(Character.toString(answer.charAt(j)).toUpperCase());
                            lbImage.setIcon(new ImageIcon(getClass().getResource("/images/claps04.gif")));
                        } else if (button.getName().equals(answer + j)) {
                            count++;
                            button.setText(Character.toString(answer.charAt(j)).toUpperCase());
                        }
                    }
                }
            });
        }
    }

    private void btBottomEvents() {
        processTime();
    }

    private void processTime() {
        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isEnable) {
                    btClock.setVisible(true);
                    time = 12;
                    btClock.setIcon(new ImageIcon(getClass().getResource("/images/pause.png")));
                    lbImage.setIcon(new ImageIcon(getClass().getResource("/images/dog.gif")));
                    if (timer == null) {
                        timer = new Timer(1000, (ActionEvent e1) -> {
                            if (time == 0) {
                                timer.stop();
                                btClock.setVisible(false);
                            }
                            lbIClock.setText(Integer.toString(time--));
                        });
                        timer.start();
                    } else {
                        timer.restart();
                    }
                }
            }
        });

        btOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btClock.setVisible(false);
                lbImage.setIcon(new ImageIcon(getClass().getResource("/images/claps04.gif")));
                for (int i = 0; i < ans.length(); i++) {
                    JButton button = (JButton) componentPnCenterTop[i];
                    button.setText(Character.toString(ans.charAt(i)).toUpperCase());
                }
                if (timer != null) {
                    timer.stop();
                }

            }
        });

        btDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btClock.setVisible(false);
                for (int i = 0; i < ans.length(); i++) {
                    JButton button = (JButton) componentPnCenterTop[i];
                    button.setText("");
                }
                lbIClock.setText("12");
                if (timer != null) {
                    timer.stop();
                }
            }

        });
        btClock.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (timer.isRunning()) {
                    btClock.setIcon(new ImageIcon(getClass().getResource("/images/resume.png")));
                    timer.stop();
                } else {
                    btClock.setIcon(new ImageIcon(getClass().getResource("/images/pause.png")));
                    timer.start();
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        pnTop = new javax.swing.JPanel();
        pnBottom = new javax.swing.JPanel();
        btStart = new javax.swing.JButton();
        btOpen = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        pnCenterTop = new javax.swing.JPanel();
        pnCenterLeft = new javax.swing.JPanel();
        lbQuestion = new javax.swing.JLabel();
        lbImage = new javax.swing.JLabel();
        pnCenterRight = new javax.swing.JPanel();
        lbIClock = new javax.swing.JLabel();
        btClock = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        mnResource = new javax.swing.JMenu();
        mniFamily = new javax.swing.JMenuItem();
        mniHealthy = new javax.swing.JMenuItem();
        mniLife = new javax.swing.JMenuItem();
        mniScience = new javax.swing.JMenuItem();
        mnAuthor = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 0));

        pnTop.setBackground(new java.awt.Color(255, 255, 255));
        pnTop.setPreferredSize(new java.awt.Dimension(1200, 100));
        getContentPane().add(pnTop, java.awt.BorderLayout.NORTH);

        pnBottom.setBackground(new java.awt.Color(255, 255, 255));

        btStart.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btStart.setText("Bắt đầu");
        btStart.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btOpen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btOpen.setText("Mở ô chữ");
        btOpen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btDelete.setText("Xóa ô chữ");
        btDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout pnBottomLayout = new javax.swing.GroupLayout(pnBottom);
        pnBottom.setLayout(pnBottomLayout);
        pnBottomLayout.setHorizontalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addGap(462, 462, 462)
                .addComponent(btStart, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(438, Short.MAX_VALUE))
        );
        pnBottomLayout.setVerticalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btStart, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(btOpen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pnBottom, java.awt.BorderLayout.SOUTH);

        pnCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnCenterTop.setBackground(new java.awt.Color(102, 255, 0));

        pnCenterLeft.setBackground(new java.awt.Color(255, 255, 255));

        lbQuestion.setBackground(new java.awt.Color(153, 153, 153));
        lbQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuestion.setText("What is the superpower make So better?");

        lbImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dog.png"))); // NOI18N

        javax.swing.GroupLayout pnCenterLeftLayout = new javax.swing.GroupLayout(pnCenterLeft);
        pnCenterLeft.setLayout(pnCenterLeftLayout);
        pnCenterLeftLayout.setHorizontalGroup(
            pnCenterLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCenterLeftLayout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(lbImage)
                .addGap(247, 247, 247))
        );
        pnCenterLeftLayout.setVerticalGroup(
            pnCenterLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLeftLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pnCenterRight.setBackground(new java.awt.Color(255, 255, 255));

        lbIClock.setBackground(new java.awt.Color(255, 255, 255));
        lbIClock.setFont(new java.awt.Font("Tahoma", 0, 150)); // NOI18N
        lbIClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIClock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock339.jpg"))); // NOI18N
        lbIClock.setText("12");
        lbIClock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbIClock.setPreferredSize(new java.awt.Dimension(300, 300));

        btClock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause.png"))); // NOI18N

        javax.swing.GroupLayout pnCenterRightLayout = new javax.swing.GroupLayout(pnCenterRight);
        pnCenterRight.setLayout(pnCenterRightLayout);
        pnCenterRightLayout.setHorizontalGroup(
            pnCenterRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCenterRightLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbIClock, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btClock)
                .addGap(28, 28, 28))
        );
        pnCenterRightLayout.setVerticalGroup(
            pnCenterRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterRightLayout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(btClock, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
            .addGroup(pnCenterRightLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lbIClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnCenterLayout = new javax.swing.GroupLayout(pnCenter);
        pnCenter.setLayout(pnCenterLayout);
        pnCenterLayout.setHorizontalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addComponent(pnCenterLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCenterRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCenterLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnCenterTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCenterLayout.setVerticalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCenterTop, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCenterLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(pnCenterLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCenterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnCenterRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        mnResource.setText("Tài nguyên");

        mniFamily.setText("Gia đình");
        mnResource.add(mniFamily);

        mniHealthy.setText("Sức khỏe");
        mnResource.add(mniHealthy);

        mniLife.setText("Cuộc sống");
        mnResource.add(mniLife);

        mniScience.setText("Khoa học");
        mnResource.add(mniScience);

        menu.add(mnResource);

        mnAuthor.setText("Tác giả");
        menu.add(mnAuthor);

        setJMenuBar(menu);

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
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JButton btClock;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btStart;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JLabel lbIClock;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbQuestion;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu mnAuthor;
    private javax.swing.JMenu mnResource;
    private javax.swing.JMenuItem mniFamily;
    private javax.swing.JMenuItem mniHealthy;
    private javax.swing.JMenuItem mniLife;
    private javax.swing.JMenuItem mniScience;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnCenterLeft;
    private javax.swing.JPanel pnCenterRight;
    private javax.swing.JPanel pnCenterTop;
    private javax.swing.JPanel pnTop;
    // End of variables declaration//GEN-END:variables

}
