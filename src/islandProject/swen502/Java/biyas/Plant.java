package islandProject.swen502.Java.biyas;

//Plant class implements from Things Interface
public class Plant implements Things{

	protected String name;
	protected int size;
	protected int x_pos;
	protected int y_pos;
	protected char symbol;
	
	public Plant() {
		
	}
	
	public Plant(String name, int size, int x_pos, int y_pos, char symbol) {
		super();
		this.name = name;
		this.size = size;
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.symbol=symbol;
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
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	@Override
	public String toString() {
		return "Plant [name=" + name + ", size=" + size + ", x_pos=" + x_pos + ", y_pos=" + y_pos + "]";
	}
	
}
