package library;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jxl.demo.Demo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Historysale extends JPanel implements ActionListener{

	private JComboBox comboBox;
	private JButton button,button_1;
	JPanel panel_1;
	public Historysale() {
		setLayout(null);
		setBounds(0, 0, 805, 503);
		ImageIcon icon=new ImageIcon(".\\images\\2.jpg");
		JLabel label=new JLabel(icon);
		label.setBounds(0, 0, 46, 45);
		this.add(label);
		JLabel label_1 = new JLabel("查看内容：按月查询：");
		label_1.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(73, 13, 170, 32);
		this.add(label_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--请选择--", "1", "2", 
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(262, 13, 106, 32);
		this.add(comboBox);
		
		button = new JButton("查询");
		button.addActionListener(this);
		button.setBounds(415, 13, 91, 32);
		this.add(button);
		
	    button_1 = new JButton("打印");
		button_1.addActionListener(this);
		button_1.setBounds(520, 13, 91, 32);
		add(button_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 45, 805, 458);
		this.add(panel_1);
		
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
	  			String s[]={"销售单单号","图书ISBN号","销售数量（本）","售价","销售金额（元）","销售时间","销售商编号","经办人"};
	  			JTable tabel=new JTable(ob,s);
				JScrollPane sPane=new JScrollPane(tabel);
				sPane.setBounds(0, 5, 803, 453);
				panel_1.setVisible(false);
				panel_1.removeAll();
				panel_1.setLayout(null);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		 
	   	  if(e.getSource()==button)
	   	  {
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
				rs=(ResultSet) stmt.executeQuery("SELECT*FROM t_salesdetail where salesDate="+"'"+comboBox.getSelectedItem()+"'");
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
	  			String s[]={"销售单单号","图书ISBN号","销售数量（本）","售价","销售金额（元）","销售时间","销售商编号","经办人"};
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
	   	  else if(e.getSource()==button_1){
	   		try {
				HistorysaleExcel.main(null);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   	JOptionPane.showMessageDialog(this, "文件导出成功，请前往E盘目录下进行查看打印", "excel打印", JOptionPane.OK_CANCEL_OPTION);
		   	  } 
	}
}
