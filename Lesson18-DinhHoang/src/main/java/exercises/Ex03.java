package exercises;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import service.BackgroundRandomService;
import service.BackgroundRandomServiceImpl;

import static utils.CompUtils.*;

@SuppressWarnings("serial")
public class Ex03 extends JFrame {

	private JLabel lbRandom;
	private JButton btStop;

	private final Font lbFont = new Font("Tahoma", Font.BOLD, 30);
	private final Font btFont = new Font("Tahoma", Font.BOLD, 20);

	private final Container con = getContentPane();
	private final BackgroundRandomService service;

	public Ex03() {
		service = new BackgroundRandomServiceImpl();

		initComponents();
		initEvents();
	}

	private void initComponents() {
		setSize(600, 500);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		setTitle("Thread Demo");

		lbRandom = new JLabel();
		btStop = new JButton();

		lbRandom.setFont(lbFont);
		add(lbRandom);

		btStop.setFont(btFont);
		btStop.setText("STOP");
		btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btStop.setFocusable(false);
		btStop.setBounds((600 - getPreWidth(btStop) - 10) / 2, 245, getPreWidth(btStop), getPreHeight(btStop));
		add(btStop);
	}

	private void initEvents() {

		Thread thread = new Thread(() -> randomColor());
		thread.start();

		btStop.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				thread.interrupt();

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				setVisible(isUndecorated());
			}
		});

	}

	private void randomColor() {
		int colorNumber = 6;
		int tmp = -1;
		while (true) {
			int color = service.getIndex(colorNumber);
			if (color != tmp) {
				con.setBackground(service.getBackgroundColor(color));
				lbRandom.setText("Random: " + service.getBackgroundColorName(color));
				lbRandom.setBounds((600 - getPreWidth(lbRandom)) / 2, 50, getPreWidth(lbRandom),
						getPreHeight(lbRandom));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.print(e.getMessage());
				}
				tmp = color;
			}
		}

	}
}