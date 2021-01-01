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
	
	JLabel l1=new JLabel("�ڴ�������Ҫ�����˺�");
	JTextField t1=new JTextField(18);
	
	JLabel l2=new JLabel("�ڴ�������Ҫ��������");
	JTextField t2=new JTextField(10);
	
	JLabel l3=new JLabel("�ڴ�������Ҫ����סַ");
	JTextField t3=new JTextField(18);
	
	JLabel l4=new JLabel("�ڴ�����������");
	JTextField t4=new JTextField(5);
	
	JLabel l5=new JLabel("�ڴ���������");
	JTextField t5=new JTextField(10);
	
	
	JButton jb1=new JButton("ȷ�ϴ��");
	JButton jb2=new JButton("��ӡ��");
	JButton jb3=new JButton("����");
	
	JTable table1;
	
	public deposit() {
		setTitle("���");
		
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
		
		jb1.addActionListener(new ActionListener() {	//ȷ�ϴ��
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
					hdao.addHistory(h);		//д���˵�
					
					AccountDao adao=new AccountDao();
					Account h_a=adao.queryAccountById(id);
					
					float balance_new=h_a.getA_balance()+Float.parseFloat(num);
					h_a.setA_balance(balance_new);
					
					adao.updateAccount(h_a);			//�����˻����
					
					JOptionPane.showMessageDialog(null, "���ɹ���");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "��������Ҫ����������Ϣ��");
					new deposit();
					setVisible(false);
				}
			}
			});
		jb2.addActionListener(new ActionListener() {	//��ӡ��
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				if((!t1.getText().trim().equals("")&&!t2.getText().trim().equals("")&&!t3.getText().trim().equals("")&&!t4.getText().trim().equals("")&&!t5.getText().trim().equals("")))
				{
					new deposit_history(id);
					setVisible(false);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "���δ��ɣ����ɴ�ʧ�ܣ�");
					new deposit();
					setVisible(false);
				}
				}
		});
		
		jb3.addActionListener(new ActionListener() {	//����
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