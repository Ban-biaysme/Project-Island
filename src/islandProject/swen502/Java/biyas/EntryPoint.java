package islandProject.swen502.Java.biyas;

import java.util.ArrayList;
import java.util.Scanner;

public class EntryPoint {

	ArrayList<Things> creatures = new ArrayList<>();
	ArrayList<Things> plants = new ArrayList<>();
	ArrayList<Things> waters = new ArrayList<>();
	
	
	public EntryPoint() {
		
		System.out.println("========================================================");
		System.out.println("=======  W E L C O M E  T O  G R E E N  I S L A N D  =======");
		System.out.println("========================================================");
		
		System.out.println("Choose the following option \n 1-> Add Creatures \n 2--> Display Creatures"
				+ "\n 3-> Draw Island  \n 4-> Move Creatures and Updated World  \n 5-> Automatically turn simulation using THREAD"
				+ "\n 6-> Draw two separe Island  \n 7--> Add Plants \n 8-> Add and Grow Grass \n 9-> Add Kiwi \n 10-> Add Water \n  "
				+ "11-> Add and Fly Sparrow \n 12-> Add Cat \n 13-> Search Food \n 14-> Add Rat \n 15-> Exit from program" );
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Select An Option");
		int userInput = scan.nextInt();

		while (userInput < 16) {
			switch (userInput) {
			
			case 1: {
				System.out.println("Add Rabbit to creature list ");
				addRabbit();
				System.out.println("Rabbit added");
				System.out.println("==========================");
				break;
			}
			
			case 2: {
				
				System.out.println("Display Creaturs");
				displayCreatures();
				System.out.println("==========================");
				break;
			}
			
			case 3: {								
				System.out.println("Draw Island");
				drawIsland();
				System.out.println("==========================");
				break;
			}
			
			case 4: {								
				System.out.println("Move All Creatures radomly and Update the Island");				
				updateDrawIsland();
				System.out.println("==========================");
				break;
			}
			
			
			case 5: {								
				System.out.println("Automatically running the simulation for 10 times");				
				Creature c = null;
				for (Things t : creatures) {
					Creature cr = (Creature) t;
						c = cr;
						break;					
				}
				automaticallyRunSimulation(c);
				System.out.println("==========================");
				break;
			}
			
			case 6: {
				System.out.println("Draw two separate Islands");
				displayTwoSeparateIslandIsland();
				break;
			}
			
			
			case 7: {
				System.out.println("Add Plants");
				addPlants();
				System.out.println("Plants added to the Island");
				drawIsland();
				System.out.println("==========================");
				break;
			}
			
			case 8: {
				addGrass();
				System.out.println("Grass added to the Island");
				drawIsland();
				System.out.println("Grow Grass");
				growGrass();
				System.out.println("==========================");
				break;
			}			
			
			case 9: {
				System.out.println("Add Kiwi");
				addKiwi();
				System.out.println("Kiwis added to the Island");
				drawIsland();
				System.out.println("==========================");
				break;
			}
			
			case 10: {
				System.out.println("Add Waters");
				addWaterToList();
				System.out.println("Waters added to the Island");
				drawIsland();
				System.out.println("==========================");
				break;
			}

			case 11: {
				System.out.println("Add Sparrow and Fly them in the Island");
				addAndFlySparrow();				
				System.out.println("==========================");
				break;
			}
			
			case 12: {
				System.out.println("Add Cat in the Island");
				drawIsland();
				System.out.println("==========================");
				break;
			}
			
			case 13: {
				System.out.println("Rabbit Search for Grass");
				searchFood();
				System.out.println("==========================");
				break;
			}
			
			case 14: {
				System.out.println("Add Rat to the Island");
				addRat();
				drawIsland();
				System.out.println("==========================");
				break;
			}
			
			case 15: {
				System.out.println("Exit from program");
				System.exit(0);
				break;
			}
		 }
		
		System.out.println("Choose the following option \n 1-> Add Creatures \n 2--> Display Creatures"
				+ "\n 3-> Draw Island  \n 4-> Move Creatures and Updated World  \n 5-> Automatically turn simulation using THREAD"
				+ "\n 6-> Draw two separe Island  \n 7--> Add Plants \n 8-> Add and Grow Grass \n 9-> Add Kiwi \n 10-> Add Water \n  "
				+ "11-> Add and Fly Sparrow \n 12-> Add Cat \n 13-> Rabbit Search for Grass \n 14-> Add Rat \n 15-> Exit from program" );
				
		System.out.println("======================================================================");
			
		System.out.println("Select Option");
		userInput = scan.nextInt();
		}		
	}
	
