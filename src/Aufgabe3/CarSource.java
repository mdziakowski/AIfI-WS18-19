package Aufgabe3;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Bug;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

public class CarSource extends Bug{
	double possibility;
	
	public CarSource(double possibility) {
		this.possibility = possibility;
	}

	@Override
	public void move() {
		Grid<Actor> gr = getGrid();
		 if (gr == null)
		     return ;
		 Location loc = getLocation();
		 if (Math.random()<this.possibility) {
		 Location next = loc.getAdjacentLocation(90);
		 // wenn das Feld gerade belegt ist wird es einfach �berschrieben
		 Car car = new Car(5);
		 car.putSelfInGrid(gr, next);
		 }
	}
	@Override
	public void act() {
		// TODO Auto-generated method stub
		
		move();
	}

	
}
