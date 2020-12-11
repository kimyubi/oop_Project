package sugangSincheong;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants.EPHeaderPanel;
import main.Main.ActionHandler;
import valueObject.VUser;

public class PHeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel wecomeLabel;
	private JButton goToMain;
	
	public PHeaderPanel(ActionHandler actionHandler) {
		this.wecomeLabel = new JLabel();
		this.add(this.wecomeLabel);		
		
		this.goToMain = new JButton(EPHeaderPanel.goToMain.getText());
		this.goToMain.setBackground(new Color(252,192,69));
		this.goToMain.setForeground(new Color(6,84,113));
		this.goToMain.addActionListener(actionHandler);
		this.add(this.goToMain);
		
	}
	public void intialize(VUser vUser) {
		this.wecomeLabel.setText(vUser.getName()+"님 환영합니다. ");		
	}
}
