package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import Dao.HistoryDao;
import Entity.History;

import GUI.bank_system;

public class deposit_history extends JFrame {
	
	JButton jb1=new JButton("��ӡ��");
	
	JButton jb2=new JButton("����");
	
	JPanel jp1=new JPanel();	//�ϲ���2����ť
	JPanel jp2=new JPanel();	//�²���ť
	
	JTable table1;
	
	public deposit_history(String id) {
		setTitle("��ӡ��");
		
		jp1.setLayout(new FlowLayout());
		jp1.add(jb1);
		
		add(jp1,BorderLayout.NORTH);		
		
		jp2.add(jb2);
		add(jp2,BorderLayout.SOUTH);
		
		jb1.addActionListener(new ActionListener() {//��ӡ��
			public void actionPerformed(ActionEvent e){
				{
					Object name1[]= {"�����˺�","����","סַ","��������","����","����","����"};
					HistoryDao hdao=new HistoryDao();
					History history=hdao.queryHistoryByTime(id);
					if(history!=null)
					{
						List<Object[]> b=new ArrayList<>();
						Object[] a={history.getId(),history.getName(),history.getHome(),history.getKind(),history.getDate(),history.getRate(),history.getNum()};
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
					if(history==null)
					{
						JOptionPane.showMessageDialog(null, "δ��ѯ���ô�������˵���");
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