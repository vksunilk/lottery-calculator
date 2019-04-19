package com.lottery.calculator.swing;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class TransactionInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

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
		textField.setBounds(142, 104, 226, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblCustomer = new JLabel("Customer Name");
		lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCustomer.setLabelFor(textField);
		lblCustomer.setBounds(30, 103, 94, 21);
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

		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(142, 62, 105, 21);
		contentPane.add(dateChooser);

		final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(257, 62, 111, 21);
		contentPane.add(dateChooser_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 134, 564, 2);
		contentPane.add(separator_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 147, 563, 265);
		contentPane.add(scrollPane);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				dateChooser.setDate(new Date());
				dateChooser_1.setDate(new Date());
			}
		});
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
