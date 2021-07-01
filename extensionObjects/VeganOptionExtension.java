package extensionObjects;

public class VeganOptionExtension implements CookingTimeExtension, CostExtension {

	@Override
	public int calculateCooking_time(int cooking_time) {
		return cooking_time + 25;
	}

	@Override
	public double calculateCost(double cost) {
		return cost * 1.5;
	}

}
