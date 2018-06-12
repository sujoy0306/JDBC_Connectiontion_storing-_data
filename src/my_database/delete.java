package my_database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class delete extends JFrame {

	private JPanel contentPane;
	private JTextField DATA;

	
	public delete() {
		setTitle("DELETE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DATA = new JTextField();
		DATA.setBounds(83, 62, 114, 19);
		contentPane.add(DATA);
		DATA.setColumns(10);
		String attr[]= {"ROLL","NAME","DEPT_ID","YEAR","SEX","DOB"};
		 JComboBox<String> comboBox = new JComboBox(attr);
		comboBox.setBounds(261, 61, 99, 21);
		contentPane.add(comboBox);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans;
				try {
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sujoy","hi_sujoy");
					Statement statement = connection.createStatement();
					//String r1,n1,d1,y1,s1,db1;
					String column=comboBox.getItemAt(comboBox.getSelectedIndex());
					//System.out.println(column);
					 String	text=DATA.getText();
					 String res="DELETE FROM student_data WHERE " +column+"="+"'"+text+"'";
				//	 System.out.println(res);
					int update=statement.executeUpdate(res);
					ans=(update+" Row deleted");
					JOptionPane.showMessageDialog(null,ans);
				} catch (SQLException e1) {
					//e1.printStackTrace();
					ans="Error  Exists!";
					JTextArea output=new JTextArea(16,14);
					output.setText(ans);
					JOptionPane.showMessageDialog(null, ans," dialog box",JOptionPane.ERROR_MESSAGE );
				}
			}
		});
		btnDelete.setBounds(170, 130, 110, 25);
		contentPane.add(btnDelete);
		setVisible(true);
	}
}
