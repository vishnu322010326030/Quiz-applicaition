package second;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Onee extends JFrame implements ActionListener{
	JButton btn_submit;
	JLabel labe;
	JButton login;
	JButton btn_exit;
	JTextField tf_username;
	JTextField tf_password;
	JLabel l_registration;
	JLabel l_username;
	JLabel l_password;
	public Onee(){
		setTitle("Registration");
		login = new JButton("Login");
		login.setBounds(330,200,100,30);
		login.setForeground(Color.white);
		login.setBackground(Color.black);
        labe = new JLabel("Note: Use numbers and special characters for a strong password");
		l_registration = new JLabel("REGISTRATION FROM");
		l_registration.setForeground(Color.red);
		labe.setBounds(50,280,400,40);
		labe.setForeground(Color.red);
		l_registration.setBounds(230,0,250,40);
		l_username = new JLabel("USERNAME");
		l_username.setBounds(120,100,80,30);
		tf_username = new JTextField();
		tf_username.setBounds(300,100,80,30);
		l_password = new JLabel("CREATE PASSWORD");
		l_password.setBounds(100,150,200,30);
		tf_password = new JTextField();
		tf_password.setBounds(300,150,80,30);
		btn_submit = new JButton("SUBMIT");
		btn_submit.setBounds(100,200,100,30);
		btn_submit.setForeground(Color.white);
		btn_submit.setBackground(Color.black);
		btn_submit.addActionListener(this);
		btn_exit = new JButton("EXIT");
		btn_exit.setBounds(225,200,80,30);
		btn_exit.setForeground(Color.white);
		btn_exit.setBackground(Color.black);
		btn_exit.addActionListener(this);
		login.addActionListener(this);
		add(btn_submit);
		add(btn_exit);
		add(tf_username);
		add(tf_password);
		add(l_username);
		add(l_password);
		add(labe);
		add(l_registration);
		add(login);
		setLayout(null);
		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
	} 
	@Override
	public void actionPerformed(ActionEvent e){
		String name= tf_username.getText().toString();
		if(e.getSource() == login) {
			new sec();
		}
		if(e.getSource() == btn_submit) {
			JOptionPane.showMessageDialog(Onee.this,
	                "Please login",
	                "Registration successful for "+name,
	                JOptionPane.INFORMATION_MESSAGE);
			
		}
		if(e.getSource() == btn_exit) {
			dispose();
		}
		
	}
}



