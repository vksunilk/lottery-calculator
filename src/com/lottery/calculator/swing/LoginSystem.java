package com.lottery.calculator.swing;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.lottery.calculator.biz.authenticate.AuthenticateLoginService;

public class LoginSystem {

	AuthenticateLoginService authenticateLogin;
	TransactionInfo transactionInfo;
	private JFrame frame;
	private JTextField txtUserId;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public LoginSystem() {
		authenticateLogin = new AuthenticateLoginService();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 423, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitle1 = new JLabel("WELCOME TO LOTTERY CALCULATOR");
		lblTitle1.setForeground(SystemColor.textHighlight);
		lblTitle1.setBackground(SystemColor.text);
		lblTitle1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		lblTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle1.setToolTipText("");
		lblTitle1.setBounds(84, 24, 247, 14);
		frame.getContentPane().add(lblTitle1);

		JLabel lblTitle2 = new JLabel("Login");
		lblTitle2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle2.setForeground(SystemColor.textHighlight);
		lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2.setBounds(165, 47, 65, 14);
		frame.getContentPane().add(lblTitle2);

		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setBounds(49, 90, 46, 14);
		frame.getContentPane().add(lblUserId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(49, 137, 59, 14);
		frame.getContentPane().add(lblPassword);

		txtUserId = new JTextField();
		txtUserId.setToolTipText("Enter your user id here");
		txtUserId.setBounds(154, 87, 166, 20);
		frame.getContentPane().add(txtUserId);
		txtUserId.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your password here");
		passwordField.setBounds(154, 134, 166, 20);
		frame.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (authenticateLogin.authenticate(txtUserId.getText(), passwordField.getPassword())) {
					transactionInfo = new TransactionInfo();
					transactionInfo.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(50, 199, 78, 23);
		frame.getContentPane().add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserId.setText("");
				passwordField.setText("");
			}
		});
		btnReset.setBounds(165, 199, 78, 23);
		frame.getContentPane().add(btnReset);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(280, 199, 78, 23);
		frame.getContentPane().add(btnExit);

		JSeparator separator = new JSeparator();
		separator.setBounds(67, 174, 1, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(49, 177, 309, 11);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(49, 72, 309, 11);
		frame.getContentPane().add(separator_2);
	}

	public JFrame getFrmLogin() {
		return frame;
	}

	public void setFrmLogin(JFrame frmLogin) {
		this.frame = frmLogin;
	}
}
