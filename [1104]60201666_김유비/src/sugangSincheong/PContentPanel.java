package sugangSincheong;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import constants.Constants.EConfigurations;
import valueObject.VGangjwa;
import valueObject.VUser;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private VUser vUser;
	private PSelectionPanel pSelectionPanel;
	private PControlPanel pControlPanel1;
	private PResultPanel pMiridamgiPanel;
	private PControlPanel pControlPanel2;
	private PResultPanel pSincheongPanel;

	private ActionHandler actionHandler;
	private ListSelectionListener listSelectionHandler;

	

	public PContentPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.actionHandler = new ActionHandler();
		this.listSelectionHandler = new ListSelectionHandler();
		
		this.pSelectionPanel = new PSelectionPanel(this.listSelectionHandler);
		this.add(this.pSelectionPanel);

		this.pControlPanel1 = new PControlPanel(this.actionHandler);
		this.add(this.pControlPanel1);

		this.pMiridamgiPanel = new PResultPanel();
		this.add(this.pMiridamgiPanel);

		this.pControlPanel2 = new PControlPanel(this.actionHandler);
		this.add(this.pControlPanel2);

		this.pSincheongPanel = new PResultPanel();
		this.add(this.pSincheongPanel);
	
	}

	public void intialize(VUser vUser) {
		this.vUser = vUser;		
	
		this.pMiridamgiPanel.initialize(this.vUser.getUserId() + EConfigurations.miridamgiFilePostfix.getText());
		this.pSincheongPanel.initialize(this.vUser.getUserId() + EConfigurations.sincheongFilePostfix.getText());
		

		this.pSelectionPanel.initialize(this.pMiridamgiPanel,this.pSincheongPanel);
		this.pControlPanel1.initialize();
		this.pControlPanel2.initialize();
	
	}

	public void finish() {
		this.pMiridamgiPanel.finish(this.vUser.getUserId() +  EConfigurations.miridamgiFilePostfix.getText());
		this.pSincheongPanel.finish(this.vUser.getUserId() + EConfigurations.sincheongFilePostfix.getText());
	}
	

	// Selection Listener: Gangjwa Table
	public void update(Object source) {
		this.pSelectionPanel.update(source);
	}
	


	public class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent event) {
			update(event.getSource());
		}
	}
	
	private void moveGangjwas(PGangjwaContainer source, PGangjwaContainer target) {
		Vector<VGangjwa> vSelectedGangjwas = source.removeSelectedGangjwas();
		target.addGangjwas(vSelectedGangjwas);		
	}


	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			if (source.equals(pControlPanel1.getmoveRightButton())) {
				moveGangjwas(pSelectionPanel, pMiridamgiPanel);
			} else if (source.equals(pControlPanel1.getmoveLeftButton())) {
				moveGangjwas(pMiridamgiPanel, pSelectionPanel);
			} else if (source.equals(pControlPanel2.getmoveRightButton())) {
				moveGangjwas(pMiridamgiPanel, pSincheongPanel);
			} else if (source.equals(pControlPanel2.getmoveLeftButton())) {
				moveGangjwas(pSincheongPanel, pMiridamgiPanel);
			}
		}

	}

}
