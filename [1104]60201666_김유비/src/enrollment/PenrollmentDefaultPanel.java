package enrollment;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import constants.Constants.EenrollmanetFrame;
import constants.Constants.ElectureListTableHeader;
import control.CEnrollment;
import main.Main.ActionHandler;
import valueObject.VLecture;
import valueObject.VSearch;
import valueObject.VUser;

public class PenrollmentDefaultPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel logo;
	private JLabel nameLabel;
	private JLabel name;
	private JLabel dmLabel;
	private JLabel dm;
	private JLabel enrolledCreditLabel;
	private JLabel enrolledCredit;
	private JLabel enrollableCreditLabel;
	private JLabel enrollableCredit;
	private JLabel currentTime;
	private JButton goToMain;
	private JButton captureBtn;
	
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel campusLabel;
	private String[] campuses = {"인문캠퍼스","자연캠퍼스"};
	private JComboBox campusComboBox;
	private JLabel codeLabel;
	private JTextField code;
	private JLabel professorLabel;
	private JTextField professor;
	private JLabel lectureNameLabel;
	private JTextField lectureName;
	private JLabel creditLabel;
	private JTextField credit;
	private JButton resetBtn;
	private JButton searchBtn;
	private JScrollPane lectureListScroll;
	private JTable lectureListTable;
	private JLabel mjLogo;

	private PMyEnrollmentPanel myEnrollmentPanel;
	private PMymiriPanel myMiriPanel;
	private CEnrollment cEnrollment = new CEnrollment();
	private int maxGrades;
	private int enrolledGrades;
	
	private DefaultTableModel lectureListTableModel;
	private VUser currentUser;
	
	public PenrollmentDefaultPanel(ActionHandler actionHandler){
		this.setLayout(null);
		this.setBackground(new Color(6,84,113));
		
		this.logo = new JLabel();
		ImageIcon icon = new ImageIcon("image/logo.png");
		Image image = icon.getImage().getScaledInstance(190, 131, Image.SCALE_DEFAULT);
		this.logo.setIcon((new ImageIcon(image)));
		this.logo.setBounds(0, 0, 218, 131);
		this.add(this.logo);
		
		this.nameLabel = new JLabel(EenrollmanetFrame.nameLabel.getText());
		this.nameLabel.setFont(new Font("굴림", Font.BOLD, 18));
		this.nameLabel.setBounds(12, 160, 52, 30);
		this.nameLabel.setForeground(new Color(245,245,245));
		this.add(this.nameLabel);
		
		this.name = new JLabel(); 
		this.name.setFont(new Font("굴림", Font.PLAIN, 16));
		this.name.setBounds(110, 160, 78, 30);
		this.name.setForeground(new Color(245,245,245));
		this.add(this.name);
		
		this.dmLabel = new JLabel(EenrollmanetFrame.dmLabel.getText());
		this.dmLabel.setFont(new Font("굴림", Font.BOLD, 18));
		this.dmLabel.setBounds(12, 215, 72, 22);
		this.dmLabel.setForeground(new Color(245,245,245));
		this.add(this.dmLabel);
		 
		this.dm = new JLabel();
		this.dm.setFont(new Font("굴림", Font.PLAIN, 16));
		this.dm.setBounds(110, 211, 108, 30);
		this.dm.setForeground(new Color(245,245,245));
		this.add(this.dm);
		
		this.enrolledCreditLabel = new JLabel(EenrollmanetFrame.enrolledCreditLabel.getText());
		this.enrolledCreditLabel.setFont(new Font("굴림", Font.BOLD, 18));
		this.enrolledCreditLabel.setBounds(12, 260, 78, 22);
		this.enrolledCreditLabel.setForeground(new Color(245,245,245));
		this.add(this.enrolledCreditLabel);
		
		this.enrolledCredit = new JLabel();
		this.enrolledCredit.setFont(new Font("굴림", Font.PLAIN, 16));
		this.enrolledCredit.setBounds(138, 256, 68, 30);
		this.enrolledCredit.setForeground(new Color(245,245,245));
		this.add(this.enrolledCredit);
		
		this.enrollableCreditLabel = new JLabel(EenrollmanetFrame.enrollableCreditLabel.getText());
		this.enrollableCreditLabel.setFont(new Font("굴림", Font.BOLD, 18));
		this.enrollableCreditLabel.setBounds(12, 315, 114, 22);
		this.enrollableCreditLabel.setForeground(new Color(245,245,245));
		this.add(this.enrollableCreditLabel);
		
		this.enrollableCredit = new JLabel();
		this.enrollableCredit.setFont(new Font("굴림", Font.PLAIN, 16));
		this.enrollableCredit.setBounds(145, 311, 67, 30);
		this.enrollableCredit.setForeground(new Color(245,245,245));
		this.add(this.enrollableCredit);
		
		this.currentTime= new JLabel();
		this.currentTime.setFont(new Font("digital-7", Font.BOLD, 22));
		this.currentTime.setBounds(60, 361, 160, 56);
		this.currentTime.setForeground(new Color(252,192,69));
		this.add(this.currentTime);
		
		this.goToMain = new JButton(EenrollmanetFrame.goToMain.getText());
		this.goToMain.setBounds(35, 420, 152, 38);
		this.goToMain.setBackground(new Color(245,245,245));
		this.goToMain.setForeground(new Color(6,84,113));
		this.goToMain.setActionCommand(EenrollmanetFrame.goToMainFromEnrollment.getText());
		this.goToMain.addActionListener(actionHandler);
		this.add(this.goToMain);
		
		this.captureBtn = new JButton(EenrollmanetFrame.captureBtn.getText());
		this.captureBtn.setBounds(35, 470, 152, 38);
		this.captureBtn.setBackground(new Color(245,245,245));
		this.captureBtn.setForeground(new Color(6,84,113));
		this.captureBtn.addActionListener(new CaptureHandler());
		this.add(this.captureBtn);
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setBounds(220, 0, 766, 563);
		this.tabbedPane.setBackground(Color.WHITE);
		this.tabbedPane.setForeground(new Color(0, 0, 0));
		this.add(this.tabbedPane);
		
		this.panel = new JPanel();
		this.panel.setBackground(new Color(97,125,137));
		tabbedPane.addTab(EenrollmanetFrame.lectureListTitle.getText(), null, panel, null);
		this.panel.setLayout(null);
		
		this.campusLabel = new JLabel(EenrollmanetFrame.campusLabel.getText());
		this.campusLabel.setBounds(28, 28, 52, 31);
		this.campusLabel.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(this.campusLabel);
		
		this.campusComboBox = new JComboBox(this.campuses);
		this.campusComboBox.setBounds(92, 29, 139, 30);
		panel.add(this.campusComboBox);
		
		this.codeLabel = new JLabel(EenrollmanetFrame.codeLabel.getText());
		this.codeLabel.setBounds(243, 28, 66, 31);
		this.codeLabel.setFont(new Font("굴림", Font.BOLD, 13));
		panel.add(this.codeLabel);
		
		this.code = new JTextField();
		this.code.setBounds(312, 29, 139, 31);
		panel.add(this.code);
		
		this.professorLabel = new JLabel(EenrollmanetFrame.professorLabel.getText());
		this.professorLabel.setBounds(462, 28, 52, 31);
		this.professorLabel.setFont(new Font("굴림", Font.BOLD, 13));
		panel.add(this.professorLabel);
		
		this.professor = new JTextField();
		this.professor.setBounds(513, 29, 106, 31);
		panel.add(this.professor);
		
		this.lectureNameLabel = new JLabel(EenrollmanetFrame.lectureNameLabel.getText());
		this.lectureNameLabel.setBounds(28, 75, 66, 31);
		this.lectureNameLabel.setFont(new Font("굴림", Font.BOLD, 13));
		panel.add(this.lectureNameLabel);
		
		this.lectureName = new JTextField();
		this.lectureName.setBounds(92, 76, 139, 31);
		panel.add(this.lectureName);
		
		this.creditLabel = new JLabel(EenrollmanetFrame.creditLabel.getText());
		this.creditLabel.setBounds(240, 75, 37, 31);
		this.creditLabel.setFont(new Font("굴림", Font.BOLD, 13));
		panel.add(this.creditLabel);
		
		this.credit = new JTextField();
		this.credit.setBounds(275, 76, 115, 31);
		panel.add(this.credit);
		
		this.resetBtn = new JButton(EenrollmanetFrame.resetBtn.getText());
		this.resetBtn.setBounds(412, 76, 95, 31);
		this.resetBtn.setBackground(new Color(245,245,245));
		this.resetBtn.setForeground(new Color(6,84,113));
		this.resetBtn.addActionListener(new EnrollmentDefaultPanelActionHandler());
		panel.add(this.resetBtn);
		
		this.searchBtn = new JButton(EenrollmanetFrame.searchBtn.getText());
		this.searchBtn.setBounds(523, 76, 95, 31);
		this.searchBtn.setForeground(new Color(252,192,69));
		this.searchBtn.setBackground(new Color(6,84,113));
		this.searchBtn.addActionListener(new EnrollmentDefaultPanelActionHandler());
		panel.add(this.searchBtn);
		
		this.lectureListScroll = new JScrollPane();
		this.lectureListScroll.setBounds(28, 138, 693, 375);
		panel.add(this.lectureListScroll);
		
		Vector<String> header = new Vector<String>();
		for(ElectureListTableHeader electureListTableHeader : ElectureListTableHeader.values()) {
			header.addElement(electureListTableHeader.getText());
		}
		
		this.lectureListTableModel = new DefaultTableModel(header, 0);	
		this.lectureListTable = new JTable(lectureListTableModel);
		
		this.lectureListTable.getColumnModel().getColumn(7).setCellRenderer(new miriTableCell());
		this.lectureListTable.getColumnModel().getColumn(7).setCellEditor(new miriTableCell());
		this.lectureListTable.getColumnModel().getColumn(8).setCellRenderer(new enrollTableCell());
		this.lectureListTable.getColumnModel().getColumn(8).setCellEditor(new enrollTableCell());
		lectureListScroll.setViewportView(this.lectureListTable);
		
		this.mjLogo = new JLabel();
		this.mjLogo.setBounds(631, 23, 100, 100);
		ImageIcon iconMj = new ImageIcon("image/logoMj.jpg");
		Image imageMj = iconMj.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		this.mjLogo.setIcon(new ImageIcon(imageMj));
		panel.add(this.mjLogo);
		
		this.myEnrollmentPanel = new PMyEnrollmentPanel();
		tabbedPane.addTab(EenrollmanetFrame.myEnrollmentText.getText(), null, this.myEnrollmentPanel, null);
		
		
		this.myMiriPanel = new PMymiriPanel();
		tabbedPane.addTab(EenrollmanetFrame.myMiriText.getText(), null, this.myMiriPanel, null);
		
		  
	    ChangeListener changeListener = new ChangeListener () {
	        public  void stateChanged (ChangeEvent changeEvent) {
	         JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource ();
	         int index = sourceTabbedPane.getSelectedIndex ();
//	         System.out.println ( "탭 변경 :" + sourceTabbedPane.getTitleAt (index));
	         if(sourceTabbedPane.getTitleAt(index).equals(EenrollmanetFrame.lectureListTitle.getText())) {
	        	 updateCredit();
	         }
	         else if(sourceTabbedPane.getTitleAt(index).equals(EenrollmanetFrame.myEnrollmentText.getText())){
	        	 myEnrollmentPanel.updateCredit();
	        	 myEnrollmentPanel.updateTable();
	         }
	         else if(sourceTabbedPane.getTitleAt(index).equals(EenrollmanetFrame.myMiriText.getText())){
	        	myMiriPanel.updateCredit();
	        	 myEnrollmentPanel.updateTable();
	         }
	       }
	     };
	    this.tabbedPane.addChangeListener (changeListener);
		
	}

	public void initialize(VUser currentUser) {
		this.currentUser = currentUser;
		this.maxGrades = cEnrollment.getMaxGrades(currentUser); // 사용자가 속한 단과대 최대 학점
		this.enrolledGrades = cEnrollment.getEnrolledGrades(currentUser); // 사용자가 신청한 학점수
		
		this.name.setText(currentUser.getName());
		this.dm.setText(currentUser.getColleage());
		this.enrolledCredit.setText(this.enrolledGrades + "학점"); //신청 학점
		this.enrollableCredit.setText(this.maxGrades-this.enrolledGrades + "학점"); //신청학점 
		Thread thread = new Thread(new clock());
		thread.start();
		initailizeData();
		
		this.myEnrollmentPanel.initialize(currentUser, this.enrolledCredit, this.enrollableCredit);
		this.myMiriPanel.initialize(currentUser, enrolledCredit, enrollableCredit);
	}
	
	public void updateCredit() {
		this.enrolledGrades = cEnrollment.getEnrolledGrades(currentUser);
		this.enrolledCredit.setText(this.enrolledGrades + "학점");
		
		this.enrolledGrades = cEnrollment.getEnrolledGrades(currentUser);
		this.enrollableCredit.setText(this.maxGrades-this.enrolledGrades + "학점");
	}

	
	private void initailizeData() {
		Vector<VLecture> vLectures = cEnrollment.getInitailData();
		for(VLecture vLecture: vLectures) {
			Vector<String> row = new Vector<String>();
			row.add(vLecture.getCode());
			row.add(vLecture.getLectureName());
			row.add(vLecture.getCredit());
			row.add(vLecture.getPersonnel());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getTime());
			row.add(vLecture.getCampus());
			this.lectureListTableModel.addRow(row);
		}
	}
	
	private class enrollTableCell extends AbstractCellEditor implements TableCellEditor,TableCellRenderer{
		private static final long serialVersionUID = 1L;
		JButton enrollBtn;
		
		public enrollTableCell() {
			this.enrollBtn = new JButton("신청");
			this.enrollBtn.setBackground(new Color(245,245,245));
			this.enrollBtn.setForeground(new Color(6,84,113));
			this.enrollBtn.addActionListener(e -> {
				String code = String.valueOf(lectureListTable.getValueAt(lectureListTable.getSelectedRow(), 0));
				
				if(enrolledGrades + cEnrollment.getCreditByCode(code) > maxGrades) {
					JOptionPane.showConfirmDialog(null,"신청 가능한 학점을 초과하였습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					return;
				}
					
				int result = cEnrollment.enrollment(currentUser,code);
				if(result == 0) {
					JOptionPane.showConfirmDialog(null,"이미 신청한 강좌입니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					return;
				}
				else {
					JOptionPane.showConfirmDialog(null,"강좌가 신청되었습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					updateCredit();
					myEnrollmentPanel.initialize(currentUser, enrolledCredit, enrollableCredit);
				}
			});
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return this.enrollBtn;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return this.enrollBtn;
		}
	}
	
	private class miriTableCell extends AbstractCellEditor implements TableCellEditor,TableCellRenderer{
		private static final long serialVersionUID = 1L;
		JButton miriBtn;
		
		public miriTableCell() {
			this.miriBtn = new JButton("담기");
			this.miriBtn.setBackground(new Color(245,245,245));
			this.miriBtn.setForeground(new Color(6,84,113));
			this.miriBtn.addActionListener(e -> {
				String code = String.valueOf(lectureListTable.getValueAt(lectureListTable.getSelectedRow(), 0));
				int result = cEnrollment.miridamgi(currentUser,code);
				if(result == 0) {
					JOptionPane.showConfirmDialog(null,"이미 미리담기한 강좌입니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					return;
				}
				else {
					JOptionPane.showConfirmDialog(null,"강좌가 미리담기되었습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					myMiriPanel.initialize(currentUser, enrolledCredit, enrollableCredit);
				}
			});
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return this.miriBtn;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return this.miriBtn;
		}
	}
	
	private class EnrollmentDefaultPanelActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand().equals(EenrollmanetFrame.resetBtn.getText())) {
				code.setText("");
				professor.setText("");
				credit.setText("");
				lectureName.setText("");
				initailizeData();
			}
			else if(event.getActionCommand().equals(EenrollmanetFrame.searchBtn.getText())) {
				VSearch vSearch = new VSearch();
				vSearch.setCampus((String)campusComboBox.getSelectedItem());
				vSearch.setCode(code.getText());
				vSearch.setCredit(credit.getText());
				vSearch.setLectureName(lectureName.getText());
				vSearch.setProfessor(professor.getText());
				Vector<VLecture> vLectures = cEnrollment.getSearchData(vSearch);
				updateTable(vLectures);
				
				
			}
		}
	}
	
	private void updateTable(Vector<VLecture> vLectures) {
		Vector<String> header = new Vector<String>();
		for(ElectureListTableHeader electureListTableHeader : ElectureListTableHeader.values()) {
			header.addElement(electureListTableHeader.getText());
		}
		lectureListTableModel = new DefaultTableModel(header, 0);	
		for(VLecture vLecture: vLectures) {
			Vector<String> row = new Vector<String>();
			row.add(vLecture.getCode());
			row.add(vLecture.getLectureName());
			row.add(vLecture.getPersonnel());
			row.add(vLecture.getCredit());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getTime());
			row.add(vLecture.getCampus());
			lectureListTableModel.addRow(row);
		}

		lectureListTable.setModel(lectureListTableModel);
		this.lectureListTable.getColumnModel().getColumn(7).setCellRenderer(new miriTableCell());
		this.lectureListTable.getColumnModel().getColumn(7).setCellEditor(new miriTableCell());
		this.lectureListTable.getColumnModel().getColumn(8).setCellRenderer(new enrollTableCell());
		this.lectureListTable.getColumnModel().getColumn(8).setCellEditor(new enrollTableCell());
		
		updateCredit();
	}
	
	public class CaptureHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand().equals(EenrollmanetFrame.captureBtn.getText())) {
				BufferedImage bufferedImage = null;
		
				//캡쳐 이미지 생성
				try {
					Robot robot = new Robot();
					bufferedImage = robot.createScreenCapture(new Rectangle(140, 30, 1000, 600));
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//이미지 수정
				ImageIcon capturedIcon = new ImageIcon(bufferedImage);
				Image resizeImg = capturedIcon.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
				JLabel capturedImage = new JLabel(new ImageIcon(resizeImg));
				
				
				//
				JFrame showImage = new JFrame("캡쳐 이미지 미리보기");
				showImage.setVisible(true);
				showImage.getContentPane().add(capturedImage);
				showImage.pack();
				showImage.setPreferredSize(new Dimension(500,500));
				ImageIcon icon = new ImageIcon("image/favicon.png");
				showImage.setIconImage(icon.getImage());
				
				
				//파일 탐색기
				JFileChooser jfc = new JFileChooser();
		        int returnVal = jfc.showSaveDialog(null);
		        if(returnVal == 0) {
		            File file = jfc.getSelectedFile();       
		            try {
		            	ImageIO.write(bufferedImage,"jpg",file);        
		            }catch(Exception e) {e.printStackTrace();}
		            JOptionPane.showConfirmDialog(null,"성공적으로 저장되었습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
		             
		        }
			}
		}
	}
	
	private class clock implements Runnable{
		public void run(){
		 while(true){
		      Calendar cal = Calendar.getInstance();
		      String hour = null;
		      if(cal.get(Calendar.HOUR)<10) {
		    	  hour = "0" + cal.get(Calendar.HOUR) +" : ";
		      }
		      else {
		    	  hour = cal.get(Calendar.HOUR) +" : ";
		      }
		      
		      String minute = null;
		      if(cal.get(Calendar.MINUTE)<10) {
		    	  minute = "0" + cal.get(Calendar.MINUTE) +" : ";
		      }
		      else {
		    	  minute = cal.get(Calendar.MINUTE)+" : ";
		      }
		      
		      
		      String second = null;
		      if(cal.get(Calendar.SECOND)<10) {
		    	  second = "0" + cal.get(Calendar.SECOND);
		      }
		      else {
		    	  second = cal.get(Calendar.SECOND)+"";
		      }
		      
		      String now = hour + minute+ second;
	                       currentTime.setText(now);	                       
	                       try{
	                    	   Thread.sleep(1000);
	                    	   }
	                       catch(InterruptedException e)
	                       {
	                    	   e.printStackTrace();
	                       }
		             
		 	}
		}
	}



}
