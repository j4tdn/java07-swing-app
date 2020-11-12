/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import service.ConverterService;
import service.ConverterServiceImpl;
import static utils.CompUtils.*;

/**
 *
 * @author DangHoang
 */
@SuppressWarnings("serial")
public class Ex04 extends JFrame {

	Container contentPane = getContentPane();

	private JLabel lbTitle;
	private JLabel lbErorrMessage;
	private JTextField tfInput;
	private JTextField tfResult;
	private JButton btSubmit;

	private final Font textTitle = new Font("Tahoma", Font.BOLD, 26);
	private final Font textFont = new Font("Tahoma", Font.PLAIN, 22);
	private final Font textHighlightFont = new Font("Tahoma", Font.BOLD, 23);
	private final Font errorFont = new Font("Tahoma", Font.ITALIC, 14);

	private final ConverterService converter;

	public Ex04() {
		converter = new ConverterServiceImpl();

		// UI
		initComponents();
		// Events
		initEvens();
	}

	private void initComponents() {
		setSize(650, 320);
		setResizable(false);
		setLocationRelativeTo(null);

		Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
		setIconImage(image);
		setTitle("Java-App");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        JFrame layout default : border layout
//        setLayout
		setLayout(null);

//        set foreground - brackground
		contentPane.setBackground(Color.GREEN);

		lbTitle = new JLabel();
		lbTitle.setFont(textTitle);
		lbTitle.setText("--- How to convert test -App ---");
		lbTitle.setBounds(120, 30, getPreWidth(lbTitle), getPreHeight(lbTitle));
		add(lbTitle);

		tfInput = new JTextField();
		tfInput.setFont(textFont);
		tfInput.setBounds(120, getPreHeight(lbTitle) + 30 * 2, getPreWidth(lbTitle), 32);
		add(tfInput);

		btSubmit = new JButton();
		btSubmit.setFont(textFont);
		btSubmit.setText("Submit");
		btSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR) {
		});
		btSubmit.setFocusable(false);
		btSubmit.setBounds(120, getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2,
				32);
		add(btSubmit);

		tfResult = new JTextField();
		tfResult.setFont(textFont);
		tfResult.setBounds(160 + (getPreWidth(lbTitle) - 40) / 2,
				getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
		tfResult.setRequestFocusEnabled(false);
		add(tfResult);

		lbErorrMessage = new JLabel();
		lbErorrMessage.setFont(errorFont);
		lbErorrMessage.setText("Input value is not valid!");
		lbErorrMessage.setForeground(Color.RED);
		lbErorrMessage.setVisible(false);
		lbErorrMessage.setBounds(120, btSubmit.getY() + getPreHeight(btSubmit) + 30, getPreWidth(lbErorrMessage) + 5,
				getPreHeight(lbErorrMessage));
		add(lbErorrMessage);
	}

	private void initEvens() {
		tfInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Convert();
				}
			}
		});

		btSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Convert();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Convert();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btSubmit.setFont(textHighlightFont);
				btSubmit.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btSubmit.setFont(textFont);
				btSubmit.setForeground(Color.BLACK);
			}
		});
	}

	private void Convert() {
		String input = tfInput.getText();
		if (input.isEmpty()) {
			return;
		}
		if (!input.trim().matches("[a-zA-Z\\s]{6,}")) {
			lbErorrMessage.setVisible(true);
		} else {
			tfResult.setText(converter.convert(input));
			lbErorrMessage.setVisible(false);
		}
	}

	public static void main(String[] args) {
		Ex04 that = new Ex04();
		that.setVisible(true);
	}
}
