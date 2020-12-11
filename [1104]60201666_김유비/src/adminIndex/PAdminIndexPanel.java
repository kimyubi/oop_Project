package adminIndex;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import main.Main.ActionHandler;

public class PAdminIndexPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private PAdminIndexTitlePanel pAdminIndexTitlePanel;
	private PAdminIndexBtnPanel pAdminIndexBtnPanel;
	private PAdminIndexFooterPanel pAdminIndexFooterPanel;
	
	public PAdminIndexPanel(ActionHandler actionHandler) {
		this.setLayout(new BorderLayout());

		this.pAdminIndexTitlePanel = new PAdminIndexTitlePanel();
		this.add(this.pAdminIndexTitlePanel, BorderLayout.NORTH);

		this.pAdminIndexBtnPanel = new PAdminIndexBtnPanel(actionHandler);
		this.add(this.pAdminIndexBtnPanel, BorderLayout.CENTER);

		this.pAdminIndexFooterPanel = new PAdminIndexFooterPanel();
		this.add(this.pAdminIndexFooterPanel, BorderLayout.SOUTH);
	
	}

}
