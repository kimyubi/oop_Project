package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MDirectory;
import model.MGangjwa;
import model.MModel;
import valueObject.VGangjwa;

public class CGangjwa {

	public CGangjwa() {
	}
	
	public Vector<VGangjwa> getData(String fileName) {
		DataAccessObject dataAccessObject = new DataAccessObject();
		Vector<MModel> mModels = dataAccessObject.getModels(fileName, "MGangjwa");
		
		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
		for (MModel mModel: mModels) {
			MGangjwa mGangjwa = (MGangjwa) mModel;
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
