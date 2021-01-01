package GUI;

import java.awt.event.*;
import javax.swing.*;

public class bank_system extends JFrame{
	JButton jb1=new JButton("查询");
	JButton jb2=new JButton("存款");
	JButton jb3=new JButton("取款");
	JButton jb4=new JButton("账单");
	JButton jb5=new JButton("注销");
	public bank_system(){
		setTitle("银行储蓄系统菜单");
		setLayout(null);
		add(jb1);
		jb1.setBounds(100, 80, 100, 30);
		jb1.addActionListener(new ActionListener() {//查询
			public void actionPerformed(ActionEvent e){
					new search();
					setVisible(false);
					}
			});
		
		add(jb2);
		jb2.setBounds(200, 80, 100, 30);
		jb2.addActionListener(new ActionListener() {//存款
			public void actionPerformed(ActionEvent e){
				new deposit();
				setVisible(false);
				}
			});
		
		add(jb3);
		jb3.setBounds(300, 80, 100, 30);
		jb3.addActionListener(new ActionListener() {//取款
			public void actionPerformed(ActionEvent e){
				new draw();
				setVisible(false);
			}
		});
		
		add(jb4);
		jb4.setBounds(400, 80, 100, 30);
		jb4.addActionListener(new ActionListener() {//账单
			public void actionPerformed(ActionEvent e){
				new history();
				setVisible(false);
			}
		});
		
		add(jb5);
		jb5.setBounds(500, 80, 100, 30);
		jb5.addActionListener(new ActionListener() {//注销
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "用户已成功退出系统！");
				new login();
				setVisible(false);
			}
		});
		
		setBounds(300,300,740,200);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
		public static void main(String[] args) {
			bank_system application=new bank_system();
		}
	}