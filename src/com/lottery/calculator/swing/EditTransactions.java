package com.lottery.calculator.swing;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lottery.calculator.biz.customer.CustomerService;
import com.lottery.calculator.bizcore.entity.CustomerEntity;
import com.lottery.calculator.swing.customcomponent.DoubleJTextField;

public class EditTransactions {

	JDialog editTransactions;
	CustomerService customerService;

	public JDialog getEditTransactions() {
		return editTransactions;
	}

	public EditTransactions() throws SQLException, InstantiationException, IllegalAccessException {
		editTransactions = new JDialog();
		editTransactions.setLocationRelativeTo(null);
		editTransactions.setTitle("Edit Transactions");
		editTransactions.setBounds(10, 150, 381, 429);
		editTransactions.getContentPane().setLayout(null);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(168, 54, 147, 20);
		customerService = new CustomerService();
		List<CustomerEntity> customerList = customerService.getCustomersAsEntity();
		if (customerList != null) {
			customerList.stream().forEach(action -> comboBox.addItem(action.getCustomerName()));
		}
		editTransactions.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("Customer Name");
		lblNewLabel.setBounds(10, 56, 99, 17);
		editTransactions.getContentPane().add(lblNewLabel);

		Label label = new Label("Daily Transaction");
		label.setBounds(10, 89, 99, 22);
		editTransactions.getContentPane().add(label);

		Label label_1 = new Label("Weekly Transaction");
		label_1.setBounds(10, 129, 114, 22);
		editTransactions.getContentPane().add(label_1);

		Label label_2 = new Label("Outstanding Balance");
		label_2.setBounds(10, 167, 131, 22);
		editTransactions.getContentPane().add(label_2);

		Label label_3 = new Label("Paid");
		label_3.setBounds(10, 210, 88, 22);
		editTransactions.getContentPane().add(label_3);

		Label label_4 = new Label("Commission");
		label_4.setBounds(10, 244, 88, 22);
		editTransactions.getContentPane().add(label_4);

		Label label_5 = new Label("Total Balance");
		label_5.setBounds(10, 285, 99, 22);
		editTransactions.getContentPane().add(label_5);

		JTextField textField = new DoubleJTextField();
		textField.setBounds(168, 89, 99, 22);
		editTransactions.getContentPane().add(textField);

		JTextField formattedTextField = new DoubleJTextField();
		formattedTextField.setBounds(168, 129, 99, 22);
		editTransactions.getContentPane().add(formattedTextField);

		JTextField formattedTextField_1 = new DoubleJTextField();
		formattedTextField_1.setBounds(168, 167, 99, 22);
		editTransactions.getContentPane().add(formattedTextField_1);

		JTextField formattedTextField_2 = new DoubleJTextField();
		formattedTextField_2.setBounds(168, 210, 99, 22);
		editTransactions.getContentPane().add(formattedTextField_2);

		JTextField formattedTextField_3 = new DoubleJTextField();
		formattedTextField_3.setBounds(168, 244, 99, 22);
		editTransactions.getContentPane().add(formattedTextField_3);

		JTextField formattedTextField_4 = new DoubleJTextField();
		formattedTextField_4.setBounds(168, 285, 99, 22);
		editTransactions.getContentPane().add(formattedTextField_4);

		JButton btnNewButton = new JButton("Save Transaction");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 334, 147, 30);
		editTransactions.getContentPane().add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(168, 334, 147, 30);
		editTransactions.getContentPane().add(btnClear);

	}
}
