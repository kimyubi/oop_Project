package constants;

public class Constants {
	
	public enum EConfigurations{
		miridamgiFilePostfix("M"),
		sincheongFilePostfix("S");

		private String text;
		private EConfigurations(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	
	public enum ELectureManageHeader{
		code("�����ڵ�"),
		name("�������"),
		personnel("����"),
		credit("����"),
		professor("������"),
		time("���ǽð�"),
		campus("ķ�۽�"),
		manage("����");

		private String text;
		private ELectureManageHeader(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	
	public enum EPAdminIndexFrame{
		width("800"),
		height("500"),
		titleText("�������б� ������û - ������");

		private String text;
		private EPAdminIndexFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum ELectureManageFrame{
		width("1000"),
		height("600"),
		titleText("���� ����"), 
		registerBtn("���ο� ���� ���"), goToMainFromELectureManageFrame("�������� ���ư��� - ElectureManageFrame");

		private String text;
		private ELectureManageFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	
	
	public enum EPLectureRegisterFrame{
		width("400"),
		height("400"),
		titleText("���� ���");

		private String text;
		private EPLectureRegisterFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPLectureRegisterPanel{
		codeLabel("�����ڵ�"), 
		nameLabel("�������"), 
		locationLabel("���ǽ�"), 
		creditLabel("����"), 
		professorLabel("������"), 
		timeLabel("���ǽð�"), 
		campusLabel("ķ�۽�"),
		registerBtn("���"), 
		cancelBtn("���"), personnelLabel("����");
		

		private String text;
		private EPLectureRegisterPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	
	public enum EPAccountManageFrame{
		width("700"),
		height("500"),
		titleText("ȸ�� ����"), 
		goToMain("�������� ���ư���"),
		goToMainFromAccountManage("�������� ���ư��� - EPAccountManageFrame"), 
		accountManageTitle("ȸ�� ����");

		private String text;
		private EPAccountManageFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EAccounManageHeader{
		name("�̸�"),
		id("���̵�"),
		pwd("��й�ȣ"),
		email("�̸���"),
		manage("����");

		private String text;
		private EAccounManageHeader(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPAdminIndexBtnPanel{
		lectureManageBtn("���� ����"),
		accountManageBtn("ȸ�� ����"),
		logoutBtn("�α׾ƿ�");
		
		private String text;
		private EPAdminIndexBtnPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPplanDetailFrame{
		width("730"),
		height("670"),
		titleText("���� ��ȹ��");

		private String text;
		private EPplanDetailFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPplanDetailPanel{
		planTitle("���� ��ȹ�� :"),
		nameLabel("������� : "), 
		codeLabel("�����ڵ� : "), 
		timeLabel("���ǽð� : "), 
		personnelLabel("�����ο� : "), 
		bookLabel("���� �� ������ : "), 
		goalLabel("�н���ǥ : "), 
		creditLabel("���� : "), 
		emailLabel("�̸��� : "), 
		weekTitle("���� ��ȹ��"), 
		week1Label("�� 1�� : "),
		week2Label("�� 2�� : "), 
		week3Label("�� 3�� : "), 
		week4Label("�� 4�� : "), 
		week5Label("�� 5�� : "),
		week6Label("�� 6�� : "),
		week7Label("�� 7�� : "),
		week8Label("�� 8�� : "),
		week9Label("�� 9�� : "),
		week10Label("�� 10�� : "),
		week11Label("�� 11�� : "),
		week12Label("�� 12�� : "),
		week13Label("�� 13�� : "),
		week14Label("�� 14�� : "),
		week15Label("�� 15�� : "),
		week16Label("�� 16�� : ");
		
		
		private String text;
		private EPplanDetailPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EenrollmanetFrame{
		width("1000"),
		height("600"),
		titleText("������û"), 
		nameLabel("�̸�"), 
		dmLabel("�ܰ���"), 
		enrolledCreditLabel("��û����"), 
		enrollableCreditLabel("��û��������"), 
		lectureListTitle("�������"), 
		campusLabel("ķ�۽�"), 
		codeLabel("���� �ڵ�"), 
		professorLabel("������"), 
		lectureNameLabel("�������"), 
		creditLabel("����"), 
		resetBtn("�ʱ�ȭ"), 
		searchBtn("�˻�"), 
		myEnrollmentText("�� ������û"), 
		myMiriText("�� �̸����"), 
		goToMain("�������� ���ư���"), 
		goToMainFromEnrollment("�������� ���ư��� -PenrollmentDefaultPanel"), captureBtn("ĸ�� �� �����ϱ�");

		private String text;
		private EenrollmanetFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum ElectureListTableHeader{
		code("�����ڵ�"),
		name("�������"),
		professor("������"),
		perssonel("����"),
		credit("����"),
		time("���� �ð�"),
		campus("ķ�۽�"),
		miri("�̸����"),
		enrollment("������û");

		private String text;
		private ElectureListTableHeader(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EMiriTableHeader{
		code("�����ڵ�"),
		name("�������"),
		perssonel("����"),
		credit("����"),
		professor("������"),
		time("���� �ð�"),
		campus("ķ�۽�"),
		enrollment("��û"),
		delete("����");

		private String text;
		private EMiriTableHeader(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPlanHeader{
		code("�����ڵ�"),
		name("�������"),
		perssonel("����"),
		credit("����"),
		professor("������"),
		time("���� �ð�"),
		campus("ķ�۽�"),
		plan("���� ��ȹ��");

		private String text;
		private EPlanHeader(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EenrollTableHeader{
		code("�����ڵ�"),
		name("�������"),
		perssonel("����"),
		credit("����"),
		professor("������"),
		time("���� �ð�"),
		campus("ķ�۽�"),
		delete("����");

		private String text;
		private EenrollTableHeader(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPFindAccountFrame{
		width("500"),
		height("450"),
		titleText("���� ã��");

		private String text;
		private EPFindAccountFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPMyinfo{
		width("500"),
		height("450"),
		titleText("�� ����");

		private String text;
		private EPMyinfo(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPMyinfoPanel{
		myInfoTitleLabel("�� ����"),
		NameLabel("�̸�"),
		emailLabel("�̸���"),
		hakbeonLabel("�й�"), 
		departmentLabel("�ܰ���"), 
		save("����"), 
		cancel("���"), 
		cancelCommand("���-�� ����");

		private String text;
		private EPMyinfoPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	
	public enum EPFindAccountPanel{
		findAccountLabel("���� ã��"),
		findIdLabel("���̵� ã��"),
		findIdField("�̸����� �Է��ϼ���."),
		findIdBtn("ã��"),
		findPwdLabel("��й�ȣ ã��"),
		findPwdField_id("���̵� �Է��ϼ���."),
		findPwdField_email("�̸����� �Է��ϼ���."),
		findPwdBtn("ã��"),
		findIdDescription("������ �� ����Ͻ� �̸����� �Է��Ͻø� �ش� �̸��Ϸ� ���̵� �߼۵˴ϴ�."),
		findPwdDescription("���̵�� ������ �� ����Ͻ� �̸����� �Է��Ͻø� �̸��Ϸ� ��й�ȣ�� �߼۵˴ϴ�."),
		goToMain("�������� ���ư���"), 
		goToMainFromFindAccount("�������� ���ư��� - ����ã��"), 
		findIdBtnCommand("ã�� - ���̵� ã��"),
		findPwdBtnCommand("ã�� - ��й�ȣ ã��");

		private String text;
		private EPFindAccountPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	
	public enum EPHeaderPanel{
		goToMain("�������� ���ư���");

		private String text;
		private EPHeaderPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPSignupPanel{
		signUpTitleLabel("ȸ������"),
		width("450"),
		height("600"),
		nameLabel("�̸�"),
		idLabel("���̵�"),
		pwdLabel("��й�ȣ"),
		confirmPwdLabel("��й�ȣ Ȯ��"),
		emailLabel("�̸���"),
		desc1Label("�̸����� ���� ã�⿡ ���ǹǷ�"),
		desc2Label("������� �̸����� ��Ȯ�� �Է����ּ���."),
		signUpBtn("����"),
		cancleBtn("���"), 
		titleText("ȸ�� ����"), 
		cancleBtnfromSignUp("ȸ������-���"), 
		signUpBtnfromSignUp("ȸ������-����");
		
		private String text;
		
		private EPSignupPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	
	public enum EIndexFrame{
		title("�������б� ������û ���α׷�"),
		width("800"),
		height("500");
		
		private String text;
		
		private EIndexFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPIndexBtnPanel{
		enrollment("������û"),
		myinfo("�� ����"),
		login("�α���"),
		signUp("ȸ������"),
		plan("���� ��ȹ��"),
		logout("�α׾ƿ�");
		
		private String text;
		
		private EPIndexBtnPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPplanFrame{
		width("800"),
		height("600"),
		titleText("���� ��ȹ��"), 
		goToMain("�������� ���ư���"), 
		goToMainFromPlan("�������� ���ư��� -EPplanFrame");
		
		private String text;
		
		private EPplanFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}

	
	public enum ELoginDialog {
		width("500"),
		height("450"),
		nameLabel(" ���̵�   "),
		sizeNameText("10"),
		passwordLabel("��й�ȣ"),
		sizePasswordText("10"),
		okButtonLabel(" �α��� "),
		cancelButtonLabel("���"),
		findAccount("���� ã��"), 
		loginFailed_2("�н����尡 ��ġ���� �ʽ��ϴ�."),
		loginFailed_3("�������� �ʴ� �����Դϴ�.\n ȸ�������� ���� �������ּ���");
		
		private String text;
		private ELoginDialog(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}

	
	public enum EPGangjwaSelectionPanel{
		gangjwaNo("���� ��ȣ"),
		gangjwaName("���¸�"),
		damdangGyosu("��� ����"),
		hakjeom("����"),
		time("�ð�");
		
		private String text;
		private EPGangjwaSelectionPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EMainFrame{
		width("800"),
		height("500"), 
		title("������û");
		
		private String text;
		private EMainFrame(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		
		public int getInt(){
			return Integer.parseInt(text);
		}
		
	}
	

	
	public enum EMenuBar {
		eFile("����"),
		eEdit("����");
		
		String text;
		EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu {
		eNew("���θ����"),
		eOpen("����"),
		eSave("�����ϱ�"),
		eSaveAs("�ٸ��̸�����"),
		ePrint("����Ʈ"),
		eExit("����");
		
		String text;
		EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EEditMenu {
		eCopy("����"),
		eCut("�߶󳻱�"),
		ePaste("���̱�"),
		eDelete("����");
		
		String text;
		EEditMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	
}
