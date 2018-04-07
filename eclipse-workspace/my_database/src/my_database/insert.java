package my_database;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class insert extends JFrame {

	private JPanel contentPane;
	private JTextField ROLL1;
	private JTextField NAME1;
	private JTextField SEX1;
	private JTextField DEPT1;
	private JTextField YEAR1;
	private JTextField DOB1;
   int rr2;
	public insert() {
		setTitle("INSERT");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ROLL1 = new JTextField();
		ROLL1.setBounds(40, 12, 114, 19);
		contentPane.add(ROLL1);
		ROLL1.setColumns(8);
		
		
		NAME1 = new JTextField();
		NAME1.setBounds(40, 53, 114, 19);
		contentPane.add(NAME1);
		NAME1.setColumns(30);
		
		
		DEPT1 = new JTextField();
		DEPT1.setBounds(40, 94, 114, 19);
		contentPane.add(DEPT1);
		DEPT1.setColumns(6);
		
		
		YEAR1 = new JTextField();
		YEAR1.setBounds(40, 137, 114, 19);
		contentPane.add(YEAR1);
		YEAR1.setColumns(4);
		
		
		SEX1 = new JTextField();
		SEX1.setBounds(40, 179, 114, 19);
		contentPane.add(SEX1);
		SEX1.setColumns(2);
		
		
		DOB1 = new JTextField();
		DOB1.setBounds(40, 223, 114, 19);
		contentPane.add(DOB1);
		DOB1.setColumns(10);
		
		
		
		JLabel lblRoll = new JLabel("ROLL");
		lblRoll.setBounds(193, 14, 66, 15);
		contentPane.add(lblRoll);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(193, 55, 66, 15);
		contentPane.add(lblName);
		
		JLabel lblDept = new JLabel("DEPT");
		lblDept.setBounds(193, 96, 66, 15);
		contentPane.add(lblDept);
		
		JLabel lblNewLabel = new JLabel("YEAR");
		lblNewLabel.setBounds(193, 139, 66, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblYear = new JLabel("SEX");
		lblYear.setBounds(193, 181, 66, 15);
		contentPane.add(lblYear);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(193, 225, 66, 15);
		contentPane.add(lblDob);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sujoy","hi_sujoy");
					Statement statement = connection.createStatement();
					//String r1,n1,d1,y1,s1,db1;
					
					String	r1=ROLL1.getText();
					 rr2=Integer.parseInt(r1);
					String	n1=NAME1.getText();
					 String	d1=DEPT1.getText();
					 String	y1=YEAR1.getText();
					 String	s1=SEX1.getText();
					 String	db1=DOB1.getText();
					int update=statement.executeUpdate("insert into student_data values("+rr2+",'"+n1+"','"+d1+"','"+y1+"','"+s1+"','"+db1+"')");
					System.out.println(update+" Row inserted");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(304, 93, 90, 55);
		contentPane.add(btnNewButton);
		setVisible(true);
	}
}
