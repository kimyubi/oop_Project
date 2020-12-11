package plan;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import constants.Constants.EPlanHeader;
import constants.Constants.EPplanFrame;
import control.CEnrollment;
import main.Main.ActionHandler;
import valueObject.VLecture;
import valueObject.VPlan;
import valueObject.VUser;

public class PplanPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private VUser currentUser;
	private JScrollPane scrollPane;
	private JTextField search;
	private JTable table;
	private DefaultTableModel model;
	private CEnrollment cEnrollment = new CEnrollment();
	private JButton goToMain;
	
	public PplanPanel(ActionHandler actionHandler) {
		this.setLayout(null);
		this.setBackground(new Color(6,84,113));
		
		scrollPane = new JScrollPane();		
		
		Vector<String> header = new Vector<String>();
		for(EPlanHeader planHeader : EPlanHeader.values()) {
			header.addElement(planHeader.getText());
		}
		
		this.model = new DefaultTableModel(header, 0);	
		this.table = new JTable(model);
		this.table.getColumnModel().getColumn(7).setCellRenderer(new getPlanTableCell());
		this.table.getColumnModel().getColumn(7).setCellEditor(new getPlanTableCell());
		
		scrollPane.setViewportView(table);
		scrollPane.setBounds(44,100, 700, 380);
		this.add(scrollPane);
		
		this.goToMain = new JButton(EPplanFrame.goToMain.getText());
		this.goToMain.setBounds(297, 505, 152, 38);
		this.goToMain.setBackground(new Color(245,245,245));
		this.goToMain.setForeground(new Color(6,84,113));
		this.goToMain.setActionCommand(EPplanFrame.goToMainFromPlan.getText());
		this.goToMain.addActionListener(actionHandler);
		this.add(this.goToMain);
		
		search = new JTextField();
		search.setBounds(44, 26, 684, 47);
		search.setFont(new Font("굴림", Font.PLAIN, 20));
		
		//글자를 칠때마다 키워드에 부합하는 결과만을 sorting하여 보여줌
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String keyword = search.getText();
				TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(model);
				table.setRowSorter(tableRowSorter);
				tableRowSorter.setRowFilter(RowFilter.regexFilter(keyword));
			}
		});
		this.add(search);
	}
	public void initialize(VUser currentUser) {
		this.currentUser = currentUser;
		initailizeData();
	}
	
	private void initailizeData() {
		Vector<VLecture> vLectures = cEnrollment.getInitailData();
		for(VLecture vLecture: vLectures) {
			Vector<String> row = new Vector<String>();
			row.add(vLecture.getCode());
			row.add(vLecture.getLectureName());
			row.add(vLecture.getPersonnel());
			row.add(vLecture.getCredit());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getTime());
			row.add(vLecture.getCampus());
			this.model.addRow(row);
		}
	}
	
	private class getPlanTableCell extends AbstractCellEditor implements TableCellEditor,TableCellRenderer{
		private static final long serialVersionUID = 1L;
		JButton showBtn;
		PplanDetailFrame showPlanFrame;
		
		public getPlanTableCell() {
			this.showBtn = new JButton("조회");
			this.showBtn.setBackground(new Color(245,245,245));
			this.showBtn.setForeground(new Color(6,84,113));
			this.showBtn.addActionListener(e -> {
				String code = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));
				try {
					VPlan vPlan = cEnrollment.getLectureByCode(code);
					this.showPlanFrame = new PplanDetailFrame();
					this.showPlanFrame.initailize(vPlan);
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
			return this.showBtn;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return this.showBtn;
		}
	}
	

}
