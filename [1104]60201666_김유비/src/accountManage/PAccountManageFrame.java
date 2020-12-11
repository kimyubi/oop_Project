package accountManage;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EPAccountManageFrame;
import main.Main.ActionHandler;

public class PAccountManageFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private PAccountManagePanel pAccountManagePanel; 
	
	public PAccountManageFrame(ActionHandler actionHandler) {
		
		this.setSize(EPAccountManageFrame.width.getInt(), EPAccountManageFrame.height.getInt());
		this.setTitle(EPAccountManageFrame.titleText.getText());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pAccountManagePanel = new PAccountManagePanel(actionHandler);
		this.setContentPane(pAccountManagePanel);
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
	}
	
	public void initailize() {
		setVisible(true);	
		this.pAccountManagePanel.initialize();
	}

	
	public Container getPpAccountManagePanel() {
		return this.getContentPane();
	}

}
