package adminIndex;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants.EPAdminIndexBtnPanel;
import main.Main.ActionHandler;

public class PAdminIndexBtnPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton lectureManageBtn;
	private JButton accountManageBtn;
	private JButton logoutBtn;
	
	public PAdminIndexBtnPanel(ActionHandler actionHandler) {
		this.setBackground(new Color(6,84,113));
		
		this.lectureManageBtn = new JButton(EPAdminIndexBtnPanel.lectureManageBtn.getText());
		this.lectureManageBtn.setBackground(new Color(252,192,69));
		this.lectureManageBtn.setForeground(new Color(6,84,113));
		this.lectureManageBtn.addActionListener(actionHandler);
		this.add(lectureManageBtn);
		
		this.accountManageBtn = new JButton(EPAdminIndexBtnPanel.accountManageBtn.getText());
		this.accountManageBtn.setBackground(new Color(245,245,245));
		this.accountManageBtn.setForeground(new Color(6,84,113));
		this.accountManageBtn.addActionListener(actionHandler);
		this.add(accountManageBtn);
			
		this.logoutBtn = new JButton(EPAdminIndexBtnPanel.logoutBtn.getText());
		this.logoutBtn.setBackground(new Color(252,192,69));
		this.logoutBtn.setForeground(new Color(6,84,113));
		this.logoutBtn.addActionListener(actionHandler);
		this.add(logoutBtn);

	}
	
	

}
