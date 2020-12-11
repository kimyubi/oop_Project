package index;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import loginedIndex.PLoginedIndexTitlePanel;
import main.Main.ActionHandler;

public class PIndexPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private PLoginedIndexTitlePanel pIndexTitlePanel;
	private PIndexBtnPanel pIndexBtnPanel;
	private PIndexFooterPanel pIndexFooterPanel;
	
	public PIndexPanel(ActionHandler actionHandler) {
		this.setLayout(new BorderLayout());

		this.pIndexTitlePanel = new PLoginedIndexTitlePanel();
		this.add(this.pIndexTitlePanel, BorderLayout.NORTH);

		this.pIndexBtnPanel = new PIndexBtnPanel(actionHandler);
		this.add(this.pIndexBtnPanel, BorderLayout.CENTER);

		this.pIndexFooterPanel = new PIndexFooterPanel();
		this.add(this.pIndexFooterPanel, BorderLayout.SOUTH);
	
	}

}
