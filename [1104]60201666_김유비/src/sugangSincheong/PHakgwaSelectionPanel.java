package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import control.CDirectory;
import valueObject.VDirectory;

public class PHakgwaSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
	
	private String fileName;
	
	public PHakgwaSelectionPanel(ListSelectionListener listSelectionHandler) {
		this.fileName = "root";
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollpane;
		
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory("캠퍼스", listSelectionHandler);
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory("대학", listSelectionHandler);
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory("학과", listSelectionHandler);
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
	}
	public void initialize() {
		this.fileName = this.pCampus.intialize(this.fileName);
		this.fileName = this.pCollege.intialize(this.fileName);
		this.fileName = this.pHakgwa.intialize(this.fileName);
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public String update(Object source) {
		if (source.equals(this.pCampus.getSelectionModel())) {
			this.fileName = this.pCampus.getSelectedFileName();
			this.fileName = this.pCollege.getModelData(this.fileName);
			this.fileName = this.pHakgwa.getModelData(this.fileName);
		} else if (source.equals(this.pCollege.getSelectionModel())) {
			this.fileName = this.pCollege.getSelectedFileName();
			this.fileName = this.pHakgwa.getModelData(this.fileName);
		} else if (source.equals(this.pHakgwa.getSelectionModel())) {
			this.fileName = this.pHakgwa.getSelectedFileName();
		}
		return this.fileName;
	}
	
	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;
		
		private Vector<VDirectory> vDirectories;
		private DefaultTableModel tableModel;
		private  ListSelectionListener listSelectionHandler;
		public PDirectory(String title, ListSelectionListener listSelectionHandler) {
			// attributes
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.listSelectionHandler = listSelectionHandler;
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			// data model
			Vector<String> header = new Vector<String>();
			header.addElement(title);
			this.tableModel = new DefaultTableModel(header, 0);			
			this.setModel(this.tableModel);
			
		}
		public String intialize(String fileName) {
			return this.getModelData(fileName);
		}
	

		
		public String getSelectedFileName() {
			int selectedIndex = this.getSelectedRow();
			String selectedFileName = this.vDirectories.get(selectedIndex).getFileName();
			return selectedFileName;
		}


		public String getModelData(String fileName) {
			this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
			
			CDirectory cDirectory = new CDirectory();
			this.vDirectories = cDirectory.getData(fileName);
			this.tableModel.setRowCount(0);
			for (VDirectory vDirectory: vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);
			}
			String selectedFileName = null;
			if (vDirectories.size() > 0) {
				this.setRowSelectionInterval(0, 0);
				selectedFileName = vDirectories.get(0).getFileName();
			}
			
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			return selectedFileName;
		}
			
	}



}
