package battleship;

public class PatrolBoat extends Ship {

	public PatrolBoat() {
		length = 1;
	}
	
	@Override
	public int getLength() {
		return length;
	}

	@Override
	public String getShipType() {
		return "Patrol Boat";
	}

}
