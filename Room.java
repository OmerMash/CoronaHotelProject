
public class Room{
	
	      static final int ONE_Recovering=1, TWO_SuspectedAsACoronaPatient=2, THREE_CoronaPatient=3, FOUR_ImportantPatients=4;
	      int[] RoomsNumbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,
			51,52,53,54,55,56,57,58,59,60,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
		  
	      public enum roomType {
		    ONE_BEDRM, TWO_BEDRM, THREE_BEDRM, PENTHOUSE
		  }
//		  public enum FloorNum {
//			ONE_Recovering, TWO_SuspectedAsACoronaPatient, THREE_CoronaPatient , FOUR_ImportantPatients
//		  }

		  private boolean available;
		  private UserGuest occupant;
		  private int roomNumber;
		  private double price;
		  private roomType type;
//		  private FloorNum FloorN;

  			//C`tor
		  public Room(int roomNumber, double price, roomType type) {
		    this.roomNumber = roomNumber;
		    this.price = price;
		    this.type = type;
//		    this.FloorN= FloorN;
		  }

		  public boolean isAvailable() {
		    return this.available;
		  }

		  public boolean getAvailable() {
		    return available;
		  }

		  public void setAvailable(boolean available) {
		    this.available = available;
		  }

		  public double getPrice() {
		    return price;
		  }

		  public void setPrice(double price) {
		    this.price = price;
		  }

		  public roomType getRoomType() {
		    return type;
		  }

		  public void setRoomType(roomType type) {
		    this.type = type;
		  }
		  public int getRoomNumber() {
			    return roomNumber;
		  }
		  public void setRoomNumber(int roomNum) {
			  this.roomNumber = roomNum;
	      }
		  public UserGuest getGuest() {
			  return occupant;
		  }
		  public void setGuest(UserGuest occupant) {
			  this.occupant = occupant;
		  }
//		  public FloorNum getFloorNum() {
//			  return FloorN;
//		  }
//		  public void setFloorNum(FloorNum floorNum) {
//			  this.FloorN = floorNum;
//		  }
//		  

}
