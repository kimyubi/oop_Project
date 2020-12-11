package loginedIndex;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import main.Main.ActionHandler;

public class PLoginedIndexPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private PLoginedIndexTitlePanel pLoginedIndexTitlePanel;
	private PLoginedIndexBtnPanel pLoginedIndexBtnPanel;
	private PLoginedIndexFooterPanel pLoginedIndexFooterPanel;
	
	public PLoginedIndexPanel(ActionHandler actionHandler) {
		this.setLayout(new BorderLayout());

		this.pLoginedIndexTitlePanel = new PLoginedIndexTitlePanel();
		this.add(this.pLoginedIndexTitlePanel, BorderLayout.NORTH);

		this.pLoginedIndexBtnPanel = new PLoginedIndexBtnPanel(actionHandler);
		this.add(this.pLoginedIndexBtnPanel, BorderLayout.CENTER);

		this.pLoginedIndexFooterPanel = new PLoginedIndexFooterPanel();
		this.add(this.pLoginedIndexFooterPanel, BorderLayout.SOUTH);
	
	}

}
