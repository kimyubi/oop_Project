package loginedIndex;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PLoginedIndexTitlePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel indexTitle;
	
	public PLoginedIndexTitlePanel() {
		this.indexTitle = new JLabel();
		this.setBackground(new Color(6,84,113));
		ImageIcon icon = new ImageIcon("image/logo.png");
		Image image = icon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		this.indexTitle.setIcon(new ImageIcon(image));
		this.add(indexTitle);
	}
	
	public void initialize() {
		
	}

}
