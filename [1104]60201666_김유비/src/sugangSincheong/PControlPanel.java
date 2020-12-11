package sugangSincheong;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton moveRightButton;
	private JButton moveLeftButton;
	
	public PControlPanel(ActionListener actionListener) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.moveRightButton = new JButton(">>");
		this.moveRightButton.addActionListener(actionListener);
		this.add(moveRightButton);
		
		this.moveLeftButton = new JButton("<<");
		this.moveLeftButton.addActionListener(actionListener);
		this.add(this.moveLeftButton);
	}

	public void initialize() {
	}

	public Object getmoveRightButton() {
		// TODO Auto-generated method stub
		return this.moveRightButton;
	}

	public Object getmoveLeftButton() {
		// TODO Auto-generated method stub
		return this.moveLeftButton;
	}
	
	
}
