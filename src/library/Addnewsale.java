package library;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;

public class Addnewsale extends JPanel implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton button,button_1;
	private JTextField textField_3;
	private JTextField textField_4;
	public Addnewsale() {
		setLayout(null);
		setBounds(0, 0, 805, 503);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 6, 805, 71);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("添加新销售信息");
		label.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 25));
		label.setBounds(32, 13, 223, 32);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 79, 805, 424);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 26, 700, 316);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("销售单单号：");
		label_2.setBounds(86, 57, 90, 18);
		panel_2.add(label_2);
		
		JLabel label_1 = new JLabel("添加新销售单");
		label_1.setBounds(14, 0, 129, 33);
		panel_2.add(label_1);
		label_1.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lable_5 = new JLabel("图书ISBN：");
		lable_5.setBounds(96, 119, 99, 18);
		panel_2.add(lable_5);
		
		JLabel label_4 = new JLabel("销售数量（本）：");
		label_4.setBounds(50, 183, 121, 18);
		panel_2.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(190, 54, 120, 24);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 116, 120, 24);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 180, 117, 24);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_6 = new JLabel("售价：");
		label_6.setBounds(409, 180, 55, 18);
		panel_2.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(499, 116, 117, 24);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_7 = new JLabel("销售商编号：");
		label_7.setBounds(385, 57, 99, 18);
		panel_2.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(499, 54, 117, 24);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_8 = new JLabel("销售时间：");
		label_8.setBounds(395, 119, 87, 18);
		panel_2.add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(499, 177, 117, 24);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_3 = new JLabel("经办人：");
		label_3.setBounds(104, 244, 72, 18);
		panel_2.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 241, 120, 24);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("出版社：");
		lblNewLabel.setBounds(409, 244, 72, 18);
		panel_2.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(499, 241, 117, 24);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
	     button = new JButton("保存");
	     button.addActionListener(this);
		button.setBounds(237, 355, 113, 44);
		panel_1.add(button);
		
	    button_1 = new JButton("清空");
	    button_1.addActionListener(this);
		button_1.setBounds(452, 355, 113, 44);
		panel_1.add(button_1);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		{
			if(textField.getText().equals(null)||textField.getText().equals("")||textField_1.getText().equals(null)||textField_1.getText().equals("")||textField_2.getText().equals(null)||textField_2.getText().equals("")||textField_3.getText().equals(null)||
					textField_3.getText().equals("")||textField_4.getText().equals(null)||textField_4.getText().equals("")||textField_5.getText().equals(null)||textField_5.getText().equals("")||textField_6.getText().equals(null)||textField_6.getText().equals("")||
					textField_7.getText().equals(null)||textField_7.getText().equals(""))
		      {
				JOptionPane.showMessageDialog(this, "<html>信息没有添加完善<br/>请重新进行添加  !<html>","系统提示", JOptionPane.INFORMATION_MESSAGE);
		      }
			else{
			try{
				// 获得连接
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/table1","root","password");
				String p1=textField_2.getText();
				double p2=Integer.parseInt(textField_7.getText());
				double q1=Double.parseDouble(p1)*p2;
				//添加销售信息表
				String sql = "insert into t_salesdetail (salesOrderId,ISBN,salesQuentity,salesPrice,salesAmount,"
						+ "salesDate,sId,userName) "
						+ "values (?,?,?,?,?,?,?,?)";
				PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setInt(1, Integer.parseInt(textField.getText()));
				pstm.setString(2, textField_1.getText());
				pstm.setString(3, textField_2.getText());
				pstm.setString(4, textField_3.getText());
				pstm.setDouble(5, q1);
				pstm.setString(6, textField_5.getText());
				pstm.setString(7, textField_6.getText());
				pstm.setString(8, textField_7.getText());
				pstm.executeUpdate();
				pstm.close();
				JOptionPane.showMessageDialog(this,"添加成功！","系统提示",JOptionPane.WARNING_MESSAGE);
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		
	}
		if(e.getSource()==button_1)
		{
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
		}

	}
}
