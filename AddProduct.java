package com.olx.view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import com.olx.controller.CategoryDao;
import com.olx.controller.CategoryService;
import com.olx.controller.ProductService;
import com.olx.controller.Datee;
import com.olx.controller.UserDao;
import com.olx.controller.UserService;
import com.olx.model.Category;
import com.olx.model.CategoryDtoRes;
import com.olx.model.Product;
import com.olx.model.User;
import com.olx.model.UserDtoRes;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class AddProduct {

	JFrame frame1;
	private JTextField Name;
	private JTextField Price;
	private JLabel im;
	private JTextField datee;
	private JTextArea Descreption;
	private JButton btnNewButton;
	private JTable table;
	private String path;
	private Category category;
	private String selectedData = null;
	private User user;
	
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
	public AddProduct(){}
	
	 String usr;
	
public AddProduct ( String st) {
	
	 
	 	usr=st;
	 
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 676, 483);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(22, 36, 46, 14);
		frame1.getContentPane().add(lblNewLabel);
		

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
		               path = selectedFile.getAbsolutePath();
		               im.setIcon(ResizeImage(path));
		          }
		           //if the user  dont click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
			}
		});
		


		btnChoosefile.setBounds(341, 7, 115, 34);
		frame1.getContentPane().add(btnChoosefile);
	 
		JLabel username = new JLabel(usr);
		username.setBounds(89, 7, 128, 18);
		frame1.getContentPane().add(username);
		
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
		lblNewLabel_5.setBounds(22, 103, 88, 20);
		frame1.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Category");
		lblNewLabel_7.setBounds(22, 269, 57, 14);
		frame1.getContentPane().add(lblNewLabel_7);
		
		Name = new JTextField();
		Name.setBounds(89, 33, 128, 20);
		frame1.getContentPane().add(Name);
		Name.setColumns(10);
		
		Price = new JTextField();
		Price.setBounds(89, 83, 128, 20);
		frame1.getContentPane().add(Price);
		Price.setColumns(10);
		
		
		String dat=Datee.currentDate();
		datee = new JTextField(dat);
		datee.setBounds(89, 58, 128, 20);
		frame1.getContentPane().add(datee);
		datee.setColumns(10);
		datee.setEnabled(false);
		


		 
	  

			 Descreption = new JTextArea(3,3);
			  
	        JScrollPane scrollableTextArea = new JScrollPane(Descreption);  
	        scrollableTextArea.setBounds(89, 127, 128, 112);
	        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	  
	        frame1.getContentPane().add(scrollableTextArea);  
		 
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 245, 121, 81);
		frame1.getContentPane().add(scrollPane);
		
		Set<Category> categories = new HashSet<Category>();
		CategoryService categoryService = new CategoryService();
		categories=categoryService.ListOfCategories();
		 Vector data = new Vector();
	     Vector row = null;
	     table = new JTable(new DefaultTableModel(
	    			new Object[][] {
	    			},
	    			new String[] {
	    			"Category Name"
	    			}
	    		));
	     table.setCellSelectionEnabled(true);
	     for(Category categ : categories){
	    	 row = new Vector(2);
	       
	         row.add(categ.getName());
	         ((DefaultTableModel)table.getModel()).addRow(row);
	     }
	  
	     ListSelectionModel cellSelectionModel = table.getSelectionModel();
	     cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	     cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    
	    	 	public void valueChanged(ListSelectionEvent e) {
	    	 		selectedData = table.getValueAt(table.getSelectedRow(), 0).toString();
	       }

	     });
		scrollPane.setViewportView(table);
		


		
		
				btnNewButton = new JButton("PostProduct");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
				  String name=Name.getText();				  
				  double price= Double.parseDouble(Price.getText());
				  String image=im.getText();
				  String date = datee.getText();
				  String descreption= Descreption.getText();
				  
		    	   CategoryDao cat =new CategoryDao();
		    	   CategoryDtoRes catt =cat.find(selectedData);
		    	   category = catt.getCategory();
		    
				   UserDao userr =new UserDao();
				   UserDtoRes u = userr.find(usr);
				   user = u.getUser();
				
					  ProductService productservice = new ProductService();
					  
					  Product product = new Product(name,date,price,category,descreption,user,image);
					  boolean r = productservice.AddProduct(product);
					  String resultMessage =productservice.getResult().getMessage();
					 if(productservice.getResult().isResult()==false) 
						 JOptionPane.showMessageDialog(frame1,resultMessage, "error",JOptionPane.ERROR_MESSAGE);
					 else{
						 JOptionPane.showMessageDialog(frame1,resultMessage);
						 try {
	        					PostProduct window = new PostProduct(usr,name,date,price,selectedData,descreption,user,path);
								window.frame1.setVisible(true);
							} catch (Exception ex) {
								ex.printStackTrace();
							}
					 }
				}
				   
			});

		btnNewButton.setBounds(441, 376, 109, 34);
		frame1.getContentPane().add(btnNewButton);
		
		 im = new JLabel("");
		 im.setBounds(310, 52, 240, 247);
		 frame1.getContentPane().add(im);
		

		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					Main window = new Main(usr);
					window.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(303, 376, 104, 34);
		frame1.getContentPane().add(btnNewButton_1);


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
