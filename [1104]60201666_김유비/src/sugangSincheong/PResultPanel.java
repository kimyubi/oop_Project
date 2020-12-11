package sugangSincheong;


import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CResult;
import valueObject.VGangjwa;

public class PResultPanel extends PGangjwaContainer {
	private static final long serialVersionUID = 1L;

	private Vector<VGangjwa> vGangjwas;
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane jScrollPane;

	public PResultPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.table = new JTable();
		
		this.jScrollPane = new JScrollPane();
		
		Vector<String> header = new Vector<String>();
		header.addElement("°­ÁÂ¹øÈ£");
		header.addElement("°­ÁÂ¸í");
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.table.setModel(tableModel);	
		this.jScrollPane.setViewportView(this.table);

		this.add(jScrollPane);
	}

	public void initialize(String fileName) {
		CResult cResult = new CResult();
		this.vGangjwas = cResult.get(fileName);
		this.updateTableContents();
	}

	public void finish(String fileName) {
		CResult cResult = new CResult();
		cResult.save(fileName, vGangjwas);
	}


	private void updateTableContents() {
		this.tableModel.setRowCount(0);
		for (VGangjwa vGangjwa : this.vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getId());
			row.add(vGangjwa.getName());
			this.tableModel.addRow(row);
		}
		if (vGangjwas.size() > 0) {
			this.table.setRowSelectionInterval(0, 0);
		}

	}

	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		this.vGangjwas.addAll(vSelectedGangjwas);
		this.updateTableContents();

	}

	public Vector<VGangjwa> removeSelectedGangjwas() {
		Vector<VGangjwa> removeGangjwas = new Vector<VGangjwa>();
		int[] indices = this.table.getSelectedRows();
		for (int i = indices.length - 1; i >= 0; i--) {
			VGangjwa removeGangjwa = this.vGangjwas.remove(indices[i]);
			removeGangjwas.add(removeGangjwa);
		}
		this.updateTableContents();
		return removeGangjwas;
	}

	
	public Vector<VGangjwa> getGangjwas() {
		return this.vGangjwas;
	}

}
