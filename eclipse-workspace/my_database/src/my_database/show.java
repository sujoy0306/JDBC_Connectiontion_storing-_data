package my_database;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class show extends JFrame {

	private JPanel contentPane;
	private JTextField DATA;

	
	public show() {
		setTitle("DISPLAY");
		setFont(new Font("Dialog", Font.BOLD, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DATA = new JTextField();
		DATA.setBounds(80, 41, 114, 19);
		contentPane.add(DATA);
		DATA.setColumns(10);
		

		String attr[]= {"ROLL","NAME","DEPT_ID","YEAR","SEX","DOB"};
		JComboBox<String> comboBox = new JComboBox(attr);
		comboBox.setBounds(233, 41, 104, 24);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("SHOW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sujoy","hi_sujoy");
					Statement statement = connection.createStatement();
					//String r1,n1,d1,y1,s1,db1;
					String column=comboBox.getItemAt(comboBox.getSelectedIndex());
					//System.out.println(column);
					 String	text=DATA.getText();
					 String res="SELECT * FROM student_data WHERE " +column+"="+"'"+text+"'";
			//		 System.out.println(res);
					 ResultSet rs=statement.executeQuery(res);;
					 while(rs.next()) {
						 int r1  = rs.getInt("roll");
				         String  n1= rs.getString("name");
				         String d1 = rs.getString("dept_id");
				         String y1 = rs.getString("year");
				         String s1 = rs.getString("sex");
				         String db1 = rs.getString("dob");
				         System.out.println(r1+" "+n1+" "+d1+" "+y1+" "+s1+" "+db1);
				        // System.out.println("CRAZY");
					 }
					 rs.close();
					//System.out.println(update+" Row deleted");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(164, 110, 110, 25);
		contentPane.add(btnNewButton);
		setVisible(true);
	}

}
