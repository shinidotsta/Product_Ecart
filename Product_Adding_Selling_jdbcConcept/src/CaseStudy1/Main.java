package CaseStudy1;
//shini
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main
{

	public static void main(String[] args) throws ClassNotFoundException
	{
	   
		first_frame();//method for calling the first frame

	}
	
	
	
	public static void first_frame()
	   {
		JFrame f=new JFrame();
	 
	      JButton Admnbtn=new JButton("Admin Login");
	      Admnbtn.setBounds(50, 50, 200, 30);
	 
	     JButton Agntbtn=new JButton("Agent Login");
	     Agntbtn.setBounds(50, 100, 200, 30);
	     
	     JButton exit=new JButton("Exit");
	     exit.setBounds(50, 150, 200, 30);
	     
	     /*----begin exit...*/
	     exit.addActionListener(new ActionListener() 
	     {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
				
			}
		});
	     /*----end exit...*/
	 	
	     Admnbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				int id=1;
				Login log=new Login(id);
				f.setVisible(false);
			}
		});
	     
	     Agntbtn.addActionListener(new ActionListener()
	     {
	    	 int id=2;
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Login log=new Login(id);
				f.setVisible(false);
			}
		});
	     
	 
	 f.add(Admnbtn);
	 f.add(Agntbtn);
	 f.add(exit);
	 f.setSize(400,400);
  f.setLayout(null);
  f.setVisible(true);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }

}
