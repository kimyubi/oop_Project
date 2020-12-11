package main;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.Constants.EMainFrame;
import main.Main.ActionHandler;
import sugangSincheong.PSugangSincheongPanel;
import valueObject.VUser;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	//components
	private PSugangSincheongPanel pSugangSincheongPanel;
	//utility
	private WindowsHandler windowsHandler;
	//ValueObject
	private VUser vUser;
	

	// constructor
	public PMainFrame(ActionHandler actionHandler) {
		// attributes
		this.setSize(EMainFrame.width.getInt(), EMainFrame.height.getInt());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(EMainFrame.title.getText());
		ImageIcon icon = new ImageIcon("image/favicon.png");
		this.setIconImage(icon.getImage());
		
		this.setLayout(new BorderLayout());
		
		//utility
		this.windowsHandler = new WindowsHandler();
		this.addWindowListener(this.windowsHandler);

		// components
		this.pSugangSincheongPanel = new PSugangSincheongPanel(actionHandler);
		this.add(this.pSugangSincheongPanel, BorderLayout.CENTER);
	}

	public void initialize(VUser vUser) {
		this.vUser = vUser;

		this.setVisible(true);
		this.pSugangSincheongPanel.initialize(this.vUser);
	}

	private void finish() {
		this.pSugangSincheongPanel.finish();
	}

	private class WindowsHandler implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
			finish();
		}

		@Override
		public void windowClosed(WindowEvent e) {

		}

		@Override
		public void windowIconified(WindowEvent e) {

		}

		@Override
		public void windowDeiconified(WindowEvent e) {

		}

		@Override
		public void windowActivated(WindowEvent e) {

		}

		@Override
		public void windowDeactivated(WindowEvent e) {

		}

	}
}
