package com.olx.view;

import java.awt.EventQueue;
import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.olx.controller.Datee;
import com.olx.controller.ProductDao;
import com.olx.controller.ProductService;
import com.olx.controller.UserDao;
import com.olx.model.LoginParameter;
import com.olx.model.Product;
import com.olx.model.User;
import com.olx.model.UserDtoRes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class AddProduct2 {

	JFrame frame1;
	private JTextField Name;
	private JTextField Price;
	private JTextField Status;
	JLabel im;
	private JTextField datee;
	private JTextArea Descreption;
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					AddProduct2 window = new AddProduct2();
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
	
	
	public AddProduct2() {
	 	initialize();
	}
	 
	
	


public AddProduct2(String st) {
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
	




	/**
	 * Initialize the contents of the frame.
	 * @param st 
	 */
	 void initialize() {
		 
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 526, 349);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		
		
		
		
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
		
		Name = new JTextField();
		Name.setBounds(89, 33, 128, 20);
		frame1.getContentPane().add(Name);
		Name.setColumns(10);
		
		Price = new JTextField();
		Price.setBounds(89, 83, 128, 20);
		frame1.getContentPane().add(Price);
		Price.setColumns(10);
		
		Status = new JTextField();
		Status.setBounds(89, 235, 128, 20);
		frame1.getContentPane().add(Status);
		Status.setColumns(10);
	
		

		String dat=Datee.currentDate();
		
		
		
		datee = new JTextField(dat);
		datee.setBounds(89, 58, 128, 20);
		frame1.getContentPane().add(datee);
		datee.setColumns(10);
		datee.setEditable(false);
		

		Descreption = new JTextArea();
		Descreption.setColumns(15);
		Descreption.setBounds(89, 114, 128, 112);
		frame1.getContentPane().add(Descreption);
		
		
		JButton btnChoosefile = new JButton("ChooseFile");
		   
		btnChoosefile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser file = new JFileChooser();
		          file.setCurrentDirectory(new File(System.getProperty("user.home")));
		          //filter the files
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              String path = selectedFile.getAbsolutePath();
		               im.setIcon(ResizeImage(path));
		          }
		           //if the user  dont click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
				
				
				
			}
		});
		JButton btnNewButton = new JButton("PostProduct");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  if (e.getSource() == btnNewButton)
			         {
					  int x =0;
				  String name=Name.getText();				  
				  double price= Double.parseDouble(Price.getText());
				  
				  String image = im.getText();
				  String date = datee.getText();
				  String descreption= Descreption.getText();
				  String status= Status.getText();
				 
				
				  try{
					  ProductDao pd =new ProductDao();
					  

					  Product product = new Product(name,date,price,descreption,image,status);
					  
					  pd.create1(product);
					  
					  
					  
					  
					  
				  
		             x++;

	                    if (x > 0) 
	                    {
	                    	try {
	        					
	        					
	        					PostProduct window = new PostProduct(name,date,price,descreption,image,status);
	        					window.frame1.setVisible(true);
	        				} catch (Exception ex) {
	        					ex.printStackTrace();
	        				}

	                    }

	                }
	          catch (Exception e1) 
	                {

	        	  e1.printStackTrace();

	                }

	            }
	          else
	           {

	                JOptionPane.showMessageDialog(btnNewButton, "Password Does Not Match");

	            } 

	        } 
	       

	    
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
		});

		btnNewButton.setBounds(99, 266, 109, 34);
		frame1.getContentPane().add(btnNewButton);
		
		
		btnChoosefile.setBounds(341, 7, 115, 34);
		frame1.getContentPane().add(btnChoosefile);
		
		 im = new JLabel("");
		im.setBounds(260, 36, 240, 224);
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
}