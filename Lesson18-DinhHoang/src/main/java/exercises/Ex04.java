package exercises;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import service.BackgroundRandomService;
import service.BackgroundRandomServiceImpl;

import static utils.CompUtils.*;

@SuppressWarnings("serial")
public class Ex04 extends JFrame {

	private JLabel lbImageRandom;
	private JButton btStop;

	private final Font btFont = new Font("Tahoma", Font.BOLD, 20);

	private final Container con = getContentPane();
	private final BackgroundRandomService service;

	public Ex04() {
		service = new BackgroundRandomServiceImpl();

		initComponents();
		initEvents();
	}

	private void initComponents() {
		setSize(600, 600);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		con.setBackground(service.getBackgroundColor(1));

		lbImageRandom = new JLabel();
		btStop = new JButton();

		add(lbImageRandom);

		btStop.setFont(btFont);
		btStop.setText("STOP");
		btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btStop.setFocusable(false);
		btStop.setBounds((600 - getPreWidth(btStop) - 10) / 2, 500, getPreWidth(btStop), getPreHeight(btStop));
		add(btStop);
	}

	private void initEvents() {

		new Thread(() -> randomImage()).start();

		btStop.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new Thread(() -> {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.exit(0);
				}).start();
			}
		});
	}

	private void randomImage() {
		int imageNumbers = 8;
		int tmp = -1;
		while (true) {
			int image = new Random().nextInt(imageNumbers) + 1;
			if (image != tmp) {
				lbImageRandom.setIcon(new ImageIcon(getClass().getResource("/images/" + image + ".jpg")));
				lbImageRandom.setBounds((600 - getPreWidth(lbImageRandom)) / 2, 25, getPreWidth(lbImageRandom),
						getPreHeight(lbImageRandom));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tmp = image;
			}
		}
	}
}