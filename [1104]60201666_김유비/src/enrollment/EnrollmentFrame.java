package enrollment;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EenrollmanetFrame;
import main.Main.ActionHandler;
import service.loginService;
import valueObject.VUser;

public class EnrollmentFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private PenrollmentDefaultPanel penrollmentDefaultPanel; 
	
	public EnrollmentFrame(ActionHandler actionHandler) {
		
		this.setSize(EenrollmanetFrame.width.getInt(), EenrollmanetFrame.height.getInt());
		this.setTitle(EenrollmanetFrame.titleText.getText());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.penrollmentDefaultPanel = new PenrollmentDefaultPanel(actionHandler);
		this.setContentPane(penrollmentDefaultPanel);
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
	}
	
	public void initailize(VUser currentUser) {
		setVisible(true);
		loginService loginService = new loginService();
		this.penrollmentDefaultPanel.initialize(loginService.getUserWithMyInfo(currentUser));		
	}

	
	public Container getPenrollmentDefaultPanel() {
		return this.getContentPane();
	}

}
