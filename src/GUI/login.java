package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Dao.AdminDao;
import Entity.Administrator;

public class login extends JFrame {
	JLabel l1=new JLabel("����Ա�˺�");
	JLabel l2=new JLabel("����Ա����");
	static JTextField t1=new JTextField(18);
	static JTextField pw=new JPasswordField(18);
	JButton jb1=new JButton("��¼");		//ȷ�ϰ�ť
	JButton jb2=new JButton("ȡ��");		//ȡ����ť

	public login() {
		setTitle("���д���ϵͳ");
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		add(l2);
		add(pw);
		
		add(jb1);
		jb1.addActionListener(new ActionListener() {	//��¼
			public void actionPerformed(ActionEvent e){
				AdminDao adao=new AdminDao();
				Administrator admin=new Administrator();
				
				if(!t1.getText().trim().equals("")&&!pw.getText().trim().equals(""))	//�û���������ǿ�
				{
					admin=adao.queryAccountById(t1.getText());
					if(admin!=null)		//��ѯ����ع���Ա�˻�
					{
						if(t1.getText().equals(admin.getAdmin_id())==true&&pw.getText().equals(admin.getAdmin_password())==true) {		//��֤����Ա�˺� ������
							JOptionPane.showMessageDialog(null, "��ӭ����"+ admin.getAdmin_name() +" ��¼");		//������ʾ ��½�ɹ�
							new bank_system();	//����˵�
							setVisible(false);
						}
						
						else
						{
							JOptionPane.showMessageDialog(null, "�˺Ż�����������飡");
							t1.setText(null);
							pw.setText(null);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "δ��ѯ����ع���Ա�����飡");
						new login();
						setVisible(false);
					}
				}
				
				else if(t1.getText().trim().equals(""))		//�˺�Ϊ��
				{
					JOptionPane.showMessageDialog(null, "�������˺ţ�");
					new login();
					setVisible(false);
				}
				
				else if(pw.getText().trim().equals(""))		//����Ϊ��
				{
					JOptionPane.showMessageDialog(null, "���������룡");
					new login();
					setVisible(false);
				}
			}
		});
		
		add(jb2);
		jb2.addActionListener(new ActionListener() {	//ȡ��
			public void actionPerformed(ActionEvent e){
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});
		
		setBounds(300,300,300,150);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		login application=new login();
	}
}
