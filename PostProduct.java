package com.olx.view;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.olx.controller.Datee;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PostProduct {

	JFrame frame1;
	JLabel im;
	
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					PostProduct window = new PostProduct();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	

	/**
	 * Create the application.
	 */
	
	
	public PostProduct() {
	 	initialize();
	}
	 
	
	


public PostProduct(String st) {
	initialize();
	

	

    JLabel username = new JLabel(st);
	username.setBounds(89, 7, 128, 18);
	frame1.getContentPane().add(username);
	
/*
	  UserDao userr =new UserDao();
	   UserDtoRes u = userr.find(st);
	  User user = u.getUser();
	   */
	   
}


public PostProduct(String name, String date, double price, String descreption,
		String image, String status) {
	initialize();
	

	
	
	JLabel lblNewLabel = new JLabel();
	lblNewLabel.setBounds(22, 36, 46, 14);
	frame1.getContentPane().add(lblNewLabel);

	
	
	JLabel lblNewLabel_1 = new JLabel("Name");
	lblNewLabel_1.setBounds(22, 36, 46, 14);
	frame1.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Date");
	lblNewLabel_2.setBounds(22, 61, 46, 14);
	frame1.getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Price");
	lblNewLabel_3.setBounds(22, 86, 46, 14);
	frame1.getContentPane().add(lblNewLabel_3);
	
	
	JLabel lblNewLabel_5 = new JLabel("Descreption");
	lblNewLabel_5.setBounds(22, 136, 66, 14);
	frame1.getContentPane().add(lblNewLabel_5);
	
	JLabel lblNewLabel_7 = new JLabel("Status");
	lblNewLabel_7.setBounds(22, 233, 46, 14);
	frame1.getContentPane().add(lblNewLabel_7);
	
	
	
	


	
	
	JLabel lblNewLabel_8= new JLabel(name);
	lblNewLabel_8.setBounds(89, 33, 128, 20);
	frame1.getContentPane().add(lblNewLabel_8);
	
	JLabel lblNewLabel_9 = new JLabel(date);
	lblNewLabel_9.setBounds(89, 58, 128, 20);
	frame1.getContentPane().add(lblNewLabel_9);
	
	JLabel lblNewLabel_10 = new JLabel(String.valueOf(price));
	lblNewLabel_10.setBounds(89, 83, 128, 20);
	frame1.getContentPane().add(lblNewLabel_10);
	
	
	JLabel lblNewLabel_11 = new JLabel(descreption);
	lblNewLabel_11.setBounds(89, 114, 128, 112);
	frame1.getContentPane().add(lblNewLabel_11);
	
	JLabel lblNewLabel_12 = new JLabel(status);
	lblNewLabel_12.setBounds(89, 235, 128, 20);
	frame1.getContentPane().add(lblNewLabel_12);
	
	
	
	
	
	
	
	   
	
	JButton btnNewButton = new JButton("Home");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			  if (e.getSource() == btnNewButton)
		

                        JOptionPane.showMessageDialog(btnNewButton, "Data Saved Successfully");

                    }

                

    
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	});

	btnNewButton.setBounds(99, 266, 109, 34);
	frame1.getContentPane().add(btnNewButton);
	
	
	 im = new JLabel(image);
	im.setBounds(265, 44, 240, 224);
	frame1.getContentPane().add(im);




	
	

}
public ImageIcon ResizeImage(String ImagePath)
{
    ImageIcon MyImage = new ImageIcon(ImagePath);
    Image img = MyImage.getImage();

    Image newImg = img.getScaledInstance(im.getWidth(), im.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}


	/**
	 * Initialize the contents of the frame.
	 * @param st 
	 */
	 void initialize() {
		 
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 645, 463);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(22, 11, 46, 14);
		frame1.getContentPane().add(lblNewLabel);
		
		
	 }
		
		
		

		
		
}
	
	







