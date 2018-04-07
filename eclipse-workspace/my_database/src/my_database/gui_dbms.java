package my_database;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class gui_dbms {

	private JFrame frmDatabaseTable;
	private static Connection connection;
	private static Statement statement;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_dbms window = new gui_dbms();
					window.frmDatabaseTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui_dbms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatabaseTable = new JFrame();
		frmDatabaseTable.setTitle("DATABASE TABLE");
		frmDatabaseTable.setBounds(100, 100, 450, 300);
		frmDatabaseTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDatabaseTable.getContentPane().setLayout(null);
		
		JButton INSERT = new JButton("INSERT");
		INSERT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new insert();
			}
		});
		INSERT.setBounds(26, 224, 110, 25);
		frmDatabaseTable.getContentPane().add(INSERT);
		
		JButton DELETE = new JButton("DELETE");
		DELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new delete();
			}
		});
		DELETE.setBounds(159, 224, 110, 25);
		frmDatabaseTable.getContentPane().add(DELETE);
		
		JButton SHOW = new JButton("SHOW");
		SHOW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new show();
			}
		});
		SHOW.setBounds(289, 224, 110, 25);
		frmDatabaseTable.getContentPane().add(SHOW);
	}
}
