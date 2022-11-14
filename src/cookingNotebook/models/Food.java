package cookingNotebook.models;

import java.util.List;

public class Food {
	private int id;
	private String name;
	private int cooktime;
	private Type type;
	private String image;
	private List<Step> steps;
	private List<Ingredient> ingredients;

	public Food(int id, String name, int cooktime, Type type, String image, List<Step> steps, List<Ingredient> ingredients) {
		this.id = id;
		this.name = name;
		this.cooktime = cooktime;
		this.type = type;
		this.image = image;
		this.steps = steps;
		this.ingredients = ingredients;
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

	public int getCooktime() {
		return cooktime;
	}

	public void setCooktime(int cooktime) {
		this.cooktime = cooktime;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", cooktime=" + cooktime + ", type=" + type + ", image=" + image
				+ "]";
	}
	
}