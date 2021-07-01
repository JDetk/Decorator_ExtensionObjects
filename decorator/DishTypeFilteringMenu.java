package decorator;

import java.util.Arrays;
import java.util.List;

import menu.Dish;
import menu.MenuCreator;

public class DishTypeFilteringMenu implements MenuCreator {

	private MenuCreator menuCreator;
	private List<String> possible_dishes = Arrays.asList("Pizza", "Bolognese", "Risotto", "Dumplings", "Flatbread");

	public DishTypeFilteringMenu(MenuCreator menuCreator) {
		this.menuCreator = menuCreator;
	}

	@Override
	public void addDish(Dish dish) {
		if (possible_dishes.contains(dish.getType())) {
			menuCreator.addDish(dish);
		} else {
			System.out.println("Could not find this dish type: " + dish.getType());
		}
	}

	@Override
	public int getCookingTime() {
		return menuCreator.getCookingTime();
	}

	@Override
	public double getCost() {
		return menuCreator.getCost();
	}

}
