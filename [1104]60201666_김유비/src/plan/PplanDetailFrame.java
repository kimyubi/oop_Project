package plan;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EPplanDetailFrame;
import valueObject.VPlan;

public class PplanDetailFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private PplanDetailPanel pplanDetailPanel; 
	
	public PplanDetailFrame() {
		
		this.setSize(EPplanDetailFrame.width.getInt(), EPplanDetailFrame.height.getInt());
		this.setTitle(EPplanDetailFrame.titleText.getText());
		this.setLocationRelativeTo(null);
		this.pplanDetailPanel = new PplanDetailPanel();
		this.setContentPane(pplanDetailPanel);
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
	}
	
	public void initailize(VPlan vPlan) {
		setVisible(true);	
		this.pplanDetailPanel.initialize(vPlan);
	}

	
	public Container getPplanDetailPanel() {
		return this.getContentPane();
	}

}
