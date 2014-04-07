package battleship;

public class EmptySea extends Ship {

	public EmptySea() {
		length = 1;
	}
	
	@Override
	public int getLength() {
		return length;
	}

	@Override
	public String getShipType() {
		// TODO Auto-generated method stub
		return null;
	}

}
