package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;

import accountManage.PAccountManageFrame;
import adminIndex.PAdminIndexFrame;
import constants.Constants.ELectureManageFrame;
import constants.Constants.ELoginDialog;
import constants.Constants.EPAccountManageFrame;
import constants.Constants.EPAdminIndexBtnPanel;
import constants.Constants.EPFindAccountPanel;
import constants.Constants.EPHeaderPanel;
import constants.Constants.EPIndexBtnPanel;
import constants.Constants.EPMyinfoPanel;
import constants.Constants.EPSignupPanel;
import constants.Constants.EPplanFrame;
import constants.Constants.EenrollmanetFrame;
import enrollment.EnrollmentFrame;
import findAccount.PFindAccountFrame;
import findAccount.PFindAccountPanel;
import index.PIndexFrame;
import lectureManage.PLectureManageFrame;
import login.PLoginDialog;
import loginedIndex.PLoginedIndexFrame;
import myInfo.PMyinfoFrame;
import plan.PplanFrame;
import signUp.PSignupPanel;
import signUp.PsignUpFrame;
import valueObject.VSignupForm;
import valueObject.VUser;

public class Main {
	private PLoginDialog pLoginDialog;
	private PIndexFrame pIndexFrame;
	private PsignUpFrame pSignupFrame;
	private PLoginedIndexFrame pLoginedIndexFrame;
	private PFindAccountFrame findAccountFrame;
	private VUser currentUser;
	private PMyinfoFrame pMyinfoFrame;
	private EnrollmentFrame enrollmentFrame;
	private PplanFrame pplanFrame;
	private PAdminIndexFrame pAdminIndexFrame;
	private PAccountManageFrame pAccountManageFrame;
	private PLectureManageFrame pLectureManageFrame;
	
	public Main() {
		this.pIndexFrame = new PIndexFrame(new ActionHandler());
		this.pIndexFrame.initailize(); 
		this.pLoginDialog = new PLoginDialog(new ActionHandler());
		this.pSignupFrame = new PsignUpFrame(new ActionHandler());
		this.pLoginedIndexFrame = new PLoginedIndexFrame(new ActionHandler());
		this.findAccountFrame = new PFindAccountFrame(new ActionHandler());
		this.pMyinfoFrame = new PMyinfoFrame(new ActionHandler());
		this.enrollmentFrame = new EnrollmentFrame(new ActionHandler());
		this.pplanFrame = new PplanFrame(new ActionHandler());
		this.pAdminIndexFrame = new PAdminIndexFrame(new ActionHandler());
		this.pAccountManageFrame = new PAccountManageFrame(new ActionHandler());
		this.pLectureManageFrame = new PLectureManageFrame(new ActionHandler());
		
	}
	
	private void intialize() {
		
	}
	
