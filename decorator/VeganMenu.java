package decorator;

import menu.Dish;
import menu.MenuCreator;

public class VeganMenu implements MenuCreator {

	private MenuCreator menuCreator;

	public VeganMenu(MenuCreator menuCreator) {
		this.menuCreator = menuCreator;
	}

	@Override
	public void addDish(Dish dish) {
		menuCreator.addDish(dish);
	}

	@Override
	public int getCookingTime() {
		return menuCreator.getCookingTime() + 25;
	}

	@Override
	public double getCost() {
		return menuCreator.getCost() * 1.5;
	}

}
