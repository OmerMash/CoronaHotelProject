import java.util.Scanner; 

public class UserGuest extends Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Pleas enter your age:");
	}	
		//Variables
	    protected static int guestCount;
	    protected static int numOfGuestsToCheckIn;
	    protected String Name = "guest_" + guestCounter();
	    protected int Gender;
	    protected int Age;
	    protected int roomNumber;
	    protected int UID;// User ID
	    protected int counterOfCoronaTests;// How many tests did the guest do
	    protected int Religious;//If the male guest must be in the room there are only men, 
	                           //or female guest must to be in room there are only women.
	    protected int timeForCoronaTest;
	    private boolean checkedIn;
	    private Room room;
	    
	    //Methods
	    //C`tor
	    public UserGuest(String Name) {
	        this.Name = Name;
	      }
	    public UserGuest()
	    {
	    	guestCount++;
	    }

	    public static int guestCounter() {
	        return guestCount;
	    }

	    public void getNumOfGuests() {
	    	System.out.print("Please enter number of Guests for check-in: ");
	    	numOfGuestsToCheckIn = input.nextInt();
	    }
	    public void checkIn(Room room) {
	        if (this.getStatus() == false) {
	          this.setCheckedIn(true);
	          this.setRoom(room);
	        }
	      }
	    public void createGuest() {
	    	UserGuest guest = new UserGuest();	
	    	for(int i = 1  ;  i <= numOfGuestsToCheckIn  ;  i++) {
	        	System.out.println();
	        	System.out.println("Please enter Guest "+i+" info:");
	        	System.out.println("Guest "+ i +" Name:");
	        	Name = input.next();
	        	System.out.println("Guest "+ i +" Gender: 1-male, 2-female ");
	        	Gender = input.nextInt();
	        	System.out.println("Guest "+ i +" Age: ");
	        	Age = input.nextInt();
	        	System.out.println("Guest "+ i +" ID: ");
	        	UID = input.nextInt();
	        	System.out.println("Guest "+ i +" Religious?:  1-Yes, 2-No ");
	        	Religious = input.nextInt();
	    	}
	    }
	    
	    public void printCheckInDetails() {
	    	System.out.println();
	    	System.out.println();
	    	System.out.println("Check in details:");
	    	System.out.println();
	    	System.out.println(UserGuest.guestCounter()+ " Guests checked-in successfuly:");
	    	System.out.println();
	    	for(int i = 1  ;  i <= numOfGuestsToCheckIn  ;  i++) {
	        	System.out.println("Guest_"+ i + " info:");
	        	System.out.println("Name: " + Name);
	        	System.out.println("Gender: " + Gender);
	        	System.out.println("Age " + Age);
	        	System.out.println("ID: " + UID);
	        	System.out.println("Religoius: " + Religious);
	        	System.out.println();
	    	}
	    }
	    public void DeleteGuest(UserGuest UID) {
	    	//add body - free memory allocation + decrease guestCounter + update rooms
	    }
//	    public void checkOut() {//Original, Default
//	        if (this.getStatus() == true) {
//	          this.setCheckedIn(false);
//	          this.setRoom(null);
//	        }
//	      }
	    public void CheckOut() {
	    	System.out.println("Please enter the number room to Check Out:");
	    	System.out.println("The guest made"+ counterOfCoronaTests +"of Corona tests");
	    	if(counterOfCoronaTests>= 3)
	    	{
	    		System.out.println("Starting Check-Out procces...");
	    		System.out.println("Now the guest needs to do last Corona test.");
	    		if(Input.is_healthy(UID,true))
	    		{
	    			System.out.println("The guest is free to go!");
	    			UpdateRoomes(UID, roomNumber);
	    		}
	    		
	    	
	    	}
	    	
	    }
	    public boolean getStatus() {
	        return checkedIn;
	      }
	    public String getName() {
	        return Name;
	      }
	    public void setName(String name) {
	        this.Name = name;
	      }

	      public Room getRoom() {
	        return room;
	      }

	      public void setRoom(Room room) {
	        this.room = room;
	      }

	      public void setCheckedIn(boolean checkedIn) {
	        this.checkedIn = checkedIn;
	      }
	      public void getRoomInfo(Room room) {
	    	    System.out.println("Room # : " + room.getRoomNumber());
	    	    System.out.println("Room price : " + room.getPrice());
	    	    System.out.println("Room type : " + room.getRoomType());
	    	    System.out.println("Room occupant : " + room.getGuest().getName());
	    	  }


}