	// Add Rabbit to the array list. X, Y,size and speed position has taken by random method
	public void addRabbit() {
		for (int i = 0; i < 5; i++) {	
			int size = (int) (Math.random() * 19) + 1;
			int speed = (int) (Math.random() * 4) + 1;
			int x = (int) (Math.random() * 25) + 1;
			int y = (int) (Math.random() * 15) + 1;

			// send data through plant object	
			Rabbit rabbit= new Rabbit(size,x,y,speed);
			creatures.add(rabbit);
		}
	}
	
	// Display Bugs from the array list
		public void displayCreatures() {

			System.out.println("-----------------------------------");
			System.out.println("Display Bug Details from the creatures arraylist");

			System.out.println("Total number of creatures: " + creatures.size());
			System.out.println("---------------------------------------------------------------------");
			System.out.println("Name\t\tSize\t\t X-position\tY-position\tSymbol\t\tSpeed ");

			for (Things t : creatures) {
				Creature c = (Creature) t;
				System.out.println(
						"--------------------------------------------------------------------------------");
				System.out.println(c.getName() + "\t" + c.getSize()
						 + "\t" + c.getX_pos() + "\t\t" + c.getY_pos()+ "\t\t" + c.getSymbol() + "\t\t" + c.getSpeed() + "\n");

			}
		}
 
	//Draw Island based on the given values
	public void drawIsland() {
			Island island= new Island(creatures, plants, waters);
			island.drawIsland();		
		}
	
	
	//Draw two separate Island
	public void displayTwoSeparateIslandIsland() {
		//Draw the first Island
		  Island island= new Island(creatures, plants, waters);
		  island.drawIsland();
		  
		  int newHeight= island.getHeight()+10;
		  int newWidth = island.getWidth()+10;
		  
		  //Create another object for the second Island
		  Island island1= new Island(creatures, plants, waters, newHeight, newWidth);
		  
		  // Draw the second Island
		  island1.drawIsland();
    }
	   
		
	//Below method move the creatures as per their speed.
	// Then it Update the Island in the Island class
	// at the end it will draw the island with updated values.
		
