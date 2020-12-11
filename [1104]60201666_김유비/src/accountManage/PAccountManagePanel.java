package accountManage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import constants.Constants.EAccounManageHeader;
import constants.Constants.EPAccountManageFrame;
import control.CUser;
import main.Main.ActionHandler;
import valueObject.VUser;

public class PAccountManagePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel accountManageTitle;
	private JScrollPane scrollPane;
	private JTextField search;
	private JTable table;
	private DefaultTableModel model;
	private CUser cUser = new CUser();
	private JButton goToMain;
	
	public PAccountManagePanel(ActionHandler actionHandler) {
		this.setLayout(null);
		this.setBackground(new Color(6,84,113));
		
		this.accountManageTitle = new JLabel(EPAccountManageFrame.accountManageTitle.getText());
		this.accountManageTitle.setFont(new Font("굴림", Font.BOLD, 20));
		this.accountManageTitle.setBounds(41, 21, 90, 24);
		this.add(this.accountManageTitle);
		
		scrollPane = new JScrollPane();		
		
		Vector<String> header = new Vector<String>();
		for(EAccounManageHeader accounManageHeader : EAccounManageHeader.values()) {
			header.addElement(accounManageHeader.getText());
		}
		
		this.model = new DefaultTableModel(header, 0);	
		this.table = new JTable(model);
		this.table.getColumnModel().getColumn(4).setCellRenderer(new AccountManageCell());
		this.table.getColumnModel().getColumn(4).setCellEditor(new AccountManageCell());
		
		scrollPane.setViewportView(table);
		scrollPane.setBounds(41, 102, 586, 300);
		this.add(scrollPane);
		
		this.goToMain = new JButton(EPAccountManageFrame.goToMain.getText());
		this.goToMain.setBounds(254, 408, 152, 38);
		this.goToMain.setBackground(new Color(245,245,245));
		this.goToMain.setForeground(new Color(6,84,113));
		this.goToMain.setActionCommand(EPAccountManageFrame.goToMainFromAccountManage.getText());
		this.goToMain.addActionListener(actionHandler);
		this.add(this.goToMain);
		
		search = new JTextField();
		search.setBounds(41, 54, 586, 38);
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
	public void initialize() {
		initailizeData();
	}
	
	private void initailizeData() {
		this.model.setRowCount(0);
		Vector<VUser> vUsers = cUser.getAccountData();
		for(VUser vUser: vUsers) {
			Vector<String> row = new Vector<String>();
			row.add(vUser.getName());
			row.add(vUser.getUserId());
			row.add(vUser.getUserpwd());
			row.add(vUser.getEmail());
			this.model.addRow(row);
		}
	}
	
	private class AccountManageCell extends AbstractCellEditor implements TableCellEditor,TableCellRenderer{
		private static final long serialVersionUID = 1L;
		JButton secessionBtn;
		
		public AccountManageCell() {
			this.secessionBtn = new JButton("탈퇴");
			this.secessionBtn.setBackground(new Color(245,245,245));
			this.secessionBtn.setForeground(new Color(6,84,113));
			this.secessionBtn.addActionListener(e -> {
				String userId = String.valueOf(table.getValueAt(table.getSelectedRow(), 1));
				cUser.secessionAccountById(userId);
				JOptionPane.showConfirmDialog(null,userId+"회원이 성공적으로 삭제되었습니다.","알림",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
				updateTable();
			});
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return this.secessionBtn;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return this.secessionBtn;
		}
	}
	
	public void updateTable() {
		Vector<String> header = new Vector<String>();
		for(EAccounManageHeader accounManageHeader : EAccounManageHeader.values()) {
			header.addElement(accounManageHeader.getText());
		}
		this.model = new DefaultTableModel(header, 0);	
		Vector<VUser> vUsers = cUser.getAccountData();
		for(VUser vUser: vUsers) {
			Vector<String> row = new Vector<String>();
			row.add(vUser.getName());
			row.add(vUser.getUserId());
			row.add(vUser.getUserpwd());
			row.add(vUser.getEmail());
			this.model.addRow(row);
		}

		this.table.setModel(this.model);
		
		this.table.getColumnModel().getColumn(4).setCellRenderer(new AccountManageCell());
		this.table.getColumnModel().getColumn(4).setCellEditor(new AccountManageCell());
	}
	

}
