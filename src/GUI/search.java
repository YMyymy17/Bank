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
	
	JLabel l1=new JLabel("�ڴ�������Ҫ��ѯ�����˺�");
	JTextField t1=new JTextField(18);
	
	JButton jb1=new JButton("�û���Ϣ");
	JButton jb2=new JButton("�˻���Ϣ");
	
	JButton jb3=new JButton("����");
	
	JPanel jp1=new JPanel();	//�ϲ���2����ť
	JPanel jp2=new JPanel();	//�²���ť
	
	JTable table1;
	JTable table2;
	
	public search() {
		setTitle("��ѯ");
		
		jp1.setLayout(new FlowLayout());
		jp1.add(l1);
		jp1.add(t1);
		jp1.add(jb1);
		jp1.add(jb2);
		
		add(jp1,BorderLayout.NORTH);		
		
		jp2.add(jb3);
		add(jp2,BorderLayout.SOUTH);
		
		jb1.addActionListener(new ActionListener() {//�û���Ϣ
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				Object name1[]= {"�����˺�","����","�Ա�","��ϵ��ʽ","סַ"};
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
					JOptionPane.showMessageDialog(null, "�ô���δע�ᣬ����ע�ᣡ");
					new register();
					setVisible(false);
				}
			}
			});
		
		jb2.addActionListener(new ActionListener() {	//�˻���Ϣ
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				Object name2[]= {"�˻�","����","���"};
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
					JOptionPane.showMessageDialog(null, "δ��ѯ���ô����˻���Ϣ��");
					new search();
					setVisible(false);
				}
				}
			});
		
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){//����
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