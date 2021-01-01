package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Dao.AdminDao;
import Entity.Administrator;

public class login extends JFrame {
	JLabel l1=new JLabel("管理员账号");
	JLabel l2=new JLabel("管理员密码");
	static JTextField t1=new JTextField(18);
	static JTextField pw=new JPasswordField(18);
	JButton jb1=new JButton("登录");		//确认按钮
	JButton jb2=new JButton("取消");		//取消按钮

	public login() {
		setTitle("银行储蓄系统");
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		add(l2);
		add(pw);
		
		add(jb1);
		jb1.addActionListener(new ActionListener() {	//登录
			public void actionPerformed(ActionEvent e){
				AdminDao adao=new AdminDao();
				Administrator admin=new Administrator();
				
				if(!t1.getText().trim().equals("")&&!pw.getText().trim().equals(""))	//用户名及密码非空
				{
					admin=adao.queryAccountById(t1.getText());
					if(admin!=null)		//查询到相关管理员账户
					{
						if(t1.getText().equals(admin.getAdmin_id())==true&&pw.getText().equals(admin.getAdmin_password())==true) {		//验证管理员账号 及密码
							JOptionPane.showMessageDialog(null, "欢迎您，"+ admin.getAdmin_name() +" 登录");		//弹窗提示 登陆成功
							new bank_system();	//进入菜单
							setVisible(false);
						}
						
						else
						{
							JOptionPane.showMessageDialog(null, "账号或密码错误，请检查！");
							t1.setText(null);
							pw.setText(null);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "未查询到相关管理员，请检查！");
						new login();
						setVisible(false);
					}
				}
				
				else if(t1.getText().trim().equals(""))		//账号为空
				{
					JOptionPane.showMessageDialog(null, "请输入账号！");
					new login();
					setVisible(false);
				}
				
				else if(pw.getText().trim().equals(""))		//密码为空
				{
					JOptionPane.showMessageDialog(null, "请输入密码！");
					new login();
					setVisible(false);
				}
			}
		});
		
		add(jb2);
		jb2.addActionListener(new ActionListener() {	//取消
			public void actionPerformed(ActionEvent e){
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});
		
		setBounds(300,300,300,150);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		login application=new login();
	}
}
