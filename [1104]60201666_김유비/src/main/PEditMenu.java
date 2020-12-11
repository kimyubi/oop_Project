package main;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.Constants;
import constants.Constants.EEditMenu;

public class PEditMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	public PEditMenu() {
		// attributes
		this.setText(Constants.EMenuBar.eEdit.getText());
		
		// components
		for (EEditMenu eEditMenu: EEditMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eEditMenu.getText());
			this.add(menuItem);
			
		}
	}
}
