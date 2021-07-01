package extensionObjects;

import java.util.Arrays;
import java.util.List;

import menu.Dish;

public class DishFilteringExtension implements FilteringDishTypeExtension {

	private List<String> possible_dishes = Arrays.asList("Pizza", "Bolognese", "Risotto", "Dumplings", "Flatbread");

	@Override
	public boolean dishTypePossible(Dish dish) {
		return possible_dishes.contains(dish.getType());
	}

}
