package extensionObjects;

import menu.Dish;

public interface Extension {

}

interface CookingTimeExtension extends Extension {
	int calculateCooking_time(int cooking_time);
}

interface CostExtension extends Extension {
	double calculateCost(double cost);
}

interface FilteringDishTypeExtension extends Extension {
	boolean dishTypePossible(Dish dish);
}