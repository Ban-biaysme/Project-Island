package islandProject.swen502.Java.biyas;

//Rabbit class inherited from the cReature super class and also inherit the properties of creatures.

public class Rabbit extends Creature implements Harbivore{
	
	//Name and symbol of Rabbit class are same for all Rabbits

	public Rabbit(int size, int x_pos, int y_pos, int speed) {
		super("Rabbit",size,x_pos,y_pos,speed,'R');
	}

}
