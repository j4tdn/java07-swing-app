package exercises;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import service.StringProcessingService;
import service.StringProcessingServiceImpl;

import static utils.CompUtils.*;

@SuppressWarnings("serial")
public class Ex02 extends JFrame {

	private JLabel lbInput;
	private JLabel lbPerform;
	private JLabel lbResult;
	private JLabel lbError;
	private JTextField tfInput;
	private JComboBox<String> cbPerform;
	private JScrollPane spResult;
	private JTextArea taResult;
	private JButton btView;
	private JButton btReset;
	private JButton btExit;

	private final Font textFont = new Font("Tahoma", Font.PLAIN, 14);
	private final Font errorFont = new Font("Tahoma", Font.PLAIN, 13);

	private final StringProcessingService service;

	public Ex02() {
		service = new StringProcessingServiceImpl();

		initComponents();
		initEvents();
	}

	private void initComponents() {
		setSize(600, 500);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		lbInput = new JLabel();
		lbPerform = new JLabel();
		lbResult = new JLabel();
		lbError = new JLabel();
		tfInput = new JTextField();
		cbPerform = new JComboBox<>();
		spResult = new JScrollPane();
		taResult = new JTextArea();
		btView = new JButton();
		btReset = new JButton();
		btExit = new JButton();

		lbInput.setFont(textFont);
		lbInput.setText("Nhập chuổi: ");
		lbInput.setBounds(80, 50, getPreWidth(lbInput), getPreHeight(lbInput));
		add(lbInput);

		lbPerform.setFont(textFont);
		lbPerform.setText("Thực hiện: ");
		lbPerform.setBounds(87, 20 + getPreWidth(lbInput), getPreWidth(lbPerform), getPreHeight(lbPerform));
		add(lbPerform);

		lbResult.setFont(textFont);
		lbResult.setText("Kết quả: ");
		lbResult.setBounds(101, 110 + getPreHeight(lbInput) * 2, getPreWidth(lbResult), getPreHeight(lbResult));
		add(lbResult);

		lbError.setFont(errorFont);
		lbError.setForeground(Color.RED);
		lbError.setText("Không được chứa ký tự và số!");
		lbError.setVisible(false);
		lbError.setBounds(110 + getPreWidth(lbInput), 20, getPreWidth(lbError), getPreHeight(lbError));
		add(lbError);

		tfInput.setFont(textFont);
		tfInput.setBounds(110 + getPreWidth(lbInput), 39, 300, 30);
		add(tfInput);

		cbPerform.setFont(textFont);
		cbPerform.setModel(new DefaultComboBoxModel<>(
				new String[] { "Đếm từ", "Đếm từ trùng lặp", "Chuyển sang Tiếng Việt không dấu" }));
		cbPerform.setBounds(110 + getPreWidth(lbInput), 87, getPreWidth(cbPerform), 30);
		add(cbPerform);

		taResult.setFont(textFont);
		taResult.setRows(1);
		taResult.setColumns(1);
		taResult.setRequestFocusEnabled(false);
		spResult.setViewportView(taResult);
		spResult.setBounds(110 + getPreWidth(lbInput), 140, 300, 220);
		add(spResult);

		btView.setFont(textFont);
		btView.setText("View");
		btView.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btView.setFocusable(false);
		btView.setBounds(90, 395, 90, 35);
		add(btView);

		btReset.setFont(textFont);
		btReset.setText("Reset");
		btReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btReset.setFocusable(false);
		btReset.setBounds(255, 395, 90, 35);
		add(btReset);

		btExit.setFont(textFont);
		btExit.setText("Exit");
		btExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btExit.setFocusable(false);
		btExit.setBounds(420, 395, 90, 35);
		add(btExit);
	}

	private void initEvents() {

		btView.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				convert();
			}
		});

		btReset.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				tfInput.setText(null);
				cbPerform.setSelectedItem("Đếm từ");
				taResult.setText(null);
				tfInput.requestFocus();
			}
		});

		btExit.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	private void convert() {
		String input = tfInput.getText();

		if (input.isEmpty()) {
			return;
		} else if (!service.isAlphabet(input)) {
			lbError.setVisible(true);
		} else {
			String select = (String) cbPerform.getSelectedItem();

			if (select.equals("Đếm từ")) {
				taResult.setText(String.valueOf(service.countWords(input)));
			} else if (select.equals("Đếm từ trùng lặp")) {
				taResult.setText(service.countDuplicateWords(input));
			} else {
				taResult.setText(service.switchTo(input));
			}

			lbError.setVisible(false);
		}
	}
}