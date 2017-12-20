package com.olx.view;

import java.awt.EventQueue;
import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.olx.controller.Datee;
import com.olx.controller.ProductService;
import com.olx.controller.UserDao;
import com.olx.model.Product;
import com.olx.model.User;
import com.olx.model.UserDtoRes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;


public class AddProduct {

	JFrame frame1;
	private JTextField Name;
	private JTextField Price;
	
	private JTextField Descreption;
	private JTextField Status;
	JLabel im;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					AddProduct window = new AddProduct();
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

	
	public AddProduct() {
	 	initialize();
	}
	 
	
	String namee;
	
public AddProduct(String st) {
	initialize();
	
	namee=(st);

    JLabel username = new JLabel(namee);
	username.setBounds(89, 7, 128, 18);
	frame1.getContentPane().add(username);

	
	
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
		lblNewLabel.setBounds(22, 11, 46, 14);
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
		lblNewLabel_7.setBounds(22, 161, 46, 14);
		frame1.getContentPane().add(lblNewLabel_7);
		
		Name = new JTextField();
		Name.setBounds(89, 33, 128, 20);
		frame1.getContentPane().add(Name);
		Name.setColumns(10);
		
		Price = new JTextField();
		Price.setBounds(89, 83, 128, 20);
		frame1.getContentPane().add(Price);
		Price.setColumns(10);
		
	
		Descreption = new JTextField();
		Descreption.setBounds(89, 133, 128, 20);
		frame1.getContentPane().add(Descreption);
		Descreption.setColumns(10);
		
		Status = new JTextField();
		Status.setBounds(89, 158, 128, 20);
		frame1.getContentPane().add(Status);
		Status.setColumns(10);
	
		

		String dat=Datee.currentDate();
		
		JLabel lblDatee = new JLabel(dat);
		lblDatee.setBounds(99, 58, 131, 20);
		frame1.getContentPane().add(lblDatee);
		
		

		
		
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
		           //if the user click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
				
				
				
			}
		});
		JButton btnNewButton = new JButton("PostProduct");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
 
				  String name=Name.getText();				  
				  double price= Double.parseDouble(Price.getText());
				  String image = im.getText();
				  String date = lblDatee.getText();
				  String descreption= Descreption.getText();
				  String status= Status.getText();
				 
				
				  

				  ProductService productService = new ProductService();
				  
             
           UserDao userr =new UserDao();
          UserDtoRes u = userr.find(namee);
         User user = u.getUser();
                  
				  Product product = new Product(name,date,price,descreption,user,image,status);
				  productService.AddProduct(product);
				  String resultMessage =productService.getResult().getMessage();
				 if(productService.getResult().isResult()==false) 
					 JOptionPane.showMessageDialog(frame1,resultMessage, "error",JOptionPane.ERROR_MESSAGE);
				 else{
					 try {
						 JOptionPane.showMessageDialog(frame1,resultMessage);
						 
						} catch (Exception e) {
							e.printStackTrace();
						}
				 }
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});

		btnNewButton.setBounds(106, 211, 109, 34);
		frame1.getContentPane().add(btnNewButton);
		
		
		btnChoosefile.setBounds(341, 7, 115, 34);
		frame1.getContentPane().add(btnChoosefile);
		
		 im = new JLabel("");
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





}