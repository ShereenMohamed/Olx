package com.olx.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.olx.controller.UserService;
import com.olx.model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Register extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField NameField;
	private JTextField Email;
	private JTextField City;
	private JTextField Phone;
	private JTextField Address;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setBounds(20, 31, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setBounds(20, 56, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email: ");
		lblNewLabel_2.setBounds(20, 81, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("City: ");
		lblNewLabel_3.setBounds(20, 106, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone: ");
		lblNewLabel_4.setBounds(20, 131, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address: ");
		lblNewLabel_5.setBounds(20, 156, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		NameField = new JTextField();
		NameField.setBounds(99, 28, 139, 20);
		contentPane.add(NameField);
		NameField.setColumns(10);
		
		Email = new JTextField();
		Email.setBounds(99, 78, 139, 20);
		contentPane.add(Email);
		Email.setColumns(10);
		
		City = new JTextField();
		City.setBounds(99, 103, 139, 20);
		contentPane.add(City);
		City.setColumns(10);
		
		Phone = new JTextField();
		Phone.setBounds(99, 128, 139, 20);
		contentPane.add(Phone);
		Phone.setColumns(10);
		
		Address = new JTextField();
		Address.setBounds(99, 153, 139, 20);
		contentPane.add(Address);
		Address.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(99, 53, 139, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=NameField.getText();
				  String password=passwordField.getText();
				  String email= Email.getText();
				  int phone =Integer.parseInt( Phone.getText());
				  String city = City.getText();
				  String address= Address.getText();
				  UserService userService = new UserService();
				  
				  User user = new User(username,password,email,phone,city,address);
				  boolean r = userService.register(user);
				  String resultMessage =userService.getResult().getMessage();
		
					
								
				 if(userService.getResult().isResult()==false){ 
					 JOptionPane.showMessageDialog(frame,resultMessage, "error",JOptionPane.ERROR_MESSAGE);}
				 else{
					 JOptionPane.showMessageDialog(frame,resultMessage);
				 }
			}
		});
		btnNewButton.setBounds(211, 184, 89, 23);
		contentPane.add(btnNewButton);
	}

}
