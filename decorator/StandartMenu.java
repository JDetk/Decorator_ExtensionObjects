package decorator;

import java.util.ArrayList;
import java.util.List;

import menu.Dish;
import menu.MenuCreator;

public class StandartMenu implements MenuCreator {

	private List<Dish> dishes = new ArrayList<>();

	@Override
	public void addDish(Dish dish) {
		this.dishes.add(dish);
	}

	@Override
	public int getCookingTime() {
		int sumCooking_time = 0;
		for (Dish dish : dishes) {
			sumCooking_time = sumCooking_time + dish.getCooking_time();
		}
		return sumCooking_time;
	}

	@Override
	public double getCost() {
		double sumCost = 0;
		for (Dish dish : dishes) {
			sumCost = sumCost + dish.getCost();
		}
		return sumCost;
	}

}
