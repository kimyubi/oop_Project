package adminIndex;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EPAdminIndexFrame;
import main.Main.ActionHandler;
import valueObject.VUser;

public class PAdminIndexFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//components
	private PAdminIndexPanel pAdminIndexPanel;
	private VUser vUser;
	
	public PAdminIndexFrame(ActionHandler actionHandler) {
		
		//attributes
		this.setSize(EPAdminIndexFrame.width.getInt(), EPAdminIndexFrame.height.getInt());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle(EPAdminIndexFrame.titleText.getText());
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
		
		//components
		this.pAdminIndexPanel = new PAdminIndexPanel(actionHandler);
		this.add(this.pAdminIndexPanel, BorderLayout.CENTER);
	}
	
	
	public void initailize(VUser vUser) {
		this.setVisible(true);
		this.vUser = vUser;
	}
	

}
