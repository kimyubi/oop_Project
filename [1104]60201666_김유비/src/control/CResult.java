package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MGangjwa;
import valueObject.VGangjwa;

public class CResult {

	public CResult() {
		
	}
	public void save(String fileName, Vector<VGangjwa> vGangjwas) {
	
		DataAccessObject dataAccessObject = new DataAccessObject();
		dataAccessObject.saveResults(fileName, vGangjwas);
		
	}
	public Vector<VGangjwa> get(String fileName) {
		DataAccessObject dataAccessObject = new DataAccessObject();
		Vector<MGangjwa> mGangjwas = dataAccessObject.getResults(fileName);
		
		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
		for(MGangjwa mGangjwa: mGangjwas) {
			VGangjwa vGangjwa = new VGangjwa(
					mGangjwa.getId(),
					mGangjwa.getName(),
					mGangjwa.getLecturer(),
					mGangjwa.getCredit(),
					mGangjwa.getTime()
					);
			vGangjwas.add(vGangjwa);
		}
		return vGangjwas;
	}

}
