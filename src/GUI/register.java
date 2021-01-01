package GUI;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import Dao.AccountDao;
import Dao.CustomerDao;
import Dao.HistoryDao;
import Entity.Account;
import Entity.Customer;
import Entity.History;

public class register extends JFrame{
	JLabel l1=new JLabel("�����˺�");
	JTextField t1=new JTextField(18);
	
	JLabel l2=new JLabel("��������");
	JTextField t2=new JTextField(5);
	
	JLabel l3=new JLabel("�����Ա�");
	JTextField t3=new JTextField(5);
	
	JLabel l4=new JLabel("��ϵ��ʽ");
	JTextField t4=new JTextField(11);
	
	JLabel l5=new JLabel("����סַ");
	JTextField t5=new JTextField(20);
	
	JButton b1=new JButton("ȷ��");
	JButton b2=new JButton("����");

	public register() {
		setTitle("����ע��");
		
		JPanel jp=new JPanel();
		jp.setLayout(new BorderLayout());
		add(jp);
		
		JPanel jp1=new JPanel();
		jp1.setLayout(new GridLayout(5,1));
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
		
		JPanel jp2=new JPanel();
		jp2.setLayout(new FlowLayout());
		jp.add(jp2,BorderLayout.SOUTH);
		
		jp2.add(b1);
		b1.addActionListener(new ActionListener() {//�ύ
			public void actionPerformed(ActionEvent e){
				
				String strDateFormat = "yyyy-MM-dd HH:mm:ss";
				SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
				java.util.Date date=new Date();
				
				if(!t1.getText().trim().equals("")&&!t2.getText().trim().equals("")&&!t3.getText().trim().equals("")&&!t4.getText().trim().equals("")&&!t5.getText().trim().equals("")) {
					Customer c=new Customer();		//�����û�
					c.setCustomer_id(t1.getText());
					c.setCustomer_name(t2.getText());
					c.setCustomer_sex(t3.getText());
					c.setCustomer_tel(t4.getText());
					c.setCustomer_home(t5.getText());
					CustomerDao cdao=new CustomerDao();
					cdao.addCustomer(c);		
					
					Account a=new Account();		//�����˻�
					a.setA_id(t1.getText());
					a.setA_name(t2.getText());
					a.setA_balance(0);
					AccountDao adao=new AccountDao();
					adao.addAccount(a);		
					
					History h=new History();		//�����˵�
					h.setId(t1.getText());
					h.setName(t2.getText());
					h.setHome(t5.getText());
					h.setKind("����");
					h.setDate(sdf.format(date));
					h.setNum(0);
					HistoryDao hdao=new HistoryDao();
					hdao.addHistory(h);
					
					JOptionPane.showMessageDialog(null, "ע��ɹ���");
					new bank_system();
					setVisible(false);
							}
				else {
					JOptionPane.showMessageDialog(null, "��Ϣ��д��������ע��ʧ�ܣ�");
					new register();
					setVisible(false);
				}
			}
					});
		jp2.add(b2);
		
		b2.addActionListener(new ActionListener() {//����
			public void actionPerformed(ActionEvent e){
				new bank_system();
				setVisible(false);
			}			
		});
		
		setBounds(300,300,600,300);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		register application=new register();
	}
}
