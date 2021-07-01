package menu;

public interface MenuCreator {

	void addDish(Dish dish);

	int getCookingTime();

	double getCost();

	static MenuCreator getRole(MenuCreator menuCreator, String className) {
		if (menuCreator.getClass().getSimpleName().equals(className))
			return menuCreator;

		if (!(menuCreator instanceof MenuCreator))
			return null;

		return MenuCreator.getRole((MenuCreator) menuCreator, className);
	}
}
