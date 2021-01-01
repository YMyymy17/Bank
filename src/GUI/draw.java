package GUI;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.*;

import javax.swing.*;
import javax.swing.event.*;

import Dao.CustomerDao;
import Dao.HistoryDao;
import Dao.AccountDao;
import Entity.Account;
import Entity.Customer;
import Entity.History;
import GUI.bank_system;
import GUI.login;

public class draw extends JFrame {
	
	JLabel l1=new JLabel("在此输入取款储户账号");
	JTextField t1=new JTextField(18);
	
	JLabel l2=new JLabel("在此输入取款金额");
	JTextField t2=new JTextField(10);
	
	JButton jb1=new JButton("查询余额");
	JButton jb2=new JButton("取款");
	JButton jb3=new JButton("打印利息清单");
	JButton jb4=new JButton("返回");
	
	JPanel jp1=new JPanel();	//上部分查询余额
	JPanel jp2=new JPanel();	//下部分取款与返回
	
	JTable table1;
	
	public draw() {
		setTitle("取款");
		
		jp1.setLayout(new FlowLayout());
		jp1.add(l1);
		jp1.add(t1);
		jp1.add(jb1);
		
		add(jp1,BorderLayout.NORTH);		
		
		jb1.addActionListener(new ActionListener() {	//账户信息
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				if(!t1.getText().trim().equals(""))
				{
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
						new draw();
						setVisible(false);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "请输入需要查询余额的账号！");
					new draw();
					setVisible(false);
				}
				}
			});
		
		jp2.add(l2);
		jp2.add(t2);
		jp2.add(jb2);
		add(jp2,BorderLayout.SOUTH);
		
		jb2.addActionListener(new ActionListener() {	//取款	
			public void actionPerformed(ActionEvent e){
				
				String strDateFormat = "yyyy-MM-dd HH:mm:ss";
				SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
				java.util.Date date=new Date();
				
				String id=t1.getText().toString();
				
				if(!t1.getText().trim().equals("")){
					AccountDao adao=new AccountDao();
					Account a=new Account();
					a=adao.queryAccountById(id);
					
					if(t2.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "未输入取款金额，取款失败！");
						new draw();
						setVisible(false);
					}
					else {
						float num=Float.parseFloat(t2.getText());
						if(num>a.getA_balance()) {
							JOptionPane.showMessageDialog(null, "取款金额大于余额，取款失败！");
							new draw();
							setVisible(false);
						}
						else {
							CustomerDao cdao=new CustomerDao();
							Customer c=cdao.queryCustomerById(id);
							HistoryDao h_dao=new HistoryDao();
							History history=h_dao.queryHistoryByTime(id);
							float rate=history.getRate();
							
							History h=new History();
							h.setId(c.getCustomer_id());
							h.setName(c.getCustomer_name());
							h.setHome(c.getCustomer_home());
							h.setKind("-");
							h.setDate(sdf.format(date));
							h.setRate(rate);
							h.setNum(num);
							
							HistoryDao hdao=new HistoryDao();
							hdao.addHistory(h);		//写入账单
							
							AccountDao a_dao=new AccountDao();
							Account h_a=a_dao.queryAccountById(id);
							
							float balance_new=h_a.getA_balance()-num;
							h_a.setA_balance(balance_new);
							
							adao.updateAccount(h_a);			//更新账户余额
							
							JOptionPane.showMessageDialog(null, "取款成功！");
						}	
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "请输入需要取款的账号！");
					new draw();
					setVisible(false);
				}
			}
		});
		
		jp2.add(jb3);
		jb3.addActionListener(new ActionListener() {	//打印利息清单
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				if(!t1.getText().trim().equals("")&&!t2.getText().trim().equals(""))
				{
					new rate_history(id);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "取款未完成，生成利息清单失败！");
					new draw();
					setVisible(false);
				}
				}
		});
		
		jp2.add(jb4);
		jb4.addActionListener(new ActionListener() {
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
		draw application=new draw();
	}
}