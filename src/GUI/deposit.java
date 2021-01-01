package GUI;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import Dao.AccountDao;
import Dao.HistoryDao;
import Entity.Account;
import Entity.History;

import GUI.bank_system;

public class deposit extends JFrame {
	
	JLabel l1=new JLabel("在此输入需要存款储户账号");
	JTextField t1=new JTextField(18);
	
	JLabel l2=new JLabel("在此输入需要存款储户姓名");
	JTextField t2=new JTextField(10);
	
	JLabel l3=new JLabel("在此输入需要存款储户住址");
	JTextField t3=new JTextField(18);
	
	JLabel l4=new JLabel("在此输入存款利率");
	JTextField t4=new JTextField(5);
	
	JLabel l5=new JLabel("在此输入存款金额");
	JTextField t5=new JTextField(10);
	
	
	JButton jb1=new JButton("确认存款");
	JButton jb2=new JButton("打印存款单");
	JButton jb3=new JButton("返回");
	
	JTable table1;
	
	public deposit() {
		setTitle("存款");
		
		JPanel jp=new JPanel();
		jp.setLayout(new BorderLayout());
		add(jp);
		
		JPanel jp1=new JPanel();
		jp1.setLayout(new GridLayout(6,1));
		jp.add(jp1,BorderLayout.CENTER);
		
		JPanel jp11=new JPanel();
		jp1.add(jp11);
		jp11.setLayout(new FlowLayout());
		jp11.add(l1);
		jp11.add(t1);
		
		JPanel jp12=new JPanel();
		jp1.add(jp12);
		jp12.setLayout(new FlowLayout());
		jp12.add(l2);
		jp12.add(t2);
		
		JPanel jp13=new JPanel();
		jp1.add(jp13);
		jp13.setLayout(new FlowLayout());
		jp13.add(l3);
		jp13.add(t3);
		
		JPanel jp14=new JPanel();
		jp1.add(jp14);
		jp14.setLayout(new FlowLayout());
		jp14.add(l4);
		jp14.add(t4);
		
		JPanel jp15=new JPanel();
		jp1.add(jp15);
		jp15.setLayout(new FlowLayout());
		jp15.add(l5);
		jp15.add(t5);
		
		JPanel jp16=new JPanel();
		jp1.add(jp16);
		jp16.setLayout(new FlowLayout());
		jp16.add(jb1);
		
		JPanel jp2=new JPanel();
		jp2.setLayout(new FlowLayout());
		
		jp2.add(jb2);
		jp2.add(jb3);
		add(jp2,BorderLayout.SOUTH);
		
		jb1.addActionListener(new ActionListener() {	//确认存款
			public void actionPerformed(ActionEvent e){
				String strDateFormat = "yyyy-MM-dd HH:mm:ss";
				SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
				java.util.Date date=new Date();
				
				String id=t1.getText().toString();
				String name=t2.getText().toString();
				String home=t3.getText().toString();
				String rate=t4.getText().toString();
				String num=t5.getText().toString();
					
				if(!t1.getText().trim().equals("")&&!t2.getText().trim().equals("")&&!t3.getText().trim().equals("")&&!t4.getText().trim().equals("")&&!t5.getText().trim().equals(""))
				{
					History h=new History();
					h.setId(id);
					h.setName(name);
					h.setHome(home);
					h.setKind("+");
					h.setDate(sdf.format(date));
					h.setRate(Float.parseFloat(rate));
					h.setNum(Float.parseFloat(num));
					
					HistoryDao hdao=new HistoryDao();
					hdao.addHistory(h);		//写入账单
					
					AccountDao adao=new AccountDao();
					Account h_a=adao.queryAccountById(id);
					
					float balance_new=h_a.getA_balance()+Float.parseFloat(num);
					h_a.setA_balance(balance_new);
					
					adao.updateAccount(h_a);			//更新账户余额
					
					JOptionPane.showMessageDialog(null, "存款成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "请输入需要存款的完整信息！");
					new deposit();
					setVisible(false);
				}
			}
			});
		jb2.addActionListener(new ActionListener() {	//打印存款单
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				if((!t1.getText().trim().equals("")&&!t2.getText().trim().equals("")&&!t3.getText().trim().equals("")&&!t4.getText().trim().equals("")&&!t5.getText().trim().equals("")))
				{
					new deposit_history(id);
					setVisible(false);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "存款未完成，生成存款单失败！");
					new deposit();
					setVisible(false);
				}
				}
		});
		
		jb3.addActionListener(new ActionListener() {	//返回
			public void actionPerformed(ActionEvent e){
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
		deposit application=new deposit();
	}
}