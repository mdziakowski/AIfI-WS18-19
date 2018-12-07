package hausaufgabe3;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

public class CarSource extends Actor {
	
	//Attribute der Produktionsfabrik
	private double prob = 0.5;
	
	/**
	 * Den Aufruf super() in den Konstruktoren brauchst du in diesem Fall nicht, 
	 * wenn du diesen wegl�sst erg�nzt ihn Java automatisch
	 */
	//Konstruktoren
	CarSource(){
		super();
	}
	
	CarSource(double prob){
		super();
		this.prob=prob;
	}
	
	//Methode, zur Produktion von Autos, sofern der Platz neben der Fabrik frei ist.
	public void act() {
        
		Grid<Actor> gr = getGrid();
		Location position = getLocation();
		Location next = new Location(position.getRow(), position.getCol() + 1);
		
		Actor neighbor = gr.get(next);
		
		if (neighbor== null && Math.random()<prob) {
			Car car = new Car(5);
			car.putSelfInGrid(gr, next);
		}
	}
}
