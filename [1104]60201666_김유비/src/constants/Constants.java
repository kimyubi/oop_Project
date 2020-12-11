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
		code("과목코드"),
		name("교과목명"),
		personnel("정원"),
		credit("학점"),
		professor("교수명"),
		time("강의시간"),
		campus("캠퍼스"),
		manage("관리");

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
		titleText("명지대학교 수강신청 - 관리자");

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
		titleText("강의 관리"), 
		registerBtn("새로운 강의 등록"), goToMainFromELectureManageFrame("메인으로 돌아가기 - ElectureManageFrame");

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
		titleText("강의 등록");

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
		codeLabel("과목코드"), 
		nameLabel("교과목명"), 
		locationLabel("강의실"), 
		creditLabel("학점"), 
		professorLabel("교수명"), 
		timeLabel("강의시간"), 
		campusLabel("캠퍼스"),
		registerBtn("등록"), 
		cancelBtn("취소"), personnelLabel("정원");
		

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
		titleText("회원 관리"), 
		goToMain("메인으로 돌아가기"),
		goToMainFromAccountManage("메인으로 돌아가기 - EPAccountManageFrame"), 
		accountManageTitle("회원 관리");

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
		name("이름"),
		id("아이디"),
		pwd("비밀번호"),
		email("이메일"),
		manage("관리");

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
		lectureManageBtn("강의 관리"),
		accountManageBtn("회원 관리"),
		logoutBtn("로그아웃");
		
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
		titleText("강의 계획서");

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
		planTitle("강의 계획서 :"),
		nameLabel("교과목명 : "), 
		codeLabel("과목코드 : "), 
		timeLabel("강의시간 : "), 
		personnelLabel("제한인원 : "), 
		bookLabel("교재 및 참고문헌 : "), 
		goalLabel("학습목표 : "), 
		creditLabel("학점 : "), 
		emailLabel("이메일 : "), 
		weekTitle("주차 계획서"), 
		week1Label("제 1주 : "),
		week2Label("제 2주 : "), 
		week3Label("제 3주 : "), 
		week4Label("제 4주 : "), 
		week5Label("제 5주 : "),
		week6Label("제 6주 : "),
		week7Label("제 7주 : "),
		week8Label("제 8주 : "),
		week9Label("제 9주 : "),
		week10Label("제 10주 : "),
		week11Label("제 11주 : "),
		week12Label("제 12주 : "),
		week13Label("제 13주 : "),
		week14Label("제 14주 : "),
		week15Label("제 15주 : "),
		week16Label("제 16주 : ");
		
		
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
		titleText("수강신청"), 
		nameLabel("이름"), 
		dmLabel("단과대"), 
		enrolledCreditLabel("신청학점"), 
		enrollableCreditLabel("신청가능학점"), 
		lectureListTitle("수강편람"), 
		campusLabel("캠퍼스"), 
		codeLabel("과목 코드"), 
		professorLabel("교수명"), 
		lectureNameLabel("교과목명"), 
		creditLabel("학점"), 
		resetBtn("초기화"), 
		searchBtn("검색"), 
		myEnrollmentText("내 수강신청"), 
		myMiriText("내 미리담기"), 
		goToMain("메인으로 돌아가기"), 
		goToMainFromEnrollment("메인으로 돌아가기 -PenrollmentDefaultPanel"), captureBtn("캡쳐 후 저장하기");

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
		code("과목코드"),
		name("교과목명"),
		professor("교수명"),
		perssonel("정원"),
		credit("학점"),
		time("강의 시간"),
		campus("캠퍼스"),
		miri("미리담기"),
		enrollment("수강신청");

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
		code("과목코드"),
		name("교과목명"),
		perssonel("정원"),
		credit("학점"),
		professor("교수명"),
		time("강의 시간"),
		campus("캠퍼스"),
		enrollment("신청"),
		delete("삭제");

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
		code("과목코드"),
		name("교과목명"),
		perssonel("정원"),
		credit("학점"),
		professor("교수명"),
		time("강의 시간"),
		campus("캠퍼스"),
		plan("강의 계획서");

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
		code("과목코드"),
		name("교과목명"),
		perssonel("정원"),
		credit("학점"),
		professor("교수명"),
		time("강의 시간"),
		campus("캠퍼스"),
		delete("삭제");

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
		titleText("계정 찾기");

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
		titleText("내 정보");

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
		myInfoTitleLabel("내 정보"),
		NameLabel("이름"),
		emailLabel("이메일"),
		hakbeonLabel("학번"), 
		departmentLabel("단과대"), 
		save("저장"), 
		cancel("취소"), 
		cancelCommand("취소-내 정보");

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
		findAccountLabel("계정 찾기"),
		findIdLabel("아이디 찾기"),
		findIdField("이메일을 입력하세요."),
		findIdBtn("찾기"),
		findPwdLabel("비밀번호 찾기"),
		findPwdField_id("아이디를 입력하세요."),
		findPwdField_email("이메일을 입력하세요."),
		findPwdBtn("찾기"),
		findIdDescription("가입할 때 사용하신 이메일을 입력하시면 해당 이메일로 아이디가 발송됩니다."),
		findPwdDescription("아이디와 가입할 때 사용하신 이메일을 입력하시면 이메일로 비밀번호가 발송됩니다."),
		goToMain("메인으로 돌아가기"), 
		goToMainFromFindAccount("메인으로 돌아가기 - 계정찾기"), 
		findIdBtnCommand("찾기 - 아이디 찾기"),
		findPwdBtnCommand("찾기 - 비밀번호 찾기");

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
		goToMain("메인으로 돌아가기");

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
		signUpTitleLabel("회원가입"),
		width("450"),
		height("600"),
		nameLabel("이름"),
		idLabel("아이디"),
		pwdLabel("비밀번호"),
		confirmPwdLabel("비밀번호 확인"),
		emailLabel("이메일"),
		desc1Label("이메일은 계정 찾기에 사용되므로"),
		desc2Label("사용중인 이메일을 정확히 입력해주세요."),
		signUpBtn("가입"),
		cancleBtn("취소"), 
		titleText("회원 가입"), 
		cancleBtnfromSignUp("회원가입-취소"), 
		signUpBtnfromSignUp("회원가입-가입");
		
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
		title("명지대학교 수강신청 프로그램"),
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
		enrollment("수강신청"),
		myinfo("내 정보"),
		login("로그인"),
		signUp("회원가입"),
		plan("강의 계획서"),
		logout("로그아웃");
		
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
		titleText("강의 계획서"), 
		goToMain("메인으로 돌아가기"), 
		goToMainFromPlan("메인으로 돌아가기 -EPplanFrame");
		
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
		nameLabel(" 아이디   "),
		sizeNameText("10"),
		passwordLabel("비밀번호"),
		sizePasswordText("10"),
		okButtonLabel(" 로그인 "),
		cancelButtonLabel("취소"),
		findAccount("계정 찾기"), 
		loginFailed_2("패스워드가 일치하지 않습니다."),
		loginFailed_3("존재하지 않는 계정입니다.\n 회원가입을 먼저 진행해주세요");
		
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
		gangjwaNo("강좌 번호"),
		gangjwaName("강좌명"),
		damdangGyosu("담당 교수"),
		hakjeom("학점"),
		time("시간");
		
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
		title("수강신청");
		
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
		eFile("파일"),
		eEdit("편집");
		
		String text;
		EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu {
		eNew("새로만들기"),
		eOpen("열기"),
		eSave("저장하기"),
		eSaveAs("다른이름으로"),
		ePrint("프린트"),
		eExit("종료");
		
		String text;
		EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EEditMenu {
		eCopy("복사"),
		eCut("잘라내기"),
		ePaste("붙이기"),
		eDelete("삭제");
		
		String text;
		EEditMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	
}
