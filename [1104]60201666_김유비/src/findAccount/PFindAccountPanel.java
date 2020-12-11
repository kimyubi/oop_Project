package findAccount;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.EPFindAccountPanel;
import control.CUser;
import mail.MailSender;
import main.Main.ActionHandler;
import valueObject.VUser;

public class PFindAccountPanel extends JPanel{
    
	private static final long serialVersionUID = 1L;
	private JLabel findAccountLabel;
	private JLabel findIdLabel;
	private JTextField findIdField;
	private JButton findIdBtn;
	private JLabel findIdDescription;
	
	private JLabel findPwdLabel;
	private JTextField findPwdField_id;
	private JTextField findPwdField_email;
	private JButton findPwdBtn;
	private JLabel findPwdDescription;
	private MailSender mailSender = new MailSender();
	private CUser cUser = new CUser();
	
	private JButton goToMain;
	
	public PFindAccountPanel(ActionHandler actionHandler){
		this.setLayout(null);
		this.setBackground(new Color(24,101,130));
		
		this.findAccountLabel = new JLabel(EPFindAccountPanel.findAccountLabel.getText());
		this.findAccountLabel.setBounds(65, 38, 142, 32);
		this.findAccountLabel.setFont(new Font("굴림", Font.BOLD, 30));
		this.findAccountLabel.setForeground(new Color(252,192,69));
		this.add(this.findAccountLabel);
		
		this.findIdLabel = new JLabel(EPFindAccountPanel.findIdLabel.getText());
		this.findIdLabel.setBounds(65, 90, 99, 32);
		this.findIdLabel.setFont(new Font("굴림", Font.BOLD, 14));
		this.findIdLabel.setForeground(new Color(252,192,69));
		this.add(this.findIdLabel);
		
		this.findIdField = new JTextField(EPFindAccountPanel.findIdField.getText());
		this.findIdField.setBounds(65, 123, 251, 32);
		this.findIdField.addFocusListener(new focusListener());
		this.add(this.findIdField);
		
		this.findIdBtn = new JButton(EPFindAccountPanel.findIdBtn.getText());
		this.findIdBtn.setBounds(325, 122, 80, 32);
		this.findIdBtn.setBackground(new Color(252,192,69));
		this.findIdBtn.setForeground(new Color(6,84,113));
		this.findIdBtn.requestFocus();
		this.findIdBtn.setActionCommand(EPFindAccountPanel.findIdBtnCommand.getText());
		this.findIdBtn.addActionListener(new FindAccountActionHandler());
		this.add(this.findIdBtn);
		
		this.findPwdLabel = new JLabel(EPFindAccountPanel.findPwdLabel.getText());
		this.findPwdLabel.setBounds(65, 201, 99, 24);
		this.findPwdLabel.setFont(new Font("굴림", Font.BOLD, 14));
		this.findPwdLabel.setForeground(new Color(252,192,69));
		this.add(this.findPwdLabel);
		
		this.findPwdField_id = new JTextField(EPFindAccountPanel.findPwdField_id.getText());
		this.findPwdField_id.setBounds(65, 235, 251, 32);
		this.findPwdField_id.addFocusListener(new focusListener());
		this.add(this.findPwdField_id);
		
		this.findPwdField_email = new JTextField(EPFindAccountPanel.findPwdField_email.getText());
		this.findPwdField_email.setBounds(65, 277, 251, 32);
		this.findPwdField_email.addFocusListener(new focusListener());
		this.add(this.findPwdField_email);
		
		this.findPwdBtn = new JButton(EPFindAccountPanel.findPwdBtn.getText());
		this.findPwdBtn.setBounds(325, 276, 80, 32);
		this.findPwdBtn.setBackground(new Color(252,192,69));
		this.findPwdBtn.setForeground(new Color(6,84,113));
		this.findPwdBtn.setActionCommand(EPFindAccountPanel.findPwdBtnCommand.getText());
		this.findPwdBtn.addActionListener(new FindAccountActionHandler());
		this.add(this.findPwdBtn);
		
		this.findIdDescription = new JLabel(EPFindAccountPanel.findIdDescription.getText());
		this.findIdDescription.setBounds(65, 160, 284, 15);
		this.findIdDescription.setFont(new Font("굴림", Font.PLAIN, 8));
		this.add(this.findIdDescription);
		
		this.findPwdDescription = new JLabel(EPFindAccountPanel.findPwdDescription.getText());
		this.findPwdDescription.setBounds(65, 315, 340, 15);
		this.findPwdDescription.setFont(new Font("굴림", Font.PLAIN, 8));
		this.add(this.findPwdDescription);
		
		this.goToMain = new JButton(EPFindAccountPanel.goToMain.getText());
		this.goToMain.setBounds(65, 345, 133, 32);
		this.goToMain.setBackground(new Color(252,192,69));
		this.goToMain.setForeground(new Color(6,84,113));
		this.goToMain.addActionListener(actionHandler);
		this.goToMain.setActionCommand(EPFindAccountPanel.goToMainFromFindAccount.getText());
		this.add(this.goToMain);
	}
	
