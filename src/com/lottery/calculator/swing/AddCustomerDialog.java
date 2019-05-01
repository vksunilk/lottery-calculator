package com.lottery.calculator.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lottery.calculator.biz.customer.CustomerService;
import com.lottery.calculator.biz.group.GroupService;
import com.lottery.calculator.bizcore.entity.GroupEntity;

import lombok.Getter;

public class AddCustomerDialog {
	/**
	 * 
	 */
	@Getter
	private JDialog addCustomerDialog;
	private CustomerService customerService;
	private GroupService groupService;

	private JTextField customerNameText;
	private JTextField contactNumber;
	private JTextField emailAddress;
	private JTextField place;

	public AddCustomerDialog() throws InstantiationException, IllegalAccessException, SQLException {
		groupService = new GroupService();
		addCustomerDialog = new JDialog();
		addCustomerDialog.setLocationRelativeTo(null);
		addCustomerDialog.setTitle("Add Customers");
		addCustomerDialog.getContentPane().setLayout(null);
		addCustomerDialog.setBounds(10, 150, 320, 350);
		customerNameText = new JTextField();
		customerNameText.setBounds(140, 89, 126, 25);
		addCustomerDialog.getContentPane().add(customerNameText);
		customerNameText.setColumns(10);

		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(23, 89, 96, 25);
		addCustomerDialog.getContentPane().add(lblCustomerName);

		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(23, 125, 96, 25);
		addCustomerDialog.getContentPane().add(lblContactNumber);

		contactNumber = new JTextField();
		contactNumber.setColumns(10);
		contactNumber.setBounds(140, 125, 126, 25);
		addCustomerDialog.getContentPane().add(contactNumber);

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setBounds(23, 161, 96, 25);
		addCustomerDialog.getContentPane().add(lblEmailAddress);

		emailAddress = new JTextField();
		emailAddress.setColumns(10);
		emailAddress.setBounds(140, 161, 126, 25);
		addCustomerDialog.getContentPane().add(emailAddress);

		JLabel lblEmailAddress_1 = new JLabel("Place");
		lblEmailAddress_1.setBounds(23, 197, 96, 25);
		addCustomerDialog.getContentPane().add(lblEmailAddress_1);

		place = new JTextField();
		place.setColumns(10);
		place.setBounds(140, 197, 126, 25);
		addCustomerDialog.getContentPane().add(place);

		JLabel lblNewLabel = new JLabel("Select Group");
		lblNewLabel.setBounds(23, 59, 78, 19);
		addCustomerDialog.getContentPane().add(lblNewLabel);

		JComboBox<GroupEntity> comboBox = new JComboBox<>();
		List<GroupEntity> customerList = groupService.getGroups();
		if (customerList != null) {
			customerList.stream().forEach(action -> comboBox.addItem(action));
		}
		comboBox.setBounds(140, 53, 126, 25);
		addCustomerDialog.getContentPane().add(comboBox);
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (customerNameText.getText() != null) {
					try {
						customerService = new CustomerService();
						customerService.addCustomers(customerNameText.getText(), contactNumber.getText(),
								emailAddress.getText(), place.getText(), (GroupEntity) comboBox.getSelectedItem());
						JOptionPane.showMessageDialog(addCustomerDialog, "Customer added successfully");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(addCustomerDialog, "Please try again later");
						e.printStackTrace();
					}
				}
			}
		});

		btnNewButton.setBounds(29, 246, 101, 34);
		addCustomerDialog.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerNameText.setText("");
				contactNumber.setText("");
				emailAddress.setText("");
				place.setText("");
				comboBox.setSelectedIndex(0);
			}
		});
		btnNewButton_1.setBounds(154, 246, 101, 34);
		addCustomerDialog.getContentPane().add(btnNewButton_1);
	}
}
