package my_database;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class show extends JFrame {

	private JPanel contentPane;
	private JTextField DATA;
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
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
					 new table(rs);
					} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(164, 110, 110, 25);
		contentPane.add(btnNewButton);
		
		JButton show_all = new JButton("SHOW ALL");
		show_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sujoy","hi_sujoy");
					Statement statement = connection.createStatement();
					 String res="SELECT * FROM student_data";
			//		 System.out.println(res);
					 ResultSet rs=statement.executeQuery(res);;
					 new table(rs);
					} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		show_all.setBounds(164, 163, 110, 25);
		contentPane.add(show_all);
		setVisible(true);
	}
}
