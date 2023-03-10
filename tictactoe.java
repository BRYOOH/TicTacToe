import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class tictactoe implements ActionListener{
	
	JFrame frame= new JFrame();
	JPanel panel= new JPanel();
	JPanel titlePanel= new JPanel();
	JLabel label= new JLabel();
	JButton [] buttons= new JButton[9];
	Random random= new Random(2);
	boolean player1_turn;
	
	
	
	tictactoe(){
		
		frame.setSize(800,800);
		frame.setTitle("tic-tac-toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
//		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setVisible(true);
		
		titlePanel.setBounds(0,0,800,100);
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBackground(new Color(0,0,0));
		titlePanel.setFocusable(false);
		
		label.setFont(new Font("InkFree", Font.BOLD,75));
		label.setText("tic-tac-toe");
		label.setBackground(new Color(25,25,25));
		label.setForeground(new Color(25,255,0));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);
		
		panel.setLayout(new GridLayout(3,3));
		panel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			buttons[i]=new JButton();
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,75));
			panel.add(buttons[i]);
		}
		
		titlePanel.add(label);
		frame.add(panel);
		frame.add(titlePanel, BorderLayout.NORTH);
		
		firstTurn();
        
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++) {
		if(e.getSource()==buttons[i]) {
			if(	player1_turn) {
				if(buttons[i].getText()==""){
					buttons[i].setText("O");
					buttons[i].setFont(new Font("MV Boli",Font.BOLD,75));
					buttons[i].setForeground(new Color(0,0,255));
					label.setText("X,s turn");
					player1_turn=false;
					check();
					}
			}else {
					if(buttons[i].getText()==""){
						buttons[i].setText("X");
						buttons[i].setFont(new Font("MV Boli",Font.BOLD,75));
						buttons[i].setForeground(new Color(0,0,255));
						label.setText("0,s turn");
						player1_turn=true;
						check();
				}
			
			}
		}
		} 
	}
	
	


public void firstTurn() {
	

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 if(random.nextInt(2)==0) {
			player1_turn=false;
			label.setText("X's turn");
		}else {
			player1_turn=true;
			label.setText("O's turns");
		}
		
	}
	
	public void check(){
	//checks winning combinations for X
		if(buttons[0].getText()=="X" &&
		   buttons[1].getText()=="X" &&
		   buttons[2].getText()=="X") {
			xWins(0,1,2);
			}
		
		if(buttons[3].getText()=="X" &&
		   buttons[4].getText()=="X" &&
	       buttons[5].getText()=="X"){
			xWins(3,4,5);
		}
		
		if(buttons[6].getText()=="X" &&
		   buttons[7].getText()=="X" &&
           buttons[8].getText()=="X"){
					xWins(6,7,8);
				}
				
		if(buttons[0].getText()=="X" &&
		   buttons[4].getText()=="X" &&
		   buttons[8].getText()=="X"){
					xWins(0,4,8);
				}
				
		if(buttons[2].getText()=="X" &&
		   buttons[4].getText()=="X" &&
		   buttons[6].getText()=="X"){
			xWins(2,4,6);
				}
				
		if(buttons[0].getText()=="X" &&
		   buttons[3].getText()=="X" &&
		   buttons[6].getText()=="X"){
					xWins(0,3,6);
				}
				
		if(buttons[1].getText()=="X" &&
		  buttons[4].getText()=="X" &&
		  buttons[7].getText()=="X"){
					xWins(1,4,7);
				}
				
		if(buttons[2].getText()=="X" &&
		   buttons[5].getText()=="X" &&
		   buttons[8].getText()=="X"){
					xWins(2,5,8);
				}
				
		//checks the combination if O's
		
		if(buttons[0].getText()=="O" &&
				   buttons[1].getText()=="O" &&
				   buttons[2].getText()=="O") {
					oWins(0,1,2);
					}
				
				if(buttons[3].getText()=="O" &&
				   buttons[4].getText()=="O" &&
			       buttons[5].getText()=="O"){
					oWins(3,4,5);
				}
				
				if(buttons[6].getText()=="O" &&
				   buttons[7].getText()=="O" &&
		           buttons[8].getText()=="O"){
							oWins(6,7,8);
						}
						
				if(buttons[0].getText()=="O" &&
				   buttons[4].getText()=="O" &&
				   buttons[8].getText()=="O"){
							oWins(0,4,8);
						}
						
				if(buttons[2].getText()=="O" &&
				   buttons[4].getText()=="O" &&
				   buttons[6].getText()=="O"){
					oWins(2,4,6);
						}
						
				if(buttons[0].getText()=="O" &&
				   buttons[3].getText()=="O" &&
				   buttons[6].getText()=="O"){
							oWins(0,3,6);
						}
						
				if(buttons[1].getText()=="O" &&
				  buttons[4].getText()=="O" &&
				  buttons[7].getText()=="O"){
							oWins(1,4,7);
						}
						
				if(buttons[2].getText()=="O" &&
				   buttons[5].getText()=="O" &&
				   buttons[8].getText()=="O"){
							oWins(2,5,8);
						}
				
	}
	
	public void xWins(int a,int b,int c){
		//passes the winning combinations for X
		buttons[a].setBackground(new Color(0,255,0));
		buttons[b].setBackground(new Color(0,255,0));
		buttons[c].setBackground(new Color(0,255,0));
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
			label.setText("X WINS");
		}
        
	}
	public void oWins(int a,int b,int c){
		buttons[a].setBackground(new Color(0,255,0));
		buttons[b].setBackground(new Color(0,255,0));
		buttons[c].setBackground(new Color(0,255,0));
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
			label.setText("O WINS");
		}
		
	}

}
