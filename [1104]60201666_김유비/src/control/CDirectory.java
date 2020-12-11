package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MDirectory;
import model.MModel;
import valueObject.VDirectory;

public class CDirectory {

	public CDirectory() {
	}
	
	public Vector<VDirectory> getData(String fileName) {
		DataAccessObject dataAccessObject = new DataAccessObject();
		Vector<MModel> mModels = dataAccessObject.getModels(fileName, "MDirectory");
		
		Vector<VDirectory> vDrectories = new Vector<VDirectory>();
		for (MModel mModel: mModels) {
			MDirectory mDirectory = (MDirectory) mModel;
			VDirectory vDirectory = new VDirectory(
				mDirectory.getName(),
				mDirectory.getFileName()
			);
			vDrectories.add(vDirectory);
		}		
		return vDrectories;
	}

}