	public void  updateDrawIsland() {
			Island island= new Island(creatures, plants, waters);
			island.updateIsland();	
		}
	
	
	//Turn Rabbit in the island multiple times using Thread	
	public void automaticallyRunSimulation(Creature c) {
		Island island = new Island(creatures, plants, waters);
		
		if (c.getX_pos() > 0 && c.getX_pos() < 50) {
			for (int i = 0; i < 5; i++) {
				try {
					c.move();
					Thread.sleep(1000);
					island.drawIsland();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 	
		}
	}
		
		
	// Add plants to the array list. X, Y and size  position has taken by random method
	public void addPlants() {
		for (int i = 0; i < 9; i++) {	
			
			int size = (int) (Math.random() * 19) + 1;
			int x = (int) (Math.random() * 25) + 1;
			int y = (int) (Math.random() * 15) + 1;

			// send data through plant object
			Plant p = new Plant("Plant", size, x, y,'P');
			plants.add(p);
			
			//Add small plants into array list and add them to plants
			Grass sp= new Grass("Grass", size, x, y, 'G');
			plants.add(sp);
			
			//Add Big Trees into array list and add them to plants
			BigPlant bp= new BigPlant("Pine", size, x, y, 'P');
			plants.add(bp);
		}		

	}
	
	public void addGrass() {
for (int i = 0; i < 9; i++) {	
			
			int size = (int) (Math.random() * 19) + 1;
			int x = (int) (Math.random() * 25) + 1;
			int y = (int) (Math.random() * 15) + 1;
			
			//Add small plants into array list and add them to plants
			Grass sp= new Grass("Grass", size, x, y, 'G');
			plants.add(sp);
		}
	}	
	//Grow the grass in the Island
	
	public void growGrass() {
		int grassSize=0;	
		
		System.out.println("Before Growing the grass ");
		for(Things t1: plants) {
			Plant p = (Plant) t1;
			if(p.getName().equalsIgnoreCase("Grass")) {
				System.out.println("Name -> " + p.getName() + "  Size->  " + p.getSize());
			}
		}
		
	 //Set the Grass size by1 in each turn
		for(Things t: plants) {
			Plant p = (Plant) t;
			if(p.getName().equalsIgnoreCase("Grass")) {
				grassSize=  p.getSize();
				p.setSize(grassSize+1);
			}			
		}
		
		System.out.println("After Growing the grass ");
		
		for(Things t1: plants) {
			Plant p = (Plant) t1;
			if(p.getName().equalsIgnoreCase("Grass")) {
				System.out.println("Name -> " + p.getName() + "  Size->  " + p.getSize());
			}			
		}
	
	}

	// Add waters to the array list. X, Y and size position has taken by random method
	public void addWaterToList() {
		for (int i = 0; i < 9; i++) {	
			int size = (int) (Math.random() * 9) + 1;
			int x = (int) (Math.random() * 25) + 1;
			int y = (int) (Math.random() * 15) + 1;

			// send data through plant object
			Water w = new Water(size, x, y);
			waters.add(w);
			
			WaterPatch wp= new WaterPatch();
			waters.add(wp);
			
			Stream s= new Stream();
			waters.add(s);
		}
	}
	
	
	// Add Sparrow to the array list. X, Y,size and speed position has taken by random method	
	// Fly Sparrow and change the the position based on speed 
	
	public void addAndFlySparrow() {
		//Add sparrow to the creature list
		for (int i = 0; i < 3; i++) {	
			int size = (int) (Math.random() * 5) + 1;
			int speed = (int) (Math.random() * 4) + 1;
			int x = (int) (Math.random() * 25) + 1;
			int y = (int) (Math.random() * 15) + 1;

			// send data through plant object	
			Sparrow s= new Sparrow(size, x, y, speed);
			creatures.add(s);
		}
		
	// Below for loop will search the sparrow and change the position in the Island
		for(Things t: creatures) {			
			Creature c=(Creature) t;
			if(c instanceof Sparrow) {
				System.out.println("Before the Sparrow Fly --> " + c.getY_pos());
				//c.moveMultipleTimes(c.getSpeed());	
				c.move();
				Island island= new Island(creatures, plants, waters);
				island.drawIsland();
				System.out.println("After the Sparrow Fly  the postion --> " + c.getY_pos());
			}
		}
		
	}
	

	// Add Cat to the array list. X, Y,size and speed position has taken by random method
	public void addCat() {
		for (int i = 0; i < 5; i++) {	
			int size = (int) (Math.random() * 10) + 1;
			int speed = (int) (Math.random() * 3) + 1;
			int x = (int) (Math.random() * 25) + 1;
			int y = (int) (Math.random() * 15) + 1;

			// send data through plant object	
			Cat c= new Cat(size, x, y, speed);
			creatures.add(c);
		}
	}
	
	// Add Kiwi to the array list. X, Y,size and speed position has taken by random method
	public void addKiwi() {
		for (int i = 0; i < 5; i++) {	
			int size = (int) (Math.random() * 5) + 1;
			int speed = (int) (Math.random() * 2) + 1;
			int x = (int) (Math.random() * 25) + 1;
			int y = (int) (Math.random() * 15) + 1;

			// send data through plant object	
			Kiwi kiwi= new Kiwi(size, x, y, speed);
			creatures.add(kiwi);
		}
	}

	//Rabbit search for plants in any direction and move toward  it
		public void searchFood() {
			
			Island island= new Island(creatures, plants, waters);
			System.out.println("Before search Food the Island look like ::");
			island.drawIsland();
			island.updateWorldOnSeasrchFood();
			System.out.println("After search Food the Island look like ::");
			island.drawIsland();
		}
	
	//Add rat to the island		
	public void addRat() {	
		for (int i = 0; i < 5; i++) {
			
			int size = (int) (Math.random() * 4) + 1;
			int speed = (int) (Math.random() * 3) + 1;
			int x = (int) (Math.random() * 25) + 1;
			int y = (int) (Math.random() * 15) + 1;

			// send data through Rat object	
			Rat rat= new Rat(size, x, y, speed);
			creatures.add(rat);
		}
	}
	
	public static void main(String[] args) {
		new EntryPoint();
	}

}
