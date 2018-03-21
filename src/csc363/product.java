package csc363;

import java.io.Serializable;

public class product implements Serializable {

	private String MfgName;
	private String ImagePath;
	private String Storage;
	private double Cost;
	 
	public String getMfgName() {
		return MfgName;
	}
	public void setMfgName(String mfgName) {
		MfgName = mfgName;
	}
	public String getImagePath() {
		return ImagePath;
	}
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	public String getStorage() {
		return Storage;
	}
	public void setStorage(String storage) {
		Storage = storage;
	}
	public double getCost() {
		return Cost;
	}
	public void setCost(double cost) {
		Cost = cost;
	}
}
