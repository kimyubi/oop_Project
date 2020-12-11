package lectureManage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import constants.Constants.ELectureManageFrame;
import constants.Constants.ELectureManageHeader;
import constants.Constants.EPLectureRegisterPanel;
import constants.Constants.EenrollmanetFrame;
import constants.Constants.ElectureListTableHeader;
import control.CEnrollment;
import enrollment.PMyEnrollmentPanel;
import enrollment.PMymiriPanel;
import enrollment.PenrollmentDefaultPanel.CaptureHandler;
import main.Main.ActionHandler;
import valueObject.VGangjwa;
import valueObject.VLecture;
import valueObject.VSearch;

public class PLectureManagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel logo;

	private JButton registerBtn;
	private JButton goToMain;
	
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

	private CEnrollment cEnrollment = new CEnrollment();
	private DefaultTableModel lectureListTableModel;

	
	public PLectureManagePanel(ActionHandler actionHandler){
		this.setLayout(null);
		this.setBackground(new Color(6,84,113));
		
		this.logo = new JLabel();
		ImageIcon icon = new ImageIcon("image/logo.png");
		Image image = icon.getImage().getScaledInstance(190, 131, Image.SCALE_DEFAULT);
		this.logo.setIcon((new ImageIcon(image)));
		this.logo.setBounds(0, 0, 218, 131);
		this.add(this.logo);
		
		this.goToMain = new JButton(EenrollmanetFrame.goToMain.getText());
		this.goToMain.setBounds(35, 470, 152, 38);
		this.goToMain.setBackground(new Color(245,245,245));
		this.goToMain.setForeground(new Color(6,84,113));
		this.goToMain.setActionCommand(ELectureManageFrame.goToMainFromELectureManageFrame.getText());
		this.goToMain.addActionListener(actionHandler);
		this.add(this.goToMain);
		
		this.registerBtn = new JButton(ELectureManageFrame.registerBtn.getText());
		this.registerBtn.setBounds(35, 420, 152, 38);
		this.registerBtn.setBackground(new Color(245,245,245));
		this.registerBtn.setForeground(new Color(6,84,113));
		this.registerBtn.addActionListener(new LectureRegisterHandler());
		this.add(this.registerBtn);
		
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
		for(ELectureManageHeader electureListTableHeader : ELectureManageHeader.values()) {
			header.addElement(electureListTableHeader.getText());
		}
		
		this.lectureListTableModel = new DefaultTableModel(header, 0);	
		this.lectureListTable = new JTable(lectureListTableModel);
		
		this.lectureListTable.getColumnModel().getColumn(7).setCellRenderer(new LectureManageCell());
		this.lectureListTable.getColumnModel().getColumn(7).setCellEditor(new LectureManageCell());
		lectureListScroll.setViewportView(this.lectureListTable);
		
		this.mjLogo = new JLabel();
		this.mjLogo.setBounds(631, 23, 100, 100);
		ImageIcon iconMj = new ImageIcon("image/logoMj.jpg");
		Image imageMj = iconMj.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		this.mjLogo.setIcon(new ImageIcon(imageMj));
		panel.add(this.mjLogo);
		
	}

	public void initialize() {
		initailizeData();
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
	
	public class LectureRegisterHandler implements ActionListener {
		private PLectureRegisterFrame registerFrame;
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand() == ELectureManageFrame.registerBtn.getText()) {
				this.registerFrame = new PLectureRegisterFrame();
				registerFrame.initailize();
			}
		}
	}
	
	
	private class LectureManageCell extends AbstractCellEditor implements TableCellEditor,TableCellRenderer{
		private static final long serialVersionUID = 1L;
		JButton manageBtn;
		
		public LectureManageCell() {
			this.manageBtn = new JButton("삭제");
			this.manageBtn.setBackground(new Color(245,245,245));
			this.manageBtn.setForeground(new Color(6,84,113));
			this.manageBtn.addActionListener(e -> {
				String code = String.valueOf(lectureListTable.getValueAt(lectureListTable.getSelectedRow(), 0));	
				
				if(cEnrollment.deleteLectureByCode(code) == 1) {
				JOptionPane.showConfirmDialog(null,code+"번 강의가 성공적으로 삭제 되었습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
				updateTable(cEnrollment.getInitailData());
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
			return this.manageBtn;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return this.manageBtn;
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
		for(ELectureManageHeader electureListTableHeader : ELectureManageHeader.values()) {
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
		this.lectureListTable.getColumnModel().getColumn(7).setCellRenderer(new LectureManageCell());
		this.lectureListTable.getColumnModel().getColumn(7).setCellEditor(new LectureManageCell());

		
	}
	

	



}
