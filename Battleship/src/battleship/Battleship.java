package battleship;

public class Battleship extends Ship {
	
	public Battleship() {
		length = 4;
		hit = new boolean[length];
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public String getShipType() {
		return "Battleship";
	}

}
