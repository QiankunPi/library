package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZhuCe extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton button,button_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZhuCe frame = new ZhuCe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZhuCe() {
		setTitle("注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 526, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//设置背景图片
		ImageIcon icon = new ImageIcon(".\\images\\1.jpg");
		JLabel label1 = new JLabel(icon);
		label1.setBounds(0, 0,icon.getIconWidth(),icon.getIconHeight());
		contentPane.add(label1);
		

		JLabel label = new JLabel("用户名：");
		label.setBounds(120, 89, 72, 18);
		label1.add(label);
		
		JLabel label_1 = new JLabel("用户密码：");
		label_1.setBounds(106, 141, 91, 18);
		label1.add(label_1);
		
		JLabel label_2 = new JLabel("确认密码：");
		label_2.setBounds(106, 204, 86, 18);
		label1.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(206, 89, 120, 24);
		label1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 138, 120, 24);
		label1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(206, 201, 120, 24);
		label1.add(textField_2);
		textField_2.setColumns(10);
		
		button = new JButton("确认注册");
		button.setBounds(117, 262, 101, 47);
		label1.add(button);
		button.addActionListener(this);
		
		button_1 = new JButton("返回");
		button_1.addActionListener(this);
		button_1.setBounds(256, 262, 101, 47);
		label1.add(button_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==button_1){
				this.setVisible(false);
			}
			 if(e.getSource()==button){
				String name,password;
				boolean flag=false;
				Statement s=Password.getStatement();
				try {
					ResultSet set=s.executeQuery("select * from mima");
					while(set.next()){
						name=set.getString("name");
						if(name.equals(textField.getText())){
							JOptionPane.showMessageDialog(this, "此用户已被注册，请重新注册", "注册",JOptionPane.ERROR_MESSAGE);
						}
					}
			}
				catch(SQLException e1){
					e1.printStackTrace();
				}
				if(flag){
					JOptionPane.showMessageDialog(this, "注册失败", "注册", JOptionPane.ERROR_MESSAGE);
				}
				else{
					if(textField_1.getText().equals(textField_2.getText())){
						try{
							// 获得连接
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/table1","root","password");
							//添加注册信息表
							String sql = "insert into mima(name,password) "
									+ "values (?,?)";
							PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
							pstm.setInt(1, Integer.parseInt(textField.getText()));
							pstm.setString(2, textField_1.getText());
							pstm.executeUpdate();
							pstm.close();
					JOptionPane.showMessageDialog(this,"注册成功！","系统提示",JOptionPane.WARNING_MESSAGE);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
						}catch (Exception e2) {
						e2.printStackTrace();
					}
					}
						else {
							JOptionPane.showMessageDialog(this,"两次密码输入不一致，请重新输入！","系统提示",JOptionPane.ERROR_MESSAGE);
				}
				}
				
	        }
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
}
