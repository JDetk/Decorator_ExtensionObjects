package decorator;

import menu.Dish;
import menu.MenuCreator;

public class GlutenFreeMenu implements MenuCreator {

	private MenuCreator menuCreator;

	public GlutenFreeMenu(MenuCreator menuCreator) {
		this.menuCreator = menuCreator;
	}

	@Override
	public void addDish(Dish dish) {
		menuCreator.addDish(dish);
	}

	@Override
	public int getCookingTime() {
		return menuCreator.getCookingTime() + 2;
	}

	@Override
	public double getCost() {
		return menuCreator.getCost() * 1.6;
	}
}
