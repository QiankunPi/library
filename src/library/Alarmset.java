package library;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Button;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Alarmset extends JPanel implements ActionListener{
	private JButton button;
	private JComboBox comboBox,comboBox_1;
	public Alarmset() {
		setBounds(0, 0, 805, 503);
		setLayout(null);
		
	    button = new JButton("保存");
		button.addActionListener(this);
		button.setBounds(328, 269, 113, 55);
		add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 127, 750, 111);
		add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("当库存的");
		label_1.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 20));
		label_1.setBounds(0, 38, 96, 18);
		panel.add(label_1);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 20));
		comboBox.setBounds(110, 35, 177, 24);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"请选择类别图书", "哈利波特"}));
		
		JLabel label_2 = new JLabel("类图书库存量少于");
		label_2.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 20));
		label_2.setBounds(301, 38, 177, 18);
		panel.add(label_2);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 20));
		comboBox_1.setBounds(502, 35, 96, 24);
		panel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"100", "200", "300"}));
		
		JLabel label_3 = new JLabel("的时候报警");
		label_3.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 20));
		label_3.setBounds(612, 22, 113, 44);
		panel.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 4, 805, 68);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("库存上限设置：");
		label.setBounds(14, 21, 197, 34);
		panel_1.add(label);
		label.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 24));
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button){
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
	  	   try {
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/table1","root","password");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			try {
				stmt=(Statement) con.createStatement(1005, 1008);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if("SELECT*FROM t_alarm where 图书类型="+"'"+comboBox.getSelectedItem() != null){
			JOptionPane.showMessageDialog(this, "设置哈利波特图书上限为"+comboBox_1.getSelectedItem()+"成功", "报警设置", JOptionPane.WARNING_MESSAGE);
		}
		}
	}
}
