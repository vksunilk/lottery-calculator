package com.lottery.calculator.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import com.lottery.calculator.bizcore.dao.GroupDao;

import lombok.Getter;

public class AddGroupDialog {

	private GroupDao groupDao;
	@Getter
	private JDialog addGroupDialog;
	private JTextField textField;

	public AddGroupDialog() throws InstantiationException, IllegalAccessException, SQLException {
		addGroupDialog = new JDialog();
		addGroupDialog.setResizable(false);
		groupDao = new GroupDao();
		addGroupDialog.setTitle("Add Group");
		addGroupDialog.getContentPane().setLayout(null);
		addGroupDialog.setBounds(10, 150, 250, 167);
		addGroupDialog.setLocationRelativeTo(null);

		textField = new JTextField();
		textField.setBounds(100, 37, 106, 25);
		addGroupDialog.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("  Group Name");
		lblNewLabel.setBounds(10, 40, 80, 19);
		addGroupDialog.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (StringUtils.isNotEmpty(textField.getText())) {
					try {
						groupDao.addGroup(textField.getText());
					} catch (SQLException | InstantiationException | IllegalAccessException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(addGroupDialog, "Error Occured. Please try again later");
					}
				} else {
					JOptionPane.showMessageDialog(addGroupDialog, "Group added successfully");
				}
			}
		});
		btnNewButton.setBounds(70, 90, 89, 23);
		addGroupDialog.getContentPane().add(btnNewButton);
	}
}
