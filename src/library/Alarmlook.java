package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class Alarmlook extends JPanel {
	private JPanel panel,panel_1;
	public Alarmlook() {
		setBounds(0, 5, 805, 503);
		setLayout(null);
		
	    panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setForeground(Color.CYAN);
		panel.setBounds(0, 0, 805, 64);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("报警信息明细");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 26));
		label.setBounds(14, 13, 260, 39);
		panel.add(label);
		
	    panel_1 = new JPanel();
		panel_1.setBounds(0, 66, 805, 437);
		this.add(panel_1);
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
				rs=(ResultSet) stmt.executeQuery("SELECT*FROM t_alarm");
				rs.last();
	  			int k=rs.getRow();
	  			if(k==0)
	  			{
	  				JOptionPane.showMessageDialog(this,"您查询的表为空表","系统提示",JOptionPane.WARNING_MESSAGE);
	  			}
	  			rs.beforeFirst();
	  			String ob[][]=new String[k][4];
	  			for(int i=0;i<k&&rs.next();i++)
	  			{
	  				ob[i][0]= rs.getString("报警编号");
	  				ob[i][1]= rs.getString("图书类型");
	  				ob[i][2]= rs.getString("ISBN");
	  				ob[i][3]=rs.getString("内容");
	  			}
	  			String s[]={"报警编号","图书类型","ISBN","内容"};
	  			JTable tabel=new JTable(ob,s);
				JScrollPane sPane=new JScrollPane(tabel);
				panel_1.setVisible(false);
				panel_1.removeAll();
				sPane.setBounds(0,0,800, 500);
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
