package CaseStudy1;
//shini
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame
{
	Login(int id)
	{
		//base on the type given in login table calling admin/login page.
		//sLogin frame displays here
		
		JLabel l1=new JLabel("UserName");
		l1.setBounds(50, 50, 100, 30);
		
		JTextField t1=new JTextField();
		 t1.setBounds(140, 50, 150, 20);
		
		JLabel l2=new JLabel("Password");
		l2.setBounds(50, 100, 100, 30);
		
		JTextField t2=new JTextField();
		 t2.setBounds(140, 100, 150, 20);
		
		 
		  JButton btn=new JButton("Login");
		   btn.setBounds(60, 350, 95, 30);
  
		   btn.addActionListener(new ActionListener() 
		   {			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				try {
					ConnectionManager con=new ConnectionManager();
					 Statement stn = null;
					stn = con.gtconctn().createStatement();
				
				 
				 ResultSet rs = null;
				
					rs = stn.executeQuery("Select * from Login ");
				
				 String uname=t1.getText();
				 String pwd=t2.getText();
				 
				
				 
				int count=0;
					while(rs.next())
					 {
					
						 
							if(rs.getString("Username").equals(uname) && rs.getString("Password").equals(pwd))
							 {
							
								if(rs.getString("type").equalsIgnoreCase("A")) 
								{
									AdminProcess admin=new AdminProcess();
									count++;
									setVisible(false);
								}
								else if(rs.getString("type").equalsIgnoreCase("G"))
								{
									int logID=rs.getInt("logID");
									AgentProcess agent=new AgentProcess(logID);
									setVisible(false);
								}
							 }
							 if(count==0)
								System.out.println();
						
					 }
				} catch (ClassNotFoundException|SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								
			}
		});
		    
          add(l1);add(t1);add(l2);add(t2);add(btn);
		   
		   setSize(400,800);
		   setLayout(null);
		   setVisible(true);
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     
		 
		   
	}
}
