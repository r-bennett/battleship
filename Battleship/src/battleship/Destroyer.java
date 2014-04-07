package battleship;

public class Destroyer extends Ship {

	@Override
	public int getLength() {
		return 2;
	}

	@Override
	public String getShipType() {
		return "Destroyer";
	}

}
