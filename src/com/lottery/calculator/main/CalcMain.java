package com.lottery.calculator.main;

import java.awt.EventQueue;

import com.lottery.calculator.swing.LoginDialog;

public class CalcMain {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDialog window = new LoginDialog();
					window.getFrmLogin().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
