package sugangSincheong;

import java.util.Vector;

import javax.swing.JPanel;

import valueObject.VGangjwa;

public abstract class PGangjwaContainer extends JPanel {
	private static final long serialVersionUID = 1L;

	
	abstract public Vector<VGangjwa> removeSelectedGangjwas();
	abstract public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas);

}
