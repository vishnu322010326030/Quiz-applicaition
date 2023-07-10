package second;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//why questions in the database printing one on it
public class userque1 extends JFrame implements ActionListener{
	JButton start;
	JLabel heading;
	JLabel heading2;
	JButton next;
	JButton submit_survey;
	JLabel que;
	JLabel op1;
	JLabel answ;
	
	JButton submit;
	JLabel qu1;
	JLabel qu2;
	JLabel qu3;
	JLabel qu4;
	JTextField answe;
	JLabel op2;
	JLabel op3;
	JLabel op4;
	JLabel quest;
	JPanel questionPanel;
	String res6 = null;
	String te = null;
	int i=0;
	public userque1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		next = new JButton("Next");
		qu1 = new JLabel("1.");
		qu2 = new JLabel("2.");
		qu3 = new JLabel("3.");
		qu4 = new JLabel("4.");
		answ = new JLabel("Type option here");
		submit = new JButton("submit");
		submit.setBounds(400,350,150,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.white);
		answe = new JTextField();
		answ.setForeground(Color.blue);
		answ.setBounds(100,370,80,30);
		answe.setBounds(190,370,80,30);
		qu1.setBounds(80,150,80,30);
		qu2.setBounds(80, 200, 80, 30);
		qu3.setBounds(80, 250, 80, 30);
		qu4.setBounds(80, 300, 80, 30);
		heading = new JLabel("ONLINE SURVEY");
		heading2 = new JLabel("Click on next to start the survey");
		quest = new JLabel("Question :");
		quest.setBounds(100, 20, 300, 80);
		quest.setForeground(Color.red);
		heading2.setBounds(150,50,300,100);
		heading2.setFont(new Font("Courier",Font.BOLD,15));
		heading.setFont(new Font("Courier",Font.BOLD,20));
		heading.setBounds(200,20,300,40);
		heading.setForeground(Color.red);
		submit_survey = new JButton("submit survey");		
		next.setBounds(400,300,150,30);
		submit_survey.setBounds(400,450,150,30);
    	submit_survey.addActionListener(this);
    	next.addActionListener(this);
    	submit.addActionListener(this);
		questionPanel = new JPanel(); // Initialize the panel
        questionPanel.setLayout(null); // Use null layout for precise positioning
        questionPanel.setBounds(0, 0, 600, 600);
        add(questionPanel);
		add(next);
		
		questionPanel.add(heading);
		questionPanel.add(heading2);
		
		setLayout(null);  
		setSize(600,500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		userque1 u=new userque1();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    
		
		if(e.getSource() == next) {
			i++;
			
			String mysqlUrl = "jdbc:mysql://localhost:3306/project";
			// step2
			Connection con;
			try {
				
				con = DriverManager.getConnection(mysqlUrl, "root", "vishnu");
				java.sql.Statement stmt;
			    stmt = con.createStatement();
				String query = "select count(*) from question";
			    //Executing the query
				
			    ResultSet rs = stmt.executeQuery(query);
			    //Retrieving the result
			    rs.next();
			    int count = rs.getInt(1);
			    //System.out.println(count);
			    String answer = "select solution from question where qno='"+i+"' ";
			    ResultSet rs6 = stmt.executeQuery(answer);
			    rs6.next();
			    res6 = rs6.getString(1);
			    te = answe.getText().toString();
			    
				String query1 = "select Question from question where qno='"+i+"' ";
				ResultSet rs1 = stmt.executeQuery(query1);
				rs1.next();
				    String res = rs1.getString(1);
				    que = new JLabel();
				    que.setText(res);
			        que.setVisible(true);
			        que.setBounds(100, 50, 300, 80);
			        questionPanel.add(que);
					
					//op1
					String query2 = "select op1 from question where qno='"+i+"' ";
					ResultSet rs2 = stmt.executeQuery(query2);
				    rs2.next();
				    String res2 = rs2.getString(1);
				    op1 = new JLabel();
				    op1.setText(res2);
				    op1.setVisible(true);
				    op1.setBounds(100,150,80,30);
				    questionPanel.add(op1);
					
					//op2
					String query3 = "select op2 from question where qno='"+i+"' ";
					ResultSet rs3 = stmt.executeQuery(query3);
				    rs3.next();
				    String res3 = rs3.getString(1);
				    op2 = new JLabel();
				    op2.setText(res3);
				    op2.setVisible(true);
				    op2.setBounds(100,200,80,30);
				    questionPanel.add(op2);
					
					//op3
					String query4 = "select op3 from question where qno='"+i+"' ";
					ResultSet rs4 = stmt.executeQuery(query4);
				    rs4.next();
				    String res4 = rs4.getString(1);
				    op3 = new JLabel();
				    op3.setText(res4);
				    op3.setVisible(true);
				    op3.setBounds(100,250,80,30);
				    questionPanel.add(op3);
					
					//op4
					String query5 = "select op4 from question where qno='"+i+"' ";
					ResultSet rs5 = stmt.executeQuery(query5);
				    rs5.next();
				    String res5 = rs5.getString(1);
				    op4 = new JLabel();
				    op4.setText(res5);
				    op4.setVisible(true);
				    op4.setBounds(100,300,80,30);
				    questionPanel.add(op4);
					
				    questionPanel.removeAll();
	                // Add the new labels to the panel
	                questionPanel.add(que);
	                questionPanel.add(op1);
	                questionPanel.add(op2);
	                questionPanel.add(op3);
	                questionPanel.add(op4);
	                questionPanel.add(quest);
	                questionPanel.add(qu1);
	                questionPanel.add(qu2);
	                questionPanel.add(qu3);
	                questionPanel.add(qu4);
	                
	                questionPanel.add(answ);
	                questionPanel.add(answe);
	                questionPanel.add(submit);
	                
	                // Repaint the panel to reflect the changes
	                questionPanel.repaint();
	                
	                
	                
	                
	                if(i == count) {
	                	questionPanel.add(submit_survey);
	                	JOptionPane.showMessageDialog(userque1.this,
            	                "Please click submit survey.",
            	                "This is the last question",
            	                JOptionPane.INFORMATION_MESSAGE);
	                }
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
		}
		
		if(e.getSource() == submit_survey) {
        	JOptionPane.showMessageDialog(userque1.this,
	                "Your Survey is successfully recorded",
	                "All the Best",
	                JOptionPane.INFORMATION_MESSAGE);
        }
		if(e.getSource() == submit) {
			if(res6 == te) {
				JOptionPane.showMessageDialog(userque1.this,
			            "Correct answer",
			            "Congralutations",
			            JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(userque1.this,
			            "The Correct answer is option" + res6,
			            "Incorrect answer",
			            JOptionPane.INFORMATION_MESSAGE);
			}
		}
		setLayout(null);  
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}







