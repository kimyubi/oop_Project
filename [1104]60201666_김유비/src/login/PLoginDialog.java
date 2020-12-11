package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import constants.Constants.ELoginDialog;
import control.CLogin;
import control.CUser;
import main.Main.ActionHandler;
import valueObject.VLogin;
import valueObject.VUser;

public class PLoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	// components
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private JButton okButton;
	private JButton findAccountButton;
	private JButton cancelButton;
	
	//Control
	private CLogin cLogin;
	private CUser cUser;
	
	public PLoginDialog(ActionHandler actionHandler) {
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(6,84,113));
		this.setBackground(new Color(6,84,113));
		this.setLayout(null);
		
		JLabel logoLabel = new JLabel();
		ImageIcon icon = new ImageIcon("image/logo.png");
		Image image = icon.getImage().getScaledInstance(170,170,Image.SCALE_DEFAULT);
		logoLabel.setIcon(new ImageIcon(image));
		logoLabel.setBounds(148,10,170,170);
		this.add(logoLabel);
		
			
		this.nameLabel = new JLabel(ELoginDialog.nameLabel.getText());
		this.nameLabel.setOpaque(true); 
		this.nameLabel.setForeground(new Color(252,192,69));
		this.nameLabel.setBackground(new Color(6,84,113));
		this.nameLabel.setFont(new Font("굴림",Font.BOLD, 18));
		this.nameLabel.setBounds(85, 190, 88, 35);
		this.add(nameLabel);
			
			
		this.nameText = new JTextField();
		this.nameText.setColumns(ELoginDialog.sizeNameText.getInt());
		this.nameText.setBounds(175, 190, 176, 35);
		this.add(nameText);
			
		this.passwordLabel = new JLabel(ELoginDialog.passwordLabel.getText());
		this.passwordLabel.setOpaque(true); 
		this.passwordLabel.setForeground(new Color(252,192,69));
		this.passwordLabel.setBackground(new Color(6,84,113));
		this.passwordLabel.setFont(new Font("굴림",Font.BOLD, 18));
		this.passwordLabel.setBounds(88, 235, 88, 35);
		this.add(passwordLabel);
		
		
		this.passwordText = new JTextField();
		this.passwordText.setColumns(ELoginDialog.sizePasswordText.getInt());
		this.passwordText.setBounds(175,235,176,35);
		this.add(passwordText);
			
		
		this.okButton = new JButton(ELoginDialog.okButtonLabel.getText());
		this.okButton.addActionListener(actionHandler);
		this.okButton.setBackground(new Color(252,192,69));
		this.okButton.setForeground(new Color(6,84,113));
		this.getRootPane().setDefaultButton(this.okButton);
		this.okButton.setBounds(88,300,88,40);	
		this.add(okButton);
		
		this.findAccountButton = new JButton(ELoginDialog.findAccount.getText());
		this.findAccountButton.addActionListener(actionHandler);
		this.findAccountButton.setBackground(new Color(252,192,69));
		this.findAccountButton.setForeground(new Color(6,84,113));
		this.findAccountButton.setBounds(180,300,88,40);
		this.add(findAccountButton);
			
		this.cancelButton = new JButton(ELoginDialog.cancelButtonLabel.getText());
		this.cancelButton.addActionListener(actionHandler);
		this.cancelButton.setBackground(new Color(252,192,69));
		this.cancelButton.setForeground(new Color(6,84,113));
		this.cancelButton.setBounds(271,300,88,40);
		this.add(cancelButton);
			
		
		//create control
		this.cLogin = new CLogin();
		this.cUser = new CUser();
	}
	
	public void initialize() {
		this.setVisible(true);	
	}
	
	public VUser validateUser(Object eventSource) {
		VUser vUser = null;
		if (eventSource.equals(this.okButton)) {
			
			String userId = this.nameText.getText();
			String password = this.passwordText.getText();
			VLogin vLogin= new VLogin(userId, password);
			
			int resultCode = this.cLogin.validateUser(vLogin);
			if (resultCode == 1) { // 로그인 성공
				vUser = this.cUser.getUser(userId);
			} 
			else if(resultCode == 2) {
				// 비밀번호 불일치
				JOptionPane.showMessageDialog(this,ELoginDialog.loginFailed_2.getText());
			}
			else if(resultCode == 3){
				//아이디 불일치 => 계정 존재 x : 3
				JOptionPane.showMessageDialog(this,ELoginDialog.loginFailed_3.getText());
			}
			
			// 텍스트 필드 초기화, 다음에 창을 켰을때 텍스트가 남아있지 않도록 하기 위해
			this.nameText.setText("");
			this.passwordText.setText("");
			
		} 
	
		return vUser;
	}

	public void resetTextField() {
		this.nameText.setText("");
		this.passwordText.setText("");	
	}


}
