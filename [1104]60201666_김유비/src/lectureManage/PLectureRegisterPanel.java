package lectureManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.EPLectureRegisterPanel;
import control.CEnrollment;
import lectureManage.PLectureManagePanel.LectureRegisterHandler;
import lectureManage.PLectureRegisterFrame.BtnHandler;
import valueObject.VLecture;

public class PLectureRegisterPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel codeLabel;
	private JTextField code;
	private JLabel nameLabel;
	private JTextField name;
	private JLabel personnelLabel;
	private JTextField personnel;
	private JLabel creditLabel;
	private JTextField credit;
	private JLabel professorLabel;
	private JTextField professor;
	private JLabel timeLabel;
	private JTextField time;
	private JLabel campusLabel;
	private String[] campuses = {"ÀÎ¹®Ä·ÆÛ½º","ÀÚ¿¬Ä·ÆÛ½º"};
	private JComboBox comboBox;
	
	private JButton registerBtn;
	private JButton cancelBtn;
	
	
	
	
	public PLectureRegisterPanel(BtnHandler btnHandler){
		this.setLayout(null);
		this.setBackground(new Color(6,84,113));
		
		this.codeLabel = new JLabel(EPLectureRegisterPanel.codeLabel.getText());
		this.codeLabel.setBounds(47, 37, 52, 15);
		this.add(this.codeLabel);
		
		this.code = new JTextField();
		this.code.setBounds(125, 34, 106, 21);
		this.add(this.code);
		
		this.nameLabel = new JLabel(EPLectureRegisterPanel.nameLabel.getText());
		this.nameLabel.setBounds(47, 71, 52, 15);
		this.add(this.nameLabel);
		
		this.name = new JTextField();
		this.name.setBounds(125, 68, 159, 21);
		this.add(this.name);
		
		this.personnelLabel = new JLabel(EPLectureRegisterPanel.personnelLabel.getText());
		this.personnelLabel.setBounds(47, 101, 52, 15);
		this.add(this.personnelLabel);
		
		this.personnel = new JTextField();
		this.personnel.setBounds(125, 99, 106, 21);
		this.add(this.personnel);
		
		this.creditLabel = new JLabel(EPLectureRegisterPanel.creditLabel.getText());
		this.creditLabel.setBounds(47, 133, 52, 15);
		this.add(this.creditLabel);
		
		this.credit = new JTextField();
		this.credit.setBounds(125, 130, 106, 21);
		this.add(this.credit);
		
		this.professorLabel = new JLabel(EPLectureRegisterPanel.professorLabel.getText());
		this.professorLabel.setBounds(47, 164, 52, 15);
		this.add(this.professorLabel);
		
		this.professor = new JTextField();
		this.professor.setBounds(125, 161, 106, 21);
		this.add(this.professor);
		
		this.timeLabel = new JLabel(EPLectureRegisterPanel.timeLabel.getText());
		this.timeLabel.setBounds(47, 195, 52, 15);
		this.add(this.timeLabel);
		
		this.time = new JTextField();
		this.time.setBounds(125, 192, 159, 21);
		this.add(this.time);
		
		this.campusLabel = new JLabel(EPLectureRegisterPanel.campusLabel.getText());
		this.campusLabel.setBounds(47, 233, 52, 15);
		this.add(this.campusLabel);
		
		this.comboBox = new JComboBox(this.campuses);
		comboBox.setBounds(122, 229, 162, 23);
		this.add(comboBox);
		
		this.registerBtn = new JButton(EPLectureRegisterPanel.registerBtn.getText());
		this.registerBtn.setBounds(72, 313, 95, 28);
		this.registerBtn.setBackground(new Color(245,245,245));
		this.registerBtn.setForeground(new Color(6,84,113));
		this.registerBtn.addActionListener(btnHandler);
		this.add(this.registerBtn);
		
		this.cancelBtn = new JButton(EPLectureRegisterPanel.cancelBtn.getText());
		this.cancelBtn.setBounds(179, 313, 95, 28);
		this.cancelBtn.setBackground(new Color(245,245,245));
		this.cancelBtn.setForeground(new Color(6,84,113));
		this.cancelBtn.addActionListener(btnHandler);
		this.add(this.cancelBtn);
		
		
	
	}
	


	public void initialize() {
		
	}
	
//	public void resetTextField() {
//		this.code.setText("");
//		this.name.setText("");
//		this.time.setText("");
//		this.credit.setText("");
//		this.professor.setText("");
//		this.personnel.setText("");
//		this.comboBox.setSelectedIndex(0);
//		
//	}

	public VLecture getLecture() {
		return new VLecture(this.code.getText(), this.name.getText(), this.personnel.getText(), this.credit.getText(), this.professor.getText(), this.time.getText(), (String)this.comboBox.getSelectedItem());
	}
	
		

}
