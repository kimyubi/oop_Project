package lectureManage;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.ELectureManageFrame;
import main.Main.ActionHandler;
import valueObject.VUser;

public class PLectureManageFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private PLectureManagePanel lectureManagePanel; 
	
	public PLectureManageFrame(ActionHandler actionHandler) {
		
		this.setSize(ELectureManageFrame.width.getInt(), ELectureManageFrame.height.getInt());
		this.setTitle(ELectureManageFrame.titleText.getText());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.lectureManagePanel = new PLectureManagePanel(actionHandler);
		this.setContentPane(lectureManagePanel);
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
	}
	
	public void initailize(VUser currentUser) {
		setVisible(true);
		this.lectureManagePanel.initialize();
	}

	
	public Container getPenrollmentDefaultPanel() {
		return this.getContentPane();
	}

}
