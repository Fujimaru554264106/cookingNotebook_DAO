package cookingNotebook.DAO_02;

public class Food {
	
	private Integer fid;
	private String fname;
	private int cooktime;
	private String ftype;
	private String fimg;
	
	public Food(Integer fid, String fname, int cooktime, String ftype, String fimg) {
		this.fid = fid;
		this.fname = fname;
		this.cooktime = cooktime;
		this.ftype = ftype;
		this.fimg = fimg;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getCooktime() {
		return cooktime;
	}

	public void setCooktime(int cooktime) {
		this.cooktime = cooktime;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getFimg() {
		return fimg;
	}

	public void setFimg(String fimg) {
		this.fimg = fimg;
	}

	@Override
	public String toString() {
		return "Food [fid=" + fid + ", fname=" + fname + ", cooktime=" + cooktime + ", ftype=" + ftype + ", fimg="
				+ fimg + "]";
	}
	
}
