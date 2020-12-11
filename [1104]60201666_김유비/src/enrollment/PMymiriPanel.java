package enrollment;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import constants.Constants.EMiriTableHeader;
import control.CEnrollment;
import valueObject.VLecture;
import valueObject.VUser;

public class PMymiriPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane miriScroll;
	private JTable miriTable;
	private DefaultTableModel myMiriTableModel;
	private VUser currentUser;
	private CEnrollment cEnrollment = new CEnrollment();
	private int maxGrades;
	private int enrolledGrades;
	private JLabel enrolledCredit; 
	private JLabel enrollableCredit;
	
	public PMymiriPanel() {
		this.setLayout(null);
		this.setBackground(new Color(97,125,137));
		
		this.miriScroll = new JScrollPane();
		this.miriScroll.setBounds(31, 34, 693, 455);
		this.add(this.miriScroll);
		
		
		Vector<String> header = new Vector<String>();
		for(EMiriTableHeader miriTableHeader : EMiriTableHeader.values()) {
			header.addElement(miriTableHeader.getText());
		}
		
		this.myMiriTableModel = new DefaultTableModel(header, 0);	
		this.miriTable = new JTable(myMiriTableModel);
		
		this.miriTable.getColumnModel().getColumn(8).setCellRenderer(new deleteLectureTableCell());
		this.miriTable.getColumnModel().getColumn(8).setCellEditor(new deleteLectureTableCell());
		this.miriTable.getColumnModel().getColumn(7).setCellRenderer(new miriToenrollTableCell());
		this.miriTable.getColumnModel().getColumn(7).setCellEditor(new miriToenrollTableCell());
		miriScroll.setViewportView(this.miriTable);
	}
	
	public void initialize(VUser currentUser, JLabel enrolledCredit, JLabel enrollableCredit) {
		this.myMiriTableModel.setRowCount(0);
		this.currentUser = currentUser;
		this.maxGrades = cEnrollment.getMaxGrades(currentUser); 
		this.enrolledGrades = cEnrollment.getEnrolledGrades(currentUser); 
		this.enrolledCredit = enrolledCredit;
		this.enrollableCredit = enrollableCredit;
		initailizeData(currentUser);
	}

	private void initailizeData(VUser currentUser) {
		Vector<VLecture> vLectures = cEnrollment.getDataFromMiri(currentUser);
		for(VLecture vLecture: vLectures) {
			Vector<String> row = new Vector<String>();
			row.add(vLecture.getCode());
			row.add(vLecture.getLectureName());
			row.add(vLecture.getCredit());
			row.add(vLecture.getPersonnel());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getTime());
			row.add(vLecture.getCampus());
			this.myMiriTableModel.addRow(row);
		}
	}
		
	public void updateCredit() {
		this.enrolledGrades = cEnrollment.getEnrolledGrades(currentUser);
		this.enrolledCredit.setText(this.enrolledGrades + "학점");
		
		this.enrolledGrades = cEnrollment.getEnrolledGrades(currentUser);
		this.enrollableCredit.setText(this.maxGrades-this.enrolledGrades + "학점");
	}
	
	
	private class miriToenrollTableCell extends AbstractCellEditor implements TableCellEditor,TableCellRenderer{
		private static final long serialVersionUID = 1L;
		JButton enrollBtn;
		
		public miriToenrollTableCell() {
			this.enrollBtn = new JButton("신청");
			this.enrollBtn.setBackground(new Color(245,245,245));
			this.enrollBtn.setForeground(new Color(6,84,113));
			this.enrollBtn.addActionListener(e -> {
				String code = String.valueOf(miriTable.getValueAt(miriTable.getSelectedRow(), 0));
				
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
					updateCredit(); // 수강신청 패널에 업데이트
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
	
	public void updateTable() {
		Vector<String> header = new Vector<String>();
		for(EMiriTableHeader miriTableHeader : EMiriTableHeader.values()) {
			header.addElement(miriTableHeader.getText());
		}
		myMiriTableModel = new DefaultTableModel(header, 0);	
		Vector<VLecture> vLectures = cEnrollment.getDataFromMiri(currentUser);
		for(VLecture vLecture: vLectures) {
			Vector<String> row = new Vector<String>();
			row.add(vLecture.getCode());
			row.add(vLecture.getLectureName());
			row.add(vLecture.getPersonnel());
			row.add(vLecture.getCredit());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getTime());
			row.add(vLecture.getCampus());
			myMiriTableModel.addRow(row);
		}

		miriTable.setModel(myMiriTableModel);
		this.miriTable.getColumnModel().getColumn(8).setCellRenderer(new deleteLectureTableCell());
		this.miriTable.getColumnModel().getColumn(8).setCellEditor(new deleteLectureTableCell());
		this.miriTable.getColumnModel().getColumn(7).setCellRenderer(new miriToenrollTableCell());
		this.miriTable.getColumnModel().getColumn(7).setCellEditor(new miriToenrollTableCell());
		
		updateCredit();
	}
	
	
	private class deleteLectureTableCell extends AbstractCellEditor implements TableCellEditor,TableCellRenderer{
		private static final long serialVersionUID = 1L;
		JButton lectureDeleteBtn;
		
		public deleteLectureTableCell() {
			this.lectureDeleteBtn = new JButton("삭제");
			this.lectureDeleteBtn.setBackground(new Color(245,245,245));
			this.lectureDeleteBtn.setForeground(new Color(6,84,113));
			this.lectureDeleteBtn.addActionListener(e -> {
				String code = String.valueOf(miriTable.getValueAt(miriTable.getSelectedRow(), 0));
				cEnrollment.deleteLectureFromMiri(currentUser, code);
				JOptionPane.showConfirmDialog(null,"강좌가 삭제되었습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
				updateTable();
				return;	
			});
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return this.lectureDeleteBtn;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return this.lectureDeleteBtn;
		}
	}


}
