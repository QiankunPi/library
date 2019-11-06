package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.sql.DriverManager;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Addxincaigou extends JPanel implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton button1,button2;
	public Addxincaigou() {
		setBounds(0, 0, 805, 603);
		setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 805, 65);
		add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		JLabel label = new JLabel("添加新采购");
		label.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(14, 13, 146, 39);
		panel.add(label);
		
		JLabel label_1 = new JLabel("图书信息");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 18));
		label_1.setBounds(14, 78, 85, 18);
		add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 109, 777, 494);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("采购单单号：");
		label_2.setBounds(54, 29, 90, 32);
		panel_1.add(label_2);
		
		JLabel lblisbn = new JLabel("图书ISBN号：");
		lblisbn.setBounds(54, 95, 109, 18);
		panel_1.add(lblisbn);
		
		JLabel label_3 = new JLabel("采购数量：");
		label_3.setBounds(73, 151, 90, 18);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("进价：");
		label_4.setBounds(101, 206, 72, 18);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("出版社：");
		label_5.setBounds(86, 258, 77, 18);
		panel_1.add(label_5);
		
		textField = new JTextField();
		textField.setBounds(157, 33, 109, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 92, 109, 24);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 148, 109, 24);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(157, 203, 109, 24);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(157, 255, 109, 24);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_6 = new JLabel("采购日期：");
		label_6.setBounds(432, 36, 90, 18);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("供货商编号：");
		label_7.setBounds(418, 98, 90, 18);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("经办人：");
		label_8.setBounds(450, 151, 72, 18);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("库号：");
		label_9.setBounds(461, 206, 72, 18);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("货架：");
		label_10.setBounds(461, 258, 72, 18);
		panel_1.add(label_10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(525, 33, 109, 24);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(522, 98, 112, 24);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(525, 148, 109, 24);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(525, 203, 109, 24);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(525, 255, 109, 24);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		button1 = new JButton("保存");
		button1.setBounds(202, 337, 113, 45);
		panel_1.add(button1);
		button2 = new JButton("清空");
		button2.setBounds(420, 337, 113, 45);
		panel_1.add(button2);
		button2.addActionListener(this);
		button1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button1)
		{
			if(textField.getText().equals(null)||textField.getText().equals("")||textField_1.getText().equals(null)||textField_1.getText().equals("")||textField_2.getText().equals(null)||textField_2.getText().equals("")||textField_3.getText().equals(null)||
					textField_3.getText().equals("")||textField_4.getText().equals(null)||textField_4.getText().equals("")||textField_5.getText().equals(null)||textField_5.getText().equals("")||textField_6.getText().equals(null)||textField_6.getText().equals("")||
					textField_7.getText().equals(null)||textField_7.getText().equals("")||textField_8.getText().equals(null)||textField_8.getText().equals("")||textField_9.getText().equals(null)||textField_9.getText().equals(""))
		      {
				JOptionPane.showMessageDialog(this, "<html>信息没有添加完善<br/>请重新进行添加  !<html>","系统提示", JOptionPane.INFORMATION_MESSAGE);
		      }
			else {
			try{
				// 获得连接
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/table1","root","password");
				String p1=textField_2.getText();
				double p2=Integer.parseInt(textField_3.getText());
				double q1=Double.parseDouble(p1)*p2;
				//添加书籍信息表
				String sql = "insert into t_purchasedetail (purchaseOrderId,ISBN,purchaseQuentity,purchasePrice,purchaseAmount,"
						+ "purchaseDate,pId,userName,storehouseNumber,shelves)"
						+ "values (?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setInt(1, Integer.parseInt(textField.getText()));
				pstm.setString(2, textField_1.getText());
				pstm.setString(3, textField_2.getText());
				pstm.setString(4, textField_3.getText());
				pstm.setDouble(5, q1);
				pstm.setString(6, textField_5.getText());
				pstm.setString(7, textField_6.getText());
				pstm.setString(8, textField_7.getText());
				pstm.setString(9, textField_8.getText());
				pstm.setString(10, textField_9.getText());
				pstm.executeUpdate();
				pstm.close();
				JOptionPane.showMessageDialog(this,"添加成功！","系统提示",JOptionPane.WARNING_MESSAGE);
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		
	}
		if(e.getSource()==button2)
		{
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
			textField_8.setText("");
			textField_9.setText("");
		}

	}
	
}
