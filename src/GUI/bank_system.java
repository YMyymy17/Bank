package GUI;

import java.awt.event.*;
import javax.swing.*;

public class bank_system extends JFrame{
	JButton jb1=new JButton("��ѯ");
	JButton jb2=new JButton("���");
	JButton jb3=new JButton("ȡ��");
	JButton jb4=new JButton("�˵�");
	JButton jb5=new JButton("ע��");
	public bank_system(){
		setTitle("���д���ϵͳ�˵�");
		setLayout(null);
		add(jb1);
		jb1.setBounds(100, 80, 100, 30);
		jb1.addActionListener(new ActionListener() {//��ѯ
			public void actionPerformed(ActionEvent e){
					new search();
					setVisible(false);
					}
			});
		
		add(jb2);
		jb2.setBounds(200, 80, 100, 30);
		jb2.addActionListener(new ActionListener() {//���
			public void actionPerformed(ActionEvent e){
				new deposit();
				setVisible(false);
				}
			});
		
		add(jb3);
		jb3.setBounds(300, 80, 100, 30);
		jb3.addActionListener(new ActionListener() {//ȡ��
			public void actionPerformed(ActionEvent e){
				new draw();
				setVisible(false);
			}
		});
		
		add(jb4);
		jb4.setBounds(400, 80, 100, 30);
		jb4.addActionListener(new ActionListener() {//�˵�
			public void actionPerformed(ActionEvent e){
				new history();
				setVisible(false);
			}
		});
		
		add(jb5);
		jb5.setBounds(500, 80, 100, 30);
		jb5.addActionListener(new ActionListener() {//ע��
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "�û��ѳɹ��˳�ϵͳ��");
				new login();
				setVisible(false);
			}
		});
		
		setBounds(300,300,740,200);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
		public static void main(String[] args) {
			bank_system application=new bank_system();
		}
	}