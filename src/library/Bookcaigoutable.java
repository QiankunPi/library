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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Color;

public class Bookcaigoutable extends JPanel {
	public Bookcaigoutable() {
		setLayout(null);
		setBounds(0, 0, 805, 503);
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 6, 805, 66);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("图书采购报表信息");
		label.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 25));
		label.setBounds(39, 13, 230, 45);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 73, 805, 430);
		add(panel_1);
		
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
				rs=(ResultSet) stmt.executeQuery("SELECT*FROM t_purchasedetail");
				rs.last();
	  			int k=rs.getRow();
	  			if(k==0)
	  			{
	  				JOptionPane.showMessageDialog(this,"您查询的表为空表","系统提示",JOptionPane.WARNING_MESSAGE);
	  			}
	  			rs.beforeFirst();
	  			String ob[][]=new String[k][10];
	  			for(int i=0;i<k&&rs.next();i++)
	  			{
	  				ob[i][0]= rs.getString("purchaseOrderId");
	  				ob[i][1]= rs.getString("ISBN");
	  				ob[i][2]= rs.getString("purchaseQuentity");
	  				ob[i][3]= rs.getString("purchasePrice");
	  				ob[i][4]= rs.getString("purchaseAmount");
	  				ob[i][5]= rs.getString("purchaseDate");
	  				ob[i][6]= rs.getString("pId");
	  				ob[i][7]= rs.getString("userName");
	  				ob[i][8]= rs.getString("storehouseNumber");
	  				ob[i][9]= rs.getString("shelves");
	  			}
	  			String s[]={"单号","ISBN号","采购数量","进价","采购金额","采购日期","供货编号","经办人","库号","货架"};
	  			JTable tabel=new JTable(ob,s);
				JScrollPane sPane=new JScrollPane(tabel);
				panel_1.setVisible(false);
				panel_1.removeAll();
				panel_1.setLayout(null);
				sPane.setBounds(0,0,803, 430);
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
