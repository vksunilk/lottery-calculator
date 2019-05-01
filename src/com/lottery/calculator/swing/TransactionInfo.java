package com.lottery.calculator.swing;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import com.lottery.calculator.biz.loadtransactions.LoadTransactionService;
import com.lottery.calculator.bizcore.entity.CustomerTransactionModel;
import com.toedter.calendar.JDateChooser;

public class TransactionInfo {

	private JFrame transactionFrame;

	public JFrame getTransactionFrame() {
		return transactionFrame;
	}

	private AddCustomerDialog customerDialog;
	private EditTransactions editTransactions;

	private LoadTransactionService loadTransactionService;
	private AddGroupDialog groupDialog;
	private JPanel contentPane;
	private JTextField customerTxt;
	private JTable table;
	private JDateChooser fromDateChooser;
	private JDateChooser toDateChooser;
	private JScrollPane scrollPane;
	private static final String EXTENDED_STATE_KEY = "extendedState";

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public TransactionInfo() {
		transactionFrame = new JFrame();
		loadTransactionService = new LoadTransactionService();
		transactionFrame.setLocationRelativeTo(null);
		transactionFrame.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		transactionFrame.setTitle("Transaction Details");
		transactionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		transactionFrame.setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		transactionFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		Button button = new Button("Edit Transactions");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					editTransactions = new EditTransactions();
					editTransactions.getEditTransactions().setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button.setBounds(30, 10, 130, 33);
		contentPane.add(button);

		Button button_1 = new Button("Add Customers");
		button_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					customerDialog = new AddCustomerDialog();
					customerDialog.getAddCustomerDialog().setVisible(true);
				} catch (InstantiationException | IllegalAccessException | SQLException e) {
					JOptionPane.showMessageDialog(transactionFrame, "Some Error Occured. Please try again later");
					e.printStackTrace();
				}

			}
		});
		button_1.setBounds(302, 10, 130, 33);
		contentPane.add(button_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(29, 49, 953, 2);
		contentPane.add(separator);

		customerTxt = new JTextField();
		customerTxt.setBounds(142, 104, 301, 32);
		contentPane.add(customerTxt);
		customerTxt.setColumns(10);

		JLabel lblCustomer = new JLabel("Customer Name");
		lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCustomer.setLabelFor(customerTxt);
		lblCustomer.setBounds(30, 103, 94, 33);
		contentPane.add(lblCustomer);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.addActionListener(new GetListener());
		btnNewButton.setBounds(476, 103, 104, 33);
		contentPane.add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Arial", Font.PLAIN, 11));
		btnClear.setBounds(602, 103, 89, 33);
		contentPane.add(btnClear);

		Button button_2 = new Button("Print Transactions");
		button_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button_2.setBounds(166, 10, 130, 33);
		contentPane.add(button_2);

		JLabel lblNewLabel = new JLabel("Transaction Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(29, 62, 94, 30);
		contentPane.add(lblNewLabel);

		fromDateChooser = new JDateChooser();
		fromDateChooser.setBounds(142, 62, 154, 31);
		fromDateChooser.setDate(new Date());
		contentPane.add(fromDateChooser);

		toDateChooser = new JDateChooser();
		toDateChooser.setBounds(330, 62, 154, 31);
		toDateChooser.setDate(new Date());
		contentPane.add(toDateChooser);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 136, 952, 0);
		contentPane.add(separator_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 159, 952, 391);
		contentPane.add(scrollPane);
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerTxt.setText("");
				fromDateChooser.setDate(new Date());
				toDateChooser.setDate(new Date());
			}
		});
		table = new JTable();
		scrollPane.setViewportView(table);

		Button viewCustomerButton = new Button("View Customers");
		viewCustomerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		viewCustomerButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		viewCustomerButton.setBounds(438, 10, 130, 33);
		contentPane.add(viewCustomerButton);

		Button button_3 = new Button("Add Group");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					groupDialog = new AddGroupDialog();
					groupDialog.getAddGroupDialog().setVisible(true);
				} catch (InstantiationException | IllegalAccessException | SQLException e) {
					JOptionPane.showMessageDialog(transactionFrame, "Some Error Occured. Please try again later");
					e.printStackTrace();
				}
			}
		});
		button_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button_3.setBounds(574, 10, 130, 33);
		contentPane.add(button_3);
	}

	class GetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Get whatever the user entered, trim any white space and change to
			// upper case
			String customer = customerTxt.getText().trim();
			Date fromDate = fromDateChooser.getDate();
			Date toDate = toDateChooser.getDate();

			// Replace any single quote chars w/ space char or SQL will think
			// the ' is the end of the string
			customer = customer.replace('\'', ' ');

			// Get rid of the last result displayed if there is one
			if (scrollPane != null)
				transactionFrame.getContentPane().remove(scrollPane);
			CustomerTransactionModel customerTransactionModel = loadTransactionService.getTableModel(customer, fromDate,
					toDate);
			if (customerTransactionModel != null) {
				table = new JTable(customerTransactionModel);
			} else {
				table = new JTable();
			}
			// Allows the user to only delete one record at a time
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// Add the table with the results to the contentPane and display it.
			scrollPane = new JScrollPane(table);
			transactionFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
			transactionFrame.doLayout();
		}

	}
}
