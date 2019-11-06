package library;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.Connection;

public class Enter extends JFrame implements ActionListener{
	JLabel name,password1,password2;
	JTextField nametTextField;
	JPasswordField password1TextField,password2TextField;
	JButton 登录,注册;
	Container c;
	public Enter() throws Exception  {
		super("图书管理系统");
		//设置布局为空
		setLayout(null);
		//定义一个容器
		c=getContentPane();
		name=new JLabel("用户账号：");
		password1=new JLabel("用户密码：");
		password2=new JLabel("确认密码：");
		nametTextField=new JTextField(16);
		password1TextField=new JPasswordField(16);
		password2TextField=new JPasswordField(16);
		登录=new JButton("登录");
		注册=new JButton("注册");
		//创建两个按钮监听
		登录.addActionListener(this);
		注册.addActionListener(this);
		//设置背景图片
		ImageIcon icon = new ImageIcon(".\\images\\1.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0, 0,icon.getIconWidth(),icon.getIconHeight());
		c.add(label);
		//将各组件添加到容器中
		label.add(name);
		label.add(nametTextField);
		label.add(password1);
		label.add(password2);
		label.add(password1TextField);
		label.add(password2TextField);
		label.add(登录);
		label.add(注册);
		//设置各组件的位置和大小(x坐标，y坐标，宽，高)
		name.setBounds(180, 100, 250, 52);
		nametTextField.setBounds(280, 110, 200, 35);
		password1.setBounds(180, 150, 250, 52);
		password2.setBounds(180, 200, 250, 52);
		password1TextField.setBounds(280, 160, 200, 35);
		password2TextField.setBounds(280, 210, 200, 35);
		登录.setBounds(200, 300, 80, 50);
		注册.setBounds(380, 300, 80, 50);
		//设置窗体大小，位置，不可拉伸
		setBounds(400, 200,650, 436);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//改变logo
		setIconImage(Toolkit.getDefaultToolkit().createImage(".\\images\\logo.jpg"));	
	}
	/*public void paint(Graphics g) {
		 super.paint(g);
		 ImageIcon image1 = new ImageIcon("C:\\Users\\皮乾坤\\Desktop\\001.jpg");
		//根据按钮大小改变图片大小
		Image temp = image1.getImage().getScaledInstance(登录.getWidth(), 登录.getHeight(), image1.getImage().SCALE_DEFAULT);
		image1 = new ImageIcon(temp);
		登录.setIcon(image1);
		
		ImageIcon image2 = new ImageIcon("C:\\Users\\皮乾坤\\Desktop\\002.jpg");
		//根据按钮大小改变图片大小
		Image temp2 = image2.getImage().getScaledInstance(注册.getWidth(), 注册.getHeight(), image2.getImage().SCALE_DEFAULT);
		image2 = new ImageIcon(temp2);
	        注册.setIcon(image2);
	};*/

	@Override
	public void actionPerformed(ActionEvent e) {
		String name,password;
		boolean flag=false;
		if(e.getSource()==登录){
			Statement s=Password.getStatement();
			try {
				ResultSet set=s.executeQuery("select * from mima");
				while(set.next()){
					name=set.getString("name");
					if(name.equals(nametTextField.getText())){
						flag=true;
						break;
					}
				}
				if(flag){
						String password1=new String(password1TextField.getPassword());
						String password2=new String(password2TextField.getPassword());
						if(password1.equals(password2)){
							password=set.getString("password");
							if(password.equals(password1)){
								try {
								MainUI mainUI=new MainUI();
								mainUI.setVisible(true);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								this.setVisible(false);
							}
							else{
								JOptionPane.showMessageDialog(this, "密码错误，请重新输入！");
								password1TextField.setText("");
								password2TextField.setText("");
							}
						}
						else{
								JOptionPane.showMessageDialog(this, "两次输入的密码不一致，请重新输入！");
								password1TextField.setText("");
								password2TextField.setText("");
							}
						}
					else{
						JOptionPane.showMessageDialog(this, "账户不存在，请重新输入！");
						nametTextField.setText("");
					}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		else if(e.getSource()==注册){
			ZhuCe zhuCe=new ZhuCe();
			zhuCe.setVisible(true);
		}
	}

	public static void main(String[] args) throws Exception {
		new Enter();
	}
}
	