	public void initailize() {
		
		
	}

	public void resetTextField() {
		this.findIdField.setText(EPFindAccountPanel.findIdField.getText());
		this.findPwdField_email.setText(EPFindAccountPanel.findPwdField_email.getText());
		this.findPwdField_id.setText(EPFindAccountPanel.findPwdField_id.getText());		
	}
	
	private class focusListener extends FocusAdapter{
		@Override
		public void focusGained(FocusEvent e) {
			if(e.getSource().equals(findIdField) && findIdField.getText().equals(EPFindAccountPanel.findIdField.getText())) {
					findIdField.setText("");
			}

			if(e.getSource().equals(findPwdField_id) && findPwdField_id.getText().equals(EPFindAccountPanel.findPwdField_id.getText())) {
				findPwdField_id.setText("");
			}
			
			if(e.getSource().equals(findPwdField_email) && findPwdField_email.getText().equals(EPFindAccountPanel.findPwdField_email.getText())) {
				findPwdField_email.setText("");
			}
		}
		
		@Override
		public void focusLost(FocusEvent e) {
			if(e.getSource().equals(findIdField) && findIdField.getText().equals("")) {
				findIdField.setText(EPFindAccountPanel.findIdField.getText());
			}
			
			if(e.getSource().equals(findPwdField_id) && findPwdField_id.getText().equals("")) {
				findPwdField_id.setText(EPFindAccountPanel.findPwdField_id.getText());
			}
			if(e.getSource().equals(findPwdField_email) && findPwdField_email.getText().equals("")) {
				findPwdField_email.setText(EPFindAccountPanel.findPwdField_email.getText());
			}

		
		}
	}
	
	private class FindAccountActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String commandName = e.getActionCommand();
			
			if(commandName.equals(EPFindAccountPanel.findIdBtnCommand.getText())){
				
			
				if(emailRegexValidation(findIdField.getText())) {
					try {
						if(cUser.ExistUserByEmail(findIdField.getText())) {
								VUser vUser = cUser.getUserByEmail(findIdField.getText());
								mailSender.sendEmailToFindId(vUser);
								JOptionPane.showConfirmDialog(null,"이메일이 발송되었습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
							}
						else 
						{
							JOptionPane.showConfirmDialog(null,"해당 이메일로 가입된 계정이 없습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
						}
					} catch (HeadlessException | ClassNotFoundException | SQLException | MessagingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else {
					if(emailRegexValidation(findIdField.getText())) {
						try {
							if(cUser.ExistUserByEmailAndId(findPwdField_email.getText(),findPwdField_id.getText())) {
								VUser vUser = cUser.getUserByEmail(findIdField.getText());
								try {
									mailSender.sendEmailToFindPwd(vUser);
								} catch (MessagingException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								JOptionPane.showConfirmDialog(null,"이메일이 발송되었습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
							}
							else 
							{
							JOptionPane.showConfirmDialog(null,"해당 아이디와 이메일로 가입된 계정이 없습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
							}
						} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		}
	}
	private boolean emailRegexValidation(String email) {
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"; 
		Pattern p = Pattern.compile(regex);     			//주어진 정규표현식(regex)로부터 패턴을 만든다.
		Matcher m = p.matcher(email); 	//대상 문자열과 패턴이 일치할 경우 대상 문자열이 패턴과 일치할 경우 true를 반환
		if(!m.matches()) { 
			JOptionPane.showConfirmDialog(null,"이메일을 형식에 맞게 입력해주세요.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE); 
			return false;
		}
		
		return true;
	}
	

		
}
