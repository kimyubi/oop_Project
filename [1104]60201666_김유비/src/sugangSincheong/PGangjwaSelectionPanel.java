package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPGangjwaSelectionPanel;
import control.CGangjwa;
import valueObject.VGangjwa;

public class PGangjwaSelectionPanel extends JTable {
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel tableModel;
	private Vector<VGangjwa> vGangjwas;
	private CGangjwa cGangjwa = new CGangjwa(); 
	private PResultPanel pMiridamgiPanel;
	private PResultPanel pSincheongPanel;
	private String hakgwaFileName;
	


	public PGangjwaSelectionPanel(ListSelectionListener listSelectionHandler) {
		
		Vector<String> header = new Vector<String>();
		for(EPGangjwaSelectionPanel ePgangjwaSelectionPanel : EPGangjwaSelectionPanel.values()) {
			header.addElement(ePgangjwaSelectionPanel.getText());
		}
		this.tableModel = new DefaultTableModel(header, 0);			
		this.setModel(tableModel);
	}
	
	public void intialize(String fileName, PResultPanel pMiridamgiPanel, PResultPanel pSincheongPanel) {
		this.pMiridamgiPanel = pMiridamgiPanel;
		this.pSincheongPanel = pSincheongPanel;
		this.update(fileName);
	}
	
	public Vector<VGangjwa> removeSelectedGangjwas() {
		int []indices=this.getSelectedRows();
		Vector<VGangjwa> vSelectedGangjwas=new Vector<VGangjwa>();
	for( int index = indices.length -1; index>=0; index--) {
		vSelectedGangjwas.add(this.vGangjwas.get(index));
		this.vGangjwas.remove(index);
	}
		this.updateTableContents();
		return vSelectedGangjwas;
	}
	

	private void removeDuplicatedGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		for(VGangjwa vSelectedGangjwa : vSelectedGangjwas) {
			for(int i = this.vGangjwas.size() -1 ; i >= 0 ; i--) {
				if(this.vGangjwas.get(i).getId().equals(vSelectedGangjwa.getId())) {
					this.vGangjwas.remove(i);
					break;
				}
			}
			
		}
		
		this.updateTableContents();
	}
	
	private void updateTableContents() {
		
		this.tableModel.setRowCount(0);
		for (VGangjwa vGangjwa: this.vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getId());
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getLecturer());
			row.add(vGangjwa.getCredit());
			row.add(vGangjwa.getTime());

			this.tableModel.addRow(row);
		}
	}

	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		this.update(this.hakgwaFileName);
		updateTableContents();
			
		}

	public Vector<VGangjwa> removeWrongPlaceGangjwas(Vector<VGangjwa> vSelectedGangjwas, String hakgwaFileName) {
		Vector<VGangjwa> vInplaceGangjwas = new Vector<VGangjwa>();
		Vector<VGangjwa> vOriginalGangjwas = cGangjwa.getData(hakgwaFileName);
		
		for(VGangjwa vOriginalGangjwa : vOriginalGangjwas) {
			for(VGangjwa vSelectedGangjwa : vSelectedGangjwas) {
				if(vOriginalGangjwa.getId().equals(vSelectedGangjwa.getId())) {
					vInplaceGangjwas.add(vSelectedGangjwa);
				}
			}
		}
		return vInplaceGangjwas;
	}

	public void update(String hakgwaFileName) {
		this.hakgwaFileName = hakgwaFileName;
		
		this.vGangjwas = cGangjwa.getData(hakgwaFileName);
		
		this.removeDuplicatedGangjwas(this.pMiridamgiPanel.getGangjwas());
		this.removeDuplicatedGangjwas(this.pSincheongPanel.getGangjwas());
		this.updateTableContents();
		
	}

	}
