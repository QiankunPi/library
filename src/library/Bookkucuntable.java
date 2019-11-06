package library;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.awt.Font;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bookkucuntable extends JPanel {
	public Bookkucuntable() {
		setLayout(null);
		setBounds(0, 0, 805, 503);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 5, 805, 66);
		add(panel);
		panel.setLayout(null);
		JLabel label = new JLabel("图书库存报表信息");
		label.setBounds(14, 13, 214, 44);
		panel.add(label);
		label.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 25));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 70, 805, 416);
		add(panel_1);
		this.setVisible(true);
		  Statement stmt=null;
		  Connection con=null;
	   	  ResultSet rs=null;
	   	  try
	  	   {
	  		   Class.forName("com.mysql.jdbc.Driver");
	  	   }
	  	   catch(ClassNotFoundException f)
	  	   {
	  		   System.out.println("SQLException:"+f.getLocalizedMessage());
	  	   }
	  	   try
	  	   {
	  		   con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/table1","root","password");
	  			stmt=(Statement) con.createStatement(1005, 1008);
				rs=(ResultSet) stmt.executeQuery("SELECT*FROM t_bookinfo");
				rs.last();
	  			int k=rs.getRow();
	  			if(k==0)
	  			{
	  				JOptionPane.showMessageDialog(this,"您查询的表为空表","系统提示",JOptionPane.WARNING_MESSAGE);
	  			}
	  			rs.beforeFirst();
	  			String ob[][]=new String[k][8];
	  			for(int i=0;i<k&&rs.next();i++)
	  			{
	  				ob[i][0]= rs.getString("ISBN");
	  				ob[i][1]= rs.getString("bookName");
	  				ob[i][2]= rs.getString("author");
	  				ob[i][3]= rs.getString("translator");
	  				ob[i][4]= rs.getString("press");
	  				ob[i][5]= rs.getString("publicationDate");
	  				ob[i][6]= rs.getString("classification");
	  				ob[i][7]= rs.getString("pricing");
	  			}
	  			String s[]={"ISBN号","书名","作者","翻译","出版社","出版时间","图书类别","定价"};
	  			JTable tabel=new JTable(ob,s);
				JScrollPane sPane=new JScrollPane(tabel);
				panel_1.setVisible(false);
				panel_1.removeAll();
				panel_1.setLayout(null);
				sPane.setBounds(0,0,805, 433);
				panel_1.add(sPane);
				panel_1.setVisible(true);
		  }
		   catch(SQLException ex)
		   {
			   ex.printStackTrace();
		   }
		  finally
		  {
			  try
			{
				if(rs!=null)
				     rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
		  }
	}
	
}
