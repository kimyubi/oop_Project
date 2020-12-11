package myInfo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.EPMyinfoPanel;
import control.CUser;
import main.Main.ActionHandler;
import valueObject.VUser;

public class PMyinfoPanel extends JPanel{
    
	private static final long serialVersionUID = 1L;
	private JLabel myInfoTitleLabel;
	private JLabel nameLabel;
	private JTextField nameField;
	
	private JLabel emailLabel;
	private JTextField emailField;
	
	private JLabel hakbeonLabel;
	private JTextField hakbeonField;
	private JLabel hakbeonTextLabel;
	
	private JLabel departmentLabel;
	private JComboBox<String> colleageCombo;
	private JLabel updatedColleage;
	private JLabel comment;
	
	private JButton save;
	private JButton cancel;
	private VUser currentUser;
	private CUser cUser = new CUser();
	
	private String[] colleages = {"인문대학","사회과학대학","경영대학","법과대학","ICT융합대학","건축대학","공과대학","자연과학대학","예술체육대학"};
	
	public PMyinfoPanel(ActionHandler actionHandler){
		this.setLayout(null);
		
		this.myInfoTitleLabel = new JLabel(EPMyinfoPanel.myInfoTitleLabel.getText());
		this.myInfoTitleLabel.setFont(new Font("굴림", Font.BOLD, 22));
		this.myInfoTitleLabel.setBounds(70, 25, 84, 38);
		this.add(this.myInfoTitleLabel);
		
		this.nameLabel = new JLabel(EPMyinfoPanel.NameLabel.getText());
		this.nameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		this.nameLabel.setBounds(70, 66, 64, 27);
		this.add(this.nameLabel);
		
		this.emailLabel = new JLabel(EPMyinfoPanel.emailLabel.getText());
		this.emailLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		this.emailLabel.setBounds(70, 131, 64, 27);
		this.add(this.emailLabel);
		
		this.nameField = new JTextField();
		this.nameField.setBounds(70, 94, 127, 27);
		this.nameField.setEnabled(false);
		this.add(this.nameField);
		
		this.emailField = new JTextField();
		this.emailField.setBounds(70, 157, 209, 27);
		this.emailField.setEnabled(false);
		this.add(this.emailField);
		
		this.hakbeonLabel = new JLabel(EPMyinfoPanel.hakbeonLabel.getText());
		this.hakbeonLabel.setBounds(70, 194, 64, 27);
		this.hakbeonLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		this.add(this.hakbeonLabel);
		
		this.hakbeonField = new JTextField();
		this.hakbeonField.setBounds(70, 219, 64, 27);
		this.add(this.hakbeonField);
		
		this.hakbeonTextLabel = new JLabel(EPMyinfoPanel.hakbeonLabel.getText());
		this.hakbeonTextLabel.setBounds(145, 231, 52, 15);
		this.hakbeonTextLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		this.add(this.hakbeonTextLabel);
		
		this.departmentLabel = new JLabel(EPMyinfoPanel.departmentLabel.getText());
		this.departmentLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		this.departmentLabel.setBounds(70, 256, 64, 27);
		this.add(this.departmentLabel);
		
		this.colleageCombo = new JComboBox<String>(this.colleages);
		this.colleageCombo.setBounds(70, 282, 209, 32);
		this.add(this.colleageCombo);
		
		this.updatedColleage = new JLabel();
		this.updatedColleage.setBounds(70, 282, 209, 32);
		this.add(this.updatedColleage);
		this.updatedColleage.setVisible(false);
		
		this.comment = new JLabel();
		this.comment.setBounds(70, 300, 209, 32);
		this.add(this.comment);
		this.comment.setVisible(false);
		
		this.save = new JButton(EPMyinfoPanel.save.getText());
		this.save.setBounds(70, 341, 95, 27);
		this.save.addActionListener(new MyInfoActionHandler());
		this.add(this.save);
		
		this.cancel = new JButton(EPMyinfoPanel.cancel.getText());
		this.cancel.setBounds(184, 341, 95, 27);
		this.cancel.setActionCommand(EPMyinfoPanel.cancelCommand.getText());
		this.cancel.addActionListener(actionHandler);
		this.add(this.cancel);
		
	}
	
	public void initailize(VUser currentUser) {
		this.currentUser = currentUser;
		this.nameField.setText(this.currentUser.getName());
		this.emailField.setText(this.currentUser.getEmail());

		if(this.currentUser.getSaved() == 1) {
			this.currentUser = cUser.getUserWithMyInfo(currentUser);
			int maxGrades =cUser.getMaxGrades(this.currentUser);
			colleageCombo.setVisible(false);
			
			hakbeonField.setText(String.valueOf(currentUser.getHakbeon()));
			hakbeonField.setEnabled(false);
			
			updatedColleage.setText(currentUser.getColleage());
			updatedColleage.setEnabled(false);
			updatedColleage.setVisible(true);
			
			comment.setText(maxGrades + " 학점까지 수강신청이 가능합니다.");
			comment.setVisible(true);
			
			save.setVisible(false);
		}
		
		else {
			colleageCombo.setVisible(true);
			hakbeonField.setEnabled(true);
			updatedColleage.setVisible(false);
			comment.setVisible(false);
			save.setVisible(true);
		}
	
		
	}
	
	public class MyInfoActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand() == EPMyinfoPanel.save.getText()) {
				System.out.println("확인");
				if(hakbeonField.getText().isEmpty() || hakbeonField.getText() == "0") {
					JOptionPane.showConfirmDialog(null,"유효하지 않은 학번입니다.\n다시 입력해주세요.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				currentUser.setHakbeon(Integer.parseInt(hakbeonField.getText()));
				currentUser.setColleage((String)colleageCombo.getSelectedItem());
				
				try {
					currentUser = cUser.updateMyInfo(currentUser);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(currentUser.getSaved() == 1) {
					colleageCombo.setVisible(false);
					
					hakbeonField.setText(String.valueOf(currentUser.getHakbeon()));
					hakbeonField.setEnabled(false);
					
					updatedColleage.setText(currentUser.getColleage());
					updatedColleage.setEnabled(false);
					updatedColleage.setVisible(true);
					
					save.setVisible(false);
					JOptionPane.showConfirmDialog(null,"저장되었습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
				}
	
				
			}
		}
	}
}
