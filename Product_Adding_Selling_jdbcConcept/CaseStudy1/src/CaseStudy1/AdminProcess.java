package CaseStudy1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdminProcess  
{
	AdminProcess()
	{
		JFrame f=new JFrame();
		
		JButton add=new JButton("Add Product");
		add.setBounds(50, 50, 200, 30);
	 
	     JButton display=new JButton("DisplayInventory");
	     display.setBounds(50, 100, 200, 30);
	     

	     JButton exit=new JButton("Exit");
	     exit.setBounds(50, 150, 200, 30);
	     
	     f.add(add);
		 f.add(display);
		 f.add(exit);
		 
		 f.setSize(400,400);
	     f.setLayout(null);
	     f.setVisible(true);
	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	     add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame f1=new JFrame();
				
				JLabel l1=new JLabel("ProductID");
				l1.setBounds(50, 50, 100, 30);
				
				JTextField t1=new JTextField();
				 t1.setBounds(140, 50, 150, 20);
				
				JLabel l2=new JLabel("Product Name");
				l2.setBounds(50, 100, 100, 30);
				
				JTextField t2=new JTextField();
				t2.setBounds(140, 100, 150, 20);
				
				JLabel l3=new JLabel("Minimum Sell Quant");
				l3.setBounds(50, 150, 100, 30);
					
				JTextField t3=new JTextField();
				t3.setBounds(140, 150, 150, 20);
					
				JLabel l4=new JLabel("Price");
				l4.setBounds(50, 200, 100, 30);
					
				JTextField t4=new JTextField();
				t4.setBounds(140, 200, 150, 20);
				
				JLabel l5=new JLabel("Quantity");
				l5.setBounds(50, 250, 100, 30);
					
				JTextField t5=new JTextField();
				t5.setBounds(140, 250, 150, 20);
				
				JButton add1=new JButton("Add");
				add1.setBounds(50, 300, 200, 30);
				
				JLabel warning=new JLabel();
				 warning.setBounds(140, 340, 150, 30);
			 		
				f1.add(l1); f1.add(t1);
				f1.add(l2); f1.add(t2);
				f1.add(l3); f1.add(t3);
				f1.add(l4); f1.add(t4);
				f1.add(l5); f1.add(t5);
				f1.add(add1);
				f1.add(warning);
				
				   
					 
				   
				add1.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						try {
							ConnectionManager con=new ConnectionManager();
							 Statement stn = null;
							stn = con.gtconctn().createStatement();
				            int total=Integer.parseInt(t4.getText())*Integer.parseInt(t5.getText());
						 stn.execute("insert into Item(pdctID,name,minSellQuant,price,quantAvl,TotalCost) values('"+Integer.parseInt(t1.getText())+"','"+t2.getText()+"','"+Integer.parseInt(t3.getText())+"','"
						 +Integer.parseInt(t4.getText())+"','"+Integer.parseInt(t5.getText())+"',"+total+")");
						  warning.setText("Insertion Successful");
							
						} catch (ClassNotFoundException|SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				});
				f1.setSize(400,400);
			     f1.setLayout(null);
			     f1.setVisible(true);
			     f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
				
				display.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						JFrame f2=new JFrame();					
						f2.setSize(400,400);
						f2.setLayout(null);
						f2.setVisible(true);
						f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
						JLabel l1=new JLabel("ProductID");
						l1.setBounds(10,25,150,30);
						
						JLabel l2=new JLabel("Product Name");
						l2.setBounds(120,25,150,30);
						
						JLabel l3=new JLabel("AvailableQuant");
						l3.setBounds(240,25,150,30);

						JLabel l4=new JLabel("Price");
						l4.setBounds(350,25,150,30);
						
						JLabel l5=new JLabel("Total Cost");
						l5.setBounds(460,25,150,30);
						
						f2.add(l1);f2.add(l2);f2.add(l3);f2.add(l4);f2.add(l5);
						
						try {
							ConnectionManager con=new ConnectionManager();
							
							  Statement	stn = con.gtconctn().createStatement();
						
							ResultSet rs = stn.executeQuery("Select *from Item");
						 
						int count=0;
						 int a=0;	
							while(rs.next())
							 {
								 String ID=rs.getString("pdctID");
								 String pdname=rs.getString("name");
								 String quantavl=rs.getString("quantAvl");
								 String price=rs.getString("price");
								 String total=rs.getString("TotalCost");					 
												 
								    JLabel id=new JLabel(ID);
								    id.setBounds(10,50+a,150,30);;
								    
									JLabel name=new JLabel(pdname);
									name.setBounds(120,50+a,150,30);
									
									JLabel avl=new JLabel(quantavl);
									avl.setBounds(240,50+a,150,30);

									JLabel prce=new JLabel(price);
									prce.setBounds(350,50+a,150,30);
									
									JLabel tot=new JLabel(total);
									tot.setBounds(460,50+a,150,30);
									
									a=a+30;	
								f2.add(id);f2.add(name);f2.add(avl);f2.add(prce);f2.add(tot);
								
							 }
						} catch (ClassNotFoundException|SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}					
					}
				});
				
				
				
				
	}

}
