package com.lottery.calculator.swing;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class TransactionInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public TransactionInfo() {
		setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		setTitle("Transaction Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Edit Transactions");
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button.setBounds(30, 10, 130, 33);
		contentPane.add(button);
		
		Button button_1 = new Button("Add Customers");
		button_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(302, 10, 130, 33);
		contentPane.add(button_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 49, 564, 2);
		contentPane.add(separator);
		
		textField = new JTextField();
		textField.setBounds(142, 105, 215, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomer = new JLabel("Customer Name");
		lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCustomer.setLabelFor(textField);
		lblCustomer.setBounds(30, 107, 94, 17);
		contentPane.add(lblCustomer);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(390, 104, 104, 23);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Arial", Font.PLAIN, 11));
		btnClear.setBounds(504, 104, 89, 23);
		contentPane.add(btnClear);
		
		Button button_2 = new Button("Print Transactions");
		button_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button_2.setBounds(166, 10, 130, 33);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("Transaction Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(29, 62, 94, 20);
		contentPane.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(142, 62, 91, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(257, 62, 91, 20);
		contentPane.add(dateChooser_1);
	}
}
