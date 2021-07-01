package extensionObjects;

public class GlutenFreeOptionExtension implements CookingTimeExtension, CostExtension {

	@Override
	public int calculateCooking_time(int cooking_time) {
		return cooking_time + 2;
	}

	@Override
	public double calculateCost(double cost) {
		return cost * 1.6;
	}

}
