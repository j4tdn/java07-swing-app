/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.IconQuestion;
import beans.Question;
import common.Topic;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import sevice.ReadFile;

/**
 *
 * @author Asus
 */
public class frMain extends javax.swing.JFrame implements Runnable{
    private final ReadFile readFile;
    private List<Question> questions ;
    private final IconQuestion[] iconQuestions = IconQuestion.values();
    private int currentQuestion =-1;
    private final Font font = new Font("Tahom", Font.PLAIN, 28);
    private final Topic[] topics = Topic.values();
    private static Thread thread;
    private int second =15;
    private boolean btStatus = true;
    private final Icon Gif = new ImageIcon(getClass().getResource("/images/dog.gif"));
    private final Icon Png = new ImageIcon(getClass().getResource("/images/dog.png"));
    private final Icon clap = new ImageIcon(getClass().getResource("/images/claps04.gif"));
    private final Icon pause = new ImageIcon(getClass().getResource("/images/pause.png"));
    private final Icon resume = new ImageIcon(getClass().getResource("/images/resume.png"));

    /**
     * Creates new form frMain
     */
    public frMain() {
        readFile = new ReadFile();
        initComponents();
        initComponent();
        initEvent();
    }
    private void initComponent(){
         setNameMenuItem();
         createButton("Family");
         btPause.setVisible(false);
         
    }
    private void setNameMenuItem(){
        int count=0;
        
        for(Component com :menuTN.getMenuComponents()){
            
            if(com instanceof JMenuItem){
                com.setName(String.valueOf(topics[count++]));
                
            }
        }
        
    }
    private void initEvent(){
        menuBarEvent();
        bottomEvent();
    }
    private void bottomEvent(){
        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(currentQuestion!=-1){
                btPause.setVisible(true);
                second=15;
                thread.resume();
                lbGif.setIcon(Gif);
                }
                
            }
            
        });
        btPause.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(btStatus){
                    
                    btStatus=false;
                    thread.suspend();
                    btPause.setIcon(resume);
                    
                }
                else{
                    
                    btPause.setIcon(pause);
                    thread.resume();
                    btStatus= true;
                    
                    
                }
            }
            
        });
        btOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int count =0;
                for(Component com:pnTopBot.getComponents()){
                    if(com instanceof JButton){
                        ((JButton) com).setText(String.valueOf(questions.get(currentQuestion).getAnswer().charAt(count++)));
                    }
                }
                lbGif.setIcon(clap);
            }
            
        });
        btDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int count =0;
                for(Component com:pnTopBot.getComponents()){
                    if(com instanceof JButton){
                        ((JButton) com).setText("");
                    }
                }
                lbGif.setIcon(Png);
            }
            
        });
    }
    private void menuBarEvent(){
        
        for(Component com :menuTN.getMenuComponents()){
            if(com instanceof JMenuItem){
                com.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        questions.clear();
                        
                        createButton(com.getName());
                    }
                    
                });
            }
        }
    }
    private void createButton(String topic){
        pnTopTop.removeAll();
        questions = readFile.getAllQuestions(topic);
        for(int i=0;i<questions.size();i++){
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(50, 50));
            button.setIcon(new ImageIcon(getClass().getResource(String.valueOf(iconQuestions[i%5].getVaue()))));
            button.setName(String.valueOf(questions.get(i).getId()));
            buttonQuestionEvent(button);
            
            pnTopTop.add(button);
            
        }
        pnTopTop.revalidate();
        pnTopTop.repaint();
        
    }
    private void createAnser(){
        pnTopBot.removeAll();
        for(int i=0;i<questions.get(currentQuestion).getAnswer().length();i++){
            
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(60, 60));
            button.setFont(font);
            buttonAnswerEvent(button,i);
            pnTopBot.add(button);
        }
        pnTopBot.revalidate();
        pnTopBot.repaint();
    }
    
    private void buttonQuestionEvent(JButton button){
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentQuestion = Integer.parseInt(button.getName());
                createAnser();
                lbQuestion.setText(questions.get(currentQuestion).getQuestions()    );
                lbGif.setIcon(Png);
            }
            
        });
        
    }
    private void buttonAnswerEvent(JButton button ,int index){
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button.setText(String.valueOf(questions.get(currentQuestion).getAnswer().charAt(index)));
                for(Component com:pnTopBot.getComponents()){
                    if(com instanceof JButton){
                        if(((JButton) com).getText().isEmpty()){
                            return;
                        }
                    }
                }
                lbGif.setIcon(clap);
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
        pnTopTop = new javax.swing.JPanel();
        pnTopBot = new javax.swing.JPanel();
        pnBot = new javax.swing.JPanel();
        btStart = new javax.swing.JButton();
        btOpen = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        pnClock = new javax.swing.JPanel();
        lbClock = new javax.swing.JLabel();
        btPause = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnQuestion = new javax.swing.JPanel();
        lbQuestion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbGif = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuTN = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 800));

        pnTop.setLayout(new java.awt.BorderLayout());

        pnTopTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnTop.add(pnTopTop, java.awt.BorderLayout.PAGE_START);

        pnTopBot.setBackground(new java.awt.Color(0, 204, 0));
        pnTopBot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnTopBot.setPreferredSize(new java.awt.Dimension(934, 200));
        pnTop.add(pnTopBot, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnBot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btStart.setText("Bắt Đầu");
        pnBot.add(btStart);

        btOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btOpen.setText("Mở Ô Chữ");
        pnBot.add(btOpen);

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btDelete.setText("Xóa Ô Chữ");
        pnBot.add(btDelete);

        getContentPane().add(pnBot, java.awt.BorderLayout.PAGE_END);

        pnCenter.setLayout(new java.awt.BorderLayout());

        pnClock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbClock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbClock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock.png"))); // NOI18N
        lbClock.setToolTipText("");
        lbClock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause.png"))); // NOI18N
        btPause.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout pnClockLayout = new javax.swing.GroupLayout(pnClock);
        pnClock.setLayout(pnClockLayout);
        pnClockLayout.setHorizontalGroup(
            pnClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClockLayout.createSequentialGroup()
                .addGroup(pnClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnClockLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbClock))
                    .addGroup(pnClockLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btPause, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnClockLayout.setVerticalGroup(
            pnClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClockLayout.createSequentialGroup()
                .addComponent(btPause, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(lbClock)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pnCenter.add(pnClock, java.awt.BorderLayout.LINE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        pnQuestion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnQuestion.setPreferredSize(new java.awt.Dimension(755, 120));

        lbQuestion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pnQuestion.add(lbQuestion);

        jPanel2.add(pnQuestion, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dog.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(lbGif)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbGif)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        pnCenter.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        menuTN.setText("Tài Nguyên");

        jMenuItem1.setText("Gia Đình");
        menuTN.add(jMenuItem1);
        menuTN.add(jSeparator1);

        jMenuItem2.setText("Sức Khỏe");
        menuTN.add(jMenuItem2);
        menuTN.add(jSeparator2);

        jMenuItem3.setText("Động Vật");
        menuTN.add(jMenuItem3);

        jMenuBar1.add(menuTN);

        jMenu2.setText("Tác Giả");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
            java.util.logging.Logger.getLogger(frMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        frMain  mainview =  new frMain();
           mainview.setVisible(true);
        thread = new Thread(mainview);
         thread.start();
         thread.suspend();
    }
    @Override
    public void run() {
        while (true) {            
            if(second>=0){
                lbClock.setText(String.valueOf(second--));
            
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            }
            else{
                
                btPause.setVisible(false);
                pnClock.revalidate();
                pnClock.repaint();
                thread.suspend();
                
                
            }
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btPause;
    private javax.swing.JButton btStart;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lbClock;
    private javax.swing.JLabel lbGif;
    private javax.swing.JLabel lbQuestion;
    private javax.swing.JMenu menuTN;
    private javax.swing.JPanel pnBot;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnClock;
    private javax.swing.JPanel pnQuestion;
    private javax.swing.JPanel pnTop;
    private javax.swing.JPanel pnTopBot;
    private javax.swing.JPanel pnTopTop;
    // End of variables declaration//GEN-END:variables
}
