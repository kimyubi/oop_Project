package loginedIndex;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants.EPIndexBtnPanel;
import main.Main.ActionHandler;

public class PLoginedIndexBtnPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton enrollBtn;
	private JButton myInfoBtn;
	private JButton logoutBtn;
	private JButton planBtn;
	
	public PLoginedIndexBtnPanel(ActionHandler actionHandler) {
		this.setBackground(new Color(6,84,113));
		
		this.enrollBtn = new JButton(EPIndexBtnPanel.enrollment.getText());
		this.enrollBtn.setBackground(new Color(252,192,69));
		this.enrollBtn.setForeground(new Color(6,84,113));
		this.enrollBtn.addActionListener(actionHandler);
		this.add(enrollBtn);
		
		this.myInfoBtn = new JButton(EPIndexBtnPanel.myinfo.getText());
		this.myInfoBtn.setBackground(new Color(245,245,245));
		this.myInfoBtn.setForeground(new Color(6,84,113));
		this.myInfoBtn.addActionListener(actionHandler);
		this.add(myInfoBtn);
			
		this.planBtn = new JButton(EPIndexBtnPanel.plan.getText());
		this.planBtn.setBackground(new Color(252,192,69));
		this.planBtn.setForeground(new Color(6,84,113));
		this.planBtn.addActionListener(actionHandler);
		this.add(planBtn);
		
		this.logoutBtn = new JButton(EPIndexBtnPanel.logout.getText());
		this.logoutBtn.setBackground(new Color(245,245,245));
		this.logoutBtn.setForeground(new Color(6,84,113));
		this.logoutBtn.addActionListener(actionHandler);
		this.add(logoutBtn);
	}
	
	

}