	private void validateUser(Object source) {
		VUser vUser = this.pLoginDialog.validateUser(source);
		if (vUser != null) {	
			this.pLoginDialog.setVisible(false);
			this.currentUser = vUser;
			
			//vUser가 관리자면
			if(vUser.getUserId().equals("admin") && vUser.getUserpwd().equals("admin")) {
				this.pAdminIndexFrame.initailize(currentUser);
			}
			
			//vUser가 일반 사용자면
			else {
				this.pLoginedIndexFrame.initailize(this.currentUser);
			}
	
		}
	}
	
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String commandName = event.getActionCommand();
			if(commandName == EPIndexBtnPanel.enrollment.getText()) {
				if(currentUser.getSaved() == 0) {
					JOptionPane.showConfirmDialog(null,"내 정보에서 단과대를 설정한 후에\n 수강신청 서비스를 이용할 수 있습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					return;
				}
				pLoginedIndexFrame.setVisible(false);
				enrollmentFrame.initailize(currentUser);
			}
			else if(commandName == EPIndexBtnPanel.myinfo.getText()) {
				pLoginedIndexFrame.setVisible(false);
				pMyinfoFrame.initailize(currentUser);
			}
			else if(commandName == EPIndexBtnPanel.login.getText()) {
				pIndexFrame.setVisible(false);
				pLoginDialog.initialize();
				
			}
			else if(commandName == EPIndexBtnPanel.signUp.getText()) {
				pIndexFrame.setVisible(false);
				pSignupFrame.initailize();
			}
			else if(commandName == EPIndexBtnPanel.plan.getText()) {
				pLoginedIndexFrame.setVisible(false);
				pplanFrame.initailize(currentUser);
			}
			else if(commandName == ELoginDialog.cancelButtonLabel.getText()){
				//// 회원가입을 하다가 중간에 취소하더라도 회원가입 폼의 텍스트 필드들에 있던 텍스트들 초기화 => 다음에 회원가입 창을 켰을때 텍스트 필드가 비어있도록
				pLoginDialog.resetTextField();
				
				pLoginDialog.setVisible(false);
				pIndexFrame.initailize();
			}
			else if(commandName == ELoginDialog.okButtonLabel.getText()){
				validateUser(event.getSource());
			}
			else if(commandName == ELoginDialog.findAccount.getText()){
				pLoginDialog.setVisible(false);
				findAccountFrame.initailize();
			}
			else if(commandName == EPSignupPanel.cancleBtnfromSignUp.getText()) {
				// 회원가입을 하다가 중간에 취소하더라도 회원가입 폼의 텍스트 필드들에 있던 텍스트들 초기화 => 다음에 회원가입 창을 켰을때 텍스트 필드가 비어있도록
				((PSignupPanel)(pSignupFrame.getPSignupPanel())).resetTextField();
				
				pSignupFrame.setVisible(false);
				pIndexFrame.initailize();
			}
			else if(commandName == EPSignupPanel.signUpBtnfromSignUp.getText()) {
				validateSignUpForm(event.getSource());
			}
			else if(commandName == EPHeaderPanel.goToMain.getText()) {
				pLoginedIndexFrame.initailize(currentUser);
			}
			else if(commandName == EPIndexBtnPanel.logout.getText()) {
				currentUser = null;
				pLoginedIndexFrame.setVisible(false);
				pIndexFrame.initailize();
			}
			else if(commandName == EPFindAccountPanel.goToMainFromFindAccount.getText()) {
				((PFindAccountPanel)(findAccountFrame.getPFindAccountPanel())).resetTextField();
				findAccountFrame.setVisible(false);
				pIndexFrame.initailize();
			}
			else if(commandName == EPMyinfoPanel.cancelCommand.getText()) {
				pMyinfoFrame.setVisible(false);
				pLoginedIndexFrame.initailize(currentUser);
			}
			else if(commandName == EenrollmanetFrame.goToMainFromEnrollment.getText()) {
				enrollmentFrame.setVisible(false);
				pLoginedIndexFrame.initailize(currentUser);
			}
			else if(commandName == EPplanFrame.goToMainFromPlan.getText()) {
				pplanFrame.setVisible(false);
				pLoginedIndexFrame.initailize(currentUser);
			}
			else if(commandName == EPAdminIndexBtnPanel.lectureManageBtn.getText()) {
				pAdminIndexFrame.setVisible(false);
				pLectureManageFrame.initailize(currentUser);
			
			}
			else if(commandName == EPAdminIndexBtnPanel.accountManageBtn.getText()) {
				pAdminIndexFrame.setVisible(false);
				pAccountManageFrame.initailize();
			}
			else if(commandName == EPAccountManageFrame.goToMainFromAccountManage.getText()) {
				pAccountManageFrame.setVisible(false);
				pAdminIndexFrame.initailize(currentUser);
			}
			else if(commandName == ELectureManageFrame.goToMainFromELectureManageFrame.getText()) {
				pLectureManageFrame.setVisible(false);
				pAdminIndexFrame.initailize(currentUser);
			}
			
		}
	}
	
	public static void main(String[] args) throws MessagingException {
		Main main = new Main();
		main.intialize();		
	}

	public void validateSignUpForm(Object source) {
		VSignupForm vSignupForm = ((PSignupPanel)this.pSignupFrame.getPSignupPanel()).validateSignUpForm(source);
		
		if(vSignupForm != null) {
			
			JOptionPane.showConfirmDialog(null,"회원가입 성공","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
			this.currentUser = new VUser(vSignupForm.getUserId(), vSignupForm.getUserPwd(), vSignupForm.getEmail(), vSignupForm.getName(),0);
			
			this.pSignupFrame.setVisible(false);
			this.pLoginedIndexFrame.initailize(this.currentUser); 
		}
		
	}
}
