package battleship;

public class PatrolBoat extends Ship {

	@Override
	public int getLength() {
		return 1;
	}

	@Override
	public String getShipType() {
		return "Patrol Boat";
	}

}
