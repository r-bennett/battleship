package battleship;

public class PatrolBoat extends Ship {

	public PatrolBoat() {
		length = 1;
		hit = new boolean[length];
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
