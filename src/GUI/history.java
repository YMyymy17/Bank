package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.*;

import javax.swing.*;
import javax.swing.event.*;

import Dao.HistoryDao;
import Entity.History;

import GUI.bank_system;
import GUI.login;

public class history extends JFrame {
	
	JLabel l1=new JLabel("�ڴ�������Ҫ��ѯ�����˺�");
	JTextField t1=new JTextField(18);
	
	JButton jb1=new JButton("��ѯ�˵�");
	
	JButton jb2=new JButton("����");
	
	JPanel jp1=new JPanel();	//�ϲ���2����ť
	JPanel jp2=new JPanel();	//�²���ť
	
	JTable table1;
	JTable table2;
	
	public history() {
		setTitle("�˵���ѯ");
		
		jp1.setLayout(new FlowLayout());
		jp1.add(l1);
		jp1.add(t1);
		jp1.add(jb1);
		
		add(jp1,BorderLayout.NORTH);		
		
		jp2.add(jb2);
		add(jp2,BorderLayout.SOUTH);
		
		jb1.addActionListener(new ActionListener() {//�˵�
			public void actionPerformed(ActionEvent e){
				String id=t1.getText().toString();
				if(!t1.getText().trim().equals(""))
				{
					Object name1[]= {"�����˺�","����","סַ","��������","����","����","����"};
					HistoryDao hdao=new HistoryDao();
					List<History> list=hdao.allHistoryById(id);
					if(list!=null)
					{
						List<Object[]> b=new ArrayList<>();
						for(History t:list) {
							Object[] a={t.getId(),t.getName(),t.getHome(),t.getKind(),t.getDate(),t.getRate(),t.getNum()};
							b.add(a);
						}	
						Object[][] x=(Object[][])b.toArray(new Object[b.size()][]);
						JTable table1=new JTable(x,name1);
						getContentPane().removeAll();
						add(new JScrollPane(table1),BorderLayout.CENTER);
						
						add(jp1,BorderLayout.NORTH);
						add(jp2,BorderLayout.SOUTH);
						setVisible(true);
						validate();
					}
					if(list==null||list.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "δ��ѯ���ô�������˵���");
						new history();
						setVisible(false);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ�˵����˺ţ�");
					new history();
					setVisible(false);
				}
			}
			});
		
		jb2.addActionListener(new ActionListener() {
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
		history application=new history();
	}
}