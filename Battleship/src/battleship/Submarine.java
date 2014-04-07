package battleship;

public class Submarine extends Ship {

	@Override
	public int getLength() {
		return 3;
	}

	@Override
	public String getShipType() {
		return "Submarine";
	}

}
