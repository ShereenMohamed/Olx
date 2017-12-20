package com.olx.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.olx.controller.UserService;
import com.olx.model.LoginParameter;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	
	private JFrame frame;

	private JTextField textName;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 366, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name: ");
		lblNewLabel.setBounds(10, 57, 73, 14);
		frame.getContentPane().add(lblNewLabel);

		
		JLabel lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setBounds(10, 103, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=textName.getText();
				
				  String password=passwordField.getText();
				  UserService userService = new UserService();
				  boolean r = userService.login(username, password);
				  String resultMessage =userService.getResult().getMessage();
				 if(userService.getResult().isResult()==false) 
					 JOptionPane.showMessageDialog(frame,resultMessage, "error",JOptionPane.ERROR_MESSAGE);
				 else{
					 
						 try {
								AddProduct2 window = new AddProduct2(username);
								
								window.frame1.setVisible(true);
								
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						 
						 
				 }
				  
			}
		});
		btnLogin.setBounds(251, 164, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		textName = new JTextField();
		textName.setBounds(82, 54, 130, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(82, 100, 130, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Register window = new Register();
					window.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBounds(125, 164, 89, 23);
		frame.getContentPane().add(btnRegister);
	}
}


		
	
		
