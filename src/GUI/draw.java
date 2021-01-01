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
	
	JLabel l1=new JLabel("�ڴ�����ȡ����˺�");
	JTextField t1=new JTextField(18);
	
	JLabel l2=new JLabel("�ڴ�����ȡ����");
	JTextField t2=new JTextField(10);
	
	JButton jb1=new JButton("��ѯ���");
	JButton jb2=new JButton("ȡ��");
	JButton jb3=new JButton("��ӡ��Ϣ�嵥");
	JButton jb4=new JButton("����");
	
	JPanel jp1=new JPanel();	//�ϲ��ֲ�ѯ���
	JPanel jp2=new JPanel();	//�²���ȡ���뷵��
	
	JTable table1;
	
	public draw() {
		setTitle("ȡ��");
		
		jp1.setLayout(new FlowLayout());
		jp1.add(l1);
		jp1.add(t1);
		jp1.add(jb1);
		
		add(jp1,BorderLayout.NORTH);		
		
		jb1.addActionListener(new ActionListener() {	//�˻���Ϣ
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				if(!t1.getText().trim().equals(""))
				{
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
						new draw();
						setVisible(false);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ�����˺ţ�");
					new draw();
					setVisible(false);
				}
				}
			});
		
		jp2.add(l2);
		jp2.add(t2);
		jp2.add(jb2);
		add(jp2,BorderLayout.SOUTH);
		
		jb2.addActionListener(new ActionListener() {	//ȡ��	
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
						JOptionPane.showMessageDialog(null, "δ����ȡ���ȡ��ʧ�ܣ�");
						new draw();
						setVisible(false);
					}
					else {
						float num=Float.parseFloat(t2.getText());
						if(num>a.getA_balance()) {
							JOptionPane.showMessageDialog(null, "ȡ���������ȡ��ʧ�ܣ�");
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
							hdao.addHistory(h);		//д���˵�
							
							AccountDao a_dao=new AccountDao();
							Account h_a=a_dao.queryAccountById(id);
							
							float balance_new=h_a.getA_balance()-num;
							h_a.setA_balance(balance_new);
							
							adao.updateAccount(h_a);			//�����˻����
							
							JOptionPane.showMessageDialog(null, "ȡ��ɹ���");
						}	
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "��������Ҫȡ����˺ţ�");
					new draw();
					setVisible(false);
				}
			}
		});
		
		jp2.add(jb3);
		jb3.addActionListener(new ActionListener() {	//��ӡ��Ϣ�嵥
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				if(!t1.getText().trim().equals("")&&!t2.getText().trim().equals(""))
				{
					new rate_history(id);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ȡ��δ��ɣ�������Ϣ�嵥ʧ�ܣ�");
					new draw();
					setVisible(false);
				}
				}
		});
		
		jp2.add(jb4);
		jb4.addActionListener(new ActionListener() {
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
		draw application=new draw();
	}
}