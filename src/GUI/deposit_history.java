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
	
	JButton jb1=new JButton("打印存款单");
	
	JButton jb2=new JButton("返回");
	
	JPanel jp1=new JPanel();	//上部分2个按钮
	JPanel jp2=new JPanel();	//下部按钮
	
	JTable table1;
	
	public deposit_history(String id) {
		setTitle("打印存款单");
		
		jp1.setLayout(new FlowLayout());
		jp1.add(jb1);
		
		add(jp1,BorderLayout.NORTH);		
		
		jp2.add(jb2);
		add(jp2,BorderLayout.SOUTH);
		
		jb1.addActionListener(new ActionListener() {//打印存款单
			public void actionPerformed(ActionEvent e){
				{
					Object name1[]= {"储户账号","姓名","住址","操作类型","日期","利率","数额"};
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
						JOptionPane.showMessageDialog(null, "未查询到该储户相关账单！");
						new bank_system();
						setVisible(false);
					}
				}
			}
			});
		
		jb2.addActionListener(new ActionListener() {
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
}