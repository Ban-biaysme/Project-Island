package islandProject.swen502.Java.biyas;

//Cat class inherited from the creature super class and also inherit the properties of creatures.
public class Cat extends Creature implements Carnivore{
	
	//Name and symbol of Cat class are same for all cats
		public Cat(int size,int x_pos, int y_pos, int speed) {
			super("Cat",size,x_pos,y_pos,speed,'C');
		}

}
