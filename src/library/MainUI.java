package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JComboBox;

import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.Box;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JTable;

import java.awt.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import org.omg.IOP.ServiceContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.IOException;

public class MainUI extends JFrame implements TreeSelectionListener,ActionListener{
	private JPanel contentPane;
	private JTree tree ;
	private JButton button;
	private DefaultMutableTreeNode d1;
	private DefaultMutableTreeNode node_1;
	JPanel panel_3=null;
	public static void main(String[] args) {
	try {
		MainUI mainUI=new MainUI();
		mainUI.setVisible(true);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	public MainUI() throws IOException{
		setTitle("图书进销存管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//最上层的面板（存放客服中心按钮）
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 1037, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//左上放的面板（存放管理员照片的那个面板）
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 66, 219, 65);
		contentPane.add(panel_1);
		//存放jtree的面板，所有的树枝目录都展现在此面板上
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("新进");
		panel_2.setBounds(0, 133, 219, 600);
		panel_2.setBackground(Color.CYAN);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		//客服中心
		button=new JButton("客服中心");
		button.setBounds(900,10,100, 50);
		button.setBackground(Color.red);
		panel.add(button);
		button.addActionListener(this);
		//向panel中添加图片
		ImageIcon icon = new ImageIcon(".\\images\\logo2.jpg");
		JLabel label=new JLabel(icon);
		label.setBounds(0, 0, 80, 65);
		panel.add(label);
		//存放在jpanel上的两个标签
		JLabel lblthe = new JLabel("图书进销存管理系统");
		lblthe.setFont(new Font("方正舒体", Font.BOLD, 34));
		lblthe.setForeground(Color.BLUE);
		lblthe.setBounds(84, 0, 333, 31);
		panel.add(lblthe);
		JLabel lblThe = new JLabel("The Books Invoicing System");
		lblThe.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblThe.setBounds(112, 34, 224, 31);
		panel.add(lblThe);
		//向panel_1中添加图片
		ImageIcon icon2=new ImageIcon(".\\images\\2.png");
		panel_1.setLayout(null);
		JLabel label2=new JLabel(icon2);
		label2.setBounds(0,0, 72, 64);
		panel_1.add(label2);
		
		JLabel label_1 = new JLabel("<html>欢迎您<br/>来到图书管理系统<html>");
		label_1.setFont(new Font("方正粗黑宋简体", Font.BOLD | Font.ITALIC, 17));
		label_1.setForeground(Color.RED);
		label_1.setBounds(75, 5, 144, 59);
		panel_1.add(label_1);
		
		//改变底部logo
		setIconImage(Toolkit.getDefaultToolkit().createImage(".\\images\\logo.jpg"));
		this.setResizable(false);
		this.setLocation(350, 200);
		
		//jtree进行分层
		tree = new JTree();
	    tree.setBackground(Color.CYAN);
	    //为jtree添加监听
	    tree.addTreeSelectionListener(this); 
		tree.setModel(new DefaultTreeModel(
		new DefaultMutableTreeNode("管理") {

				{
					node_1 = new DefaultMutableTreeNode("采购管理");
						 d1=new DefaultMutableTreeNode("添加新采购");
						 DefaultMutableTreeNode d2=new DefaultMutableTreeNode("历史采购查询");
						 node_1.add(d1);
						 node_1.add(d2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("销售管理");
						DefaultMutableTreeNode d3=new DefaultMutableTreeNode("添加新销售");
						DefaultMutableTreeNode d4=new DefaultMutableTreeNode("历史销售管理");
						 node_1.add(d3);
						 node_1.add(d4);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("库存管理");
						DefaultMutableTreeNode d5=new DefaultMutableTreeNode("库存图书基本信息查看");
						node_1.add(d5);
					add(node_1);
					node_1=new DefaultMutableTreeNode("人员管理");
						DefaultMutableTreeNode d6=new DefaultMutableTreeNode("供货商管理");
						DefaultMutableTreeNode d7=new DefaultMutableTreeNode("销售商管理");
						 node_1.add(d6);
						node_1.add(d7);
					add(node_1);
					node_1=new DefaultMutableTreeNode("账款管理");
						DefaultMutableTreeNode d8=new DefaultMutableTreeNode("采购费用支出明细");
						DefaultMutableTreeNode d9=new DefaultMutableTreeNode("销售费用支出明细");
						node_1.add(d8);
						node_1.add(d9);
					add(node_1);
					node_1=new DefaultMutableTreeNode("报警管理");
						DefaultMutableTreeNode d10=new DefaultMutableTreeNode("报警信息设置");
						DefaultMutableTreeNode d11=new DefaultMutableTreeNode("报警信息查看");
						node_1.add(d10);
						node_1.add(d11);         
					 add(node_1);
					 node_1=new DefaultMutableTreeNode("报表管理");
					    DefaultMutableTreeNode d12=new DefaultMutableTreeNode("图书库存报表");
					    DefaultMutableTreeNode d13=new DefaultMutableTreeNode("图书采购报表");
					    DefaultMutableTreeNode d14=new DefaultMutableTreeNode("图书销售报表");
					    node_1.add(d12);
					    node_1.add(d13);
					    node_1.add(d14);
				     add(node_1);
						}
					}
				));
				tree.setBounds(0, 0, 219, 430);
				panel_2.add(tree);
				//空面板，来使其它面板添加在上面
				 panel_3 = new JPanel();
				 panel_3.setBounds(221, 62, 805, 603);
				 panel_3.setLayout(null);
				 contentPane.add(panel_3);
	}
	@Override
	public void valueChanged(TreeSelectionEvent e){
		//利用node.toString()方法进行监听判断
		 DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		 panel_3.setVisible(false);
		 panel_3.removeAll();
		 try {
			 if (node.toString().equals("添加新采购")){
					panel_3.add(new Addxincaigou());
					panel_3.setVisible(true);
					}
			 else if (node.toString().equals("历史采购查询")){
					panel_3.add(new Historycaigou());
					panel_3.setVisible(true);
				 }
			 else if (node.toString().equals("添加新销售")){
					panel_3.add(new Addnewsale());
					panel_3.setVisible(true);
				 }
			 else if (node.toString().equals("历史销售管理")){
					panel_3.add(new Historysale());
					panel_3.setVisible(true);
				 }
			 else  if (node.toString().equals("库存图书基本信息查看")){
					panel_3.add(new Kucunbook());
					panel_3.setVisible(true);
				 }
			 else if (node.toString().equals("供货商管理")){
					panel_3.add(new Provider());
					panel_3.setVisible(true);
				 }
			 else  if (node.toString().equals("销售商管理")){
					panel_3.add(new Seller());
					panel_3.setVisible(true);
				 }
			 else if (node.toString().equals("采购费用支出明细")){
					panel_3.add(new Historycaigou());
					panel_3.setVisible(true);
				 }
			 else  if (node.toString().equals("销售费用支出明细")){
					panel_3.add(new Historysale());
					panel_3.setVisible(true);
				 }
			 else if (node.toString().equals("报警信息设置")){
					panel_3.add(new Alarmset());
					panel_3.setVisible(true);
				 }
			 else if (node.toString().equals("图书库存报表")){
					panel_3.add(new Bookkucuntable());
					panel_3.setVisible(true);
				 }
			 else if (node.toString().equals("报警信息查看")){
					panel_3.add(new Alarmlook());
					panel_3.setVisible(true);
				 }
			 else  if (node.toString().equals("图书采购报表")){
					panel_3.add(new Bookcaigoutable());
					panel_3.setVisible(true);
				 }
			 else if (node.toString().equals("图书销售报表")){
					panel_3.add(new Booksaletable());
					panel_3.setVisible(true);
				 }
		} catch (Exception e2) {	
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button){
			ChatWindow chatWindow=new ChatWindow();
			chatWindow.setVisible(true);
			ChatWindow2 chatWindow2=new ChatWindow2();
			chatWindow2.setVisible(true);
			
		}
	}
}
