package index;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EIndexFrame;
import main.Main.ActionHandler;

public class PIndexFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//components
	private PIndexPanel pIndexPanel;
	
	public PIndexFrame(ActionHandler actionHandler) {
		//attributes
		this.setSize(EIndexFrame.width.getInt(), EIndexFrame.height.getInt());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle(EIndexFrame.title.getText());
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
		
		//components
		this.pIndexPanel = new PIndexPanel(actionHandler);
		this.add(this.pIndexPanel, BorderLayout.CENTER);
	}
	
	
	public void initailize() {
		this.setVisible(true);
	}
	

}
