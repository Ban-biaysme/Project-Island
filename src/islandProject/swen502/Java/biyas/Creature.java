package islandProject.swen502.Java.biyas;

import java.util.ArrayList;

//Creature class implements from Things Interface
public class Creature implements Things{
	
	protected String name;
	protected int size;
	protected int x_pos;
	protected int y_pos;
	protected int speed;
	protected char symbol;
	
	public Creature() {
		//empty constructor used to get values for other creatures with some parameters
	}

	public Creature(String name, int size, int x_pos, int y_pos, int speed,char symbol) {
		this.name = name;
		this.size = size;
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.speed= speed;
		this.symbol = symbol;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getX_pos() {
		return x_pos;
	}

	public void setX_pos(int x_pos) {
		this.x_pos = x_pos;
	}

	public int getY_pos() {
		return y_pos;
	}

	public void setY_pos(int y_pos) {
		this.y_pos = y_pos;
	}
	

	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	
	//Move all the creatures in a specific direction	
	public void move() {
		int genNum = (int) (Math.random() * 3) + 1;		
		if (genNum == 1) {
			this.setY_pos(y_pos-speed);			
		} else if (genNum == 2) {
			this.setX_pos(x_pos+speed);
		}else if (genNum == 3) {
			this.setY_pos(y_pos+speed);
		}else if (genNum == 4) {
			this.setX_pos(x_pos-speed);
		}
	}
	
	
	//Move all the creatures in a specific direction	
	public void moveMultipleTimes(int pos) {
		int genNum = (int) (Math.random() * 3) + 1;		
		if (genNum == 1) {
			this.y_pos -= pos;			
		} else if (genNum == 2) {
			this.x_pos+= pos;
		}else if (genNum == 3) {
			this.y_pos += pos;
		}else if (genNum == 4) {
			this.x_pos -= pos;
		}
	}

	//Search food method will search plant for the Rabbit
	 public void searchFood(String direction, Island island, Things t) {
		 ArrayList<Things> objList = new ArrayList<>();	

		 Things tobj = null;
		 
			if (t instanceof Rabbit) {
				ArrayList<Things> objList1 = island.getPlants();	
				for(Things p:objList1) {
					if(p instanceof Grass) {
						objList.add(p);
					}
				}
			}else {
				return;
			}
			
			int distance = 100;
			if (direction.equals("N")) {
				for (Things th : objList) {
					if (th.getX_pos()== this.x_pos && th.getY_pos() < this.y_pos) {
						int steps = Math.abs(this.y_pos - th.getY_pos());
						if (steps < distance) {
							distance = steps;
							tobj = th;
							}

						}

					}
				}else if (direction.equals("S")) {
					for (Things th : objList) {
						if (th.getX_pos() == this.x_pos  && th.getY_pos() > this.y_pos) {
							int steps = Math.abs(this.y_pos  - th.getY_pos());
							if (steps < distance) {
								distance = steps;
								tobj = th;
							}

						}

					}
				}else if (direction.equals("E")) {
					for (Things th : objList) {
						if (th.getY_pos() == this.y_pos && th.getX_pos() > this.x_pos) {
							int steps = Math.abs(this.x_pos - th.getX_pos());
							if (steps < distance) {
								distance = steps;
								tobj = th;
							}

						}

					}
				} else if (direction.equals("W")) {
					for (Things th : objList) {
						if (th.getY_pos() == this.y_pos && th.getX_pos() < this.x_pos) {
							int steps = Math.abs(this.x_pos - th.getX_pos());
							if (steps < distance) {
								distance = steps;
								tobj = th;

							}

						}

					}
				}
			if (tobj != null) {
				for (int r = 0; r < distance; r++) {
					if (direction.equals("N")) {
						if (!isNextObstacle(this.x_pos, this.y_pos - 1, island)) {
							this.move();

						} else {
							return;
						}

					} else if (direction.equals("S")) {
						if (!isNextObstacle(this.x_pos, this.y_pos+ 1, island)) {
							this.move();

						} else {
							return;
						}

					} else if (direction.equals("E")) {
						if (!isNextObstacle(this.x_pos + 1, this.y_pos, island)) {
							this.move();

						} else {
							return;
						}

					}else if (direction.equals("W")) {
						if (!isNextObstacle(this.x_pos - 1, this.y_pos, island)) {
							this.move();

						} else {
							return;
						}

					}

				}

			} else {
				this.move();
			}

	}
	 
		public boolean isNextObstacle(int x, int y, Island island) {

			if (x < island.width && y < island.height) {
				for (Things t : island.getWaters()) {
					if (t.getX_pos() == x && t.getY_pos() == y) {
						return true;

					}

				}

			}

			return false;

		}
	 
	@Override
	public String toString() {
		return "Creature [name=" + name + ", size=" + size + ", x_pos=" + x_pos + ", y_pos=" + y_pos + ", speed="
				+ speed + ", symbol=" + symbol + "]";
	}
		
}
