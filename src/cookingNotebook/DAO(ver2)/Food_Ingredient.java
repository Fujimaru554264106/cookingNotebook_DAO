package cookingNotebook.DAO;

public class Food_Ingredient {

	private Integer fid;
	private Integer iid;
	private Double amount;
	private String unit;
	
	public Food_Ingredient(Integer fid, Integer iid, Double amount, String unit) {
		this.fid = fid;
		this.iid = iid;
		this.amount = amount;
		this.unit = unit;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Food_Ingredient [fid=" + fid + ", iid=" + iid + ", amount=" + amount + ", unit=" + unit + "]";
	}
	
}
