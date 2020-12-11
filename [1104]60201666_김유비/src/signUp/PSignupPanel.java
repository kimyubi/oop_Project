package signUp;

import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.EPSignupPanel;
import control.CSignUp;
import main.Main.ActionHandler;
import valueObject.VSignupForm;

public class PSignupPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel signUpTitleLabel;
	private JLabel nameLabel;
	private JLabel idLabel;
	private JLabel pwdLabel;
	private JLabel confirmPwdLabel;
	private JLabel emailLabel;
	private JLabel desc1Label;
	private JLabel desc2Label;
	
	private JTextField nameField;
	private JTextField idField;
	private JTextField pwdField;
	private JTextField confirmPwdField;
	private JTextField emailField;
	
	private JButton signUpBtn;
	private JButton cancleBtn;
	
	
	public PSignupPanel(ActionHandler actionHandler){
		this.setLayout(null);
		this.setBackground(new Color(24,101,130));
	
		this.signUpTitleLabel = new JLabel(EPSignupPanel.signUpTitleLabel.getText());
		this.signUpTitleLabel.setFont(new Font("����", Font.BOLD, 30));
		this.signUpTitleLabel.setForeground(new Color(252,192,69));
		this.signUpTitleLabel.setBounds(101, 36, 141, 35);
		this.add(signUpTitleLabel);
		
		
		this.nameLabel = new JLabel(EPSignupPanel.nameLabel.getText());
		this.nameLabel.setFont(new Font("����", Font.BOLD, 18));
		this.nameLabel.setBounds(101, 83, 90, 35);
		this.nameLabel.setForeground(new Color(226,156,15));
		this.add(this.nameLabel);
		
		this.nameField = new JTextField();
		this.nameField.setBounds(101, 112, 231, 35);
		this.add(this.nameField);
		
		this.idLabel = new JLabel(EPSignupPanel.idLabel.getText());
		this.idLabel.setFont(new Font("����", Font.BOLD, 18));
		this.idLabel.setBounds(101, 157, 90, 35);
		this.idLabel.setForeground(new Color(226,156,15));
		this.add(this.idLabel);
		
		this.idField = new JTextField();
		this.idField.setBounds(101, 186, 231, 35);
		this.add(this.idField);
		
		this.pwdLabel = new JLabel(EPSignupPanel.pwdLabel.getText());
		this.pwdLabel.setFont(new Font("����", Font.BOLD, 18));
		this.pwdLabel.setBounds(101, 229, 90, 35);
		this.pwdLabel.setForeground(new Color(226,156,15));
		this.add(this.pwdLabel);
		
		this.pwdField = new JTextField();
		this.pwdField.setBounds(101, 258, 231, 35);
		this.add(this.pwdField);
		
		this.confirmPwdLabel = new JLabel(EPSignupPanel.confirmPwdLabel.getText());
		this.confirmPwdLabel.setFont(new Font("����", Font.BOLD, 18));
		this.confirmPwdLabel.setBounds(101, 303, 133, 35);
		this.confirmPwdLabel.setForeground(new Color(226,156,15));
		this.add(this.confirmPwdLabel);
		
		this.confirmPwdField = new JTextField();
		this.confirmPwdField.setBounds(101, 333, 231, 35);
		this.add(this.confirmPwdField);
		
		this.emailLabel = new JLabel(EPSignupPanel.emailLabel.getText());
		this.emailLabel.setFont(new Font("����", Font.BOLD, 18));
		this.emailLabel.setBounds(101, 373, 133, 35);
		this.emailLabel.setForeground(new Color(226,156,15));
		this.add(this.emailLabel);
		
		this.emailField = new JTextField();
		this.emailField.setBounds(101, 405, 231, 35);
		this.add(this.emailField);
		
		this.desc1Label = new JLabel(EPSignupPanel.desc1Label.getText());
		this.desc1Label.setBounds(105, 444, 236, 26);
		this.desc1Label.setForeground(new Color(252,192,69));
		this.add(this.desc1Label);
		
		this.desc2Label = new JLabel(EPSignupPanel.desc2Label.getText());
		this.desc2Label.setBounds(105, 463, 236, 26);
		this.desc2Label.setForeground(new Color(252,192,69));
		this.add(this.desc2Label);
		
		this.signUpBtn = new JButton(EPSignupPanel.signUpBtn.getText());
		this.signUpBtn.setBounds(101, 499, 109, 30);
		this.signUpBtn.setBackground(new Color(253,240,222));
		this.signUpBtn.setForeground(new Color(6,84,113));
		this.signUpBtn.addActionListener(actionHandler);
		this.signUpBtn.setActionCommand(EPSignupPanel.signUpBtnfromSignUp.getText());
		this.add(this.signUpBtn);
		
		this.cancleBtn = new JButton(EPSignupPanel.cancleBtn.getText());
		this.cancleBtn.setBounds(223, 499, 109, 30);
		this.cancleBtn.setBackground(new Color(253,240,222));
		this.cancleBtn.setForeground(new Color(6,84,113));
		this.cancleBtn.addActionListener(actionHandler);
		this.cancleBtn.setActionCommand(EPSignupPanel.cancleBtnfromSignUp.getText());
		this.add(this.cancleBtn);
		
		
		

	
	}
	
	public VSignupForm validateSignUpForm(Object eventSource) {
		
		//null�� �˻�
		if(this.nameField.getText().isEmpty()||this.idField.getText().isEmpty()||this.pwdField.getText().isEmpty()||this.emailField.getText().isEmpty()) {
			JOptionPane.showConfirmDialog(null,"�Էµ��� ���� �ʵ尡 �ֽ��ϴ�.","�˸�",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		//��й�ȣ�� ��й�ȣ Ȯ�� ��ġ �˻�
		if(!this.pwdField.getText().contentEquals(this.confirmPwdField.getText())) {
			JOptionPane.showConfirmDialog(null,"��й�ȣ�� ���� �ٸ��ϴ�.","�˸�",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"; 
		Pattern p = Pattern.compile(regex);     			//�־��� ����ǥ����(regex)�κ��� ������ �����.
		Matcher m = p.matcher(this.emailField.getText()); 	//��� ���ڿ��� ������ ��ġ�� ��� ��� ���ڿ��� ���ϰ� ��ġ�� ��� true�� ��ȯ
		if(!m.matches()) { 
			JOptionPane.showConfirmDialog(null,"�̸����� ���Ŀ� �°� �Է����ּ���.","�˸�",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE); 
			return null;
		}
		
		VSignupForm vSignupForm = new VSignupForm();
		vSignupForm.setName(this.nameField.getText());
		vSignupForm.setUserId(this.idField.getText());
		vSignupForm.setUserPwd(this.pwdField.getText());
		vSignupForm.setEmail(this.emailField.getText());
		
		CSignUp cSignUp = new CSignUp();
		if(!cSignUp.validateEmail(vSignupForm)) {
			JOptionPane.showConfirmDialog(null,"�̹� ������� �̸����Դϴ�.","�˸�",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		if(!cSignUp.saveAccount(vSignupForm)) {
			JOptionPane.showConfirmDialog(null,"�̹� ������� ���̵��Դϴ�.","�˸�",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		// �ؽ�Ʈ �ʵ� �ʱ�ȭ, ������ â�� ������ �ؽ�Ʈ�� �������� �ʵ��� �ϱ� ����
		this.idField.setText("");
		this.nameField.setText("");
		this.pwdField.setText("");
		this.confirmPwdField.setText("");
		this.emailField.setText("");
		
		return vSignupForm;
	}
	
	public void initailize() {
		
	
	}

	public void resetTextField() {
		this.idField.setText("");
		this.nameField.setText("");
		this.pwdField.setText("");
		this.confirmPwdField.setText("");
		this.emailField.setText("");
		
	}
	
	
	

}
