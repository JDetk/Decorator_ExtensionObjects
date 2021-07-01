package extensionObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import menu.Dish;
import menu.MenuCreator;

public class ExtendableStandartMenu implements MenuCreator {

	private List<Dish> dishes = new ArrayList<>();
	private List<Extension> extensions = new ArrayList<>();

	@Override
	public void addDish(Dish dish) {
		boolean dishFound = true;
		for (Extension extension : extensions) {
			if (extension.getClass().toString().contains("ExtensionObjects.DishFilteringExtension")) {
				dishFound = ((FilteringDishTypeExtension) extension).dishTypePossible(dish);
			}
		}
		if (dishFound) {
			this.dishes.add(dish);
		} else {
			System.out.println("Could not find this dish type: " + dish.getType());
		}
	}

	@Override
	public int getCookingTime() {
		int sumCooking_time = 0;
		for (Dish dish : dishes) {
			sumCooking_time = sumCooking_time + dish.getCooking_time();
		}
		for (Extension extension : extensions) {
			if (!(extension.getClass().toString().contains("extensionObjects.DishFilteringExtension"))) {
				sumCooking_time = ((CookingTimeExtension) extension).calculateCooking_time(sumCooking_time);
			}
		}
		return sumCooking_time;
	}

	@Override
	public double getCost() {
		double sumCost = 0;
		for (Dish dish : dishes) {
			sumCost = sumCost + dish.getCost();
		}
		for (Extension extension : extensions) {
			if (!(extension.getClass().toString().contains("extensionObjects.DishFilteringExtension"))) {
				sumCost = ((CostExtension) extension).calculateCost(sumCost);
			}
		}
		return sumCost;
	}

	public void addExtension(Extension extension) {
		this.extensions.add(extension);
	}

	public Optional<Extension> getExtension(Class<?> type) {
		return extensions.stream().filter(extension -> type.isInstance(extension)).findFirst();
	}
}
