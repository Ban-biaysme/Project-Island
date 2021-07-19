package islandProject.swen502.Java.biyas;

import java.util.ArrayList;

//Island class is the main control point of the island
// it contains all the lists of creatures, plants and waters
// 

public class Island {

	private ArrayList<Things> creatures = new ArrayList<>();
	private ArrayList<Things> plants = new ArrayList<>();
	private ArrayList<Things> waters = new ArrayList<>();

	public ArrayList<Things> getCreatures() {
		return creatures;
	}

	public void setCreatures(ArrayList<Things> creatures) {
		this.creatures = creatures;
	}


	public ArrayList<Things> getWaters() {
		return waters;
	}

	public void setWaters(ArrayList<Things> waters) {
		this.waters = waters;
	}

	protected int height;
	protected int width;

	public Island(ArrayList<Things> creatures, ArrayList<Things> plants, ArrayList<Things> waters) {
		this.height = 25;
		this.width = 50;

		this.creatures = creatures;
		this.plants = plants;
		this.waters = waters;
	}
	
	
	public ArrayList<Things> getPlants() {
		return plants;
	}
	
	public void setPlants(ArrayList<Things> plants) {
		this.plants = plants;
	}


	public Island(ArrayList<Things> creatures, ArrayList<Things> plants, ArrayList<Things> waters, int height, int width) {
		this.height = height;
		this.width = width;

		this.creatures = creatures;
		this.plants = plants;
		this.waters = waters;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}

	//Draw the Island with different elements
	public void drawIsland() {
		for (int y_axis = 0; y_axis < this.height; y_axis++) {
			System.out.print("*");
			for (int x_axis = 0; x_axis < this.width; x_axis++) {

				if (y_axis == 0 || y_axis == this.height - 1) {
					System.out.print("#");
				} else {
					Things t = getDisplayObject(x_axis, y_axis);
					if (t != null) {
						System.out.print(t.getSymbol());
					} else {
						System.out.print(" ");
					}

				}

			}
			System.out.print("*");
			System.out.println();
		}

	}

	//Get x and Y position based on the creature type
	public Things getDisplayObject(int x, int y) {
		for (Things t : creatures) {
			if (t.getX_pos() == x && t.getY_pos() == y) {
				if ((x > 0 && x < 50) && (y > 0 && y < 25)) {
					return t;
				}

			}
		}
		for (Things p : plants) {
			if (p.getX_pos() == x && p.getY_pos() == y) {
				if ((x > 0 && x < 50) && (y > 0 && y < 25)) {
					return p;
				}

			}
		}

		for (Things p : waters) {
			if (p.getX_pos() == x && p.getY_pos() == y) {
				if ((x > 0 && x < 50) && (y > 0 && y < 25)) {
					return p;
				}

			}
		}
		return null;

	}

	//Update the Island after changing the position of creatures
	public void updateIsland() {
		for (Things t : creatures) {
			if (t instanceof Creature) {
				Creature c = (Creature) t;
				c.move();
				if (c.getX_pos() <= 0) {
					c.setX_pos(c.getX_pos() + 2);
				} else if (c.getX_pos() >= 50) {
					c.setX_pos(c.getX_pos() - 2);
				} else if (c.getY_pos() <= 0) {
					c.setX_pos(c.getY_pos() + 2);
				} else if (c.getY_pos() <= 0) {
					c.setX_pos(c.getY_pos() - 2);
				}
			}
		}
		drawIsland();
	}
	
	
	public void updateWorldOnSeasrchFood() {
		
		for (Things t : creatures) {
			Creature c = (Creature) t;
			
			int r = (int) (Math.random() * 3) +1;

			if (r == 1 && c.getY_pos()< height-1) {

				c.searchFood("N",this,c);

			} else if (r == 2 && c.getX_pos() < width -1) {

				c.searchFood("E",this,c);

			} else if (r == 3 && c.getY_pos() > 1) {

				c.searchFood("S",this,c);

			} else if (r == 4 && c.getX_pos() > 1) {

				c.searchFood("W",this,c);

			}

		}
	}
}
