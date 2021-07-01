package menu;

public class Dish {

	private String type;
	private int cooking_time;
	private double cost;

	public Dish(String type, int cooking_time, double cost) {
		this.type = type;
		this.cooking_time = cooking_time;
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public int getCooking_time() {
		return cooking_time;
	}

	public double getCost() {
		return cost;
	}
}
