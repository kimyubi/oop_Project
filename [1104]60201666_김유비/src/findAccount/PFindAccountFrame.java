package findAccount;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EPFindAccountFrame;
import main.Main.ActionHandler;

public class PFindAccountFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public PFindAccountFrame(ActionHandler actionHandler) {
		this.setSize(EPFindAccountFrame.width.getInt(), EPFindAccountFrame.height.getInt());
		this.setTitle(EPFindAccountFrame.titleText.getText());
		this.setLocationRelativeTo(null);
		this.setContentPane(new PFindAccountPanel(actionHandler));
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
	}
	
	
	public void initailize() {
		setVisible(true);
	}
	
	public Container getPFindAccountPanel() {
		return this.getContentPane();
	}
}
