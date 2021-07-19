package islandProject.swen502.Java.biyas;

//Sparrow class inherited from the creature super class and also inherit the properties of creatures.

public class Sparrow extends Creature implements Omnivore{

	//Name and symbol of Sparrow class are same for all Sparrows
	public Sparrow(int size, int x_pos, int y_pos, int speed) {
		super("Sparrow",size, x_pos, y_pos, speed,'^');
	}

}
