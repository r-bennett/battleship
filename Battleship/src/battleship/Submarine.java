package battleship;

public class Submarine extends Ship {
	
	public Submarine() {
		length = 3;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public String getShipType() {
		return "Submarine";
	}

}
