package com.olx.view;


import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.olx.model.User;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PostProduct {

	JFrame frame1;
	JLabel im;
	JButton btnNewButton;

public PostProduct(final String st,String name, String date, double price,String category, String descreption,User user,
		String image) {
	initialize();

    JLabel username = new JLabel(st);
	username.setBounds(89, 7, 128, 18);
	frame1.getContentPane().add(username);
	
	JLabel lblNewLabel_1 = new JLabel("Name");
	lblNewLabel_1.setBounds(22, 36, 46, 14);
	frame1.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Date");
	lblNewLabel_2.setBounds(22, 74, 46, 14);
	frame1.getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Price");
	lblNewLabel_3.setBounds(22, 102, 46, 14);
	frame1.getContentPane().add(lblNewLabel_3);
	
	JLabel lblNewLabel_5 = new JLabel("Category");
	lblNewLabel_5.setBounds(22, 137, 62, 20);
	frame1.getContentPane().add(lblNewLabel_5);

	JLabel lblNewLabel_7 = new JLabel("Descreption");
	lblNewLabel_7.setBounds(24, 266, 75, 14);
	frame1.getContentPane().add(lblNewLabel_7);
	
	JLabel lblNewLabel_8= new JLabel(name);
	lblNewLabel_8.setBounds(89, 36, 128, 20);
	frame1.getContentPane().add(lblNewLabel_8);
	
	JLabel lblNewLabel_9 = new JLabel(date);
	lblNewLabel_9.setBounds(89, 71, 128, 20);
	frame1.getContentPane().add(lblNewLabel_9);
	
	JLabel lblNewLabel_10 = new JLabel(String.valueOf(price));
	lblNewLabel_10.setBounds(89, 99, 128, 20);
	frame1.getContentPane().add(lblNewLabel_10);
	
	
	JLabel lblNewLabel_11 = new JLabel(descreption);
	lblNewLabel_11.setVerticalAlignment(SwingConstants.TOP);
	lblNewLabel_11.setBounds(109, 266, 424, 52);
	frame1.getContentPane().add(lblNewLabel_11);
	

	JLabel lblNewLabel_4 = new JLabel(category);
	lblNewLabel_4.setBounds(89, 138, 109, 18);
	frame1.getContentPane().add(lblNewLabel_4);
	
	 im = new JLabel(image);
	 im.setBounds(276, 16, 309, 216);
	 frame1.getContentPane().add(im);
	 im.setIcon(ResizeImage(image));
	   
	
	btnNewButton = new JButton("Home");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			try {
				Main window = new Main(st);
				window.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

                    }
			
		
	});

	btnNewButton.setBounds(470, 329, 115, 23);
	frame1.getContentPane().add(btnNewButton);
	
	

}
public ImageIcon ResizeImage(String ImagePath)
{
    ImageIcon MyImage = new ImageIcon(ImagePath);
    Image img = MyImage.getImage();

    Image newImg = img.getScaledInstance(im.getWidth(), im.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}

	 void initialize() {

			frame1 = new JFrame();
			frame1.setBounds(100, 100, 634, 393);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.getContentPane().setLayout(null);
			
		
		

			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setBounds(22, 36, 46, 14);
			frame1.getContentPane().add(lblNewLabel);
			
		
		
	 }
		
}

