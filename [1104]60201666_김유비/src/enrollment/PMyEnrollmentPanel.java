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

import constants.Constants.EenrollTableHeader;
import control.CEnrollment;
import valueObject.VLecture;
import valueObject.VUser;

public class PMyEnrollmentPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane enrollmentScroll;
	private JTable enrollTable;
	private DefaultTableModel myEnrollmentTableModel;
	private VUser currentUser;
	private CEnrollment cEnrollment = new CEnrollment();
	private int maxGrades;
	private int enrolledGrades;
	private JLabel enrolledCredit; 
	private JLabel enrollableCredit;
	
	public PMyEnrollmentPanel() {
		this.setLayout(null);
		this.setBackground(new Color(97,125,137));
		
		this.enrollmentScroll = new JScrollPane();
		this.enrollmentScroll.setBounds(31, 34, 693, 455);
		this.add(this.enrollmentScroll);
		
		
		Vector<String> header = new Vector<String>();
		for(EenrollTableHeader eenrollTableHeader : EenrollTableHeader.values()) {
			header.addElement(eenrollTableHeader.getText());
		}
		
		this.myEnrollmentTableModel = new DefaultTableModel(header, 0);	
		this.enrollTable = new JTable(myEnrollmentTableModel);
		
		this.enrollTable.getColumnModel().getColumn(7).setCellRenderer(new deleteLectureTableCell());
		this.enrollTable.getColumnModel().getColumn(7).setCellEditor(new deleteLectureTableCell());
		enrollmentScroll.setViewportView(this.enrollTable);
		
	}
	
	public void initialize(VUser currentUser, JLabel enrolledCredit, JLabel enrollableCredit) {
		this.currentUser = currentUser;
		this.maxGrades = cEnrollment.getMaxGrades(currentUser); 
		this.enrolledGrades = cEnrollment.getEnrolledGrades(currentUser); 
		this.enrolledCredit = enrolledCredit;
		this.enrollableCredit = enrollableCredit;
		initailizeData(currentUser);
	}
	
	public DefaultTableModel getmyEnrollmentTableModel() {
		return this.myEnrollmentTableModel;
	}

	private void initailizeData(VUser currentUser) {
		this.myEnrollmentTableModel.setRowCount(0);
		Vector<VLecture> vLectures = cEnrollment.getDataFromEnrollment(currentUser);
		for(VLecture vLecture: vLectures) {
			Vector<String> row = new Vector<String>();
			row.add(vLecture.getCode());
			row.add(vLecture.getLectureName());
			row.add(vLecture.getPersonnel());
			row.add(vLecture.getCredit());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getTime());
			row.add(vLecture.getCampus());
			this.myEnrollmentTableModel.addRow(row);
		}
	}
		
	
	public void updateCredit() {
		this.enrolledGrades = cEnrollment.getEnrolledGrades(currentUser);
		this.enrolledCredit.setText(this.enrolledGrades + "학점");
		
		this.enrolledGrades = cEnrollment.getEnrolledGrades(currentUser);
		this.enrollableCredit.setText(this.maxGrades-this.enrolledGrades + "학점");
	}
	
	public void updateTable() {
		Vector<String> header = new Vector<String>();
		for(EenrollTableHeader eenrollTableHeader : EenrollTableHeader.values()) {
			header.addElement(eenrollTableHeader.getText());
		}
		myEnrollmentTableModel = new DefaultTableModel(header, 0);	
		Vector<VLecture> vLectures = cEnrollment.getDataFromEnrollment(currentUser);
		for(VLecture vLecture: vLectures) {
			Vector<String> row = new Vector<String>();
			row.add(vLecture.getCode());
			row.add(vLecture.getLectureName());
			row.add(vLecture.getPersonnel());
			row.add(vLecture.getCredit());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getTime());
			row.add(vLecture.getCampus());
			myEnrollmentTableModel.addRow(row);
		}

		enrollTable.setModel(myEnrollmentTableModel);
		enrollTable.getColumnModel().getColumn(7).setCellRenderer(new deleteLectureTableCell());
		enrollTable.getColumnModel().getColumn(7).setCellEditor(new deleteLectureTableCell());
		
		updateCredit();
	}

	
	private class deleteLectureTableCell extends AbstractCellEditor implements TableCellEditor,TableCellRenderer{
		private static final long serialVersionUID = 1L;
		JButton deleteLectureBtn;
		
		public deleteLectureTableCell() {
			this.deleteLectureBtn = new JButton("삭제");
			this.deleteLectureBtn.setBackground(new Color(245,245,245));
			this.deleteLectureBtn.setForeground(new Color(6,84,113));
			this.deleteLectureBtn.addActionListener(e -> {
				String code = String.valueOf(enrollTable.getValueAt(enrollTable.getSelectedRow(), 0));
				cEnrollment.deleteLectureFromEnrollment(currentUser, code);
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
			return this.deleteLectureBtn;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return this.deleteLectureBtn;
		}
	}

	
}
