package studentdatabase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Studentpage extends JFrame {

	private static Database db = new Database();

	private JPanel contentPane;
	static private JTextField textField_1;
	static private JTextField textField_2;
	static private JTextField textField_3;
	static private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentpage frame = new Studentpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */

	PreparedStatement ps = null;

	public void edit(String FIRSTNAME, String LASTNAME, String NIC, String PHONE) {
		textField_1.setText(FIRSTNAME);
		textField_2.setText(LASTNAME);
		textField_3.setText(NIC);
		textField_4.setText(PHONE);

	}

	public static void insertmethod() {

		String FIRSTNAME = textField_1.getText();
		String LASTNAME = textField_2.getText();
		String NIC = textField_3.getText();
		String PHONE = textField_4.getText();
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");

		PreparedStatement ps;
		try {
			ps = (PreparedStatement) db.con
					.prepareStatement("INSERT INTO INFO(FIRSTNAME,LASTNAME,NIC,PHONE) VALUES(?,?,?,?)");

			ps.setString(1, FIRSTNAME);
			ps.setString(2, LASTNAME);
			ps.setString(3, NIC);
			ps.setString(4, PHONE);
			ps.execute();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public Studentpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setBounds(50, 178, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Last name");
		lblNewLabel_2.setBounds(50, 227, 46, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("NIC");
		lblNewLabel_3.setBounds(50, 291, 46, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Phone");
		lblNewLabel_4.setBounds(50, 335, 46, 14);
		panel.add(lblNewLabel_4);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Mainpage().setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 491, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertmethod();
				setVisible(false);
				new Mainpage().setVisible(true);

			}
		});
		btnNewButton_1.setBounds(223, 491, 89, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(420, 491, 89, 23);
		panel.add(btnNewButton_2);

		textField_1 = new JTextField();
		textField_1.setBounds(209, 175, 249, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(208, 224, 250, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(209, 288, 249, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(209, 332, 249, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("School Data Entering page");
		lblNewLabel_5.setBounds(223, 23, 127, 14);
		panel.add(lblNewLabel_5);
	}
}
