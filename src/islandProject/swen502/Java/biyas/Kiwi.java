package islandProject.swen502.Java.biyas;

//Kiwi class inherited from the creature super class and also inherit the properties of creatures.

public class Kiwi extends Creature implements Carnivore{

	//Name and symbol of Kiwi class are same for all Kiwis

	public Kiwi(int size, int x_pos, int y_pos, int speed) {
		super("Kiwi",size,x_pos,y_pos,speed,'^');
	}

}
