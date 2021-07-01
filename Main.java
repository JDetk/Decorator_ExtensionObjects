import decorator.DishTypeFilteringMenu;
import decorator.GlutenFreeMenu;
import decorator.StandartMenu;
import decorator.VeganMenu;
import extensionObjects.DishFilteringExtension;
import extensionObjects.ExtendableStandartMenu;
import extensionObjects.GlutenFreeOptionExtension;
import extensionObjects.VeganOptionExtension;
import menu.Dish;
import menu.MenuCreator;

public class Main {

	public static void main(String[] args) {

		MenuCreator menuCreator = new VeganMenu(new GlutenFreeMenu(new StandartMenu()));
		printDecoratorMenu(menuCreator);
		ExtendableStandartMenu extendableStandartMenu = new ExtendableStandartMenu();
		printExtensionMenu(extendableStandartMenu);

	}

	public static void printDecoratorMenu(MenuCreator menuCreator) {

		System.out.println("Decorator pattern");
		menuCreator.addDish(new Dish("Dumplings", 9, 11.00));
		menuCreator.addDish(new Dish("Risotto", 12, 23.00));
		menuCreator.addDish(new Dish("Stinking Bishop", 14, 21.00));

		VeganMenu veganMenuPlius = (VeganMenu) MenuCreator.getRole((MenuCreator) menuCreator, "VeganMenu");
		if (veganMenuPlius != null) {
			System.out.println("\nGluten-Free PLIUS Vegan menu: \n" + "Cooking time: " + veganMenuPlius.getCookingTime()
					+ " min.");
			System.out.printf("Total cost of this menu: %.2f eur\n\n", veganMenuPlius.getCost());
		}

		menuCreator = new DishTypeFilteringMenu(new VeganMenu(new GlutenFreeMenu(new StandartMenu())));
		menuCreator.addDish(new Dish("Bolognese", 30, 17.00));
		menuCreator.addDish(new Dish("Stinking Bishop", 14, 21.00));

		DishTypeFilteringMenu filteredVGFMenu = (DishTypeFilteringMenu) MenuCreator.getRole((MenuCreator) menuCreator,
				"DishTypeFilteringMenu");
		if (filteredVGFMenu != null) {
			System.out.println("FILTERED Gluten-Free PLIUS Vegan menu: \n" + "Cooking time: "
					+ filteredVGFMenu.getCookingTime() + " min.");
			System.out.printf("Total cost of this menu: %.2f eur", filteredVGFMenu.getCost());
		}
	}

	public static void printExtensionMenu(ExtendableStandartMenu extendableStandartMenu) {

		System.out.println("\n\nExtension objects pattern\n");

		extendableStandartMenu.addExtension(new VeganOptionExtension());
		extendableStandartMenu.addExtension(new GlutenFreeOptionExtension());
		extendableStandartMenu.addDish(new Dish("Dumplings", 9, 11.00));
		extendableStandartMenu.addDish(new Dish("Risotto", 12, 23.00));
		extendableStandartMenu.addDish(new Dish("Stinking Bishop", 14, 21.00));

		System.out.println("Gluten-Free PLIUS Vegan menu: \n" + "Cooking time: "
				+ extendableStandartMenu.getCookingTime() + " min.");
		System.out.printf("Total cost of this menu: %.2f eur\n\n", extendableStandartMenu.getCost());

		ExtendableStandartMenu extendableStandartMenuFull = new ExtendableStandartMenu();
		extendableStandartMenuFull.addExtension(new VeganOptionExtension());
		extendableStandartMenuFull.addExtension(new GlutenFreeOptionExtension());
		extendableStandartMenuFull.addExtension(new DishFilteringExtension());
		extendableStandartMenuFull.addDish(new Dish("Bolognese", 30, 17.00));
		extendableStandartMenuFull.addDish(new Dish("Stinking Bishop", 14, 21.00));

		System.out.println("FILTERED Gluten-Free PLIUS Vegan menu: \n" + "Cooking time: "
				+ extendableStandartMenuFull.getCookingTime() + " min.");
		System.out.printf("Total cost of this menu: %.2f eur", extendableStandartMenuFull.getCost());
	}

}
