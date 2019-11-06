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

public class Booksaletable extends JPanel {

	public Booksaletable() {
		setLayout(null);
		setBounds(0, 0, 805, 503);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 805, 67);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("图书销售报表信息");
		label.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 25));
		label.setBounds(27, 24, 271, 30);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 805, 434);
		add(panel_1);
		panel_1.setLayout(null);
		
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
				rs=(ResultSet) stmt.executeQuery("SELECT*FROM t_salesdetail");
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
	  				ob[i][0]= rs.getString("salesOrderId");
	  				ob[i][1]= rs.getString("ISBN");
	  				ob[i][2]= rs.getString("salesQuentity");
	  				ob[i][3]= rs.getString("salesPrice");
	  				ob[i][4]= rs.getString("salesAmount");
	  				ob[i][5]= rs.getString("salesDate");
	  				ob[i][6]= rs.getString("sId");
	  				ob[i][7]= rs.getString("userName");
	  			}
	  			String s[]={"销售单单号","图书ISBN号","销售数量（本）","销售金额（元）","销售时间","销售商编号","销售商编号","经办人"};
	  			JTable tabel=new JTable(ob,s);
				JScrollPane sPane=new JScrollPane(tabel);
				panel_1.setVisible(false);
				panel_1.removeAll();
				panel_1.setLayout(null);
				sPane.setBounds(0,5,803, 453);
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
