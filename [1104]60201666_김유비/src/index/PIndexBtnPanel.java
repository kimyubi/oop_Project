package index;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants.EPIndexBtnPanel;
import main.Main.ActionHandler;

public class PIndexBtnPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton loginBtn;
	private JButton signUpBtn;
	
	public PIndexBtnPanel(ActionHandler actionHandler) {
		this.setBackground(new Color(6,84,113));
		
		this.loginBtn = new JButton(EPIndexBtnPanel.login.getText());
		this.loginBtn.setBackground(new Color(252,192,69));
		this.loginBtn.setForeground(new Color(6,84,113));
		this.loginBtn.addActionListener(actionHandler);
		this.add(loginBtn);
		
		this.signUpBtn = new JButton(EPIndexBtnPanel.signUp.getText());
		this.signUpBtn.setBackground(new Color(245,245,245));
		this.signUpBtn.setForeground(new Color(6,84,113));
		this.signUpBtn.addActionListener(actionHandler);
		this.add(signUpBtn);
		
	
	}
	
	

}
