package cookingNotebook.DAO;

public class Ingredient {

	private Integer iid;
	private String iname;
	
	public Ingredient(Integer iid, String iname) {
		this.iid = iid;
		this.iname = iname;
	}

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	@Override
	public String toString() {
		return "Ingredient [iid=" + iid + ", iname=" + iname + "]";
	}
	
}
