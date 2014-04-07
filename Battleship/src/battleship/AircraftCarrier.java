package battleship;

public class AircraftCarrier extends Ship {
	
	public AircraftCarrier() {
		length = 5;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public String getShipType() {
		return "Aircraft Carrier";
	}

}
