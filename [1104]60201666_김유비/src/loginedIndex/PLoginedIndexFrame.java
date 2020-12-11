package loginedIndex;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EIndexFrame;
import main.Main.ActionHandler;
import valueObject.VUser;

public class PLoginedIndexFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//components
	private PLoginedIndexPanel loginedIndexPanel;
	private VUser vUser;
	
	public PLoginedIndexFrame(ActionHandler actionHandler) {
		//attributes
		this.setSize(EIndexFrame.width.getInt(), EIndexFrame.height.getInt());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle(EIndexFrame.title.getText());
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
		
		//components
		this.loginedIndexPanel = new PLoginedIndexPanel(actionHandler);
		this.add(this.loginedIndexPanel, BorderLayout.CENTER);
	}
	
	
	public void initailize(VUser vUser) {
		this.setVisible(true);
		this.vUser = vUser;
	}
	

}
