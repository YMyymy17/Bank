package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import Dao.HistoryDao;
import Entity.History;

import GUI.bank_system;

public class rate_history extends JFrame {
	
	JButton jb1=new JButton("��ӡ��Ϣ�嵥");
	
	JButton jb2=new JButton("����");
	
	JPanel jp1=new JPanel();	//�ϲ���2����ť
	JPanel jp2=new JPanel();	//�²���ť
	
	JLabel l1=new JLabel("�������");
	JTextField t1=new JTextField();
	
	JTable table1;
	
	public rate_history(String id) {
		setTitle("��ӡ��Ϣ�嵥");
		
		jp1.setLayout(new FlowLayout());
		jp1.add(jb1);
		
		add(jp1,BorderLayout.NORTH);		
		
		jp2.add(jb2);
		add(jp2,BorderLayout.SOUTH);
		
		jb1.addActionListener(new ActionListener() {//��ӡ��Ϣ�嵥
			public void actionPerformed(ActionEvent e){
				{
					Object name1[]= {"�����˺�","����","����","����","����","�������"};
					HistoryDao hdao=new HistoryDao();
					History history=hdao.queryHistoryByTime(id);
					if(history.getId()!=null&&history.getName()!=null)
					{
						List<Object[]> b=new ArrayList<>();
						Object[] a={history.getId(),history.getName(),history.getDate(),history.getRate(),history.getNum(),history.getNum()*history.getRate()};
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
						JOptionPane.showMessageDialog(null, "δ��ѯ���ô������ȡ���¼��");
						new bank_system();
						setVisible(false);
					}
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
}