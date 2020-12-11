package main;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.Constants;
import constants.Constants.EFileMenu;

public class PFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	public PFileMenu() {
		// attributes
		this.setText(Constants.EMenuBar.eFile.getText());
		
		// components		
		for (EFileMenu eFileMenu: EFileMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eFileMenu.getText());
			this.add(menuItem);
		}		
	}
}
