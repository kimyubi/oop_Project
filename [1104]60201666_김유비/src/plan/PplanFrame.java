package plan;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EPplanFrame;
import main.Main.ActionHandler;
import service.loginService;
import valueObject.VUser;

public class PplanFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private PplanPanel pPlanPanel; 
	
	public PplanFrame(ActionHandler actionHandler) {
		
		this.setSize(EPplanFrame.width.getInt(), EPplanFrame.height.getInt());
		this.setTitle(EPplanFrame.titleText.getText());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pPlanPanel = new PplanPanel(actionHandler);
		this.setContentPane(pPlanPanel);
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
	}
	
	public void initailize(VUser currentUser) {
		setVisible(true);
		loginService loginService = new loginService();
		this.pPlanPanel.initialize(loginService.getUserWithMyInfo(currentUser));		
	}

	
	public Container getPenrollmentDefaultPanel() {
		return this.getContentPane();
	}

}
