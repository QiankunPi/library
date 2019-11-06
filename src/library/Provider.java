package library;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Provider extends JPanel implements ActionListener{
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
	private JTextField textField_10;
	private JPanel panel_1;
	private JButton button,button_1,button_2;
	private JRadioButton radioButton,radioButton_1;
	private JComboBox comboBox;
	private String sex;
	private JLabel label_3;
	private JPanel panel;
	private Connection con;
	private Statement sql;
	public Provider() {
		setBounds(0, 0, 805, 603);
		setLayout(null);
		setVisible(true);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 805, 63);
		add(panel);
		panel.setBackground(Color.CYAN);
		panel.setLayout(null);
		
		
		JLabel label = new JLabel("供货商基本信息");
		label.setBackground(Color.RED);
		label.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(14, 13, 223, 37);
		panel.add(label);
		
		label_3 = new JLabel("如果您要修改信息，请在下方修改完信息之后，点击此按钮！");
		label_3.setBounds(197, 20, 431, 30);
		panel.add(label_3);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 65, 805, 424);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("供货商编号：");
		label_1.setBounds(72, 31, 122, 32);
		panel_1.add(label_1);
		
		JLabel lblNewLabel = new JLabel("供货商名称：");
		lblNewLabel.setBounds(72, 91, 95, 18);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("供货商邮箱：");
		lblNewLabel_1.setBounds(72, 138, 95, 18);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("供货商地址：");
		lblNewLabel_2.setBounds(481, 91, 95, 18);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("供货商所在地邮编：");
		lblNewLabel_3.setBounds(441, 138, 146, 18);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("供货商电话：");
		lblNewLabel_4.setBounds(72, 193, 95, 18);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("供货商负责人：");
		lblNewLabel_5.setBounds(464, 38, 123, 18);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("负责人称谓：");
		lblNewLabel_7.setBounds(481, 193, 95, 18);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("负责人联系电话：");
		lblNewLabel_8.setBounds(453, 240, 123, 18);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("银行卡号：");
		lblNewLabel_9.setBounds(499, 291, 95, 18);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("供货商收款银行：");
		lblNewLabel_10.setBounds(45, 291, 122, 18);
		panel_1.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(200, 35, 122, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 88, 122, 24);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 135, 122, 24);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 190, 122, 24);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(590, 35, 122, 24);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(590, 88, 122, 24);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(590, 135, 122, 24);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(590, 190, 122, 24);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(590, 237, 122, 24);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(590, 288, 122, 24);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel label_2 = new JLabel("负责人性别：");
		label_2.setBounds(72, 243, 108, 18);
		panel_1.add(label_2);
		
		radioButton = new JRadioButton("男");
		radioButton.setBounds(200, 239, 71, 27);
		radioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sex = "男";
				radioButton_1.setSelected(false);
			}
		});
		panel_1.add(radioButton);
		
		radioButton_1 = new JRadioButton("女");
		radioButton_1.setBounds(268, 239, 157, 27);
        radioButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sex = "女";
				radioButton.setSelected(false);
			}
		});
		panel_1.add(radioButton_1);
		
		
		button = new JButton("修改供货商信息");
		button.setBounds(602, 21, 137, 35);
		panel.add(button);
		button.addActionListener(this);
		
		button_1 = new JButton("保存");
		button_1.setBounds(240, 342, 101, 44);
		panel_1.add(button_1);
		button_1.addActionListener(this);
		
		button_2 = new JButton("清空");
		button_2.setBounds(453, 342, 108, 44);
		panel_1.add(button_2);
		button_2.addActionListener(this);
		
		textField_10 = new JTextField();
		textField_10.setBounds(200, 288, 122, 24);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button_1){
			if(textField.getText().equals(null)||textField.getText().equals("")||textField_1.getText().equals(null)||textField_1.getText().equals("")||textField_2.getText().equals(null)||textField_2.getText().equals("")||textField_3.getText().equals(null)||
					textField_3.getText().equals("")||textField_4.getText().equals(null)||textField_4.getText().equals("")||textField_5.getText().equals(null)||textField_5.getText().equals("")||textField_6.getText().equals(null)||textField_6.getText().equals("")||
					textField_7.getText().equals(null)||textField_7.getText().equals("")||textField_8.getText().equals(null)||textField_8.getText().equals("")||sex==null)
		      {
				JOptionPane.showMessageDialog(this, "<html>信息没有添加完善<br/>请重新进行添加  !<html>","系统提示", JOptionPane.INFORMATION_MESSAGE);
		      }
			else{
		try{
			// 获得连接
			Class.forName("com.mysql.jdbc.Driver");
		 con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/table1","root","password");
			//添加书籍信息表
			String sql = "insert t_providerInfo (pId,pName,pMail,pAddress,pZip,"
					+ "pTel,pOwner,pSex,pTitle,pCellphone,pBank,bankId) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt(textField.getText()));
			pstm.setString(2, textField_1.getText());
			pstm.setString(3, textField_2.getText());
			pstm.setString(4, textField_3.getText());
			pstm.setString(5, textField_4.getText());
			pstm.setString(6, textField_5.getText());
			pstm.setString(7, textField_6.getText());
			pstm.setString(8, sex);
			pstm.setString(9, textField_7.getText());
			pstm.setString(10, textField_8.getText());
			pstm.setString(11, textField_9.getText());
			pstm.setString(12, textField_10.getText());
			pstm.executeUpdate();
			pstm.close();
			JOptionPane.showMessageDialog(this, "添加成功", "系统提示", JOptionPane.WARNING_MESSAGE);
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		}
		else if(e.getSource()==button_2)
		{
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			radioButton.setSelected(false);
			radioButton_1.setSelected(false);
			textField_7.setText("");
			textField_8.setText("");
			textField_9.setText("");
			textField_10.setText("");
		}
		else if(e.getSource()==button){
			if(textField.getText().equals(null)||textField.getText().equals("")||textField_1.getText().equals(null)||textField_1.getText().equals("")||textField_2.getText().equals(null)||textField_2.getText().equals("")||textField_3.getText().equals(null)||
					textField_3.getText().equals("")||textField_4.getText().equals(null)||textField_4.getText().equals("")||textField_5.getText().equals(null)||textField_5.getText().equals("")||textField_6.getText().equals(null)||textField_6.getText().equals("")||
					textField_7.getText().equals(null)||textField_7.getText().equals("")||textField_8.getText().equals(null)||textField_8.getText().equals("")||sex==null)
		      {
				JOptionPane.showMessageDialog(this, "<html>信息没有修改完善<br/>请重新进行修改 !<html>","系统提示", JOptionPane.INFORMATION_MESSAGE);
		      }
			else{
				  JOptionPane.showMessageDialog(this, "修改成功","系统提示", JOptionPane.INFORMATION_MESSAGE);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				} 
				catch (ClassNotFoundException e1) 
				{
					e1.printStackTrace();
				}
				try
				{
				con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/table1","root","password");
				sql=(Statement) con.createStatement();
				String updatesql="UPDATE t_providerInfo SET pName="+"'"+textField_1.getText()+"'"+","+"pMail="+"'"+textField_2.getText()+"'"+","
				+"pAddress="+"'"+textField_3.getText()+"'"+","+"pZip="+"'"+textField_4.getText()+"'"+","+"pTel="+"'"+textField_5.getText()+"'"+","
				+"pOwner="+"'"+textField_6.getText()+"'"+","+"pSex="+"'"+sex+"'"+","+"pTitle="+"'"+textField_7.getText()+"'"+","
				+"pCellphone="+"'"+textField_8.getText()+"'"+","+"pBank="+"'"+textField_9.getText()+"'"+","+"bankId="+"'"+textField_10.getText()+"'"
				+"WHERE pId="+"'"+textField.getText()+"'";
				
				sql.executeUpdate(updatesql);
				con.close();
				sql.close();
				this.setVisible(true);
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				} 
				}
		   }
		}
	}

