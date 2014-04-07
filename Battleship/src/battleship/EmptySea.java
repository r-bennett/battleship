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
		return "Empty Sea";
	}

	@Override
	public boolean shootAt(int row, int column) {
		return false;
	}
	
	@Override
	public String toString() {
		if(firedUpon)
			return "-";
		return ".";
	}

}
