package com.lottery.calculator.main;

import java.awt.EventQueue;

import com.lottery.calculator.swing.LoginSystem;

public class CalcMain {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSystem window = new LoginSystem();
					window.getFrmLogin().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
