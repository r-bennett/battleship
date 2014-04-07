package battleship;

public class Battleship extends Ship {

	@Override
	public int getLength() {
		return 4;
	}

	@Override
	public String getShipType() {
		return "Battleship";
	}

}
