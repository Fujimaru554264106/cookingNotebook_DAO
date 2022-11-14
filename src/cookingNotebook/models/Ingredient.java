package cookingNotebook.models;

public class Ingredient {
	private int id;
	private String name;
	private int hasAmount;
	private String unit;
	
	public Ingredient(int id, String name, int hasAmount, String unit) {
		super();
		this.id = id;
		this.name = name;
		this.hasAmount = hasAmount;
		this.unit = unit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHasAmount() {
		return hasAmount;
	}

	public void setHasAmount(int hasAmount) {
		this.hasAmount = hasAmount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", hasAmount=" + hasAmount + ", unit=" + unit + "]";
	}
	
}