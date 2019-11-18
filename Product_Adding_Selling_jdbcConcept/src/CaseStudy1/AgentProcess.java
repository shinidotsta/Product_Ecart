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


public class AgentProcess 
{
	AgentProcess(int logID)
	{
        JFrame f=new JFrame();
		
		JButton buy=new JButton("Buy/Sell");
		buy.setBounds(50, 50, 200, 30);
	 
	     JButton history=new JButton("History");
	     history.setBounds(50, 100, 200, 30);
	     

	     JButton exit=new JButton("Logout");
	     exit.setBounds(50, 150, 200, 30);
	     
	     f.add(buy);
		 f.add(history);
		 f.add(exit);
		 
		 f.setSize(400,800);
	     f.setLayout(null);
	     f.setVisible(true);
	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	     /*---------------------logout begin---------*/
	     
	     
	     exit.addActionListener(new ActionListener()
	     {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Main.first_frame();
				f.setVisible(false);
				
			}
		});
	     /*---------------------logout end---------*/
	     
	    /*--------------begin transaction History-----------*/
	     
	     history.addActionListener(new ActionListener()
	     {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFrame h=new JFrame();
				
				JLabel l1=new JLabel("User");
				l1.setBounds(10,25,150,30);
				
				JLabel l2=new JLabel("Type");
				l2.setBounds(120,25,150,30);
				
				JLabel l3=new JLabel("prdctID");
				l3.setBounds(240,25,150,30);

				JLabel l4=new JLabel("Prdct Name");
				l4.setBounds(350,25,150,30);
				
				JLabel l5=new JLabel("Cost");
				l5.setBounds(460,25,150,30);
				
				JLabel l6=new JLabel("Total Cost");
				l6.setBounds(580,25,150,30);
				
				JLabel l7=new JLabel("Quantity");
				l7.setBounds(670,25,150,30);
				
				h.add(l1);h.add(l2);h.add(l3);h.add(l4);h.add(l5);h.add(l6);h.add(l7);
				
				ConnectionManager con=new ConnectionManager();
				try {
					Statement stn=con.gtconctn().createStatement();
					ResultSet rs=stn.executeQuery(" \r\n" + 
							"     SELECT L.Username,T.type,P.pdctID,P.name, T.cost,T.totalcost,T.quantity FROM transaction T\r\n" + 
							" INNER JOIN LOGIN L\r\n" + 
							" INNER JOIN Item P  \r\n" + 
							" ON T.logID=L.logID AND T.pdctID=P.pdctID  where T.logID="+logID);
					 int a=0;	
					
					while(rs.next())
					{
						String UserName=rs.getString("UserName");
						String type=rs.getString("type");
						String pdctID=rs.getString("pdctID");
						String name=rs.getString("name");
						String cost=rs.getString("cost");
						String totalcost=rs.getString("totalcost");
						String quantity=rs.getString("quantity");
						
						
										 
						    JLabel uname=new JLabel(UserName);
						    uname.setBounds(10,50+a,150,30);;
						    
							JLabel typ=new JLabel(type);
							typ.setBounds(120,50+a,150,30);
							
							JLabel pID=new JLabel(pdctID);
							pID.setBounds(240,50+a,150,30);

							JLabel pdname=new JLabel(name);
							pdname.setBounds(350,50+a,150,30);
							
							
							JLabel cst=new JLabel(cost);
							cst.setBounds(460,50+a,150,30);
							
							JLabel ttcst=new JLabel(totalcost);
							ttcst.setBounds(580,50+a,150,30);
							
							JLabel buydqunty=new JLabel(quantity);
							buydqunty.setBounds(670,50+a,150,30);
							
							
							h.add(uname);h.add(typ);h.add(pID);h.add(pdname);h.add(cst);h.add(ttcst);	h.add(buydqunty);						
							a=a+30;	
					}
					
				} 
				catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  

				h.setSize(400,400);
				h.setLayout(null);
				h.setVisible(true);
			//	h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
	     
	     
		  /*--------------end transaction History-----------*/
	     /*--------------begin buy/sell-----------*/
	     
	    
				
				buy.addActionListener(new ActionListener() 
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						JFrame f2=new JFrame();					
						f2.setSize(400,400);
						f2.setLayout(null);
						f2.setVisible(true);
					//	f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
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
						
						JLabel l6=new JLabel("MinSell Quant");
						l6.setBounds(580,25,150,30);
						
						f2.add(l1);f2.add(l2);f2.add(l3);f2.add(l4);f2.add(l5);f2.add(l6);
						
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
								 String min=rs.getString("minSellQuant");
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
									
									JLabel minsell=new JLabel(min);
									minsell.setBounds(580,50+a,150,30);
									
									a=a+30;	
								f2.add(id);f2.add(name);f2.add(avl);f2.add(prce);f2.add(tot);f2.add(minsell);
								
								JLabel buy=new JLabel("buy/sell");
								buy.setBounds(50, 450, 100, 30);
									
								JTextField by=new JTextField();
								by.setBounds(140, 450, 150, 20);
								
								JLabel Quantity=new JLabel("Quantity");
								Quantity.setBounds(50, 500, 100, 30);
									
								JTextField Quan=new JTextField();
								Quan.setBounds(140, 500, 100, 20);
								
								JLabel ProductID=new JLabel("ProductID");
								ProductID.setBounds(50, 550, 100, 30);
									
								JTextField pdctID=new JTextField();
								pdctID.setBounds(140, 550, 150, 20);
								
								f2.add(buy); f2.add(by);
								f2.add(Quantity); f2.add(Quan);
								f2.add(ProductID); f2.add(pdctID);
								
								 JButton prcd=new JButton("Proceed");
								 prcd.setBounds(50, 600, 200, 30);
								 f2.add(prcd);
								 
								JLabel warning=new JLabel();
								warning.setBounds(100, 650, 200, 30);
								f2.add(warning);
								
								JLabel prcdlabel=new JLabel();
								prcdlabel.setBounds(100, 700, 200, 30);
								 f2.add(prcdlabel);
								
								prcd.addActionListener(new ActionListener() 
								{
									
									@Override
									public void actionPerformed(ActionEvent arg0)
									{
										
										if((by.getText().equalsIgnoreCase("buy")))
										{
											try
											{
											ConnectionManager con=new ConnectionManager();
											Statement stn1=con.gtconctn().createStatement();										
											int tb_pdctID=Integer.parseInt(pdctID.getText());
											String s="select *from Item where pdctID='"+tb_pdctID+"'";										
									     	ResultSet rs1=stn1.executeQuery(s);										
									 //    	System.out.println(s);
									     	while(rs1.next())
									     	{										
											String tb_name=rs1.getString("name");
											int tb_minSell=rs1.getInt("minSellQuant");
											int tb_AvlQuant=rs1.getInt("quantAvl");
											int tb_Price=rs1.getInt("price");
											int tb_Cost=rs1.getInt("TotalCost");										
										//   System.out.println(tb_pdctID+" "+tb_name+" "+tb_minSell+" "+tb_AvlQuant+" "+tb_Price+" "+tb_Cost);
											if(Integer.parseInt(Quan.getText())>tb_AvlQuant)
											{
												prcdlabel.setText("Product Not available");
												f2.add(prcdlabel);
											}
											else if( Integer.parseInt(Quan.getText())<tb_minSell)
											{
												prcdlabel.setText("please by the min Quantity");
												f2.add(prcdlabel);
											}
											else if(Integer.parseInt(Quan.getText())<=tb_AvlQuant && Integer.parseInt(Quan.getText())>=tb_minSell)
											{
												int updateAvl=tb_AvlQuant-Integer.parseInt(Quan.getText());
												int total=updateAvl*tb_Price;
												
												 stn1.executeUpdate("update Item set quantAvl="+updateAvl+" where pdctID='"+tb_pdctID+"'");		 
												 stn1.executeUpdate("update Item set TotalCost="+total+" where pdctID='"+tb_pdctID+"'");
												 int quuant=Integer.parseInt(Quan.getText());
												 
												 int trans_ttcst=quuant*tb_Price;
												 
										 stn1.executeUpdate("insert into transaction(type,quantity,cost,totalcost,pdctID,logID) values"
														+ " ('buy',"+quuant+","+tb_Price+","+trans_ttcst+","+tb_pdctID+","+logID+")");
													 																 
													 prcdlabel.setText("Thank you for buying");
													 break;
											}							
									     	}
											} catch (ClassNotFoundException|SQLException e1) {
												// TODO Auto-generated catch block
												//e1.printStackTrace();
											}																							
										}
										else if(by.getText().equalsIgnoreCase("sell"))
										{
											try
											{
											ConnectionManager con=new ConnectionManager();
											Statement stn1=con.gtconctn().createStatement();										
											int tb_pdctID=Integer.parseInt(pdctID.getText());
											String s="select *from Item where pdctID='"+tb_pdctID+"'";										
									     	ResultSet rs1=stn1.executeQuery(s);										
									     	System.out.println(s);
									     	while(rs1.next())
									     	{										
											String tb_name=rs1.getString("name");
											int tb_minSell=rs1.getInt("minSellQuant");
											int tb_AvlQuant=rs1.getInt("quantAvl");
											int tb_Price=rs1.getInt("price");
											int tb_Cost=rs1.getInt("TotalCost");										
										//   System.out.println(tb_pdctID+" "+tb_name+" "+tb_minSell+" "+tb_AvlQuant+" "+tb_Price+" "+tb_Cost);
											
												int updateAvl=tb_AvlQuant+Integer.parseInt(Quan.getText());
												int total=updateAvl*tb_Price;
												
												 stn1.executeUpdate("update Item set quantAvl="+updateAvl+" where pdctID='"+tb_pdctID+"'");		 
												 stn1.executeUpdate("update Item set TotalCost="+total+" where pdctID='"+tb_pdctID+"'");
												 int quuant=Integer.parseInt(Quan.getText());
												 int trans_ttcst=quuant*tb_Price;
										 stn1.executeUpdate("insert into transaction(type,quantity,cost,totalcost,pdctID,logID) values"
														+ " ('sell',"+quuant+","+tb_Price+","+trans_ttcst+","+tb_pdctID+","+logID+")");
													 																 
													 prcdlabel.setText("Thank you for Selling");
																		
									     	}
											} catch (ClassNotFoundException|SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}								
										}
							    //     f2.setVisible(false);
										
									}
								});
								
								/*--------------end show-----------*/
							 }
							
						} catch (ClassNotFoundException|SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}					
						
					}
				});
	}
	
}
