package plan;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants.EPplanDetailPanel;
import main.Main.ActionHandler;
import valueObject.VPlan;

public class PplanDetailPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel planTitle;
	private JLabel nameLabel;
	private JLabel name;
	private JLabel codeLabel;
	private JLabel code;
	private JLabel timeLabel;
	private JLabel time;
	private JLabel personnelLabel;
	private JLabel personnel;
	private JLabel bookLabel;
	private JLabel book;
	private JLabel creditLabel;
	private JLabel credit;
	private JLabel emailLabel;
	private JLabel email;
	private JLabel goalLabel;
	private JLabel goal;
	
	private JLabel weekTitle;
	private JLabel week1Label;
	private JLabel week2Label;
	private JLabel week3Label;
	private JLabel week4Label;
	private JLabel week5Label;
	private JLabel week6Label;
	private JLabel week7Label;
	private JLabel week8Label;
	private JLabel week9Label;
	private JLabel week10Label;
	private JLabel week11Label;
	private JLabel week12Label;
	private JLabel week13Label;
	private JLabel week14Label;
	private JLabel week15Label;
	private JLabel week16Label;
	
	private JLabel week1;
	private JLabel week2;
	private JLabel week3;
	private JLabel week4;
	private JLabel week5;
	private JLabel week6;
	private JLabel week7;
	private JLabel week8;
	private JLabel week9;
	private JLabel week10;
	private JLabel week11;
	private JLabel week12;
	private JLabel week13;
	private JLabel week14;
	private JLabel week15;
	private JLabel week16;
	

	public PplanDetailPanel() {
		this.setLayout(null);
		this.setBackground(new Color(6,84,113));
		
		this.planTitle = new JLabel(EPplanDetailPanel.planTitle.getText());
		this.planTitle .setFont(new Font("±¼¸²", Font.BOLD, 18));
		this.planTitle .setBounds(27, 15, 130, 37);
		this.add(this.planTitle);
		
		this.nameLabel = new JLabel(EPplanDetailPanel.nameLabel.getText());
		this.nameLabel.setBounds(27, 55, 78, 22);
		this.add(this.nameLabel);
		
		this.name = new JLabel();
		this.name.setBounds(99, 55, 195, 27);
		this.add(this.name);
		
		this.codeLabel = new JLabel(EPplanDetailPanel.codeLabel.getText());
		this.codeLabel.setBounds(27, 75, 78, 22);
		this.add(this.codeLabel);
		
		this.code = new JLabel();
		this.code.setBounds(99, 75, 58, 27);
		this.add(this.code);
		
		this.timeLabel = new JLabel(EPplanDetailPanel.timeLabel.getText());
		this.timeLabel.setBounds(27, 95, 78, 22);
		this.add(this.timeLabel);
		
		this.time = new JLabel();
		this.time.setBounds(99, 95, 195, 27);
		this.add(this.time);
		
		this.personnelLabel = new JLabel(EPplanDetailPanel.personnelLabel.getText());
		this.personnelLabel.setBounds(27, 115, 78, 22);
		this.add(this.personnelLabel);
		
		this.personnel = new JLabel();
		this.personnel.setBounds(99, 115, 58, 27);
		this.add(this.personnel);
		
		this.bookLabel = new JLabel(EPplanDetailPanel.bookLabel.getText());
		this.bookLabel.setBounds(27, 135, 111, 22);
		this.add(this.bookLabel);
		
		this.book = new JLabel();
		this.book.setBounds(138, 133, 384, 27);
		this.add(this.book);
		
		this.goalLabel = new JLabel(EPplanDetailPanel.goalLabel.getText());
		this.goalLabel.setBounds(27, 155, 78, 22);
		this.add(this.goalLabel);
		
		this.goal = new JLabel();
		this.goal.setBounds(88, 155, 558, 27);
		this.add(this.goal); 
		
		this.creditLabel = new JLabel(EPplanDetailPanel.creditLabel.getText());
		this.creditLabel.setBounds(396, 55, 41, 22);
		this.add(this.creditLabel);
		
		this.credit = new JLabel();
		this.credit.setBounds(441, 55, 58, 27);
		this.add(this.credit);
		
		this.emailLabel = new JLabel(EPplanDetailPanel.emailLabel.getText());
		this.emailLabel.setBounds(396, 75, 58, 22);
		this.add(this.emailLabel);
		
		this.email = new JLabel();
		this.email.setBounds(451, 75, 195, 27);
		this.add(this.email);
		
		this.weekTitle = new JLabel(EPplanDetailPanel.weekTitle.getText());
		this.weekTitle.setFont(new Font("±¼¸²", Font.BOLD, 18));
		this.weekTitle.setBounds(27, 190, 130, 37);
		this.add(this.weekTitle);
		
		this.week1Label = new JLabel(EPplanDetailPanel.week1Label.getText());
		this.week1Label.setBounds(27, 220, 78, 22);
		this.add(this.week1Label);
		
		this.week2Label = new JLabel(EPplanDetailPanel.week2Label.getText());
		this.week2Label.setBounds(27, 245, 78, 22);
		this.add(this.week2Label);
		
		this.week3Label = new JLabel(EPplanDetailPanel.week3Label.getText());
		this.week3Label .setBounds(27, 270, 78, 22);
		this.add(this.week3Label);
		
		this.week4Label = new JLabel(EPplanDetailPanel.week4Label.getText());
		this.week4Label.setBounds(27, 295, 78, 22);
		this.add(this.week4Label);
		
		this.week5Label = new JLabel(EPplanDetailPanel.week5Label.getText());
		this.week5Label.setBounds(27, 320, 78, 22);
		this.add(this.week5Label);
		
		this.week6Label = new JLabel(EPplanDetailPanel.week6Label.getText());
		this.week6Label.setBounds(27, 345, 78, 22);
		this.add(this.week6Label);
		
		this.week7Label = new JLabel(EPplanDetailPanel.week7Label.getText());
		this.week7Label.setBounds(27, 370, 78, 22);
		this.add(this.week7Label);
		
		this.week8Label = new JLabel(EPplanDetailPanel.week8Label.getText());
		week8Label.setBounds(27, 395, 78, 22);
		this.add(this.week8Label);
		
		this.week9Label = new JLabel(EPplanDetailPanel.week9Label.getText());
		this.week9Label.setBounds(27, 420, 78, 22);
		this.add(this.week9Label);
		
		this.week10Label = new JLabel(EPplanDetailPanel.week10Label.getText());
		this.week10Label.setBounds(27, 445, 78, 22);
		this.add(this.week10Label);
		
		this.week11Label = new JLabel(EPplanDetailPanel.week11Label.getText());
		this.week11Label.setBounds(27, 470, 78, 22);
		this.add(this.week11Label);
		
		this.week12Label = new JLabel(EPplanDetailPanel.week12Label.getText());
		this.week12Label.setBounds(27, 495, 78, 22);
		this.add(this.week12Label);
		
		this.week13Label = new JLabel(EPplanDetailPanel.week13Label.getText());
		week13Label.setBounds(27, 520, 78, 22);
		this.add(this.week13Label);
		
		this.week14Label = new JLabel(EPplanDetailPanel.week14Label.getText());
		this.week14Label.setBounds(27, 545, 78, 22);
		this.add(this.week14Label);
		
		this.week15Label = new JLabel(EPplanDetailPanel.week15Label.getText());
		this.week15Label.setBounds(27, 570, 78, 22);
		this.add(this.week15Label);
		
		this.week16Label = new JLabel(EPplanDetailPanel.week16Label.getText());
		this.week16Label.setBounds(27, 595, 78, 22);
		this.add(this.week16Label);
		
		this.week1 = new JLabel();
		this.week1.setBounds(82, 220, 616, 22);
		this.add(this.week1);
		
		this.week2 = new JLabel();
		this.week2.setBounds(82, 245, 616, 22);
		this.add(this.week2);
		
		this.week3 = new JLabel();
		this.week3 .setBounds(82, 270, 616, 22);
		this.add(this.week3);
		
		this.week4 = new JLabel();
		this.week4.setBounds(82, 295, 616, 22);
		this.add(this.week4);
		
		this.week5 = new JLabel();
		this.week5.setBounds(82, 320, 616, 22);
		this.add(this.week5);
		
		this.week6 = new JLabel();
		week6.setBounds(82, 345, 616, 22);
		this.add(week6);
		
		this.week7 = new JLabel();
		this.week7.setBounds(82, 370, 616, 22);
		this.add(this.week7);
		
		this.week8 = new JLabel();
		this.week8 .setBounds(82, 395, 616, 22);
		this.add(this.week8);
		
		this.week9 = new JLabel();
		this.week9.setBounds(82, 420, 616, 22);
		this.add(this.week9);
		
		this.week10 = new JLabel();
		this.week10.setBounds(82, 445, 616, 22);
		this.add(this.week10);
		
		this.week11 = new JLabel();
		this.week11.setBounds(82, 470, 616, 22);
		this.add(this.week11);
		
		this.week12 = new JLabel();
		this.week12.setBounds(82, 495, 616, 22);
		this.add(this.week12);
		
		this.week13 = new JLabel();
		this.week13.setBounds(82, 520, 616, 22);
		this.add(this.week13);
		
		this.week14 = new JLabel();
		this.week14.setBounds(82, 545, 616, 22);
		this.add(this.week14);
		
		this.week15 = new JLabel();
		this.week15.setBounds(82, 570, 616, 22);
		this.add(this.week15);
		
		this.week16 = new JLabel();
		this.week16.setBounds(82, 595, 616, 22);
		this.add(this.week16);
	
	}
	public void initialize(VPlan vPlan) {
		this.name.setText(vPlan.getLectureName());
		this.code.setText(vPlan.getCode());
		this.time.setText(vPlan.getTime());
		this.personnel.setText(vPlan.getPersonnel());
		this.book.setText(vPlan.getBook());
		this.goal.setText(vPlan.getGoal());
		this.email.setText(vPlan.getEmail());
		this.credit.setText(vPlan.getCredit());
		
		this.week1.setText(vPlan.getWeek1());
		this.week2.setText(vPlan.getWeek2());
		this.week3.setText(vPlan.getWeek3());
		this.week4.setText(vPlan.getWeek4());
		this.week5.setText(vPlan.getWeek5());
		this.week6.setText(vPlan.getWeek6());
		this.week7.setText(vPlan.getWeek7());
		this.week8.setText(vPlan.getWeek8());
		this.week9.setText(vPlan.getWeek9());
		this.week10.setText(vPlan.getWeek10());
		this.week11.setText(vPlan.getWeek11());
		this.week12.setText(vPlan.getWeek12());
		this.week13.setText(vPlan.getWeek13());
		this.week14.setText(vPlan.getWeek14());
		this.week15.setText(vPlan.getWeek15());
		this.week16.setText(vPlan.getWeek16());
	}
	

	


}
