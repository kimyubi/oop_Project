package signUp;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EPSignupPanel;
import main.Main.ActionHandler;

public class PsignUpFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public PsignUpFrame(ActionHandler actionHandler) {
		this.setSize(EPSignupPanel.width.getInt(), EPSignupPanel.height.getInt());
		this.setTitle(EPSignupPanel.titleText.getText());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new PSignupPanel(actionHandler));
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
	}
	
	
	public void initailize() {
		setVisible(true);
	}
	
	public Container getPSignupPanel() {
		return this.getContentPane();
	}

}
