package exercises;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import service.ConvertService;
import service.ConvertServiceImpl;

import static utils.CompUtils.*;

@SuppressWarnings("serial")
public class Ex01 extends JFrame {

	private JLabel lbTitle;
	private JLabel lbInput;
	private JLabel lbResult;
	private JLabel lbError;
	private JTextField tfInput;
	private JTextField tfResult;
	private JButton btResult;

	private final Font titleFont = new Font("Tahoma", Font.BOLD, 36);
	private final Font textFont = new Font("Tahoma", Font.PLAIN, 14);
	private final Font errorFont = new Font("Tahoma", Font.PLAIN, 13);

	private final ConvertService con;

	public Ex01() {
		con = new ConvertServiceImpl();

		initComponents();
		initEvents();
	}

	private void initComponents() {
		setSize(600, 400);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		setTitle("Ex01-Truncate");

		lbTitle = new JLabel();
		lbInput = new JLabel();
		lbResult = new JLabel();
		lbError = new JLabel();
		tfInput = new JTextField();
		tfResult = new JTextField();
		btResult = new JButton();

		lbTitle.setFont(titleFont);
		lbTitle.setForeground(Color.GREEN);
		lbTitle.setText("TRUNCATE - NUMBER");
		lbTitle.setBounds(110, 30, getPreWidth(lbTitle), getPreHeight(lbTitle));
		add(lbTitle);

		lbInput.setFont(textFont);
		lbInput.setText("Nhập dãy số: ");
		lbInput.setBounds(80, 90 + getPreHeight(lbTitle), getPreWidth(lbInput), getPreHeight(lbInput));
		add(lbInput);

		lbError.setFont(errorFont);
		lbError.setForeground(Color.RED);
		lbError.setText("Nhập sai cú pháp");
		lbError.setBounds(130 + getPreWidth(lbInput), 60 + getPreHeight(lbTitle), getPreWidth(lbError),
				getPreHeight(lbError));
		lbError.setVisible(false);
		add(lbError);

		tfInput.setFont(textFont);
		tfInput.setBounds(130 + getPreWidth(lbInput), 80 + getPreHeight(lbTitle), 270, 30);
		add(tfInput);

		lbResult.setFont(textFont);
		lbResult.setText("Kết quả: ");
		lbResult.setBounds(110, 110 + getPreHeight(lbInput) + getPreHeight(lbTitle), getPreWidth(lbResult),
				getPreWidth(lbResult));
		add(lbResult);

		tfResult.setFont(textFont);
		tfResult.setRequestFocusEnabled(false);
		tfResult.setBounds(130 + getPreWidth(lbInput), 120 + getPreHeight(lbInput) + getPreHeight(lbTitle), 270, 30);
		add(tfResult);

		btResult.setFont(textFont);
		btResult.setText("Thực hiện");
		btResult.setFocusable(false);
		btResult.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btResult.setBounds(250 + getPreWidth(lbInput), 180 + getPreHeight(lbInput) + getPreHeight(lbTitle), 150, 30);
		add(btResult);
	}

	private void initEvents() {

		tfInput.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					convert();
				}
			}
		});

		btResult.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				convert();
			}
		});
	}

	private void convert() {
		String input = tfInput.getText();

		if (input.isEmpty()) {
			return;
		} else if (!input.trim().matches("[,0-9]+") || !con.syntaxCheck(input)) {
			lbError.setVisible(true);
		} else {
			tfResult.setText(con.getResult(input));
			lbError.setVisible(false);
		}
	}
}