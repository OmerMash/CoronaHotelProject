package hit.co.il;
import java.nio.file.FileAlreadyExistsException;


public class Room{
	//default constracror
	public Room () {
		
	}
	  public Room(int roomNumber, double price, roomType type, FloorNum FloorN) {
		    this.roomNumber = roomNumber;
		    this.price = price;
		    this.type = type;
		    this.FloorN= FloorN;
		  }
	
		  public enum roomType {
		    ONE_BEDRM, TWO_BEDRM, THREE_BEDRM, PENTHOUSE
		  }
		  public enum FloorNum {
			ONE_Recovering, TWO_SuspectedAsACoronaPatient, THREE_CoronaPatient , FOUR_ImportantPatients
		  }

		  private boolean available;
		  private UserGuest occupant;
		  private int roomNumber;
		  private double price;
		  private roomType type;
		  private FloorNum FloorN;

		  public int getRoom() {
			  return 1;
		  }

		  public boolean isAvailable() {
		    //check if Available and return it
			  return available;
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
		  public FloorNum getFloorNum() {
			  return FloorN;
		  }
		  public void setFloorNum(FloorNum floorNum) {
			  this.FloorN = floorNum;
		  }
		  

}
