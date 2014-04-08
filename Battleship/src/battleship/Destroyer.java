package battleship;

public class Destroyer extends Ship {
	
	public Destroyer() {
		length = 2;
		hit = new boolean[length];
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public String getShipType() {
		return "Destroyer";
	}

}
