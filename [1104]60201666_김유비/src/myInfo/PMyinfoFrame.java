package myInfo;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EPMyinfo;
import main.Main.ActionHandler;
import valueObject.VUser;

public class PMyinfoFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private VUser currentUser;
	private PMyinfoPanel pMyinfoPanel;
	
	public PMyinfoFrame(ActionHandler actionHandler) {
		this.setSize(EPMyinfo.width.getInt(), EPMyinfo.height.getInt());
		this.setTitle(EPMyinfo.titleText.getText());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pMyinfoPanel = new PMyinfoPanel(actionHandler);
		this.setContentPane(pMyinfoPanel);
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
	}
	
	
	public void initailize(VUser currentUser) {
		setVisible(true);
		this.currentUser = currentUser;
		this.pMyinfoPanel.initailize(currentUser);
	}
	
	public Container PMyinfoPanel() {
		return this.getContentPane();
	}
}
