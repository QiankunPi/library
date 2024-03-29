package library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ChatWindow extends JFrame {

	private JButton sendButton;
	 private JButton cancelButton;
	 private JButton receiveButton;
	 private JTextArea receiveText;
	 private JTextField sendText;
	 
	 private JLabel localPort = new JLabel();
	 
	 private JTextField remoteAddress;
	 private JTextField remotePort;
	 private SendThread sendThread;
	 private ReceiveThread receiveThread;
	 
	 private void GUIini(){
	  Container c = this.getContentPane();
	  c.setLayout(new BorderLayout());
	  setBounds(970, 320, 400,500);
	  setTitle("与客户端对话");
	 
	 
	  //第二个panel
	  JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
	  panel2.setSize(400,200);
	  panel2.add(new JLabel("对话内容"));
	  receiveText = new JTextArea(15,30);
	  receiveText.setEditable(false);
	  receiveText.setAutoscrolls(true);
	  JScrollPane jsp = new JScrollPane(receiveText);
	  panel2.add(jsp);
	  //第三个panel
	//  JPanel panel3 = new JPanel(new GridLayout(2, 1));
	  panel2.add(new JLabel("请输入发送的内容"));
	  sendText = new JTextField(30);
	  sendText.setAutoscrolls(true);
	  panel2.add(sendText);
	  c.add(panel2,BorderLayout.CENTER);
	  //c.add(panel3);
	  //第四个panel
	  JPanel panel4 = new JPanel(new GridLayout(1, 0));
	  panel4.setSize(400,20);
	  receiveButton = new JButton("开始接受数据");
	  sendButton = new JButton("发送");
	  cancelButton = new JButton("取消");
	  panel4.add(receiveButton);
	  panel4.add(cancelButton);
	  panel4.add(sendButton);
	  c.add(panel4,BorderLayout.SOUTH);
	  //四个面板内容设置完毕
	 
	  setVisible(true);
	  setResizable(false);
	 }
	 
	 private void ActionIni() {
	 
	  //键盘动作
	  this.addKeyListener(new KeyListener() {
	 
	   @Override
	   public void keyTyped(KeyEvent e) {
	 
	   }
	 
	   @Override
	   public void keyReleased(KeyEvent e) {
	    // TODO Auto-generated method stub
	    if(e.getKeyCode() == KeyEvent.VK_ENTER){
	     //发送文本
	     try {
			sendThread.senMessage(InetAddress.getLocalHost().getHostAddress(), 8086, sendText.getText());
		} catch (NumberFormatException | UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     receiveText.setText(receiveText.getText() + "\n" + "我:" + sendText.getText());
	    }
	   }
	 
	   @Override
	   public void keyPressed(KeyEvent e) {
	    // TODO Auto-generated method stub
	 
	   }
	  });
	  //取消按钮的动作
	  cancelButton.addMouseListener(new MouseListener() {
	 
	   @Override
	   public void mouseReleased(MouseEvent e) {
	    // TODO Auto-generated method stub
	    sendText.setText("");
	   }
	 
	   @Override
	   public void mousePressed(MouseEvent e) {
	    // TODO Auto-generated method stub
	 
	   }
	 
	   @Override
	   public void mouseExited(MouseEvent e) {
	    // TODO Auto-generated method stub
	 
	   }
	 
	   @Override
	   public void mouseEntered(MouseEvent e) {
	    // TODO Auto-generated method stub
	 
	   }
	 
	   @Override
	   public void mouseClicked(MouseEvent e) {
	    // TODO Auto-generated method stub
	 
	   }
	  });
	  sendButton.addMouseListener(new MouseListener() {
	 
	   @Override
	   public void mouseReleased(MouseEvent e) {
	    //发送文本
	    try {
			sendThread.senMessage(InetAddress.getLocalHost().getHostAddress(), 8086, sendText.getText());
		} catch (NumberFormatException | UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    receiveText.setText(receiveText.getText() + "我:" + sendText.getText()+ "\n");
	   }
	 
	   @Override
	   public void mousePressed(MouseEvent e) {
	    // TODO Auto-generated method stub
	 
	   }
	 
	   @Override
	   public void mouseExited(MouseEvent e) {
	    // TODO Auto-generated method stub
	 
	   }
	 
	   @Override
	   public void mouseEntered(MouseEvent e) {
	    // TODO Auto-generated method stub
	 
	   }
	 
	   @Override
	   public void mouseClicked(MouseEvent e) {
	    // TODO Auto-generated method stub
	 
	   }
	  });
	 }
	 
	 private void ThreadIni() {
	  // TODO Auto-generated method stub
	  sendThread = new SendThread(0, this);
	  receiveThread = new ReceiveThread(this);
	 }
	 //构造函数
	 public ChatWindow() {
	  GUIini();
	  ActionIni();
	  ThreadIni();
	 }
	 
	 public void printError(String err){
	  System.out.println("Error occur:" + err);
	 }
	 
	 //回调函数,用于接受从线程中返回的数据
	 public void setReceive(String receive){
	  receiveText.setText(receiveText.getText() + "客户端:" + receive+ "\n" );
	 }
	 
	 //当接受数据的线程开始工作以后，就调用该回调函数，设置当前聊天窗口使用的端口是哪个
	 public void setLocalPort(int localPortText){
	  localPort.setText(""+localPortText);
	 }
	 

}