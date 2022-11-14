package cookingNotebook.models;

public class FoodAndIngredient {
	private int idFood;
	private int idIngredient;
	private int quantity;

	public FoodAndIngredient() {
	}

	public FoodAndIngredient(int idFood, int idIngredient, int quantity) {
		this.idFood = idFood;
		this.idIngredient = idIngredient;
		this.quantity = quantity;
	}

	public int getIdFood() {
		return idFood;
	}

	public void setIdFood(int idFood) {
		this.idFood = idFood;
	}

	public int getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
