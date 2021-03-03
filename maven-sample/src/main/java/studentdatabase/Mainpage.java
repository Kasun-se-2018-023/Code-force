package studentdatabase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class Mainpage extends JFrame {
	Studentpage std = new Studentpage();
	private JPanel contentPane;
	Database db = new Database();
	private static JTable table = new JTable();

	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage frame = new Mainpage();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public void tableload() {
		try {
			String sql = "SELECT ID,FIRSTNAME,LASTNAME,NIC,PHONE FROM INFO";
			ps = (PreparedStatement) db.con.prepareStatement(sql);
			rs = (ResultSet) ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void delete_row(int Id_value) {

		try {
			ps = (PreparedStatement) db.con.prepareStatement("DELETE FROM INFO WHERE id = ?");
			ps.setInt(1, Id_value);
			ps.execute();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Mainpage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("School Managment System.");
		lblNewLabel.setBounds(202, 26, 132, 25);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("ADD\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				std.setVisible(true);

			}
		});
		btnNewButton.setBounds(35, 494, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("EDIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String FIRSTNAME = (String) table.getValueAt(i, 1);
				String LASTNAME = (String) table.getValueAt(i, 2);
				String NIC = (String) table.getValueAt(i, 3);
				String PHONE = (String) table.getValueAt(i, 4);
				std.edit(FIRSTNAME, LASTNAME, NIC, PHONE);
				setVisible(false);
				std.setVisible(true);
				int Id_value_foredit = (Integer) table.getValueAt(i, 0);
				delete_row(Id_value_foredit);

			}
		});
		btnNewButton_1.setBounds(181, 494, 89, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				int Id_value = (Integer) table.getValueAt(i, 0);

				delete_row(Id_value);
				new Mainpage().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(328, 494, 89, 23);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Exit\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(461, 494, 89, 23);
		panel.add(btnNewButton_3);

		table.setBounds(0, 156, 564, 308);
		panel.add(table);
		tableload();
	}
}
