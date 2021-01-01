package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import Dao.CustomerDao;
import Dao.AccountDao;
import Entity.Account;
import Entity.Customer;

import GUI.bank_system;

public class search extends JFrame {
	
	JLabel l1=new JLabel("在此输入需要查询储户账号");
	JTextField t1=new JTextField(18);
	
	JButton jb1=new JButton("用户信息");
	JButton jb2=new JButton("账户信息");
	
	JButton jb3=new JButton("返回");
	
	JPanel jp1=new JPanel();	//上部分2个按钮
	JPanel jp2=new JPanel();	//下部按钮
	
	JTable table1;
	JTable table2;
	
	public search() {
		setTitle("查询");
		
		jp1.setLayout(new FlowLayout());
		jp1.add(l1);
		jp1.add(t1);
		jp1.add(jb1);
		jp1.add(jb2);
		
		add(jp1,BorderLayout.NORTH);		
		
		jp2.add(jb3);
		add(jp2,BorderLayout.SOUTH);
		
		jb1.addActionListener(new ActionListener() {//用户信息
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				Object name1[]= {"储户账号","姓名","性别","联系方式","住址"};
				CustomerDao cdao=new CustomerDao();
				Customer c=cdao.queryCustomerById(id);
				if(c!=null)
				{
					List<Object[]> b=new ArrayList<>();
					Object[] a={c.getCustomer_id(),c.getCustomer_name(),c.getCustomer_sex(),c.getCustomer_tel(),c.getCustomer_home()};
					b.add(a);
					Object[][] x=(Object[][])b.toArray(new Object[b.size()][]);
					JTable table1=new JTable(x,name1);
					getContentPane().removeAll();
					add(new JScrollPane(table1),BorderLayout.CENTER);
					
					add(jp1,BorderLayout.NORTH);
					add(jp2,BorderLayout.SOUTH);
					setVisible(true);
					validate();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "该储户未注册，请先注册！");
					new register();
					setVisible(false);
				}
			}
			});
		
		jb2.addActionListener(new ActionListener() {	//账户信息
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				Object name2[]= {"账户","姓名","余额"};
				AccountDao adao=new AccountDao();
				Account a=adao.queryAccountById(id);
				if(a!=null)
				{
					List<Object[]> b1=new ArrayList<>();
					Object[] a1={a.getA_id(),a.getA_name(),a.getA_balance()};
					b1.add(a1);
				
					Object[][] y=(Object[][])b1.toArray(new Object[b1.size()][]);
					JTable table2=new JTable(y,name2);
					getContentPane().removeAll();
					add(new JScrollPane(table2),BorderLayout.CENTER);
				
				add(jp1,BorderLayout.NORTH);
				add(jp2,BorderLayout.SOUTH);
				validate();
				}
				else {
					JOptionPane.showMessageDialog(null, "未查询到该储户账户信息！");
					new search();
					setVisible(false);
				}
				}
			});
		
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){//返回
				new bank_system();
				setVisible(false);
				}
		});
		
		setBounds(300,300,600,400);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		search application=new search();
	}
}