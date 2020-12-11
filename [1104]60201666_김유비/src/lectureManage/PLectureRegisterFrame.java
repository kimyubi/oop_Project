package lectureManage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import constants.Constants.EPLectureRegisterFrame;
import constants.Constants.EPLectureRegisterPanel;
import control.CEnrollment;
import lectureManage.PLectureManagePanel.LectureRegisterHandler;
import valueObject.VLecture;

public class PLectureRegisterFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private PLectureRegisterPanel pLectureRegisterPanel; 
	private CEnrollment cEnrollment = new CEnrollment();
	
	public PLectureRegisterFrame() {
		
		this.setSize(EPLectureRegisterFrame.width.getInt(), EPLectureRegisterFrame.height.getInt());
		this.setTitle(EPLectureRegisterFrame.titleText.getText());
		this.setLocationRelativeTo(null);
		this.pLectureRegisterPanel = new PLectureRegisterPanel(new BtnHandler());
		this.setContentPane(pLectureRegisterPanel);
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
	}
	
	public void initailize() {
		setVisible(true);
		this.pLectureRegisterPanel.initialize();
	}

	
	public Container getPenrollmentDefaultPanel() {
		return this.getContentPane();
	}
	
	public class BtnHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand() == EPLectureRegisterPanel.registerBtn.getText()) {
				VLecture vLecture = pLectureRegisterPanel.getLecture();
				if(vLecture.getCode().isEmpty() || vLecture.getLectureName().isEmpty() || vLecture.getCredit().isEmpty() || vLecture.getPersonnel().isEmpty() || vLecture.getProfessor().isEmpty() || vLecture.getTime().isEmpty() ) {
					JOptionPane.showConfirmDialog(null,"입력하지 않은 필드가 있는지 확인해주세요.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					return;
				}
				// 과목 코드 중복 확인
				if(cEnrollment.existByCode(vLecture.getCode())) {
					JOptionPane.showConfirmDialog(null,"이미 사용중인 과목코드입니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(Integer.parseInt(vLecture.getCredit()) < 1) {
					JOptionPane.showConfirmDialog(null,"학점은 1학점 이상으로 입력해주세요.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(cEnrollment.registerLecture(vLecture) == 1) {
						JOptionPane.showConfirmDialog(null,vLecture.getCode()+"번 강의가 성공적으로 등록 되었습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
						setVisible(false);
				}
			}
			
			else {
				setVisible(false);
			}
				
		}
	}

}
