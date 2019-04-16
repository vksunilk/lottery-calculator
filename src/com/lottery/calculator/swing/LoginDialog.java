package com.lottery.calculator.swing;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.lottery.calculator.biz.authenticate.AuthenticateLoginService;

public class LoginDialog {

	AuthenticateLoginService authenticateLogin;

	private JFrame frmLogin;
	private JTextField textField;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnReset;

	/**
	 * Create the application.
	 */
	public LoginDialog() {
		authenticateLogin = new AuthenticateLoginService();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmLogin(new JFrame());
		getFrmLogin().setResizable(false);
		getFrmLogin().setIconImage(
				Toolkit.getDefaultToolkit().getImage("D:\\Sunil's workspace\\swing-sample\\img\\login.png"));
		getFrmLogin().setType(Type.POPUP);
		getFrmLogin().setTitle("Login");
		getFrmLogin().setBounds(100, 100, 401, 300);
		getFrmLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmLogin().getContentPane().setLayout(null);

		JLabel lblWelcomeBack = new JLabel("Welcome Back !!! ");
		lblWelcomeBack.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblWelcomeBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeBack.setBounds(47, 24, 235, 31);
		getFrmLogin().getContentPane().add(lblWelcomeBack);

		JLabel lblNewLabel = new JLabel("User Name :");
		lblNewLabel.setBounds(47, 88, 86, 31);
		getFrmLogin().getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setToolTipText("Please enter your username!!!");
		lblNewLabel.setLabelFor(textField);
		textField.setBounds(139, 88, 168, 31);
		getFrmLogin().getContentPane().add(textField);
		textField.setColumns(10);

		lblPassword = new JLabel("Password :");
		lblPassword.setBounds(51, 128, 86, 31);
		getFrmLogin().getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		lblPassword.setLabelFor(passwordField);
		passwordField.setBounds(139, 128, 168, 31);
		getFrmLogin().getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (authenticateLogin.authenticate(textField.getText(), passwordField.getPassword())) {

				}
			}
		});
		btnLogin.setBounds(65, 189, 97, 31);
		getFrmLogin().getContentPane().add(btnLogin);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnReset.setBounds(204, 189, 97, 31);
		getFrmLogin().getContentPane().add(btnReset);
	}

	public JFrame getFrmLogin() {
		return frmLogin;
	}

	public void setFrmLogin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
	}
}
